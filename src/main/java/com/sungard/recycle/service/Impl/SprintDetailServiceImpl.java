package com.sungard.recycle.service.Impl;

import com.sungard.recycle.dto.MasterVotingQue;
import com.sungard.recycle.dto.SprintDetail;
import com.sungard.recycle.repository.MasterVotingQueRepository;
import com.sungard.recycle.repository.SprintDetailRepository;
import com.sungard.recycle.service.ISprintDetailService;
import org.apache.log4j.Logger;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Rakesh.Sharma on 6/15/2016.
 */
@Service
public class SprintDetailServiceImpl implements ISprintDetailService {
    private static Logger logger = Logger.getLogger(SprintDetailServiceImpl.class);

    @Autowired
    private DatabaseService databaseService;

    @Autowired
    private SprintDetailRepository sprintDetailRepository;

    @Override
    public void add(SprintDetail sprintDetail) {
        sprintDetailRepository.save(sprintDetail);
    }

    @Override
    public void delete(SprintDetail sprintDetail) {
        sprintDetailRepository.delete(sprintDetail);
    }

    @Override
    public SprintDetail get(SprintDetail sprintDetail) {
        return sprintDetailRepository.findOne(sprintDetail.getId());
    }

    @Override
    public SprintDetail modify(SprintDetail sprintDetail) {
        return sprintDetailRepository.save(sprintDetail);
    }

    public List<SprintDetail> getSprintDetails(){
        Iterable iterable = sprintDetailRepository.findAll();
        List<SprintDetail> sprintDetails= new ArrayList<SprintDetail>();

        logger.debug("getGoalsComparisionData");

        Session session = databaseService.getHibernateFactory().openSession();

        SQLQuery query = session.createSQLQuery(" select name,no_of_days,no_of_team_members,start_date," +
                "end_date,actual_total,sprint_total,sprint_status,id from sprint_detail order by name;");

        List<Object[]> result = query.list();

        for(int i=0;i<result.size();i++)
        {
            Object[] data = result.get(i);
            SprintDetail sprintDetail = new SprintDetail();
            sprintDetail.setName((String) data[0]);
            sprintDetail.setNoOfDays((Integer) data[1]);
            sprintDetail.setNoOfTeamMembers((Integer) data[2]);
            sprintDetail.setStartDate((Date) data[3]);
            sprintDetail.setEndDate((Date) data[4]);
            sprintDetail.setActualTotal((BigDecimal) data[5]);
            sprintDetail.setSprintTotal((BigDecimal) data[6]);
            sprintDetail.setSprintStatus((String) data[7]);
            sprintDetail.setId(((BigInteger) data[8]).longValue());

            sprintDetails.add(sprintDetail);
        }
        return sprintDetails;
    }
}
