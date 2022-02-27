package com.audit_service.model;

import java.sql.Date;

//@Entity
public class CandidatePanelInfo {

    private Panel panel;
    private Candidate candidate;
    private Date date_of_Interview;

    public Panel getPanel() {
        return panel;
    }

    public void setPanel(Panel panel) {
        this.panel = panel;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }

    public Date getDate_of_Interview() {
        return date_of_Interview;
    }

    public void setDate_of_Interview(Date date_of_Interview) {
        this.date_of_Interview = date_of_Interview;
    }
}
