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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Created by Rakesh.Sharma on 6/11/2016.
 */
@Entity
@Table(name="Master_Goal")
public class MasterGoal {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE,generator = "master_goal_gen")
    @SequenceGenerator(name = "master_goal_gen", sequenceName = "master_goal_seq", allocationSize = 1, initialValue = 0)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;
    @Column(name="goal_name")
    private String goalName;
    private String description;
    private BigDecimal weightage;
    @Column(name="expected_total")
    private BigDecimal expectedTotal;
    @OneToMany(cascade=CascadeType.ALL)
    private List<MasterParameter> masterParameters = new ArrayList<MasterParameter>();
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
     * @return the masterParameters
     */
    public List<MasterParameter> getMasterParameters() {
        return masterParameters;
    }
    /**
     * @param masterParameters the masterParameters to set
     */
    public void setMasterParameters(List<MasterParameter> masterParameters) {
        this.masterParameters = masterParameters;
    }
    }
