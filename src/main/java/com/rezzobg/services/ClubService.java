package com.rezzobg.services;

import com.rezzobg.dto.PlaceDtoForList;
import com.rezzobg.exceptions.InvalidClubException;
import com.rezzobg.models.Club;
import com.rezzobg.repositories.ClubRepository;
import com.rezzobg.repositories.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClubService {
    @Autowired
    private ClubRepository clubRepository;

    @Autowired
    private GenreRepository genreRepository;

    private List<PlaceDtoForList> collectClubs() {
        return collectClubs();
    }

    private List<PlaceDtoForList> collectClubs(List<Club> clubs) {
        return clubs.stream().map(club -> new PlaceDtoForList(club.getName(), club.getPhotos().get(0).getUrl(),
                club.getMidAmount(), club.getAddress().getArea(), club.getRating(),
                genreRepository.findByClubId(club.getId()).stream()
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
}
