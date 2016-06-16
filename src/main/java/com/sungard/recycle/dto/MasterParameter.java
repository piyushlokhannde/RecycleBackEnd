package com.sungard.recycle.dto;

import java.math.BigDecimal;

import javax.persistence.*;

/**
 * Created by Rakesh.Sharma on 6/11/2016.
 */
@Entity
@Table(name="Master_Parameter")
public class MasterParameter {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE,generator = "master_parameter_gen")
    @SequenceGenerator(name = "master_parameter_gen", sequenceName = "master_parameter_seq", allocationSize = 1, initialValue = 0)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;
    private String name;
    private String description;

    @ManyToOne
    private MasterGoal masterGoal;

    private Integer startValue = 0;
    private Integer endValue = 0;
    private String parameterType;
    private Boolean isHigherTheBetter;
    private String units;
    private BigDecimal weightage = new BigDecimal(0.0);
    private BigDecimal expectedTotal = new BigDecimal(0.0);
    @OneToOne
    private MasterLevel levelId;
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
     * @return the masterGoal
     */
    public MasterGoal getMasterGoal() {
        return masterGoal;
    }
    /**
     * @param masterGoal the masterGoal to set
     */
    public void setMasterGoal(MasterGoal masterGoal) {
        this.masterGoal = masterGoal;
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
     * @return the levelId
     */
    public MasterLevel getLevelId() {
        return levelId;
    }
    /**
     * @param levelId the levelId to set
     */
    public void setLevelId(MasterLevel levelId) {
        this.levelId = levelId;
    }
}
