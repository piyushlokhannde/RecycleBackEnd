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
import org.apache.log4j.Logger;
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

    @Transactional
    public void add(SprintFeedback sprintFeedback){
        logger.debug("voting details added");
        sprintFeedbackRepository.save(sprintFeedback);
    }

    public List<SprintFeedback> getSprintFeedbackData(Long sprintId){
        logger.debug("getAll");
        List<SprintFeedback> lst= new ArrayList<SprintFeedback>();
        Iterable iterable = masterVotingQueService.getQues();
        List<MasterVotingQue> ques= new ArrayList<MasterVotingQue>();
        for(Iterator<MasterVotingQue> iter = iterable.iterator(); iter.hasNext();) {
            SprintFeedback sfd = new SprintFeedback();
            sfd.setVotingQue(iter.next());
            SprintDetail sprintDetail = new SprintDetail();
            sprintDetail.setId(sprintId);
            sfd.setSprintDetail(sprintDetail);
            lst.add(sfd);
        }
        return lst;
    }
}
