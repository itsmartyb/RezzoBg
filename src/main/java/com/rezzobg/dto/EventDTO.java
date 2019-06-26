package com.rezzobg.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class EventDTO extends ProposalDTO {
    private Time hour;

    @Builder
    public EventDTO(String title, String description, String url,
                    LocalDate date, String placeName, Time hour) {
        super(title, description, url, date, placeName);
        this.hour = hour;
    }
}
