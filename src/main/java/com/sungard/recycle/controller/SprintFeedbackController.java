package com.sungard.recycle.controller;

import com.sungard.recycle.dto.MasterVotingQue;
import com.sungard.recycle.dto.SprintDetail;
import com.sungard.recycle.dto.SprintFeedback;
import com.sungard.recycle.dto.VotingDetail;
import com.sungard.recycle.service.IMasterVotingQueService;
import com.sungard.recycle.service.ISprintDetailService;
import com.sungard.recycle.service.ISprintFeedbackService;
import com.sungard.recycle.service.IVotingService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Rakesh.Sharma on 6/15/2016.
 */
@CrossOrigin
@RestController
public class SprintFeedbackController {

    private static Logger logger = Logger.getLogger(SprintFeedbackController.class);

    @Autowired
    private ISprintFeedbackService sprintFeedbackService;

    @RequestMapping("/getSprintFeedbackData")
    public List<SprintFeedback> getSprintFeedbackData(@RequestBody SprintDetail sprintDetail) {
        logger.debug("In getSprintDetail");
        return sprintFeedbackService.getSprintFeedbackData(sprintDetail.getId());
    }

    @RequestMapping(value = "/saveSprintFeedback",method = RequestMethod.POST)
    public void saveSprintFeedback(@RequestBody List<SprintFeedback> sprintFeedbacks) {
        logger.debug("In saveSprintFeedback");
        if(sprintFeedbacks != null){
            for (SprintFeedback sfb :sprintFeedbacks){
                sprintFeedbackService.add(sfb);
            }
        }
    }
}
