package com.aisqlassistant.repository;

import com.aisqlassistant.entity.SavedQuery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SavedQueryRepository extends JpaRepository<SavedQuery, Long> {
}