package com.hks.external.receive.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class MainMsgDto {
    private String outp_msg_cd;
    private String outp_msg_ctnt;

    @Builder
    public MainMsgDto(String outp_msg_cd, String coutp_msg_ctnt) {
        this.outp_msg_cd = outp_msg_cd;
        this.outp_msg_ctnt = coutp_msg_ctnt;
    }
}
