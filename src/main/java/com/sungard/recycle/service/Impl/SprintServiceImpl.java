package com.sungard.recycle.service.Impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sungard.recycle.dto.MasterGoal;
import com.sungard.recycle.dto.SprintGoal;
import com.sungard.recycle.repository.MasterGoalRepository;
import com.sungard.recycle.repository.SprintGoalRepository;
import com.sungard.recycle.service.ISprintService;

/**
 * Created by Taufique.Shaikh on 6/15/2016.
 */
@Service
public class SprintServiceImpl implements ISprintService {

    @Autowired
    private SprintGoalRepository sprintGoalRepository;

    @Autowired
    private MasterGoalRepository masterGoalRepository;

    @Override
    @Transactional
    public void createSprint(SprintGoal sprintGoal) {
        sprintGoalRepository.save(sprintGoal);
    }

    @Override
    public List<MasterGoal> getSprintGoals() {
        List<MasterGoal> masterGoals = new ArrayList<MasterGoal>();
        Iterable<MasterGoal> iterables = masterGoalRepository.findAll();
        Iterator<MasterGoal> iterator = iterables.iterator();
        while (iterator.hasNext()) {
            MasterGoal masterGoal = iterator.next();
            masterGoals.add(masterGoal);
        }
        return masterGoals;
    }
}
