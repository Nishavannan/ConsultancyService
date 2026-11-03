package com.newage.consultancy.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor

//Passes Data from consumer to service
public class ConsultationRequestDto {


    @NotBlank(message = "Member ID is required")
    private String memberId;

    @NotBlank(message = "Member name is required")
    private String memberName;

    @NotNull(message = "Startdate is required")
    private LocalDate startdate;

    @NotNull(message = "DurationInMinutes is required")
    @Positive(message = "DurationInMinutes should be greater than zero")
    private Integer durationInMinutes;
}
