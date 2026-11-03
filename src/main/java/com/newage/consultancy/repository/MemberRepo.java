package com.newage.consultancy.repository;

import com.newage.consultancy.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepo extends JpaRepository<Member, String> {
}
