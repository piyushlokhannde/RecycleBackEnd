package com.sungard.recycle.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Taufique.Shaikh on 6/15/2016.
 */
public class SprintTo {
    private List<SprintGoal> sprintGoals = new ArrayList<>();
    private SprintDetail sprintDetail;



    public SprintDetail getSprintDetail() {
        return sprintDetail;
    }

    public void setSprintDetail(SprintDetail sprintDetail) {
        this.sprintDetail = sprintDetail;
    }

    /**
     * @return the sprintGoals
     */
    public List<SprintGoal> getSprintGoals() {
        return sprintGoals;
    }

    /**
     * @param sprintGoals the sprintGoals to set
     */
    public void setSprintGoals(List<SprintGoal> sprintGoals) {
        this.sprintGoals = sprintGoals;
    }
}
