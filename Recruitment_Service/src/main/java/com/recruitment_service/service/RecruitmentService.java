package com.recruitment_service.service;

import com.recruitment_service.entity.Candidate;
import com.recruitment_service.entity.PanelCandid;
import com.recruitment_service.feign.AuditFeign;
import com.recruitment_service.feign.EligibilityFeign;
import com.recruitment_service.feign.ConsultancyFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class RecruitmentService {

    @Autowired
   private ConsultancyFeign consultancyFeign;

    @Autowired
            private EligibilityFeign eligibilityFeign;

    @Autowired
            private AuditFeign auditFeign;
    List<Candidate> candidateInfo= new ArrayList<>();
/*Method  to access the consultany service method using feign client to retrieve the
* list of candidate with given role and list of technology  and will store in temporary list CandidInfo
*   Url:   http://localhost:8001/recruit/role/tech1
* sameple Url: http://localhost:8001/recruit/FrontendDeveloper/Java,Go
* Zuule Url:  http://localhost:8765/Service2/recruit/FrontendDeveloper/Java,Go
* */
    //localhost:8001/candidate/FrontendDeveloper/Go,Java
    public List<Candidate> getCandidateByTechnologyDetails(String role, String[] tech1){
        List<Candidate> candidates= consultancyFeign.getCandidates(role, tech1) ;
        for(Candidate c:candidates){
            candidateInfo.add(c);
        }
        return candidates;
    }
    /*
    Method is used to return the list of  candidates from temporary list which will be used by Eligibility service for filteration
    url:http://localhost:8001/recruit/isEliibile
    Zuule url: http://localhost:8765/Service2/recruit/isEligibile
    */
    public List<Candidate> getAllCandidInfo(){
        return candidateInfo;
    }
/*  Method  will return list of candidates which have been retrieved from Eligibility service after filteration using eligibility  feign client
         url: http://localhost:8001/recruit/eligible
        Zuule url: http://localhost:8765/Service2/recruit/eligible
*/
    public List<Candidate> getEligibleCandidatesInfo(){
        List<Candidate> list1= new ArrayList<>();
        List<Candidate> candidates=  eligibilityFeign.getAllEligibleCandidates();
        for(Candidate c7:candidates){
            list1.add(c7);
        }
        return list1;
    }
  /* This method returns the data retrieved from the audi Service into the recruitment Service*/
    public List<PanelCandid> getAllPanelCandidInfo(){
        return auditFeign.getAllPanelCandid();
    }
}
