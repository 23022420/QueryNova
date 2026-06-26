package com.aisqlassistant.controller;

import com.aisqlassistant.dto.request.QueryRequest;
import com.aisqlassistant.service.AIQueryService;
import com.aisqlassistant.service.QueryExecutionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/query")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class QueryController {

    private final AIQueryService aiQueryService;
    private final QueryExecutionService queryExecutionService;

   @PostMapping("/generate")
public ResponseEntity<?> generateQuery(
        @RequestBody QueryRequest request) {

    return ResponseEntity.ok(

            aiQueryService.generateSql(

                    request.getPrompt(),
                    request.getUrl(),
                    request.getUsername(),
                    request.getPassword()

            )

    );

}

    @PostMapping("/format")
    public ResponseEntity<?> formatQuery(
            @RequestBody Map<String, String> request) {

        return ResponseEntity.ok(
                aiQueryService.formatSql(request.get("query"))
        );
    }

    @PostMapping("/difficulty")
    public ResponseEntity<?> difficulty(
            @RequestBody Map<String, String> request) {

        return ResponseEntity.ok(
                aiQueryService.calculateDifficulty(request.get("query"))
        );
    }

    @PostMapping("/danger")
    public ResponseEntity<?> danger(
            @RequestBody Map<String, String> request) {

        return ResponseEntity.ok(
                aiQueryService.detectDangerousQuery(request.get("query"))
        );
    }

    @PostMapping("/optimize")
    public ResponseEntity<?> optimize(
            @RequestBody Map<String, String> request) {

        return ResponseEntity.ok(
                aiQueryService.optimizeQuery(request.get("query"))
        );
    }

    @PostMapping("/explain")
    public ResponseEntity<?> explain(
            @RequestBody Map<String, String> request) {

        return ResponseEntity.ok(
                aiQueryService.explainQuery(request.get("query"))
        );
    }

    @PostMapping("/autofix")
    public ResponseEntity<?> autofix(
            @RequestBody Map<String, String> request) {

        return ResponseEntity.ok(
                aiQueryService.autoFixQuery(request.get("query"))
        );
    }

    @PostMapping("/execute")
    public ResponseEntity<?> execute(
            @RequestBody QueryRequest request) {

        return ResponseEntity.ok(
                queryExecutionService.executeQuery(
                        request.getUrl(),
                        request.getUsername(),
                        request.getPassword(),
                        request.getSql()
                )
        );
    }
}