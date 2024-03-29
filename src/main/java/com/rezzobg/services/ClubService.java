package com.rezzobg.services;

import com.rezzobg.dto.PlaceDTO;
import com.rezzobg.dto.PlaceDtoForList;
import com.rezzobg.exceptions.InvalidClubException;
import com.rezzobg.exceptions.InvalidRestaurantException;
import com.rezzobg.models.*;
import com.rezzobg.repositories.ClubRepository;
import com.rezzobg.repositories.GenreRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ClubService extends PlaceService{
    @Autowired
    private ClubRepository clubRepository;

    @Autowired
    private GenreRepository genreRepository;

    @Autowired
    private CharacteristicService characteristicService;

    @Autowired
    private GenreService genreService;

    private List<PlaceDtoForList> collectClubs() {
        return collectClubs();
    }

    private List<PlaceDtoForList> collectClubs(List<Club> clubs) {
        return clubs.stream().map(club -> new PlaceDtoForList(club.getName(), club.getPhotos().get(0).getUrl(),
                club.getMidAmount(), club.getAddress().getArea(), club.getRating(),
                genreRepository.findByClubsId(club.getId()).stream()
                        .map(genre -> genre.getName()).collect(Collectors.toList()))).collect(Collectors.toList());
    }

    public List<PlaceDtoForList> getAllClubs() {
        List<Club> clubs = clubRepository.findAll();
        return collectClubs(clubs);
    }

    public List<PlaceDtoForList> getAllClubsByCity(Long id) {
       List<Club> clubs = clubRepository.findByAddressCityId(id);
       return collectClubs(clubs);
    }

    public Club getClubDetails(Long id) throws InvalidClubException {
        Optional<Club> clubFromDB = clubRepository.findById(id);
        Club club = null;
        System.out.println(clubFromDB);
        try {
            club = clubFromDB.get();
        } catch(Exception e) {
            throw new InvalidClubException();
        }
        return club;
    }

    private Set<Genre> getAndSaveCharacteristics(PlaceDTO placeDTO) {
        Set<Genre> genres = new HashSet<>();
        for(String name: placeDTO.getCharacteristicNames()) {
            if(!this.characteristicService.isInDatabase(name)) {
                genres.add(this.genreService.saveGenre(new Genre(name)));
            } else {
                genres.add((Genre)this.characteristicService.findCharacteristic(name));
            }
        }
        return genres;
    }

    public void addClub(PlaceDTO placeDTO) {
        Address address = manageAddress(placeDTO);
        Club club = new Club(placeDTO.getName(), placeDTO.getStartWorkingDay(), placeDTO.getEndWorkingDay(),
                placeDTO.getMidAmount(), 0.0, placeDTO.getDescription(), placeDTO.getPlaces(), address);
        club.setGenres(getAndSaveCharacteristics(placeDTO));
        club.setExtras(getAndSaveExtras(placeDTO));
        Club c = this.clubRepository.save(club);
        List<Photo> photos = getAndSavePhotos(placeDTO, c);
    }

    @Transactional
    public void deleteClub(Long restaurantId) throws InvalidRestaurantException {
        Optional<Club> club = this.clubRepository.findById(restaurantId);
        Club c;
        try {
            c = club.get();
        } catch (Exception e) {
            throw new InvalidRestaurantException("Such restaurant does not exist!");
        }
        deletePlaceRelationsFromDB(c);
        this.clubRepository.delete(c);
    }
}
