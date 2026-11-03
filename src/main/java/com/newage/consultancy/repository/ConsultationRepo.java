package com.newage.consultancy.repository;

import com.newage.consultancy.entity.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConsultationRepo extends JpaRepository<Consultation,String> {

    List<Consultation> findByMemberId(String memberId);
}
