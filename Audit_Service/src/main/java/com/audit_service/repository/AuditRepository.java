package com.audit_service.repository;

import com.audit_service.model.PanelCandid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*JpaRepository Interface for PanelCandidClass*/
@Repository
public interface AuditRepository extends JpaRepository<PanelCandid,Integer> {
}
