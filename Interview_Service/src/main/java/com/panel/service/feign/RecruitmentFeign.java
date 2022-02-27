package com.panel.service.feign;


import com.panel.service.model.Candidate;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
/*Implementation of Feign Client for Recruitment Service*/
@FeignClient(value = "Recruitment-Service", url= "http://localhost:8001/recruit/")
public interface RecruitmentFeign {

@GetMapping("/eligible")
     List<Candidate> getAllEligibleCandidates();
}
