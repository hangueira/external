package com.hks.external.receive.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TransFormDto {

    private HeadDto head;

    public TransFormDto(HeadDto headDto) {
        this.head = headDto;
    }

}
