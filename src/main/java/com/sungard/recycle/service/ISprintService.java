package com.sungard.recycle.service;

import java.util.List;

import com.sungard.recycle.dto.MasterGoal;
import com.sungard.recycle.dto.SprintGoal;
import com.sungard.recycle.to.GoalComparisionChartDataTO;
import com.sungard.recycle.to.SprintTO;

/**
 * Created by Taufique.Shaikh on 6/15/2016.
 */
public interface ISprintService {
    public void createSprint(SprintGoal sprintGoal);

    public List<MasterGoal> getSprintGoals();

    public List<GoalComparisionChartDataTO> getGoalsComparisionData();
}
