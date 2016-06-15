package com.sungard.recycle.service.Impl;

import com.sungard.recycle.dto.SprintDetail;
import com.sungard.recycle.repository.MasterVotingQueRepository;
import com.sungard.recycle.repository.SprintDetailRepository;
import com.sungard.recycle.service.ISprintDetailService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Rakesh.Sharma on 6/15/2016.
 */
@Service
public class SprintDetailServiceImpl implements ISprintDetailService {
    private static Logger logger = Logger.getLogger(SprintDetailServiceImpl.class);

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
}
