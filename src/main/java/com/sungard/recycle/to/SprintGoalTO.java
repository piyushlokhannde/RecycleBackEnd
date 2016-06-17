package com.sungard.recycle.to;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class SprintGoalTO {
    private Long id;
    private String goalName;
    private String description;
    private BigDecimal weightage = new BigDecimal(0.0);
    private BigDecimal expectedTotal = new BigDecimal(0.0);
    private List<SprintParameterTO> sprintParameters = new ArrayList<SprintParameterTO>();

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
     * @return the sprintParameters
     */
    public List<SprintParameterTO> getSprintParameters() {
        return sprintParameters;
    }

    /**
     * @param sprintParameters the sprintParameters to set
     */
    public void setSprintParameters(List<SprintParameterTO> sprintParameters) {
        this.sprintParameters = sprintParameters;
    }

}
