package com.hks.external.receive.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TransFormDto {

    private HeadDto head;
    private MsgDto msg;

    public TransFormDto(HeadDto headDto) {
        this.head = headDto;
    }

    @Builder
    public TransFormDto(HeadDto headDto, MsgDto msgDto) {
        this.head = headDto;
        this.msg = msgDto;
    }

}
