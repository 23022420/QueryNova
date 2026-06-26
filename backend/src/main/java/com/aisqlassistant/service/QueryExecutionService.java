package com.aisqlassistant.service;

import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.*;

@Service
public class QueryExecutionService {

    public Map<String, Object> executeQuery(
        String url,
        String username,
        String password,
        String sql) {

    Map<String, Object> response = new LinkedHashMap<>();

    long startTime = System.currentTimeMillis();

    try (Connection connection =
                 DriverManager.getConnection(url, username, password);

         Statement statement = connection.createStatement()) {

        boolean hasResult = statement.execute(sql);

        if (hasResult) {

            ResultSet rs = statement.getResultSet();
            ResultSetMetaData meta = rs.getMetaData();

            List<Map<String, Object>> rows = new ArrayList<>();

            while (rs.next()) {

                Map<String, Object> row = new LinkedHashMap<>();

                for (int i = 1; i <= meta.getColumnCount(); i++) {

                    row.put(meta.getColumnLabel(i), rs.getObject(i));

                }

                rows.add(row);

            }

            response.put("success", true);
            response.put("queryType", "SELECT");
            response.put("rowCount", rows.size());
            response.put("rows", rows);

        } else {

            int affected = statement.getUpdateCount();

            response.put("success", true);
            response.put("queryType", "UPDATE");
            response.put("affectedRows", affected);

        }

    } catch (SQLException e) {

        response.put("success", false);
        response.put("error", e.getMessage());

    }

    response.put(
            "executionTimeMs",
            System.currentTimeMillis() - startTime
    );

    return response;

}

}