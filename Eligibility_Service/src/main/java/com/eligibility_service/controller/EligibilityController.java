package com.eligibility_service.controller;


import com.eligibility_service.config.EligibilityMessagingConfig;
import com.eligibility_service.entity.Candidate;
import com.eligibility_service.service.EligibilityService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/eligible")
public class EligibilityController {

    @Autowired
    private EligibilityService eligibilityService;

    @Autowired
    private RabbitTemplate template;

@GetMapping("/isEligible")
    public List<Candidate> getCandidates(){
    List<Candidate> candidates5=  this.eligibilityService.getAllEligibleCandids();
    for(Candidate c8:candidates5){
        template.convertAndSend(EligibilityMessagingConfig.EXCHANGE_1, EligibilityMessagingConfig.ROUTING_KEY_1,c8);
    }
    return candidates5;
}
}
