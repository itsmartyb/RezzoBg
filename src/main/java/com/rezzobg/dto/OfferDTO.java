package com.rezzobg.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class OfferDTO extends ProposalDTO {
    private int price;

    @Builder
    public OfferDTO(String title, String description, String url,
                    LocalDate date, String placeName, int price) {
        super(title, description, url, date, placeName);
        this.price = price;
    }
}
