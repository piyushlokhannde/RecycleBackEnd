package com.sungard.recycle.to;

import java.util.List;

public class SprintFeedbackChartDataTO {
    private String teamName;
    private List<List<Integer>> sprintFeedbackDetails;
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
     * @return the sprintFeedbackDetails
     */
    public List<List<Integer>> getSprintFeedbackDetails() {
        return sprintFeedbackDetails;
    }
    /**
     * @param sprintFeedbackDetails the sprintFeedbackDetails to set
     */
    public void setSprintFeedbackDetails(List<List<Integer>> sprintFeedbackDetails) {
        this.sprintFeedbackDetails = sprintFeedbackDetails;
    }
}
