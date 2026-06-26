package com.aisqlassistant.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.aisqlassistant.entity.QueryHistory;


@Service
@RequiredArgsConstructor
public class AIQueryService {

    private final GeminiService geminiService;
    private final SchemaReaderService schemaReaderService;
    private final QueryHistoryService queryHistoryService;
    // Current method (existing controller ke liye)
    public String generateSql(String prompt) {

    String finalPrompt = """
You are an expert SQL developer.

Convert the following natural language into ONLY executable SQL.

Rules:
- Return only SQL.
- Do not explain.
- Do not use markdown.
- Do not wrap in ```sql.

User Request:
""" + prompt;

    String sql = geminiService.askGemini(finalPrompt);

    QueryHistory history = QueryHistory.builder()
            .userPrompt(prompt)
            .generatedQuery(sql)
            .databaseType("Unknown")
            .queryType("AI_GENERATED")
            .executionStatus("GENERATED")
            .build();

    queryHistoryService.save(history);

    return sql;
}

    // Future method (Schema-aware SQL generation)
    public String generateSql(
            String prompt,
            String url,
            String username,
            String password) {

        String schema = schemaReaderService.readSchema(
                url,
                username,
                password
        );

        String finalPrompt = """
You are an expert SQL developer.

Database Schema:

""" + schema + """

Generate ONLY executable SQL.

Rules:
- Return only SQL.
- No explanation.
- No markdown.

User Request:
""" + prompt;

        String sql = geminiService.askGemini(finalPrompt);

QueryHistory history = QueryHistory.builder()
        .userPrompt(prompt)
        .generatedQuery(sql)
        .databaseType("Custom Database")
        .queryType("AI_GENERATED")
        .executionStatus("GENERATED")
        .build();

queryHistoryService.save(history);

return sql;
    }

    public String explainQuery(String sql) {

        return geminiService.askGemini("""
Explain the following SQL query in simple English.

SQL:
""" + sql);

    }

    public String optimizeQuery(String sql) {

        return geminiService.askGemini("""
Optimize the following SQL query.

Return ONLY optimized SQL.

SQL:
""" + sql);

    }

    public String autoFixQuery(String sql) {

        return geminiService.askGemini("""
Fix the syntax errors in the following SQL query.

Return ONLY corrected SQL.

SQL:
""" + sql);

    }

    public String formatSql(String sql) {

        return geminiService.askGemini("""
Format the following SQL query properly.

Return ONLY formatted SQL.

SQL:
""" + sql);

    }

    public String detectDangerousQuery(String sql) {

        return geminiService.askGemini("""
Determine whether the following SQL query is dangerous.

Respond exactly like this:

Safe: YES/NO
Reason: <reason>

SQL:
""" + sql);

    }

    public String calculateDifficulty(String sql) {

        return geminiService.askGemini("""
Rate the SQL query difficulty.

Respond exactly like this:

Difficulty: Easy/Medium/Hard
Reason: <reason>

SQL:
""" + sql);

    }
}