package com.sparta.basicspringsession2.dto;

import lombok.Getter;

@Getter
public class MemberUpdateResponseDto {
    private final String name;
    public MemberUpdateResponseDto(final String name) {
        this.name = name;
    }
}
