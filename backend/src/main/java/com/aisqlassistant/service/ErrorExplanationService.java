package com.aisqlassistant.service;

import org.springframework.stereotype.Service;

@Service
public class ErrorExplanationService {

    public String explain(String error) {

        return switch (error.toLowerCase()) {

            case "syntax" ->
                    "SQL syntax is incorrect.";

            case "table" ->
                    "Referenced table does not exist.";

            case "column" ->
                    "Referenced column not found.";

            default ->
                    "Unknown SQL error.";
        };

    }

}