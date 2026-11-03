package com.newage.consultancy.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

@Table(name = "consultation")
public class Consultation {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "start_date", nullable = false)
    private LocalDate startdate;

    @Column(name = "duration_in_minutes", nullable = false)
    private Integer durationInMinutes;


    @ManyToOne(fetch = FetchType.LAZY)//Fetches member only when consultation.getMember is called
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;
}
