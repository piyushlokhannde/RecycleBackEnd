package com.sungard.recycle.controller;

import java.util.concurrent.atomic.AtomicLong;


import com.sungard.recycle.Greeting;
import com.sungard.recycle.dto.TeamMember;
import com.sungard.recycle.service.ITeamMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    private ITeamMemberService teamMemberService = null;

    public ITeamMemberService getTeamMemberService() {
        return teamMemberService;
    }
    @Autowired
    public void setTeamMemberService(ITeamMemberService teamMemberService) {
        this.teamMemberService = teamMemberService;
    }

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        System.out.print("Inside greeting");
        getTeamMemberService().add(new TeamMember());
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }
}