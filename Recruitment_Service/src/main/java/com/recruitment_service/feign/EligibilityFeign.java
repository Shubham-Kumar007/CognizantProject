package com.recruitment_service.feign;

import com.recruitment_service.entity.Candidate;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
/*Implementation of Feign client for Eligibility Service*/
@FeignClient(value="Eligibility-Service", url="localhost:8002/eligible/")
public interface EligibilityFeign {

    @GetMapping("/isEligible")
    List<Candidate> getAllEligibleCandidates();
}
