package com.audit_service.controller;

import com.audit_service.config.InterviewMessagingConfig;
import com.audit_service.model.CandidatePanelInfo;
import com.audit_service.model.PanelCandid;
import com.audit_service.service.InterviewAuditService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Component
@RequestMapping("/audit")
public class AuditController {

    @Autowired
       private InterviewAuditService interviewAuditService;
    Logger logger= LoggerFactory.getLogger(AuditController.class);

@GetMapping("/")
  public List<PanelCandid> findAllPanelCandidInfo(){
    return this.interviewAuditService.findAllPanelCandidInfo();
}
}
