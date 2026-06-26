package com.aisqlassistant.service;

import org.springframework.stereotype.Service;

@Service
public class DifficultyAnalyzerService {

    public String calculateDifficulty(String sql) {

        String query = sql.toUpperCase();

        int score = 0;

        if (query.contains("JOIN")) score += 25;
        if (query.contains("GROUP BY")) score += 20;
        if (query.contains("HAVING")) score += 20;
        if (query.contains("UNION")) score += 15;
        if (query.contains("SUBQUERY")) score += 20;

        if (score <= 20)
            return "EASY";

        if (score <= 50)
            return "MEDIUM";

        return "HARD";
    }

}