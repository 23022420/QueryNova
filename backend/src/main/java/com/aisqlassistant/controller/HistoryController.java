package com.aisqlassistant.controller;

import com.aisqlassistant.entity.QueryHistory;
import com.aisqlassistant.service.QueryHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/history")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class HistoryController {

    private final QueryHistoryService historyService;

    @GetMapping
    public List<QueryHistory> getHistory() {

        return historyService.getAllHistory();

    }

    @PostMapping
    public QueryHistory saveHistory(
            @RequestBody QueryHistory history) {

        return historyService.save(history);

    }

    @DeleteMapping("/{id}")
    public void deleteHistory(
            @PathVariable Long id) {

        historyService.delete(id);

    }

}