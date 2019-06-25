package com.rezzobg.dto;

import com.rezzobg.models.Kitchen;
import com.rezzobg.models.Photo;
import lombok.*;

import javax.validation.constraints.NotBlank;
import java.sql.Time;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RestaurantDTO {
    @NotBlank(message = "Name is not long enough!")
    private String name;
   // @NotBlank(message = "Working day is not long enough!")
    private Time startWorkingDay;
    //@NotBlank(message = "Working day not long enough!")
    private Time endWorkingDay;
    @NotBlank(message = "Mid amount is not long enough!")
    private String midAmount;
    @NotBlank(message = "Description is not long enough!")
    private String description;
    //private int discount;
    //@NotBlank(message = "Places are not long enough!")
    private int places;
    @NotBlank(message = "Street is not long enough!")
    private String street;
    @NotBlank(message = "Area is not long enough!")
    private String area;
    @NotBlank(message = "City is not long enough!")
    private String city;
    @NotBlank(message = "Country is not long enough!")
    private String country;
   // @NotBlank(message = "Photos are not long enough!")
    private List<String> urlPhotos;
   // @NotBlank(message = "Kitchens are not long enough!")
    private List<String> kitchenNames;
   // @NotBlank(message = "Extras are not long enough!")
    private List<String> extras;
}
