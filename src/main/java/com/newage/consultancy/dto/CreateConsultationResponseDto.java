package com.newage.consultancy.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

//passes data from service to consumer
public class CreateConsultationResponseDto {

    private String id;

}
