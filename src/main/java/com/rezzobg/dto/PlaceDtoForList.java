package com.rezzobg.dto;

import com.rezzobg.models.Characteristic;
import com.rezzobg.models.Kitchen;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PlaceDtoForList {
    private String name;
    private String pictureUrl;
    private String midAmount;
    private String area;
    private double rating;
    private List<String> styles = new LinkedList<>();

    public PlaceDtoForList(String name, String pictureUrl, String midAmount, String area, double rating) {
        this.name = name;
        this.pictureUrl = pictureUrl;
        this.midAmount = midAmount;
        this.rating = rating;
    }
}
