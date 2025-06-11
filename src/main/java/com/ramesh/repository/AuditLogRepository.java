package com.ramesh.repository;

import com.ramesh.entity.AuditLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditLogRepository  extends JpaRepository<AuditLog,Long> {
}
