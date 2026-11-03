package com.newage.consultancy.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "member") //telling that the relationship between member and consultation is already managed by member field in the Consultation class
    private List<Consultation> consultation = new ArrayList<>();

    public Member(String id, String name){
        this.id = id;
        this.name = name;

    }
}
