package com.rezzobg.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OfferDtoForList extends ProposalDtoForList {
    private int price;

    public OfferDtoForList(String title, String pictureUrl, int price) {
        super(title, pictureUrl);
        this.price = price;
    }
}
