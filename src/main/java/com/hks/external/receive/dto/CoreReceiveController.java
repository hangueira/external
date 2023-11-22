package com.hks.external.receive.dto;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class CoreReceiveController {

    @PostMapping("/receive")
    public TransFormDto coreReceive(@RequestBody TransFormDto transFormDto) {
        String ifId = transFormDto.getHead().getIf_id();
        String chnlType = "BNK";
        HeadDto headDto = new HeadDto(ifId, chnlType);

        TransFormDto resultTransFormDto = new TransFormDto(headDto);
        return resultTransFormDto;
    }

    @PostMapping("/headReceive")
    public CreateResponse headReceive(@RequestBody CreateRequest createRequest) {
        String name = createRequest.getHead().getName();
        log.info(name);
        return new CreateResponse(1l);

    }

    @Data
    static class CreateRequest {
        private HeadRequest head;
    }

    @Data
    static class CreateResponse {
        private Long id;

        public CreateResponse(Long id) {
            this.id = id;
        }
    }

    @Data
    static class HeadRequest {
        private String name;
    }
}
