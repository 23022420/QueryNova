package com.aisqlassistant.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchemaService {

    public List<String> getTables() {

        return List.of(
                "users",
                "orders",
                "employees",
                "products"
        );

    }

}