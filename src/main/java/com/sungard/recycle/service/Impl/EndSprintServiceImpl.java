package com.sungard.recycle.service.Impl;

import com.sungard.recycle.dto.SprintDetail;
import com.sungard.recycle.dto.SprintGoal;
import com.sungard.recycle.dto.SprintParameter;
import com.sungard.recycle.calculation.IParamType;
import com.sungard.recycle.factory.ParamTypeFactory;
import com.sungard.recycle.service.IEndSprintService;
import com.sungard.recycle.service.ISprintDetailService;
import com.sungard.recycle.service.ITeamMemberService;
import com.sungard.recycle.service.IVotingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * Created by Manjit.Kumar on 6/15/2016.
 */
@Service
public class EndSprintServiceImpl implements IEndSprintService {
    @Autowired
    ITeamMemberService teamMemberService ;
    @Autowired
    ISprintDetailService sprintDetailService;
    @Autowired
    IVotingService votingService;

    public ISprintDetailService getSprintDetailService() {
        return sprintDetailService;
    }

    public void setSprintDetailService(ISprintDetailService sprintDetailService) {
        this.sprintDetailService = sprintDetailService;
    }

    public ITeamMemberService getTeamMemberService() {
        return teamMemberService;
    }

    public void setTeamMemberService(ITeamMemberService teamMemberService) {
        this.teamMemberService = teamMemberService;
    }

    public IVotingService getVotingService() {
        return votingService;
    }

    public void setVotingService(IVotingService votingService) {
        this.votingService = votingService;
    }

    public void markSprintToComplete(Long sprintId){
        //teamMemberService.addPointsToTopPerformer(sprintId);
        SprintDetail sprintDetail = new SprintDetail();
        sprintDetail.setId(sprintId);
        sprintDetail = sprintDetailService.get(sprintDetail);
        //sprintDetail = getDummyData();
        for(SprintGoal sprintGoal:sprintDetail.getSprintGoals()){

            for(SprintParameter sprintParameter: sprintGoal.getSprintParameters()){
                IParamType paramTypeObj = ParamTypeFactory.getParamType(sprintParameter.getParameterType());
                BigDecimal parameterPoint = paramTypeObj.calculateParameterPoint(sprintParameter);
                sprintParameter.setParamTotal(parameterPoint);
                sprintGoal.setActualTotal(sprintGoal.getActualTotal().add(parameterPoint));
                sprintDetail.setActualTotal(sprintDetail.getActualTotal().add(parameterPoint));
            }

        }

    }

    private void getDummyData() {
        SprintParameter sprintParameter = new SprintParameter();
        sprintParameter.setParameterType("HOURS");

    }
}
