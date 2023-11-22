package com.hks.external.receive.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
public class MsgDto {

    private String msg_dvcd;
    private MainMsgDto main_Msg;

    @Builder
    public MsgDto(String msg_dvcd, MainMsgDto main_Msg) {
        this.msg_dvcd = msg_dvcd;
        this.main_Msg = main_Msg;
    }
}
