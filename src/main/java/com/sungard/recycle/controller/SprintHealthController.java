package com.sungard.recycle.controller;

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

    //@RequestMapping(value = "/getSprintJson", method = RequestMethod.GET)
    //public long getSprintHealthCount(@RequestParam(value="sprintId", defaultValue="0") Long sprintId) {
    @RequestMapping(value = "/getSprintHealthCount",method = RequestMethod.POST)
    public long getSprintHealthCount(@RequestBody List<Long> teamMemberIds) {
        long healthCount = teamMemberService.getSprintHealthCount(teamMemberIds);
        return healthCount;
    }

}
