package com.sungard.recycle.controller;

import com.sungard.recycle.dto.TeamDetail;
import com.sungard.recycle.dto.TeamMember;
import com.sungard.recycle.service.ITeamMemberService;
import com.sungard.recycle.to.TeamMemberTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
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


    @RequestMapping(value = "/getTeamMember",method = RequestMethod.POST)
    public TeamMember getTeamMember(@RequestParam(value="name", defaultValue="World") String name) {
        System.out.print("Inside greeting");
        return getTeamMemberService().get(new TeamMember());
    }


    @RequestMapping(value = "/addTeamMember",method = RequestMethod.POST)
    public void addMember(@RequestBody TeamMember teamMember) {
        System.out.print("Inside greeting");
        getTeamMemberService().add(new TeamMember());
    }

    @RequestMapping(value = "/addTeamMemberList",method = RequestMethod.POST)
    public void addTeamMemberList(@RequestBody List<TeamMemberTO> teamMemberTOs) {
        for (TeamMemberTO teamMemberTO : teamMemberTOs) {
            if (teamMemberTO.isSelected()) {
                TeamMember teamMember = new TeamMember();
                BeanUtils.copyProperties(teamMemberTO, teamMember);
                teamMember.setVotingpoints(teamMember.getVotingpoints() + 1);
                getTeamMemberService().add(teamMember);
            }

        }
    }


    @RequestMapping("/getTeamMemberList")
    public List<TeamMemberTO> getTeamMember(@RequestParam(value="id", defaultValue="0") Long springId) {
        System.out.print("Inside getTeamMemberList");
        List<TeamMember> teamMembers = null;
        List<TeamMemberTO> teamMemberTOs = new ArrayList<>();
        List<TeamDetail> teamDetails = getTeamMemberService().getTeamDetailForGivenSprintId(springId);
        if(teamDetails != null && !teamDetails.isEmpty()){
            TeamDetail teamDetail1 = teamDetails.get(0);
            teamMembers = teamDetail1.getTeamMember();
            for(TeamMember teamMember : teamMembers){
                TeamMemberTO teamMemberTO = new TeamMemberTO();
                BeanUtils.copyProperties(teamMember, teamMemberTO);
                teamMemberTOs.add(teamMemberTO);
            }
        }
        return teamMemberTOs;
    }
}
