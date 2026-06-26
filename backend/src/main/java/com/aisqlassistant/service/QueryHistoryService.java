package com.aisqlassistant.service;

import com.aisqlassistant.entity.QueryHistory;
import com.aisqlassistant.repository.QueryHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QueryHistoryService {

    private final QueryHistoryRepository repository;

    public QueryHistory save(QueryHistory history) {

        return repository.save(history);

    }

    public List<QueryHistory> getAllHistory() {

        return repository.findAll();

    }

    public void delete(Long id) {

        repository.deleteById(id);

    }

}