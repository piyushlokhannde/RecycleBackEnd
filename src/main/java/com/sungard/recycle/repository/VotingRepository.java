package com.sungard.recycle.repository;

import com.sungard.recycle.dto.MasterVotingQue;
import com.sungard.recycle.dto.VotingDetail;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Rakesh.Sharma on 6/15/2016.
 */
public interface VotingRepository extends CrudRepository<VotingDetail, Long> {
}
