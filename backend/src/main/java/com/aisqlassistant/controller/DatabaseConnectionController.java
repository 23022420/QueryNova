package com.aisqlassistant.controller;

import com.aisqlassistant.entity.DatabaseConnection;
import com.aisqlassistant.service.DatabaseConnectionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/database")
@RequiredArgsConstructor
public class DatabaseConnectionController {

    private final DatabaseConnectionService service;

    @PostMapping("/save")
    public DatabaseConnection save(
            @RequestBody DatabaseConnection connection) {

        return service.save(connection);

    }

    @GetMapping("/all")
    public List<DatabaseConnection> all() {

        return service.getAllConnections();

    }

    @PostMapping("/test")
    public boolean test(
            @RequestBody DatabaseConnection connection) {

        return service.testConnection(connection);

    }

}