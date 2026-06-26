package com.aisqlassistant.service;

import com.aisqlassistant.entity.SavedQuery;
import com.aisqlassistant.repository.SavedQueryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SavedQueryService {

    private final SavedQueryRepository repository;

    public SavedQuery save(SavedQuery query) {

        return repository.save(query);

    }

    public List<SavedQuery> getAll() {

        return repository.findAll();

    }

    public void delete(Long id) {

        repository.deleteById(id);

    }

}