package com.sungard.recycle.to;

import java.util.List;

public class GoalComparisionChartDataTO {
    private String teamName;
    private List<List<Integer>> goalDetails;
    /**
     * @return the teamName
     */
    public String getTeamName() {
        return teamName;
    }
    /**
     * @param teamName the teamName to set
     */
    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
    /**
     * @return the goalDetails
     */
    public List<List<Integer>> getGoalDetails() {
        return goalDetails;
    }
    /**
     * @param goalDetails the sprintFeedbackDetails to set
     */
    public void setGoalDetails(List<List<Integer>> goalDetails) {
        this.goalDetails = goalDetails;
    }
}
