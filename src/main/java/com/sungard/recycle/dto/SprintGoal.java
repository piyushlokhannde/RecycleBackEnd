package com.sungard.recycle.dto;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Rakesh.Sharma on 6/11/2016.
 */
@Entity
@Table(name="Sprint_Goal")
public class SprintGoal {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE,generator = "sprint_goal_gen")
    @SequenceGenerator(name = "sprint_goal_gen", sequenceName = "sprint_goal_seq", allocationSize = 1, initialValue = 0)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @ManyToOne
    private SprintDetail sprintDetail;
    private String goalName;
    private Integer weightage;
    private Integer expectedTotal;
    private Integer actualTotal;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SprintDetail getSprintDetail() {
        return sprintDetail;
    }

    public void setSprintDetail(SprintDetail sprintDetail) {
        this.sprintDetail = sprintDetail;
    }

    public String getGoalName() {
        return goalName;
    }

    public void setGoalName(String goalName) {
        this.goalName = goalName;
    }

    public Integer getWeightage() {
        return weightage;
    }

    public void setWeightage(Integer weightage) {
        this.weightage = weightage;
    }

    public Integer getExpectedTotal() {
        return expectedTotal;
    }

    public void setExpectedTotal(Integer expectedTotal) {
        this.expectedTotal = expectedTotal;
    }

    public Integer getActualTotal() {
        return actualTotal;
    }

    public void setActualTotal(Integer actualTotal) {
        this.actualTotal = actualTotal;
    }
}
