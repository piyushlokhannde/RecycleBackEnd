package com.sungard.recycle.controller;

import com.sungard.recycle.dto.*;
import com.sungard.recycle.service.ISprintDetailService;
import com.sungard.recycle.service.ITeamMemberService;
import com.sungard.recycle.service.Impl.DatabaseService;
import com.sungard.recycle.to.SprintGoalTO;
import com.sungard.recycle.to.SprintParameterTO;
import com.sungard.recycle.to.SprintTO;
import com.sungard.recycle.to.TeamMemberTO;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Rakesh.Sharma on 6/15/2016.
 */
@CrossOrigin
@RestController
public class SprintDetailController {

    @Autowired
    private DatabaseService databaseService;

    @Autowired
    private ISprintDetailService sprintDetailService;

    @Autowired
    private ITeamMemberService teamMemberService;

    @RequestMapping(value = "/getAllSprintSummary", method = RequestMethod.GET)
    public List<SprintDetail> getAllSprintSummary(){
        return sprintDetailService.getSprintDetails();
    }

    @RequestMapping(value = "/getSprintData", method = RequestMethod.GET)
    public SprintTO getSprintData(@RequestParam(value="sprintId", defaultValue="") String sprintId) {
        SprintDetail sprintDetailInput = new SprintDetail();
        sprintDetailInput.setId(new Long(sprintId));
        SprintDetail sprintDetailDb = sprintDetailService.get(sprintDetailInput);
        SprintTO sprintTO = new SprintTO();
        sprintTO.setId(sprintDetailDb.getId());
        sprintTO.setActualTotal(sprintDetailDb.getActualTotal());
        sprintTO.setEndDate(sprintDetailDb.getEndDate());
        sprintTO.setName(sprintDetailDb.getName());
        sprintTO.setNoOfDays(sprintDetailDb.getNoOfDays());
        sprintTO.setNoOfTeamMembers(sprintDetailDb.getNoOfTeamMembers());
        sprintTO.setSprintStatus(sprintDetailDb.getSprintStatus());
        sprintTO.setSprintTotal(sprintDetailDb.getSprintTotal());
        sprintTO.setStartDate(sprintDetailDb.getStartDate());

        List<SprintGoal> sprintGoals = sprintDetailDb.getSprintGoals();
        for(SprintGoal sprintGoal : sprintGoals) {
            SprintGoalTO sprintGoalTO = new SprintGoalTO();
            sprintGoalTO.setId(sprintGoal.getId());
            sprintGoalTO.setActualTotal(sprintGoal.getActualTotal());
            sprintGoalTO.setDescription(sprintGoal.getDescription());
            sprintGoalTO.setExpectedTotal(sprintGoal.getExpectedTotal());
            sprintGoalTO.setGoalName(sprintGoal.getGoalName());

            List<SprintParameter> sprintParameters = sprintGoal.getSprintParameters();
            for(SprintParameter sprintParameter : sprintParameters) {
                SprintParameterTO sprintParameterTO = new SprintParameterTO();
                sprintParameterTO.setId(sprintParameter.getId());
                sprintParameterTO.setActualValue(sprintParameter.getActualValue());
                sprintParameterTO.setDescription(sprintParameter.getDescription());
                sprintParameterTO.setEndValue(sprintParameter.getEndValue());
                sprintParameterTO.setExpectedTotal(sprintParameter.getExpectedTotal());
                sprintParameterTO.setIsHigherTheBetter(sprintParameter.getIsHigherTheBetter());
                sprintParameterTO.setLevelName(sprintParameter.getLevelName());
                sprintParameterTO.setName(sprintParameter.getName());
                sprintParameterTO.setParameterType(sprintParameter.getParameterType());
                sprintParameterTO.setParamTotal(sprintParameter.getParamTotal());
                //sprintParameterTO.setSprintGoal(sprintGoal);
                sprintParameterTO.setStartValue(sprintParameter.getStartValue());
                sprintParameterTO.setUnits(sprintParameter.getUnits());
                sprintParameterTO.setWeightage(sprintParameter.getWeightage());
                sprintGoalTO.getSprintParameters().add(sprintParameterTO);
            }

            sprintGoalTO.setWeightage(sprintGoal.getWeightage());
            //sprintDetailTO.getSprintGoals().add(sprintGoal);
            sprintTO.getSprintGoalTOs().add(sprintGoalTO);
        }

        List<TeamDetail> teamDetails = teamMemberService.getTeamDetailForGivenSprintId(sprintDetailInput.getId());
        if(!teamDetails.isEmpty()) {
            TeamDetail teamDetail = (TeamDetail) teamDetails.get(0);
            List<TeamMember> teamMembers = teamDetail.getTeamMember();
            for(TeamMember teamMember : teamMembers) {
                TeamMemberTO teamMemberTO = new TeamMemberTO();
                teamMemberTO.setId(teamMember.getId());
                teamMemberTO.setEmailId(teamMember.getEmailId());
                teamMemberTO.setEmpID(teamMember.getEmpID());
                teamMemberTO.setEmpName(teamMember.getEmpName());
                //teamMemberTO.setTeamDetail(teamDetail);
                teamMemberTO.setTeamMemberTotal(teamMember.getTeamMemberTotal());
                teamMemberTO.setTeamName(teamMember.getTeamName());
                teamMemberTO.setVotingpoints(teamMember.getVotingpoints());
                sprintTO.getTeamMemberTOs().add(teamMemberTO);
            }
        }
        return sprintTO;
    }
}
