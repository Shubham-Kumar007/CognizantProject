package com.recruitment_service.feign;

import com.recruitment_service.entity.Candidate;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
/*Implementation of  Feign client for Consultancy Service*/
@FeignClient(value="Consultancy-service", url="http://localhost:8000/candidate/")
public interface ConsultancyFeign {

    @GetMapping("/{role}/{tech1}")
    List<Candidate> getCandidates(@PathVariable("role") String role, @PathVariable("tech1") String[] tech1);
}
