package com.sungard.recycle.service;

import com.sungard.recycle.dto.TeamDetail;
import com.sungard.recycle.dto.TeamMember;

import java.util.List;

/**
 * Created by Manjit.Kumar on 6/9/2016.
 */
public interface ITeamMemberService {
    void add(TeamMember teamMember);
    void delete(TeamMember teamMember);
    TeamMember get(TeamMember teamMember);
    TeamMember modify(TeamMember teamMember);
    void addPointsToTopPerformer(Long sprintId);
    List<TeamDetail> getTeamDetailForGivenSprintId(Long sprintId);
    long getSprintHealthCount(List<Long> teamMemberIds);
}
