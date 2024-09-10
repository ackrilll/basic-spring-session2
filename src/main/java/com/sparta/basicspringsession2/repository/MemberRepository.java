package com.sparta.basicspringsession2.repository;
import com.sparta.basicspringsession2.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
