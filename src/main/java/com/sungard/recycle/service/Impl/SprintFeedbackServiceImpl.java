package com.sungard.recycle.service.Impl;

import com.sungard.recycle.dto.MasterVotingQue;
import com.sungard.recycle.dto.SprintDetail;
import com.sungard.recycle.dto.SprintFeedback;
import com.sungard.recycle.dto.VotingDetail;
import com.sungard.recycle.repository.SprintFeedbackRepository;
import com.sungard.recycle.repository.VotingRepository;
import com.sungard.recycle.service.IMasterVotingQueService;
import com.sungard.recycle.service.ISprintFeedbackService;
import com.sungard.recycle.service.IVotingService;
import com.sungard.recycle.to.SprintFeedbackChartDataTO;

import org.apache.log4j.Logger;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Rakesh.Sharma on 6/15/2016.
 */
@Service
public class SprintFeedbackServiceImpl implements ISprintFeedbackService {

    private static Logger logger = Logger.getLogger(SprintFeedbackServiceImpl.class);

    @Autowired
    private SprintFeedbackRepository sprintFeedbackRepository;

    @Autowired
    private IMasterVotingQueService masterVotingQueService;


    @Autowired
    private DatabaseService databaseService;

    @Transactional
    public void add(SprintFeedback sprintFeedback) {
        logger.debug("voting details added");
        sprintFeedbackRepository.save(sprintFeedback);
    }

    public List<SprintFeedback> getSprintFeedbackData(Long sprintId) {
        logger.debug("getAll");
        List<SprintFeedback> lst = new ArrayList<SprintFeedback>();
        Iterable iterable = masterVotingQueService.getQues();
        List<MasterVotingQue> ques = new ArrayList<MasterVotingQue>();
        for (Iterator<MasterVotingQue> iter = iterable.iterator(); iter.hasNext();) {
            SprintFeedback sfd = new SprintFeedback();
            sfd.setVotingQue(iter.next());
            SprintDetail sprintDetail = new SprintDetail();
            sprintDetail.setId(sprintId);
            sfd.setSprintDetail(sprintDetail);
            lst.add(sfd);
        }
        return lst;
    }

    public List<SprintFeedbackChartDataTO> getSprintFeedbackChartData() {
        Session session = databaseService.getHibernateFactory().openSession();
        
        SQLQuery query = session.createSQLQuery(" select voting_que_id,avg(rating),master_team_id,mteam.name from "
                + " sprint_feedback spd inner join " + " team_detail td on spd.sprint_detail_id = td.sprint_detail_id  inner join "
                + " master_team mteam  on td.master_team_id = mteam.id " + "group by voting_que_id,master_team_id,mteam.name " + " order by name ");
        List<SprintFeedbackChartDataTO> sprintFeedbackChartDataTOs = new ArrayList<SprintFeedbackChartDataTO>();
        @SuppressWarnings("unchecked")
        List<Object[]> result = query.list();
         
        for(int i=0;i<result.size();i++)
        {
          
            Object[] data = result.get(i);
            SprintFeedbackChartDataTO sprintFeedbackChartDataTO = new SprintFeedbackChartDataTO();
            sprintFeedbackChartDataTO.setTeamName((String)data[2]);
            
            
            
        }
        
        return null;
    }

    /**
     * @return the databaseService
     */
    public DatabaseService getDatabaseService() {
        return databaseService;
    }

    /**
     * @param databaseService the databaseService to set
     */
    public void setDatabaseService(DatabaseService databaseService) {
        this.databaseService = databaseService;
    }
}
