package com.newage.consultancy.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor

//Passes data from service to consumer
public class ConsultationResponseDto {

    private String id;
    private LocalDate startDate;
    private Integer duration;
}
