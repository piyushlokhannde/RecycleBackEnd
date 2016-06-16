package com.sungard.recycle.dto;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Created by Rakesh.Sharma on 6/11/2016.
 */
@Entity
@Table(name = "Sprint_Parameter")
public class SprintParameter {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sprint_parameter_gen")
    @SequenceGenerator(name = "sprint_parameter_gen", sequenceName = "sprint_parameter_seq", allocationSize = 1, initialValue = 0)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;
    private String name;
    private String description;

    @ManyToOne
    private SprintGoal sprintGoal;
    private Integer startValue;
    private Integer endValue;
    private String parameterType;
    private Boolean isHigherTheBetter;
    private String units;
    private BigDecimal weightage;
    private BigDecimal paramTotal;
    private String levelName;
    private BigDecimal actualValue;
    private BigDecimal expectedTotal;
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
     * @return the sprintGoal
     */
    public SprintGoal getSprintGoal() {
        return sprintGoal;
    }
    /**
     * @param sprintGoal the sprintGoal to set
     */
    public void setSprintGoal(SprintGoal sprintGoal) {
        this.sprintGoal = sprintGoal;
    }
    /**
     * @return the startValue
     */
    public Integer getStartValue() {
        return startValue;
    }
    /**
     * @param startValue the startValue to set
     */
    public void setStartValue(Integer startValue) {
        this.startValue = startValue;
    }
    /**
     * @return the endValue
     */
    public Integer getEndValue() {
        return endValue;
    }
    /**
     * @param endValue the endValue to set
     */
    public void setEndValue(Integer endValue) {
        this.endValue = endValue;
    }
    /**
     * @return the parameterType
     */
    public String getParameterType() {
        return parameterType;
    }
    /**
     * @param parameterType the parameterType to set
     */
    public void setParameterType(String parameterType) {
        this.parameterType = parameterType;
    }
    /**
     * @return the isHigherTheBetter
     */
    public Boolean getIsHigherTheBetter() {
        return isHigherTheBetter;
    }
    /**
     * @param isHigherTheBetter the isHigherTheBetter to set
     */
    public void setIsHigherTheBetter(Boolean isHigherTheBetter) {
        this.isHigherTheBetter = isHigherTheBetter;
    }
    /**
     * @return the units
     */
    public String getUnits() {
        return units;
    }
    /**
     * @param units the units to set
     */
    public void setUnits(String units) {
        this.units = units;
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
     * @return the paramTotal
     */
    public BigDecimal getParamTotal() {
        return paramTotal;
    }
    /**
     * @param paramTotal the paramTotal to set
     */
    public void setParamTotal(BigDecimal paramTotal) {
        this.paramTotal = paramTotal;
    }
    /**
     * @return the levelName
     */
    public String getLevelName() {
        return levelName;
    }
    /**
     * @param levelName the levelName to set
     */
    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }
    /**
     * @return the actualValue
     */
    public BigDecimal getActualValue() {
        return actualValue;
    }
    /**
     * @param actualValue the actualValue to set
     */
    public void setActualValue(BigDecimal actualValue) {
        this.actualValue = actualValue;
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


}
