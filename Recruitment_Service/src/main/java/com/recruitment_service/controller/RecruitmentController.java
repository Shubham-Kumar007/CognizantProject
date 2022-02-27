package com.recruitment_service.controller;

import com.recruitment_service.entity.Candidate;
import com.recruitment_service.entity.PanelCandid;
import com.recruitment_service.service.RecruitmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/recruit")
public class RecruitmentController {
    @Autowired
    private RecruitmentService recruitmentService;

    @GetMapping("/{role}/{tech1}")
    public List<Candidate> getDetails(@PathVariable("role") String role, @PathVariable("tech1") String[] tech1){
        return this.recruitmentService.getCandidateByTechnologyDetails(role,tech1);
    }



    @GetMapping("/isEligible")
    public  List<Candidate> getAllDetails(){
        return this.recruitmentService.getAllCandidInfo();
    }

    @GetMapping("/eligible")
    public List<Candidate> getAllEligibleList(){
        return this.recruitmentService.getEligibleCandidatesInfo();
    }
    @GetMapping("/audit")
    public List<PanelCandid> getAllAuditDatas(){
        return this.recruitmentService.getAllPanelCandidInfo();
    }
}
