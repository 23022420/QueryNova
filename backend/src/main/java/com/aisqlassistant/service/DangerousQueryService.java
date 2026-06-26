package com.aisqlassistant.service;

import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class DangerousQueryService {

    public Map<String, Object> analyze(String sql) {

        Map<String, Object> result = new LinkedHashMap<>();

        String query = sql.toUpperCase();

        boolean danger =
                query.contains("DROP")
                        || query.contains("DELETE")
                        || query.contains("TRUNCATE")
                        || query.contains("ALTER");

        result.put("dangerous", danger);

        if (danger) {

            result.put("risk", "HIGH");
            result.put("message",
                    "Dangerous SQL detected.");

        } else {

            result.put("risk", "SAFE");
            result.put("message",
                    "No dangerous statements found.");
        }

        return result;
    }

}