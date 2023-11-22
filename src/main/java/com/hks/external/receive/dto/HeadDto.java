package com.hks.external.receive.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class HeadDto {

    private String if_id;
    private String chnl_type;

    public HeadDto(String if_id, String chnl_type) {
        this.if_id = if_id;
        this.chnl_type = chnl_type;
    }

}
