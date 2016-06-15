package com.sungard.recycle.service.Impl;

import com.sungard.recycle.dto.VotingDetail;
import com.sungard.recycle.repository.MasterVotingQueRepository;
import com.sungard.recycle.repository.VotingRepository;
import com.sungard.recycle.service.IVotingService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by Rakesh.Sharma on 6/15/2016.
 */
@Service
public class VotingServiceImpl implements IVotingService {

    private static Logger logger = Logger.getLogger(MasterVotingQueServiceImpl.class);

    @Autowired
    private VotingRepository votingRepository;

    @Transactional
    public void add(VotingDetail votingDetail){
        logger.debug("voting details added");
        votingRepository.save(votingDetail);
    }
}
