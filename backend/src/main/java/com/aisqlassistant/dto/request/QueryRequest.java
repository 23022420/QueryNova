package com.aisqlassistant.dto.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QueryRequest {

    private String url;

    private String username;

    private String password;

    private String sql;

}