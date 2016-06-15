package com.sungard.recycle.controller;

import com.sungard.recycle.dto.TeamMember;
import com.sungard.recycle.service.ITeamMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Manjit.Kumar on 6/10/2016.
 */
@CrossOrigin
@RestController
public class TeamMemberController {
    private ITeamMemberService teamMemberService = null;

    public ITeamMemberService getTeamMemberService() {
        return teamMemberService;
    }
    @Autowired
    public void setTeamMemberService(ITeamMemberService teamMemberService) {
        this.teamMemberService = teamMemberService;
    }

    @RequestMapping("/getTeamMember")
    public TeamMember greeting(@RequestParam(value="name", defaultValue="World") String name) {
        System.out.print("Inside greeting");
        return getTeamMemberService().get(new TeamMember());
    }

    @RequestMapping("/addTeamMember")
    public void addMember(@RequestParam(value="name", defaultValue="World") String name) {
        System.out.print("Inside greeting");
        getTeamMemberService().add(new TeamMember());
    }
}
