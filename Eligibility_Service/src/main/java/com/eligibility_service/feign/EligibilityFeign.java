package com.eligibility_service.feign;


import com.eligibility_service.entity.Candidate;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
/*Implementation of Feign client for recruitment service */
@FeignClient(value="eligibility-service", url="http://localhost:8001/recruit/")
public interface EligibilityFeign {
//localhost:8001/candidate/FrontendDeveloper/Go,Java
    @GetMapping("/isEligible")
    public List<Candidate> getCandidates();

}
