package com.rezzobg.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.sql.Time;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PlaceDTO {
    @NotBlank(message = "Name is not long enough!")
    private String name;
    private Time startWorkingDay;
    private Time endWorkingDay;
    @NotBlank(message = "Mid amount is not long enough!")
    private String midAmount;
    @NotBlank(message = "Description is not long enough!")
    private String description;
    private int discount;
    private int places;
    @NotBlank(message = "Street is not long enough!")
    private String street;
    @NotBlank(message = "Area is not long enough!")
    private String area;
    @NotBlank(message = "City is not long enough!")
    private String city;
    @NotBlank(message = "Country is not long enough!")
    private String country;
    private List<String> urlPhotos;
    private List<String> characteristicNames;
    private List<String> extras;
}
