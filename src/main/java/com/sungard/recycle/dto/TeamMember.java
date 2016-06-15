package com.sungard.recycle.dto;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import javax.validation.constraints.Size;

import java.io.Serializable;

/**
 * Created by Manjit.Kumar on 6/9/2016.
 */
@Entity
@Table(name="TEAM_MEMBER")
public class TeamMember implements Serializable{

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE,generator = "team_member_gen")
    @SequenceGenerator(name = "team_member_gen", sequenceName = "team_member_seq", allocationSize = 1, initialValue = 0)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "EMP_ID", nullable = false)
    private Long empID;

    @Column(name = "EMP_NAME", nullable = false)
    private String empName;

    @Column(name = "TEAM_NAME", nullable = false)
    private String teamName;

    @Column(name = "EMAIL_ID", nullable = false)
    private String emailId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEmpID() {
        return empID;
    }

    public void setEmpID(Long empID) {
        this.empID = empID;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
}
