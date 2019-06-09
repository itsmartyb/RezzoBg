package com.rezzobg.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EventDtoForList extends ProposalDtoForList {
    private Time time;

    public EventDtoForList(String title, String pictureUrl, Time time) {
        super(title, pictureUrl);
        this.time = time;
    }

}
