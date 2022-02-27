package com.audit_service.service;

import com.audit_service.config.InterviewMessagingConfig;
import com.audit_service.model.CandidatePanelInfo;
import com.audit_service.model.PanelCandid;
import com.audit_service.repository.AuditRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InterviewAuditService {
    @Autowired
    private AuditRepository auditRepository;
 /*Consuming the queue data at the consumer side, in this case , the consumer is our audit Service Class*/
    @RabbitListener(queues= InterviewMessagingConfig.QUEUE)
    public void savePanelCandidInfoToDB(CandidatePanelInfo candidatePanelInfo){
        try {
            PanelCandid panelCandid= new PanelCandid();
            panelCandid.setPanelId(candidatePanelInfo.getPanel().getPanelId());
            panelCandid.setPanelName(candidatePanelInfo.getPanel().getPanelName());
            panelCandid.setCandidateId(candidatePanelInfo.getCandidate().getId());
            panelCandid.setCandidateName(candidatePanelInfo.getCandidate().getFirstName());
            panelCandid.setTechnology(candidatePanelInfo.getCandidate().getTech1());
            this.auditRepository.save(panelCandid);
            System.out.println(candidatePanelInfo.getPanel() + "  " + candidatePanelInfo.getCandidate() + " " +
                    candidatePanelInfo.getDate_of_Interview());
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
/*This mehod is  to fetch all the panelcandid list stored in the database
    url:   localhost:8004/audit/
*/
    public List<PanelCandid> findAllPanelCandidInfo(){
        return this.auditRepository.findAll();
    }


}
