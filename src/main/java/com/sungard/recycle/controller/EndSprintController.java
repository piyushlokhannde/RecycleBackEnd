package com.sungard.recycle.controller;

import com.sungard.recycle.Greeting;
import com.sungard.recycle.dto.TeamMember;
import com.sungard.recycle.service.IEndSprintService;
import com.sungard.recycle.service.ITeamMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Manjit.Kumar on 6/15/2016.
 */
@RestController
public class EndSprintController {

    private IEndSprintService endSprintService = null;

    public IEndSprintService getEndSprintService() {
        return endSprintService;
    }
    @Autowired
    public void setEndSprintService(IEndSprintService endSprintService) {
        this.endSprintService = endSprintService;
    }

    @RequestMapping("/endSprint")
    public void endSprint(@RequestParam(value="sprintId", defaultValue="0") Long sprintId) {
        System.out.print("Inside endSprint");
        getEndSprintService().markSprintToComplete(sprintId);

    }
}
