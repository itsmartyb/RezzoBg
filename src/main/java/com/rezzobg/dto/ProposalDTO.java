package com.rezzobg.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class ProposalDTO {
    @NotBlank(message = "Title is not long enough!")
    private String title;
    @NotBlank(message = "Description is not long enough!")
    private String description;
    @NotBlank(message = "PictureURL is not long enough!")
    private String url;
    private LocalDate date;
    @NotBlank(message = "Place name is not long enough!")
    private String placeName;

}
