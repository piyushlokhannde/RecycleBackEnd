package com.sungard.recycle.controller;

import com.sungard.recycle.dto.MasterVotingQue;
import com.sungard.recycle.dto.SprintDetail;
import com.sungard.recycle.dto.TeamMember;
import com.sungard.recycle.dto.VotingDetail;
import com.sungard.recycle.repository.TeamMemberRepository;
import com.sungard.recycle.service.IMasterVotingQueService;
import com.sungard.recycle.service.ISprintDetailService;
import com.sungard.recycle.service.IVotingService;
import com.sungard.recycle.service.Impl.MasterVotingQueServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Rakesh.Sharma on 6/15/2016.
 */
@CrossOrigin
@RestController
public class VotingController {
    private static Logger logger = Logger.getLogger(VotingController.class);

    private IMasterVotingQueService masterVotingQueService;

    private ISprintDetailService sprintDetailService;

    @Autowired
    private IVotingService votingService;

    public IMasterVotingQueService getMasterVotingQueService() {
        return masterVotingQueService;
    }

    @Autowired
    public void setMasterVotingQueService(IMasterVotingQueService masterVotingQueService) {
        this.masterVotingQueService = masterVotingQueService;
    }

    public ISprintDetailService getSprintDetailService() {
        return sprintDetailService;
    }

    @Autowired
    public void setSprintDetailService(ISprintDetailService sprintDetailService) {
        this.sprintDetailService = sprintDetailService;
    }

    @RequestMapping("/getVotingQues")
    public List<MasterVotingQue> getVotingQues(@RequestParam(value="name", defaultValue="World") String name) {
        logger.debug("In getVotingQues");
        return masterVotingQueService.getQues();
    }

    @RequestMapping(value = "/getSprintDetail",method = RequestMethod.POST)
    public SprintDetail getSprintDetail(@RequestBody SprintDetail sprintDetail) {
        logger.debug("In getSprintDetail");
        return sprintDetailService.get(sprintDetail);
    }

    @RequestMapping(value = "/saveVoting",method = RequestMethod.POST)
    public void saveVotingDetail(@RequestBody List<VotingDetail> votingDetails) {
        logger.debug("In saveVotingDetail");
        if(votingDetails != null){
            for (VotingDetail vd :votingDetails){
                votingService.add(vd);
            }
        }
    }
}
