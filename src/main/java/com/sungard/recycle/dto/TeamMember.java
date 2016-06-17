package com.sungard.recycle.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.*;

/**
 * Created by Manjit.Kumar on 6/9/2016.
 */
@Entity
@Table(name = "TEAM_MEMBER")
public class TeamMember implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -894319003473501681L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "team_member_gen")
    @SequenceGenerator(name = "team_member_gen", sequenceName = "team_member_seq", allocationSize = 1, initialValue = 0)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "EMP_ID")
    private Long empID;

    @Column(name = "EMP_NAME")
    private String empName;

    @Column(name = "TEAM_NAME")
    private String teamName;

    @Column(name = "EMAIL_ID")
    private String emailId;
    @Column(name = "votingpoints")
    private Long votingpoints = 0l;
    private BigDecimal teamMemberTotal = new BigDecimal(0.0);
    
    @ManyToOne
    @JoinColumn(nullable = false, updatable = false)
    private TeamDetail teamDetail;
    @Transient
    private boolean isSelected;

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public Long getVotingpoints() {
        return votingpoints;
    }

    public void setVotingpoints(Long votingpoints) {
        this.votingpoints = votingpoints;
    }

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

    public BigDecimal getTeamMemberTotal() {
        return teamMemberTotal;
    }

    public void setTeamMemberTotal(BigDecimal teamMemberTotal) {
        this.teamMemberTotal = teamMemberTotal;
    }

    /**
     * @return the teamDetail
     */
    public TeamDetail getTeamDetail() {
        return teamDetail;
    }

    /**
     * @param teamDetail the teamDetail to set
     */
    public void setTeamDetail(TeamDetail teamDetail) {
        this.teamDetail = teamDetail;
    }
}
