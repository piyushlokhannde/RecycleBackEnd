package com.sungard.recycle.dto;

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

    private Integer startValue;
    private Integer endValue;
    private String parameterType;
    @OneToOne
    private MasterLevel levelId;
    private Boolean isHigherTheBetter;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public MasterGoal getMasterGoal() {
        return masterGoal;
    }

    public void setMasterGoal(MasterGoal masterGoal) {
        this.masterGoal = masterGoal;
    }

    public Integer getStartValue() {
        return startValue;
    }

    public void setStartValue(Integer startValue) {
        this.startValue = startValue;
    }

    public Integer getEndValue() {
        return endValue;
    }

    public void setEndValue(Integer endValue) {
        this.endValue = endValue;
    }

    public String getParameterType() {
        return parameterType;
    }

    public void setParameterType(String parameterType) {
        this.parameterType = parameterType;
    }

    public MasterLevel getLevelId() {
        return levelId;
    }

    public void setLevelId(MasterLevel levelId) {
        this.levelId = levelId;
    }

    public Boolean getHigherTheBetter() {
        return isHigherTheBetter;
    }

    public void setHigherTheBetter(Boolean higherTheBetter) {
        isHigherTheBetter = higherTheBetter;
    }
}
