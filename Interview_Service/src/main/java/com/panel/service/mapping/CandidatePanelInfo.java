package com.panel.service.mapping;

import com.panel.service.model.Candidate;
import com.panel.service.model.Panel;
import java.sql.Date;
/*This Class is introduced  to store the Panel Detail ,Candidate Detail  along with Date of Interview Schedued*/
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
