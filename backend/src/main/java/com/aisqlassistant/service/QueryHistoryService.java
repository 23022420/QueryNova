package com.aisqlassistant.service;

import com.aisqlassistant.entity.QueryHistory;
import com.aisqlassistant.repository.QueryHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QueryHistoryService {

    private final QueryHistoryRepository repository;

    public QueryHistory save(QueryHistory history) {

        if (history.getCreatedAt() == null) {
            history.setCreatedAt(LocalDateTime.now());
        }

        return repository.save(history);
    }

    public List<QueryHistory> getAllHistory() {
        return repository.findAllByOrderByCreatedAtDesc();
    }

    public Optional<QueryHistory> getById(Long id) {
        return repository.findById(id);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    public long getHistoryCount() {
        return repository.count();
    }
}