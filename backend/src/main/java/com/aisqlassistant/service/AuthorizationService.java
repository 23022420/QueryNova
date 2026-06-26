package com.aisqlassistant.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorizationService {

    public boolean canExecute(String role, String sql) {

        String query = sql.toUpperCase();

        if ("ADMIN".equals(role)) {
            return true;
        }

        if ("ANALYST".equals(role)) {

            if (query.startsWith("SELECT")) {
                return true;
            }

            return false;
        }

        if ("USER".equals(role)) {

            return query.startsWith("SELECT");
        }

        return false;
    }

    public String maskSensitiveColumns(String role, String columnName, Object value) {

        if ("ADMIN".equals(role)) {
            return String.valueOf(value);
        }

        List<String> sensitiveColumns = List.of(
                "salary",
                "password",
                "email",
                "phone"
        );

        if (sensitiveColumns.contains(columnName.toLowerCase())) {
            return "********";
        }

        return String.valueOf(value);
    }

}
