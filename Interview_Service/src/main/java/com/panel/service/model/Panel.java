package com.panel.service.model;

import javax.persistence.*;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Panel_Info")
/*This is Panel Entity */
public class Panel {
    @Id
    private long panelId;
    private String panelName;
    private String technology;
    private Time free_time_starts;
    private Time free_time_ends;
    @Transient
    private boolean isAvailable= true;
    @OneToMany(mappedBy = "panel",
            orphanRemoval = true,
            cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Interviewer> interviewers= new ArrayList<>();

    public Panel() {
    }

    public Panel(String panelName, String technology, Time free_time_starts, Time free_time_ends) {
        this.panelName = panelName;
        this.technology = technology;
        this.free_time_starts = free_time_starts;
        this.free_time_ends = free_time_ends;
    }

    public String getTechnology() {
        return technology;
    }

    public void setTechnology(String technology) {
        this.technology = technology;
    }

    public long getPanelId() {
        return panelId;
    }

    public void setPanelId(long panelId) {
        this.panelId = panelId;
    }

    public String getPanelName() {
        return panelName;
    }

    public void setPanelName(String panelName) {
        this.panelName = panelName;
    }

    public Time getFree_time_starts() {
        return free_time_starts;
    }

    public void setFree_time_starts(Time free_time_starts) {
        this.free_time_starts = free_time_starts;
    }

    public Time getFree_time_ends() {
        return free_time_ends;
    }

    public void setFree_time_ends(Time free_time_ends) {
        this.free_time_ends = free_time_ends;
    }

    public List<Interviewer> getInterviewers() {
        return interviewers;
    }

    public void setInterviewers(List<Interviewer> interviewers) {
        this.interviewers = interviewers;
    }

    public boolean isAvailable() {
        return isAvailable;
    }
    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return "Panel{" +
                "panelId=" + panelId +
                ", panelName='" + panelName + '\'' +
                ", Technology='" + technology + '\'' +
                ", free_time_starts=" + free_time_starts +
                ", free_time_ends=" + free_time_ends +
                ", isAvailable=" + isAvailable +
                ", interviewers=" + interviewers +
                '}';
    }
}
