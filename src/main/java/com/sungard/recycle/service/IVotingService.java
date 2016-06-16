package com.sungard.recycle.service;

import com.sungard.recycle.dto.TeamMember;
import com.sungard.recycle.dto.VotingDetail;

import java.util.List;

/**
 * Created by Rakesh.Sharma on 6/15/2016.
 */
public interface IVotingService {
    void add(VotingDetail votingDetail);
    void addVoteToTeamMember(List<TeamMember> teamMemberList);
}
