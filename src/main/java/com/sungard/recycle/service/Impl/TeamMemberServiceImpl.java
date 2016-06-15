package com.sungard.recycle.service.Impl;

import com.sungard.recycle.dto.TeamMember;
import com.sungard.recycle.repository.TeamMemberRepository;
import com.sungard.recycle.service.ITeamMemberService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


/**
 * Created by Manjit.Kumar on 6/9/2016.
 */
@Service
public class TeamMemberServiceImpl implements ITeamMemberService {
   private static Logger logger = Logger.getLogger(TeamMemberServiceImpl.class);

    @Autowired
    private TeamMemberRepository teamMemberRepository;


    @Override
    @Transactional
    public void add(TeamMember teamMember) {
        logger.info("Add Team Member"+teamMember);
        teamMemberRepository.save(getDummyTeamMemberToAdd());
    }

    @Override
    public void delete(TeamMember teamMember) {
        logger.info("delete Team Member"+teamMember);
    }

    @Override
    public TeamMember get(TeamMember teamMember) {
        logger.info("get Team Member"+teamMember);
        return getDummyTeamMember();
    }

    @Override
    public TeamMember modify(TeamMember teamMember) {
        logger.info("modify Team Member"+teamMember);
        return  null;
    }

    private TeamMember getDummyTeamMember(){
        TeamMember t = new TeamMember();
        t.setId(1l);
        t.setEmailId("Rakesh.Sharma@fisglobal.com");
        t.setEmpID(110772l);
        t.setEmpName("Rakesh Sharma Ji");
        t.setTeamName("Apni Team");
        return t;
    }

    private TeamMember getDummyTeamMemberToAdd(){
        TeamMember t = new TeamMember();
        t.setEmailId("Rakesh.Sharma@fisglobal.com");
        t.setEmpID(110772l);
        t.setEmpName("Rakesh Sharma Ji");
        t.setTeamName("Apni Team");
        return t;
    }
}
