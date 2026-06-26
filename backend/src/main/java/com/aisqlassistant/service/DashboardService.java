package com.aisqlassistant.service;

import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class DashboardService {

    public Map<String, Object> getDashboardStats() {

        Map<String, Object> stats = new LinkedHashMap<>();

        stats.put("totalQueries", 0);
        stats.put("successfulQueries", 0);
        stats.put("failedQueries", 0);
        stats.put("savedQueries", 0);
        stats.put("connectedDatabases", 0);

        return stats;
    }

}