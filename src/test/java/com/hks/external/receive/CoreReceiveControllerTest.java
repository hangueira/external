package com.hks.external.receive;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hks.external.receive.dto.HeadDto;
import com.hks.external.receive.dto.MainMsgDto;
import com.hks.external.receive.dto.MsgDto;
import com.hks.external.receive.dto.TransFormDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class CoreReceiveControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testCoreReceive() throws Exception {
        // given
        HeadDto headDto = new HeadDto("ESCOREBNKBIEB5111", "BNK");

        MainMsgDto mainMsgDto = MainMsgDto.builder()
                .outp_msg_cd("0000000000")
                .coutp_msg_ctnt("정상 조회되었습니다.").build();

        MsgDto msgDto = MsgDto.builder()
                .msg_dvcd("NM")
                .main_Msg(mainMsgDto).build();

        // when
        TransFormDto transFormDto = TransFormDto.builder()
                .headDto(headDto)
                .msgDto(msgDto)
                .build();

        // then
        mockMvc.perform(MockMvcRequestBuilders.post("/receive")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(transFormDto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.head.if_id").value("ESCOREBNKBIEB5111")) // Adjust the JSON path based on your actual response structure
                .andExpect(jsonPath("$.msg.main_Msg.outp_msg_cd").value("0000000000"))
                .andExpect(jsonPath("$.msg.main_Msg.outp_msg_ctnt").value("정상 조회되었습니다."));
    }
}