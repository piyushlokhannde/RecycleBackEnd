package com.sungard.recycle.service;

import com.sungard.recycle.dto.SprintFeedback;
import com.sungard.recycle.dto.VotingDetail;
import com.sungard.recycle.to.SprintFeedbackChartDataTO;

import java.util.List;

/**
 * Created by Rakesh.Sharma on 6/15/2016.
 */
public interface ISprintFeedbackService {
    void add(SprintFeedback sprintFeedback);
    List<SprintFeedback> getSprintFeedbackData(Long sprintId);
    public List<SprintFeedbackChartDataTO> getSprintFeedbackChartData();
}
