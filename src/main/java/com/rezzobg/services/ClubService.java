package com.rezzobg.services;

import com.rezzobg.dto.PlaceDtoForList;
import com.rezzobg.models.Club;
import com.rezzobg.models.Place;
import com.rezzobg.repositories.ClubRepository;
import com.rezzobg.repositories.GenreRepository;
import com.rezzobg.repositories.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClubService {
    @Autowired
    private ClubRepository clubRepository;

    @Autowired
    private GenreRepository genreRepository;

    private List<PlaceDtoForList> collectClubs(List<Club> clubs) {
        List<String> genreNames = genreRepository.findAll().stream()
                .map(genre -> genre.getName()).collect(Collectors.toList());

        return clubs.stream().map(club -> new PlaceDtoForList(club.getName(), club.getPhotos().get(0).getUrl(),
                club.getMidAmount(), club.getAddress().getArea(), club.getRating(), genreNames)).collect(Collectors.toList());

    }

    public List<PlaceDtoForList> getAllClubs() {
        //List<Club> clubs = clubRepository.findAll();
//        List<String> genreNames = genreRepository.findAll().stream()
//                .map(genre -> genre.getName()).collect(Collectors.toList());
//
//        return clubs.stream().map(club -> new PlaceDtoForList(club.getName(), club.getPhotos().get(0).getUrl(),
//                club.getMidAmount(), club.getAddress().getArea(), club.getRating(), genreNames)).collect(Collectors.toList());
       // return collectClubs(clubs);
        return null;
    }

    public List<PlaceDtoForList> getAllClubsByCity(Long id) {
       List<Club> clubs = clubRepository.findByAddressCityId(id);
       return collectClubs(clubs);
    }
}
