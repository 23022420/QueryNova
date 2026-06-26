package com.aisqlassistant.dto.request;

import lombok.*;
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QueryRequest {

    private String prompt;

    private String sql;

    private String url;

    private String username;

    private String password;

}