package com.sungard.recycle.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sungard.recycle.dto.SprintDetail;
import com.sungard.recycle.dto.SprintFeedback;
import com.sungard.recycle.service.ISprintFeedbackService;
import com.sungard.recycle.to.SprintFeedbackChartDataTO;

/**
 * Created by Rakesh.Sharma on 6/15/2016.
 */
@CrossOrigin
@RestController
public class SprintFeedbackController {
    private static Logger logger = Logger.getLogger(SprintFeedbackController.class);

    @Autowired
    private ISprintFeedbackService sprintFeedbackService;

    @RequestMapping(value = "/getSprintFeedbackData", method = RequestMethod.POST)
    public List<SprintFeedback> getSprintFeedbackData(@RequestBody SprintDetail sprintDetail) {
        logger.debug("In getSprintDetail");
        return sprintFeedbackService.getSprintFeedbackData(sprintDetail.getId());
    }

    @RequestMapping(value = "/saveSprintFeedback", method = RequestMethod.POST)
    public void saveSprintFeedback(@RequestBody List<SprintFeedback> sprintFeedbacks) {
        logger.debug("In saveSprintFeedback");
        if (sprintFeedbacks != null) {
            for (SprintFeedback sfb : sprintFeedbacks) {
                sprintFeedbackService.add(sfb);
            }
        }
    }

    @RequestMapping(value = "/getSprintFeedbackChartData", method = RequestMethod.GET)
    public List<SprintFeedbackChartDataTO> getSprintFeedbackChartData() {
        List<SprintFeedbackChartDataTO> sprintFeedbackChartDataTOs = new ArrayList<SprintFeedbackChartDataTO>();
        sprintFeedbackChartDataTOs.addAll(sprintFeedbackService.getSprintFeedbackChartData());
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(1);

        List<Integer> list1 = new ArrayList<Integer>();
        list1.add(2);
        list1.add(3);

        lists.add(list);
        lists.add(list1);

        SprintFeedbackChartDataTO sprintFeedbackChartDataTO = new SprintFeedbackChartDataTO();
        sprintFeedbackChartDataTO.setTeamName("Team A");
        sprintFeedbackChartDataTO.setSprintFeedbackDetails(lists);
        
        sprintFeedbackChartDataTOs.add(sprintFeedbackChartDataTO);
        return sprintFeedbackChartDataTOs;
    }
}
