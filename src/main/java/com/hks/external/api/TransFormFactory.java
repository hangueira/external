package com.hks.external.api;

import com.hks.external.api.dto.BancaData;
import com.hks.external.api.dto.Header;
import com.hks.external.api.dto.Message;
import com.hks.external.api.dto.TransForm;

import static com.hks.external.api.dto.Header.*;

public abstract class TransFormFactory<T> {

    public TransForm createTransForm(String ifId) {
        Header header = builder()
                .ifId(ifId)
                .build();
        Message message = Message.builder()
                .resultCd("NM")
                .build();
        createBancaData();
        return TransForm.builder()
                .header(header)
                .message(message)
                .bancaData(createBancaData())
                .build();
    }

    public abstract T createBancaData();


}
