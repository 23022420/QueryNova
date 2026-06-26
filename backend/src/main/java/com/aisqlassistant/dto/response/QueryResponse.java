package com.aisqlassistant.dto.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QueryResponse {

    private boolean success;

    private Object data;

    private String message;

}