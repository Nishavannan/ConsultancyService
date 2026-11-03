package com.newage.consultancy.controller;

import com.newage.consultancy.dto.ConsultationRequestDto;
import com.newage.consultancy.dto.ConsultationResponseDto;
import com.newage.consultancy.dto.CreateConsultationResponseDto;
import com.newage.consultancy.service.ConsultationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/consultations")
public class ConsultancyController {

    private final ConsultationService consultationService;

    @GetMapping
    public ResponseEntity<List<ConsultationResponseDto>> getConsultations(@RequestParam String memberId){
        return ResponseEntity.ok(consultationService.getConsultations(memberId));

    }

    @PostMapping
    public ResponseEntity<CreateConsultationResponseDto> createConsultation(@RequestBody @Valid ConsultationRequestDto requestDto){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(consultationService.createConsultation(requestDto));
    }
}
