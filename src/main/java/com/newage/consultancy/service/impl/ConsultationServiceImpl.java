package com.newage.consultancy.service.impl;

import com.newage.consultancy.dto.ConsultationRequestDto;
import com.newage.consultancy.dto.ConsultationResponseDto;
import com.newage.consultancy.dto.CreateConsultationResponseDto;
import com.newage.consultancy.entity.Consultation;
import com.newage.consultancy.entity.Member;
import com.newage.consultancy.exception.MemberNotFoundException;
import com.newage.consultancy.exception.MethodArgumentNotValidException;
import com.newage.consultancy.exception.ServerException;
import com.newage.consultancy.repository.ConsultationRepo;
import com.newage.consultancy.repository.MemberRepo;
import com.newage.consultancy.service.ConsultationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpServerErrorException;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class ConsultationServiceImpl implements ConsultationService {


    private final ConsultationRepo consultationRepo;
    private final MemberRepo memberRepo;

    @Override
    @Transactional(readOnly = true)
    public List<ConsultationResponseDto> getConsultations(String memberID) {

        try {
            if (memberID.isBlank()) {
                throw new MethodArgumentNotValidException("Invalid request. ");
            }

            List<Consultation> consultations = consultationRepo.findByMemberId(memberID);

            if (consultations.isEmpty()) {
                throw new MemberNotFoundException("No consultation found for given member");
            }
            return consultations.stream().map(consultation -> new ConsultationResponseDto(consultation.getId(), consultation.getStartdate(), consultation.getDurationInMinutes())).toList();
        }catch (MemberNotFoundException ex){
            throw new MemberNotFoundException("No consultation found for given member");
        }catch (ServerException ex){
            throw new ServerException("Error processing request. Please try after some time.");
        }
    }

    @Override
    @Transactional
    public CreateConsultationResponseDto createConsultation(ConsultationRequestDto request) {

        try {
            Member member = memberRepo.findById(request.getMemberId())
                    .orElseGet(() -> memberRepo.save(new Member(request.getMemberId(), request.getMemberName())));

            String consultationId = UUID.randomUUID().toString();

            Consultation consultation = new Consultation();

            consultation.setId(consultationId);
            consultation.setMember(member);
            consultation.setStartdate(request.getStartdate());
            consultation.setDurationInMinutes(request.getDurationInMinutes());

            consultationRepo.save(consultation);
            return new CreateConsultationResponseDto(consultationId);
        }catch (IllegalArgumentException ex){
            log.error("Bad request: ",ex);
            throw new MethodArgumentNotValidException("Invalid request.");
        }catch (HttpServerErrorException ex){
            throw new ServerException("Error processing request. Please try after some time.");
        }

    }

}
