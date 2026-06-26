package com.aisqlassistant.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "query_history")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QueryHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    @Column(nullable = false)
    private String userPrompt;

    @Lob
    @Column(nullable = false)
    private String generatedQuery;

    @Lob
    private String optimizedQuery;

    @Column(nullable = false)
    private String databaseType;

    @Column(nullable = false)
    private String queryType;

    @Column(nullable = false)
    private String executionStatus;

    private Integer rowsAffected;

    private Long executionTimeMs;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
    }
}