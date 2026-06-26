package com.aisqlassistant.service;

import org.springframework.stereotype.Service;

@Service
public class AuditService {

    public void saveLog(String username,
                        String action,
                        String description) {

        System.out.println(
                username +
                " | " +
                action +
                " | " +
                description
        );

    }

}