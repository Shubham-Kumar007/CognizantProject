package com.recruitment_service.entity;

import java.sql.Date;

public class Candidate {

    private int id;
    private String firstName;
    private  String lastName;
    private  long universityRegistrationNo;
    private String emailId;
    private  String mobile_no;
    private Date date_of_birth;
    private  String gender;
    private String nationality;
    private  String highest_qualification;
    private  String college_name;
    private  String branch;
    private  int year_of_passing;
    private int gap_in_education;
    private int standing_backlog;
    private Float percentage;
    private Date date_of_application;
    private String tech1;
    private String tech2;
    private String role;

    public Candidate() {
    }

    public Candidate(String firstName, String lastName, long universityRegistrationNo, String emailId, String mobile_no,
                     Date date_of_birth, String gender, String nationality, String highest_qualification, String college_name,
                     String branch, int year_of_passing, int gap_in_education,
                     int standing_backlog, float percentage, Date date_of_application, String tech1, String tech2, String role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.universityRegistrationNo = universityRegistrationNo;
        this.emailId = emailId;
        this.mobile_no = mobile_no;
        this.date_of_birth = date_of_birth;
        this.gender = gender;
        this.nationality = nationality;
        this.highest_qualification = highest_qualification;
        this.college_name = college_name;
        this.branch = branch;
        this.year_of_passing = year_of_passing;
        this.gap_in_education = gap_in_education;
        this.standing_backlog = standing_backlog;
        this.percentage = percentage;
        this.date_of_application = date_of_application;
        this.tech1 = tech1;
        this.tech2 = tech2;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public long getUniversityRegistrationNo() {
        return universityRegistrationNo;
    }

    public void setUniversityRegistrationNo(long universityRegistrationNo) {
        this.universityRegistrationNo = universityRegistrationNo;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getMobile_no() {
        return mobile_no;
    }

    public void setMobile_no(String mobile_no) {
        this.mobile_no = mobile_no;
    }

    public Date getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(Date date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getHighest_qualification() {
        return highest_qualification;
    }

    public void setHighest_qualification(String highest_qualification) {
        this.highest_qualification = highest_qualification;
    }

    public String getCollege_name() {
        return college_name;
    }

    public void setCollege_name(String college_name) {
        this.college_name = college_name;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public int getYear_of_passing() {
        return year_of_passing;
    }

    public void setYear_of_passing(int year_of_passing) {
        this.year_of_passing = year_of_passing;
    }

    public int getGap_in_education() {
        return gap_in_education;
    }

    public void setGap_in_education(int gap_in_education) {
        this.gap_in_education = gap_in_education;
    }

    public int getStanding_backlog() {
        return standing_backlog;
    }

    public void setStanding_backlog(int standing_backlog) {
        this.standing_backlog = standing_backlog;
    }

    public Float getPercentage() {
        return percentage;
    }

    public void setPercentage(Float percentage) {
        this.percentage = percentage;
    }

    public Date getDate_of_application() {
        return date_of_application;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setDate_of_application(Date date_of_application) {
        this.date_of_application = date_of_application;
    }

    public String getTech1() {
        return tech1;
    }

    public void setTech1(String tech1) {
        this.tech1 = tech1;
    }

    public String getTech2() {
        return tech2;
    }

    public void setTech2(String tech2) {
        this.tech2 = tech2;
    }

    @Override
    public String toString() {
        return "Candidate{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", universityRegistrationNo=" + universityRegistrationNo +
                ", emailId='" + emailId + '\'' +
                ", mobile_no='" + mobile_no + '\'' +
                ", date_of_birth=" + date_of_birth +
                ", gender='" + gender + '\'' +
                ", nationality='" + nationality + '\'' +
                ", highest_qualification='" + highest_qualification + '\'' +
                ", college_name='" + college_name + '\'' +
                ", branch='" + branch + '\'' +
                ", year_of_passing=" + year_of_passing +
                ", gap_in_education=" + gap_in_education +
                ", standing_backlog=" + standing_backlog +
                ", percentage=" + percentage +
                ", date_of_application=" + date_of_application +
                ", tech1='" + tech1 + '\'' +
                ", tech2='" + tech2 + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
