package com.aisqlassistant.service;

import org.springframework.stereotype.Service;

@Service
public class AutoFixService {

    public String fix(String sql) {

        return sql.trim()
                .replaceAll("\\s+", " ");
    }

}