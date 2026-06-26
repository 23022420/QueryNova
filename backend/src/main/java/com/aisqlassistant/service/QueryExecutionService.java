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

        long start = System.currentTimeMillis();

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

                        row.put(
                                meta.getColumnName(i),
                                rs.getObject(i)
                        );

                    }

                    rows.add(row);

                }

                response.put("type", "SELECT");
                response.put("rows", rows);

            } else {

                response.put(
                        "affectedRows",
                        statement.getUpdateCount()
                );

                response.put("type", "UPDATE");

            }

            response.put("success", true);

        } catch (Exception e) {

            response.put("success", false);
            response.put("error", e.getMessage());

        }

        response.put(
                "executionTime",
                System.currentTimeMillis() - start + " ms"
        );

        return response;

    }

}