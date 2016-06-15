package com.sungard.recycle.service.Impl;

import com.sungard.recycle.dto.MasterVotingQue;
import com.sungard.recycle.repository.MasterVotingQueRepository;
import com.sungard.recycle.repository.TeamMemberRepository;
import com.sungard.recycle.service.IMasterVotingQueService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static javafx.scene.input.KeyCode.O;

/**
 * Created by Rakesh.Sharma on 6/15/2016.
 */
@Service
public class MasterVotingQueServiceImpl implements IMasterVotingQueService{
    private static Logger logger = Logger.getLogger(MasterVotingQueServiceImpl.class);

    @Autowired
    private MasterVotingQueRepository masterVotingQueRepository;

    public List<MasterVotingQue> getQues(){
        Iterable iterable = masterVotingQueRepository.findAll();
        List<MasterVotingQue> ques= new ArrayList<MasterVotingQue>();
        for(Iterator<MasterVotingQue> iter = iterable.iterator(); iter.hasNext();) {
            ques.add(iter.next());
        }
        return ques;
    }
}
