package com.newage.consultancy.service;

import com.newage.consultancy.dto.ConsultationRequestDto;
import com.newage.consultancy.dto.ConsultationResponseDto;
import com.newage.consultancy.dto.CreateConsultationResponseDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ConsultationService {

    List<ConsultationResponseDto> getConsultations(String memberID);
    CreateConsultationResponseDto createConsultation(ConsultationRequestDto consultationRequestDto);


}
