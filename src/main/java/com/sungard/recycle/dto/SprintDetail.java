package com.sungard.recycle.dto;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Rakesh.Sharma on 6/11/2016.
 */
@Entity
@Table(name="Sprint_Detail")
public class SprintDetail {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE,generator = "sprint_detail_gen")
    @SequenceGenerator(name = "sprint_detail_gen", sequenceName = "sprint_detail_seq", allocationSize = 1, initialValue = 0)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;
    private String name;
    private Date startDate;
    private Date endDate;
    private Integer noOfDays;
    private Integer noOfTeamMembers;
    private Integer sprintTotal;
    private Integer actualTotal;

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

    public Integer getSprintTotal() {
        return sprintTotal;
    }

    public void setSprintTotal(Integer sprintTotal) {
        this.sprintTotal = sprintTotal;
    }

    public Integer getActualTotal() {
        return actualTotal;
    }

    public void setActualTotal(Integer actualTotal) {
        this.actualTotal = actualTotal;
    }
}
