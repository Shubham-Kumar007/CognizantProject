package com.panel.service.service;

import com.panel.service.model.Interviewer;
import com.panel.service.repository.InterviewerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InterviewService {
    @Autowired
    private InterviewerRepository interviewerRepository;

    public Interviewer saveInterviewer(Interviewer interviewer){
       return  this.interviewerRepository.save(interviewer);
    }

    public List<Interviewer>  findAllInterviewer(){
        return  this.interviewerRepository.findAll();
    }
}

