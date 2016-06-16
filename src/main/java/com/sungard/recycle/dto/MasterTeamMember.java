package com.sungard.recycle.dto;

import javax.persistence.*;

/**
 * Created by Rakesh.Sharma on 6/11/2016.
 */
@Entity
@Table(name="Master_Team_Member")
public class MasterTeamMember {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE,generator = "master_team_member_gen")
    @SequenceGenerator(name = "master_team_member_gen", sequenceName = "master_team_member_seq", allocationSize = 1, initialValue = 0)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;
    private String empName;
    private String description;
    private String status;
    private String emailId;
    @ManyToOne
    private MasterTeam masterTeam;
    private Long empID;
    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }
    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }
    /**
     * @return the empName
     */
    public String getEmpName() {
        return empName;
    }
    /**
     * @param empName the empName to set
     */
    public void setEmpName(String empName) {
        this.empName = empName;
    }
    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }
    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }
    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }
    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }
    /**
     * @return the emailId
     */
    public String getEmailId() {
        return emailId;
    }
    /**
     * @param emailId the emailId to set
     */
    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
    /**
     * @return the masterTeam
     */
    public MasterTeam getMasterTeam() {
        return masterTeam;
    }
    /**
     * @param masterTeam the masterTeam to set
     */
    public void setMasterTeam(MasterTeam masterTeam) {
        this.masterTeam = masterTeam;
    }
    /**
     * @return the empID
     */
    public Long getEmpID() {
        return empID;
    }
    /**
     * @param empID the empID to set
     */
    public void setEmpID(Long empID) {
        this.empID = empID;
    }
    
}

