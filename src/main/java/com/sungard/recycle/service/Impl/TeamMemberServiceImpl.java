package com.sungard.recycle.service.Impl;

import com.sungard.recycle.dto.TeamDetail;
import com.sungard.recycle.dto.TeamMember;
import com.sungard.recycle.repository.TeamMemberRepository;
import com.sungard.recycle.service.ITeamMemberService;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


/**
 * Created by Manjit.Kumar on 6/9/2016.
 */
@Service
public class TeamMemberServiceImpl implements ITeamMemberService {
   private static Logger logger = Logger.getLogger(TeamMemberServiceImpl.class);
    @PersistenceContext
    public EntityManager em;
    private DatabaseService databaseService;
    @Autowired
    private TeamMemberRepository teamMemberRepository;


    @Override
    @Transactional
    public void add(TeamMember teamMember) {
        logger.info("Add Team Member"+teamMember);
        teamMemberRepository.save(teamMember);
    }

    @Override
    public void delete(TeamMember teamMember) {
        logger.info("delete Team Member"+teamMember);
    }

    @Override
    public TeamMember get(TeamMember teamMember) {
        logger.info("get Team Member"+teamMember);
        return teamMemberRepository.findOne(teamMember.getId());
    }

    @Override
    public TeamMember modify(TeamMember teamMember) {
        logger.info("modify Team Member"+teamMember);
        teamMemberRepository.save(teamMember);
        return  null;
    }

    public void addPointsToTopPerformer(Long sprintId){
      List<TeamDetail> teamDetails = getTeamDetailForGivenSprintId(sprintId);
        if(!teamDetails.isEmpty()) {
            TeamDetail teamDetail =(TeamDetail) teamDetails.get(0);
            List<TeamMember> teamMembers = teamDetail.getTeamMember();
            Comparator<TeamMember> teamDetailComparator = Comparator.comparing(TeamMember::getVotingpoints).reversed();
            Collections.sort(teamMembers, teamDetailComparator);
            int noOfTopPerformer = (int) (teamMembers.size() * 0.30);
            List<TeamMember> teamMemberList = new ArrayList<>();
            int teamSize = teamMembers.size();
            if (teamSize > noOfTopPerformer) {
                for (int i = 0; i < teamSize; i++) {
                    TeamMember teamMember = teamMembers.get(i);
                    teamMember.setTeamMemberTotal(teamMember.getTeamMemberTotal().add(BigDecimal.valueOf(5l)));
                    teamMemberRepository.save(teamMember);
                }
            }

        }

    }
    public List<TeamDetail> getTeamDetailForGivenSprintId(Long sprintId){
        List<TeamDetail> teamDetails =(List<TeamDetail>) em.createNamedQuery("findAllTeamDetailForGivenId")
                .setParameter("sprintDetailId", sprintId)
                .getResultList();
        return teamDetails;
    }

    @Override
    public long getSprintHealthCount(List<Long> teamMemberIds) {
        String allTeamScoreAvgHql = "select avg(teamMemberTotal) from TeamMember";
        Session session = databaseService.getHibernateFactory().getCurrentSession();
        Query hqlQuery = session.createQuery(allTeamScoreAvgHql);
        Long allTeamScoreAvg = (Long) hqlQuery.uniqueResult();

        String teamScoreAvgHql="select avg(teamMemberTotal) from TeamMember where id in (:teamMemberIds)";
        hqlQuery = session.createQuery(allTeamScoreAvgHql);
        hqlQuery.setParameterList("teamMemberIds", teamMemberIds);
        Long teamScoreAvg = (Long) hqlQuery.uniqueResult();

        long teamHeathPer = (teamScoreAvg/allTeamScoreAvg)*100;
        return teamHeathPer;
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
    @Autowired
    public void setDatabaseService(DatabaseService databaseService) {
        this.databaseService = databaseService;
    }
}
