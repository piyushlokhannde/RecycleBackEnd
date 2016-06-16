package com.sungard.recycle.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Created by Rakesh.Sharma on 6/11/2016.
 */
@Entity
@Table(name = "Sprint_Goal")
public class SprintGoal {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sprint_goal_gen")
    @SequenceGenerator(name = "sprint_goal_gen", sequenceName = "sprint_goal_seq", allocationSize = 1, initialValue = 0)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;
    private String goalName;
    private String description;
    @ManyToOne
    private SprintDetail sprintDetail;
    private BigDecimal weightage = new BigDecimal(0.0);
    private BigDecimal expectedTotal = new BigDecimal(0.0);
    private BigDecimal actualTotal = new BigDecimal(0.0);
    @OneToMany(cascade = CascadeType.ALL)
    private List<SprintParameter> sprintParameters = new ArrayList<SprintParameter>();

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
     * @return the goalName
     */
    public String getGoalName() {
        return goalName;
    }

    /**
     * @param goalName the goalName to set
     */
    public void setGoalName(String goalName) {
        this.goalName = goalName;
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
     * @return the sprintDetail
     */
    public SprintDetail getSprintDetail() {
        return sprintDetail;
    }

    /**
     * @param sprintDetail the sprintDetail to set
     */
    public void setSprintDetail(SprintDetail sprintDetail) {
        this.sprintDetail = sprintDetail;
    }

    /**
     * @return the sprintParameters
     */
    public List<SprintParameter> getSprintParameters() {
        return sprintParameters;
    }

    /**
     * @param sprintParameters the sprintParameters to set
     */
    public void setSprintParameters(List<SprintParameter> sprintParameters) {
        this.sprintParameters = sprintParameters;
    }

    /**
     * @return the weightage
     */
    public BigDecimal getWeightage() {
        return weightage;
    }

    /**
     * @param weightage the weightage to set
     */
    public void setWeightage(BigDecimal weightage) {
        this.weightage = weightage;
    }

    /**
     * @return the expectedTotal
     */
    public BigDecimal getExpectedTotal() {
        return expectedTotal;
    }

    /**
     * @param expectedTotal the expectedTotal to set
     */
    public void setExpectedTotal(BigDecimal expectedTotal) {
        this.expectedTotal = expectedTotal;
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
