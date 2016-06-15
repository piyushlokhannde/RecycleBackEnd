package com.sungard.recycle.service;

import com.sungard.recycle.dto.SprintDetail;
import com.sungard.recycle.dto.TeamMember;

/**
 * Created by Rakesh.Sharma on 6/15/2016.
 */
public interface ISprintDetailService {
    void add(SprintDetail sprintDetail);
    void delete(SprintDetail sprintDetail);
    SprintDetail get(SprintDetail sprintDetail);
    SprintDetail modify(SprintDetail sprintDetail);
}
