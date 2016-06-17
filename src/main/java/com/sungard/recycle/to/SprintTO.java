package com.sungard.recycle.to;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SprintTO {
    private Long id;
    private String name;
    private Date startDate;
    private Date endDate;
    private Integer noOfDays = 0;
    private Integer noOfTeamMembers = 0;
    private BigDecimal sprintTotal = new BigDecimal(0.0);
    private BigDecimal actualTotal = new BigDecimal(0.0);
    private String sprintStatus;
    private Long teamId;
    private String teamName;
    private List<TeamMemberTO> teamMemberTOs = new ArrayList<TeamMemberTO>();
    private List<SprintGoalTO> sprintGoalTOs = new ArrayList<SprintGoalTO>();
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
     * @return the name
     */
    public String getName() {
        return name;
    }
    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * @return the startDate
     */
    public Date getStartDate() {
        return startDate;
    }
    /**
     * @param startDate the startDate to set
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    /**
     * @return the endDate
     */
    public Date getEndDate() {
        return endDate;
    }
    /**
     * @param endDate the endDate to set
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    /**
     * @return the noOfDays
     */
    public Integer getNoOfDays() {
        return noOfDays;
    }
    /**
     * @param noOfDays the noOfDays to set
     */
    public void setNoOfDays(Integer noOfDays) {
        this.noOfDays = noOfDays;
    }
    /**
     * @return the noOfTeamMembers
     */
    public Integer getNoOfTeamMembers() {
        return noOfTeamMembers;
    }
    /**
     * @param noOfTeamMembers the noOfTeamMembers to set
     */
    public void setNoOfTeamMembers(Integer noOfTeamMembers) {
        this.noOfTeamMembers = noOfTeamMembers;
    }
    /**
     * @return the sprintTotal
     */
    public BigDecimal getSprintTotal() {
        return sprintTotal;
    }
    /**
     * @param sprintTotal the sprintTotal to set
     */
    public void setSprintTotal(BigDecimal sprintTotal) {
        this.sprintTotal = sprintTotal;
    }
    /**
     * @return the actualTotal
     */
    public BigDecimal getActualTotal() {
        return actualTotal;
    }
    /**
     * @param actualTotal the actualTotal to set
     */
    public void setActualTotal(BigDecimal actualTotal) {
        this.actualTotal = actualTotal;
    }
    /**
     * @return the sprintStatus
     */
    public String getSprintStatus() {
        return sprintStatus;
    }
    /**
     * @param sprintStatus the sprintStatus to set
     */
    public void setSprintStatus(String sprintStatus) {
        this.sprintStatus = sprintStatus;
    }
    /**
     * @return the teamId
     */
    public Long getTeamId() {
        return teamId;
    }
    /**
     * @param teamId the teamId to set
     */
    public void setTeamId(Long teamId) {
        this.teamId = teamId;
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
     * @return the teamMemberTOs
     */
    public List<TeamMemberTO> getTeamMemberTOs() {
        return teamMemberTOs;
    }
    /**
     * @param teamMemberTOs the teamMemberTOs to set
     */
    public void setTeamMemberTOs(List<TeamMemberTO> teamMemberTOs) {
        this.teamMemberTOs = teamMemberTOs;
    }
    /**
     * @return the sprintGoalTOs
     */
    public List<SprintGoalTO> getSprintGoalTOs() {
        return sprintGoalTOs;
    }
    /**
     * @param sprintGoalTOs the sprintGoalTOs to set
     */
    public void setSprintGoalTOs(List<SprintGoalTO> sprintGoalTOs) {
        this.sprintGoalTOs = sprintGoalTOs;
    }
    

}
