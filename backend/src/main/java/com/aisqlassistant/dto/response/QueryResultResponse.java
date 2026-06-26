package com.aisqlassistant.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QueryResultResponse {

    private boolean success;

    private String message;

    private List<Map<String,Object>> rows;

    private Integer affectedRows;

    private Long executionTime;

}
