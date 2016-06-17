package com.sungard.recycle.controller;

import com.sungard.recycle.dto.DummyJasonObj;
import com.sungard.recycle.dto.SprintGoal;
import com.sungard.recycle.service.ITeamMemberService;
import com.sungard.recycle.to.TeamMemberTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Manjit.Kumar on 6/16/2016.
 */
@CrossOrigin
@RestController
public class SprintHealthController {

    private ITeamMemberService teamMemberService = null;

    public ITeamMemberService getTeamMemberService() {
        return teamMemberService;
    }
    @Autowired
    public void setTeamMemberService(ITeamMemberService teamMemberService) {
        this.teamMemberService = teamMemberService;
    }

    @RequestMapping(value = "/getSprintHealthCount", method = RequestMethod.GET)
    public DummyJasonObj getSprintHealthCount() {
        long healthCount = teamMemberService.getSprintHealthCount();
        DummyJasonObj dummyJasonObj = new DummyJasonObj();
        dummyJasonObj.setValue(String.valueOf(healthCount));
        return dummyJasonObj;
    }

}
