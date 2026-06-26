package com.aisqlassistant.service;

import org.springframework.stereotype.Service;

@Service
public class QueryFormatterService {

    public String format(String sql) {

        if (sql == null || sql.isBlank()) {
            return "";
        }

        return sql.trim()
                .replaceAll("\\s+", " ")
                .replace("select", "SELECT")
                .replace("from", "FROM")
                .replace("where", "WHERE")
                .replace("group by", "GROUP BY")
                .replace("order by", "ORDER BY");
    }
}