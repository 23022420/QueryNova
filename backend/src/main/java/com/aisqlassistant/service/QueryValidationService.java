package com.aisqlassistant.service;

import org.springframework.stereotype.Service;

@Service
public class QueryValidationService {

    public boolean isSafe(String sql) {

        String query = sql.toUpperCase();

        return !(query.contains("DROP")
                || query.contains("TRUNCATE")
                || query.contains("ALTER")
                || query.contains("DELETE FROM") && !query.contains("WHERE")
                || query.contains("UPDATE") && !query.contains("WHERE"));

    }

}