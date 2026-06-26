package com.aisqlassistant.repository;

import com.aisqlassistant.entity.QueryHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QueryHistoryRepository
        extends JpaRepository<QueryHistory, Long> {

}