package com.aisqlassistant.service;

import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.*;

@Service
public class SchemaReaderService {

    public String readSchema(
            String url,
            String username,
            String password) {

        StringBuilder schema = new StringBuilder();

        try (Connection connection =
                     DriverManager.getConnection(url, username, password)) {

            DatabaseMetaData metaData = connection.getMetaData();

            ResultSet tables = metaData.getTables(
                    null,
                    null,
                    "%",
                    new String[]{"TABLE"}
            );

            while (tables.next()) {

                String tableName = tables.getString("TABLE_NAME");

                schema.append("Table: ")
                        .append(tableName)
                        .append("\n");

                ResultSet columns =
                        metaData.getColumns(null, null, tableName, "%");

                while (columns.next()) {

                    schema.append("  - ")
                            .append(columns.getString("COLUMN_NAME"))
                            .append(" : ")
                            .append(columns.getString("TYPE_NAME"))
                            .append("\n");

                }

                schema.append("\n");

            }

        } catch (Exception e) {

            return "Unable to read schema : " + e.getMessage();

        }

        return schema.toString();

    }

}