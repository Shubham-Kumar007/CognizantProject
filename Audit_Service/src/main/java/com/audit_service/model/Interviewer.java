package com.audit_service.model;

//import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

//@Entity
//@Table(name = "Interviewer")
public class Interviewer {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private long interviewerId;
    private String interviewerName;
    private String designation;
    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "panelId")
    private Panel panel;
    public Interviewer() {
    }

    public Interviewer(long interviewerId, String interviewerName, String designation) {
        this.interviewerId = interviewerId;
        this.interviewerName = interviewerName;
        this.designation = designation;
    }

    public long getInterviewerId() {
        return interviewerId;
    }

    public void setInterviewerId(long interviewerId) {
        this.interviewerId = interviewerId;
    }

    public String getInterviewerName() {
        return interviewerName;
    }

    public void setInterviewerName(String interviewerName) {
        this.interviewerName = interviewerName;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }
  @JsonIgnore
    public Panel getPanel() {
        return panel;
    }

    public void setPanel(Panel panel) {
        this.panel = panel;
    }

    @Override
    public String toString() {
        return "Interviewer{" +
                "interviewerId=" + interviewerId +
                ", interviewerName='" + interviewerName + '\'' +
                ", designation='" + designation + '\'' +
                '}';
    }
}
