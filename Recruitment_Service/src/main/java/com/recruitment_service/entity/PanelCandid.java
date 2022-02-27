package com.recruitment_service.entity;


public class PanelCandid {
    private int pid;
    private long  panelId;
    private String panelName;
    private int candidateId;
    private String candidateName;
    private String technology;

    public PanelCandid() {
    }

    public PanelCandid(int pid, long panelId, String panelName, String candidateName, String technology) {
        this.pid = pid;
        this.panelId = panelId;
        this.panelName = panelName;
        this.candidateName = candidateName;
        this.technology = technology;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
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

    public int getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(int candidateId) {
        this.candidateId = candidateId;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public void setCandidateName(String candidateName) {
        this.candidateName = candidateName;
    }

    public String getTechnology() {
        return technology;
    }

    public void setTechnology(String technology) {
        this.technology = technology;
    }

    @Override
    public String toString() {
        return "PanelCandid{" +
                "pid=" + pid +
                ", panelId=" + panelId +
                ", panelName='" + panelName + '\'' +
                ", candidateId=" + candidateId +
                ", candidateName='" + candidateName + '\'' +
                ", technology='" + technology + '\'' +
                '}';
    }
}
