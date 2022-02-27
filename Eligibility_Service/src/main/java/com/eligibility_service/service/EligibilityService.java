package com.eligibility_service.service;


import com.eligibility_service.entity.Candidate;
import com.eligibility_service.feign.EligibilityFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EligibilityService {
/* These are criteria on basis of which the list of candidate is filtered*/
    @Value("${year_of_passing}")
   int year_of_passing;

    @Value("${no_of_gaps}")
    int no_of_gaps;

    @Value("${standing_backlogs}")
    int standing_backlogs;

    @Value("${percentage}")
   float percentage;
    @Autowired
    private EligibilityFeign eligibilityFeign;

    /*Method is used to filter the list of candidates received from recruitment service on basis of criteria set
    *url:  http://localhost:8002/eligible/isEligible
    * Zuule url: http://localhost:8765/Service3/eligible/isEligible
    * */
    public List<Candidate> getAllEligibleCandids(){
        List<Candidate> candids= new ArrayList<>();
         List<Candidate> candidates= eligibilityFeign.getCandidates();
         for(Candidate c5:candidates){
              if(c5.getGap_in_education()<=no_of_gaps && c5.getPercentage()>=percentage &&
                      c5.getStanding_backlog()<=standing_backlogs &&
                                c5.getYear_of_passing()>=year_of_passing){
                  candids.add(c5);
              }
         }
         return candids;
    }
}
