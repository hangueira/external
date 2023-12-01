package com.hks.external.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class TransForm<T> {
    private Header header;
    private Message message;
    private T bancaData;
}
