package com.hks.external.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Header {

    private String ifId;

    public void setDto(String ifId) {
        this.ifId = ifId;
    }
}
