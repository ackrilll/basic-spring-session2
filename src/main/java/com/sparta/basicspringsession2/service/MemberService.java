package com.sparta.basicspringsession2.service;

import com.sparta.basicspringsession2.dto.*;
import com.sparta.basicspringsession2.entity.Member;
import com.sparta.basicspringsession2.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional
    public MemberSaveResponseDto saveMember(MemberSaveRequestDto requestDto) {
        Member member = new Member(requestDto.getName());
        Member savedMember = memberRepository.save(member);
        return new MemberSaveResponseDto(savedMember.getId(), savedMember.getName());
    }


    public List<MemberSimpleResponseDto> getMembers() {
        List<Member> members = memberRepository.findAll();
        List<MemberSimpleResponseDto> membersDto = new ArrayList<>();
        for (Member member : members) {
            MemberSimpleResponseDto memberSimpleResponseDto = new MemberSimpleResponseDto(member.getName());
            membersDto.add(memberSimpleResponseDto);
        }
        return membersDto;
    }

    public MemberDetailResponseDto getMember(Long id){
        Member member = memberRepository.findById(id).orElseThrow(()->new NullPointerException("해당 멤버는 없습니다"));
        return new MemberDetailResponseDto(member.getId(),member.getName());
    }

    @Transactional
    public MemberUpdateResponseDto updateMember(Long memberId, MemberUpdateDto requestDto) {
        Member member = memberRepository.findById(memberId).orElseThrow(() -> new NullPointerException("해당 멤버는 없습니다"));
        member.update(requestDto.getName());
        return new MemberUpdateResponseDto(member.getName());
    }

    @Transactional
    public void deleteMember(Long memberId) {
        Member member = memberRepository.findById(memberId).orElseThrow(() -> new NullPointerException("해당 멤버는 없습니다"));
        memberRepository.delete(member);
    }
}
