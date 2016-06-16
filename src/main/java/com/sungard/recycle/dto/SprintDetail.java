package com.sungard.recycle.dto;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Created by Rakesh.Sharma on 6/11/2016.
 */
@Entity
@Table(name = "Sprint_Detail")
public class SprintDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sprint_detail_gen")
    @SequenceGenerator(name = "sprint_detail_gen", sequenceName = "sprint_detail_seq", allocationSize = 1, initialValue = 0)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;
    private String name;
    private Date startDate;
    private Date endDate;
    private Integer noOfDays;
    private Integer noOfTeamMembers;
    private BigDecimal sprintTotal;
    private BigDecimal actualTotal;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Integer getNoOfDays() {
        return noOfDays;
    }

    public void setNoOfDays(Integer noOfDays) {
        this.noOfDays = noOfDays;
    }

    public Integer getNoOfTeamMembers() {
        return noOfTeamMembers;
    }

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

   
}
