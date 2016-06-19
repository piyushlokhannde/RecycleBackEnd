package com.sungard.recycle.service.Impl;

import com.sungard.recycle.dto.SprintDetail;
import com.sungard.recycle.dto.SprintGoal;
import com.sungard.recycle.dto.SprintParameter;
import com.sungard.recycle.calculation.IParamType;
import com.sungard.recycle.factory.ParamTypeFactory;
import com.sungard.recycle.repository.MasterVotingQueRepository;
import com.sungard.recycle.repository.SprintDetailRepository;
import com.sungard.recycle.service.IEndSprintService;
import com.sungard.recycle.service.ISprintDetailService;
import com.sungard.recycle.service.ITeamMemberService;
import com.sungard.recycle.service.IVotingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

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
    @Autowired
    private SprintDetailRepository sprintDetailRepository;

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
        sprintDetail = getDummyData();
        for(SprintGoal sprintGoal:sprintDetail.getSprintGoals()){

            for(SprintParameter sprintParameter: sprintGoal.getSprintParameters()){
                IParamType paramTypeObj = ParamTypeFactory.getParamType(sprintParameter.getParameterType());
                BigDecimal parameterPoint = paramTypeObj.calculateParameterPoint(sprintParameter);
                sprintParameter.setParamTotal(parameterPoint);
                sprintGoal.setActualTotal(sprintGoal.getActualTotal().add(parameterPoint));
                sprintDetail.setActualTotal(sprintDetail.getActualTotal().add(parameterPoint));
            }

        }
        sprintDetailRepository.save(sprintDetail);

    }

    private SprintDetail getDummyData() {
        SprintParameter sprintParameter = new SprintParameter();
        sprintParameter.setParameterType("FIXED");
        sprintParameter.setActualValue(BigDecimal.valueOf(5));
        sprintParameter.setStartValue(6);
        sprintParameter.setEndValue(6);
        sprintParameter.setExpectedTotal(BigDecimal.valueOf(50));
        sprintParameter.setIsHigherTheBetter(false);


        SprintParameter sprintParameter1 = new SprintParameter();
        sprintParameter1.setParameterType("RANGE");
        sprintParameter1.setActualValue(BigDecimal.valueOf(12));
        sprintParameter1.setStartValue(6);
        sprintParameter1.setEndValue(9);
        sprintParameter1.setExpectedTotal(BigDecimal.valueOf(60));
        sprintParameter1.setIsHigherTheBetter(true);


        List<SprintParameter> sprintParameterList = new ArrayList<>();
        sprintParameterList.add(sprintParameter);
        sprintParameterList.add(sprintParameter1);

        SprintGoal sprintGoal = new SprintGoal();
        sprintGoal.setSprintParameters(sprintParameterList);
        sprintGoal.setActualTotal(BigDecimal.ZERO);
        List<SprintGoal> sprintGoals = new ArrayList<>();
        sprintGoals.add(sprintGoal);
        SprintDetail sprintDetail = new SprintDetail();
        sprintDetail.setSprintGoals(sprintGoals);
        return sprintDetail;


    }
}
