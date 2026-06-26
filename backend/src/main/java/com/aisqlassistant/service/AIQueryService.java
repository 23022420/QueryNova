package com.aisqlassistant.service;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class AIQueryService {

    public Map<String, Object> generateSql(String prompt) {

        Map<String, Object> response = new LinkedHashMap<>();

        response.put("prompt", prompt);
        response.put("sql",
                "-- AI Generated SQL\nSELECT * FROM employees;");
        response.put("status", "SUCCESS");

        return response;
    }

    public Map<String, Object> formatSql(String sql) {

        Map<String, Object> response = new LinkedHashMap<>();

        response.put("formattedQuery", sql.toUpperCase());

        return response;
    }

    public Map<String, Object> calculateDifficulty(String sql) {

        Map<String, Object> response = new LinkedHashMap<>();

        response.put("difficulty", "MEDIUM");
        response.put("score", 55);

        return response;
    }

    public Map<String, Object> detectDangerousQuery(String sql) {

        Map<String, Object> response = new LinkedHashMap<>();

        boolean danger = sql.toUpperCase().contains("DROP")
                || sql.toUpperCase().contains("DELETE");

        response.put("dangerous", danger);

        if (danger) {
            response.put("risk", "HIGH");
        } else {
            response.put("risk", "SAFE");
        }

        return response;
    }

    public Map<String, Object> optimizeQuery(String sql) {

        Map<String, Object> response = new LinkedHashMap<>();

        response.put("optimizedQuery", sql);
        response.put("message",
                "Optimization suggestions generated.");

        return response;
    }

    public Map<String, Object> explainQuery(String sql) {

        Map<String, Object> response = new LinkedHashMap<>();

        response.put("explanation",
                "This SQL query retrieves records from the selected table.");

        return response;
    }

    public Map<String, Object> autoFixQuery(String sql) {

        Map<String, Object> response = new LinkedHashMap<>();

        response.put("fixedQuery", sql);
        response.put("status", "FIXED");

        return response;
    }

}