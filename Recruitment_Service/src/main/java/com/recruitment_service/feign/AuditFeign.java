package com.recruitment_service.feign;

import com.recruitment_service.entity.PanelCandid;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(value="Audit-Service",url="http://localhost:8004/audit/")
public interface AuditFeign {
    @GetMapping("/")
    public List<PanelCandid> getAllPanelCandid();
}
