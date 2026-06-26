package com.aisqlassistant.controller;

import com.aisqlassistant.entity.SavedQuery;
import com.aisqlassistant.service.SavedQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/saved")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class SavedQueryController {

    private final SavedQueryService savedQueryService;

    @GetMapping
    public List<SavedQuery> getAll() {

        return savedQueryService.getAll();

    }

    @PostMapping
    public SavedQuery save(
            @RequestBody SavedQuery query) {

        return savedQueryService.save(query);

    }

    @DeleteMapping("/{id}")
    public void delete(
            @PathVariable Long id) {

        savedQueryService.delete(id);

    }

}