package com.sungard.recycle.to;

import java.math.BigDecimal;

public class TeamMemberTO {
    private Long id;
    private Long empID;
    private String empName;
    private String teamName;
    private String emailId;
    private Long votingpoints;
    private BigDecimal teamMemberTotal;
    private boolean isSelected;

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
     * @return the teamName
     */
    public String getTeamName() {
        return teamName;
    }

    /**
     * @param teamName the teamName to set
     */
    public void setTeamName(String teamName) {
        this.teamName = teamName;
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
     * @return the votingpoints
     */
    public Long getVotingpoints() {
        return votingpoints;
    }

    /**
     * @param votingpoints the votingpoints to set
     */
    public void setVotingpoints(Long votingpoints) {
        this.votingpoints = votingpoints;
    }

    /**
     * @return the teamMemberTotal
     */
    public BigDecimal getTeamMemberTotal() {
        return teamMemberTotal;
    }

    /**
     * @param teamMemberTotal the teamMemberTotal to set
     */
    public void setTeamMemberTotal(BigDecimal teamMemberTotal) {
        this.teamMemberTotal = teamMemberTotal;
    }

    /**
     * @return the isSelected
     */
    public boolean isSelected() {
        return isSelected;
    }

    /**
     * @param isSelected the isSelected to set
     */
    public void setSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }

}
