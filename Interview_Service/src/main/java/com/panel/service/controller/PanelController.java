package com.panel.service.controller;

import com.panel.service.config.InterviewMessagingConfig;
import com.panel.service.mapping.CandidatePanelInfo;
import com.panel.service.model.Interviewer;
import com.panel.service.model.Panel;
import com.panel.service.service.PanelSevice;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/panel")
public class PanelController {
    @Autowired
    private PanelSevice panelSevice;

    @Autowired
    private RabbitTemplate template;
    @PostMapping
    public Panel savePanelData(@RequestBody Panel panel){
        List<Interviewer> list1=panel.getInterviewers();
        list1.forEach(interviewer -> {
            interviewer.setPanel(panel);
        });
        return  this.panelSevice.savePanel(panel);
    }
    @GetMapping
    public List<Panel> getPanelInfos(){
        return this.panelSevice.getPanels();
    }

    @GetMapping("/interview")
    public List<CandidatePanelInfo> getInterviewDetailsOfStudent(){
        List<CandidatePanelInfo> cpi=this.panelSevice.getPanelAssignedToCandid();
        for(CandidatePanelInfo cpi1:cpi){
            template.convertAndSend(InterviewMessagingConfig.EXCHANGE, InterviewMessagingConfig.ROUTING_KEY,cpi1);
        }
        return cpi;
    }
}


