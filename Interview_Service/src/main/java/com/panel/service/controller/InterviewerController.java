package com.panel.service.controller;

import com.panel.service.model.Interviewer;
import com.panel.service.model.Panel;
import com.panel.service.service.InterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/interview")
public class InterviewerController {

    @Autowired
    private InterviewService interviewService;

    @PostMapping
    public Interviewer saveInterviewerInfo(@RequestBody Interviewer interviewer){
        return this.interviewService.saveInterviewer(interviewer);
    }
    @GetMapping
    public List<Interviewer> getAllInterviewer(){
        return this.interviewService.findAllInterviewer();
    }
}
