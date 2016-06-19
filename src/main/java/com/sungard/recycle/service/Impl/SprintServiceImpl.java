package com.sungard.recycle.service.Impl;

import java.math.BigDecimal;
import java.util.*;

import javax.transaction.Transactional;

import com.sungard.recycle.dto.*;
import com.sungard.recycle.to.GoalComparisionChartDataTO;
import com.sungard.recycle.to.SprintFeedbackChartDataTO;
import org.apache.log4j.Logger;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sungard.recycle.repository.MasterGoalRepository;
import com.sungard.recycle.repository.SprintGoalRepository;
import com.sungard.recycle.service.ISprintService;
import com.sungard.recycle.to.SprintTO;

/**
 * Created by Taufique.Shaikh on 6/15/2016.
 */
@Service
public class SprintServiceImpl implements ISprintService {

    private static Logger logger = Logger.getLogger(SprintServiceImpl.class);

    @Autowired
    private SprintGoalRepository sprintGoalRepository;

    @Autowired
    private MasterGoalRepository masterGoalRepository;

    @Autowired
    private DatabaseService databaseService;

    @Override
    @Transactional
    public void createSprint(SprintGoal sprintGoal) {
        sprintGoalRepository.save(sprintGoal);
    }

    @Override
    public List<MasterGoal> getSprintGoals() {
        List<MasterGoal> masterGoals = new ArrayList<MasterGoal>();
        Iterable<MasterGoal> iterables = masterGoalRepository.findAll();
        Iterator<MasterGoal> iterator = iterables.iterator();
        while (iterator.hasNext()) {
            MasterGoal masterGoal = iterator.next();
            masterGoals.add(masterGoal);
        }
        return masterGoals;
    }

    public List<GoalComparisionChartDataTO> getGoalsComparisionData(){
        logger.debug("getGoalsComparisionData");

        Session session = databaseService.getHibernateFactory().openSession();

        SQLQuery query = session.createSQLQuery(" select avg(actual_total),sg.goal_name, mteam.name from "
                + " sprint_goal sg inner join " + " team_detail td on sg.sprint_detail_id = td.sprint_detail_id  inner join "
                + " master_team mteam  on td.master_team_id = mteam.id " + "group by goal_name,mteam.name " + " order by mteam.name ");

        Map<String, GoalComparisionChartDataTO> teamGoalsMap = new HashMap<String, GoalComparisionChartDataTO>() ;
        List<Object[]> result = query.list();

        for(int i=0;i<result.size();i++)
        {
            Object[] data = result.get(i);
            BigDecimal score = (BigDecimal) data[0];
            String teamName =  (String)data[2];
            String goalName =  (String)data[1];
            if(teamGoalsMap.get(teamName)!= null){
                GoalComparisionChartDataTO goalComparisionChartDataTO = teamGoalsMap.get(teamName);
                setGoalScore(goalComparisionChartDataTO, goalName, score);
            }else{
                GoalComparisionChartDataTO goalComparisionChartDataTO = new GoalComparisionChartDataTO();
                List<List<Integer>> goalDetails = new ArrayList<>();
                goalComparisionChartDataTO.setTeamName(teamName);
                goalComparisionChartDataTO.setGoalDetails(goalDetails);
                setGoalScore(goalComparisionChartDataTO, goalName, score);
                teamGoalsMap.put(teamName, goalComparisionChartDataTO);
            }

        }

        return new ArrayList<>(teamGoalsMap.values());
    }

    private void setGoalScore(GoalComparisionChartDataTO goalComparisionChartDataTO, String goalName, BigDecimal score){
        List<Integer> goalDetails=  new ArrayList<Integer>();
        if(goalName.startsWith("Quality")){
            goalDetails.add(1);
            goalDetails.add(score.intValue());
        } else if (goalName.startsWith("Delivery")){
            goalDetails.add(2);
            goalDetails.add(score.intValue());
        } else if (goalName.startsWith("Inovation")){
            goalDetails.add(3);
            goalDetails.add(score.intValue());
        }

        goalComparisionChartDataTO.getGoalDetails().add(goalDetails);
    }

}
