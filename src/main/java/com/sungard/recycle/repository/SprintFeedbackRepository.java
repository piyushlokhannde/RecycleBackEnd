package com.sungard.recycle.repository;

import com.sungard.recycle.dto.SprintFeedback;
import com.sungard.recycle.dto.VotingDetail;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Rakesh.Sharma on 6/15/2016.
 */
public interface SprintFeedbackRepository extends CrudRepository<SprintFeedback, Long> {

}
