package com.aisqlassistant.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "audit_logs")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuditLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String action;

    @Column(nullable = false)
    private String queryType;

    @Lob
    private String sqlQuery;

    @Column(nullable = false)
    private String status;

    private String ipAddress;

    private String executedBy;

    private Long executionTimeMs;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    private LocalDateTime executedAt;

    @PrePersist
    public void prePersist() {
        executedAt = LocalDateTime.now();
    }
}