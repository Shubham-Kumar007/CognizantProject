package com.consultancy_service.controller;

import com.consultancy_service.entity.Candidate;
import com.consultancy_service.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/candidate")
public class CandidateController {
    @Autowired
    private CandidateService candidateService;

    @PostMapping
    public void saveCandidate() {
        this.candidateService.saveCandidate();
    }

    @GetMapping
    public List<Candidate> getAllCandidates(){
        return this.candidateService.getCandidates();

    }

    @GetMapping("/{role}/{tech1}")
    public List<Candidate> getCandidateDataByTechnology1(@PathVariable("role") String role,@PathVariable("tech1") String[] tech1){
             return candidateService.getCandidateByTechnologyInfo(role,tech1);
    }

}
