package com.sungard.recycle.controller;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sungard.recycle.dto.DummyJasonObj;
import com.sungard.recycle.dto.MasterGoal;
import com.sungard.recycle.dto.MasterLevel;
import com.sungard.recycle.dto.MasterLevelDetail;
import com.sungard.recycle.dto.MasterParameter;
import com.sungard.recycle.dto.MasterTeam;
import com.sungard.recycle.dto.MasterTeamMember;
import com.sungard.recycle.dto.SprintDetail;
import com.sungard.recycle.dto.SprintGoal;
import com.sungard.recycle.dto.SprintParameter;
import com.sungard.recycle.dto.TeamDetail;
import com.sungard.recycle.dto.TeamMember;
import com.sungard.recycle.service.ISprintService;
import com.sungard.recycle.service.Impl.DatabaseService;
import com.sungard.recycle.to.SprintGoalTO;
import com.sungard.recycle.to.SprintParameterTO;
import com.sungard.recycle.to.SprintTO;
import com.sungard.recycle.to.TeamMemberTO;
import com.sungard.recycle.to.TeamTO;

/**
 * Created by Taufique.Shaikh on 6/15/2016.
 */
@RestController
@CrossOrigin
public class SprintController {

    static final String FIXED = "FIXED";
    static final String RANGE = "RANGE";
    static final String LEVEL = "LEVEL";

    static final String HOURS = "HOURS";
    static final String PERCENTAGE = "PERCENTAGE";
    static final String INSTANCE = "INSTANCE";

    public ISprintService getSprintService() {
        return sprintService;
    }

    @Autowired
    public void setSprintService(ISprintService sprintService) {
        this.sprintService = sprintService;
    }

    private ISprintService sprintService = null;

    private DatabaseService databaseService;

    @RequestMapping(value = "/createsprint", method = RequestMethod.POST)
    @Transactional
    public DummyJasonObj createSprint(@RequestBody SprintTO sprintTO) {
        SprintDetail sprintDetail = new SprintDetail();
        sprintDetail.setActualTotal(sprintTO.getActualTotal());
        sprintDetail.setEndDate(sprintTO.getEndDate());
        sprintDetail.setName(sprintTO.getName());
        sprintDetail.setNoOfDays(sprintTO.getNoOfDays());
        sprintDetail.setNoOfTeamMembers(sprintTO.getNoOfTeamMembers());
        sprintDetail.setSprintStatus(sprintTO.getSprintStatus());
        sprintDetail.setSprintTotal(sprintTO.getSprintTotal());
        sprintDetail.setStartDate(sprintTO.getStartDate());
        
        
        List<SprintGoalTO> sprintGoalTOs = sprintTO.getSprintGoalTOs();
        for(SprintGoalTO sprintGoalTO : sprintGoalTOs) {
            SprintGoal sprintGoal = new SprintGoal();
            sprintGoal.setActualTotal(sprintGoalTO.getActualTotal());
            sprintGoal.setDescription(sprintGoalTO.getDescription());
            sprintGoal.setExpectedTotal(sprintGoalTO.getExpectedTotal());
            sprintGoal.setGoalName(sprintGoalTO.getGoalName());
            sprintGoal.setSprintDetail(sprintDetail);
            
            List<SprintParameterTO> sprintParameterTOs = sprintGoalTO.getSprintParameters();
            for(SprintParameterTO sprintParameterTO : sprintParameterTOs) {
                SprintParameter sprintParameter = new SprintParameter();
                sprintParameter.setActualValue(sprintParameterTO.getActualValue());
                sprintParameter.setDescription(sprintParameterTO.getDescription());
                sprintParameter.setEndValue(sprintParameterTO.getEndValue());
                sprintParameter.setExpectedTotal(sprintParameterTO.getExpectedTotal());
                sprintParameter.setIsHigherTheBetter(sprintParameterTO.getIsHigherTheBetter());
                sprintParameter.setLevelName(sprintParameterTO.getLevelName());
                sprintParameter.setName(sprintParameterTO.getName());
                sprintParameter.setParameterType(sprintParameterTO.getParameterType());
                sprintParameter.setParamTotal(sprintParameterTO.getParamTotal());
                sprintParameter.setSprintGoal(sprintGoal);
                sprintParameter.setStartValue(sprintParameterTO.getStartValue());
                sprintParameter.setUnits(sprintParameterTO.getUnits());
                sprintParameter.setWeightage(sprintParameterTO.getWeightage());
                sprintGoal.getSprintParameters().add(sprintParameter);
            }
            
            sprintGoal.setWeightage(sprintGoalTO.getWeightage());
            sprintDetail.getSprintGoals().add(sprintGoal);
        }
        
        
        
        Session masterTeamSession = databaseService.getHibernateFactory().openSession();
        MasterTeam masterTeam = (MasterTeam) masterTeamSession.get(MasterTeam.class, sprintTO.getTeamId());
        
        TeamDetail teamDetail = new TeamDetail();
        teamDetail.setMasterTeam(masterTeam);
        teamDetail.setSprintDetail(sprintDetail);
        
        List<TeamMemberTO> teamMemberTOs = sprintTO.getTeamMemberTOs();
        for(TeamMemberTO teamMemberTO : teamMemberTOs) {
            TeamMember teamMember = new TeamMember();
            teamMember.setEmailId(teamMemberTO.getEmailId());
            teamMember.setEmpID(teamMemberTO.getEmpID());
            teamMember.setEmpName(teamMemberTO.getEmpName());
            teamMember.setTeamDetail(teamDetail);
            teamMember.setTeamMemberTotal(teamMemberTO.getTeamMemberTotal());
            teamMember.setTeamName(teamMemberTO.getTeamName());
            teamMember.setVotingpoints(teamMemberTO.getVotingpoints());
            teamDetail.getTeamMember().add(teamMember);
        }
        
        Session sprintSession = databaseService.getHibernateFactory().openSession();
        sprintSession.beginTransaction();
        Serializable sprintId = sprintSession.save(sprintDetail);
        sprintSession.getTransaction().commit();
        
        Session teamDetailSession = databaseService.getHibernateFactory().openSession(); 
        teamDetailSession.beginTransaction();
        teamDetailSession.save(teamDetail);
        teamDetailSession.getTransaction().commit();
        
        sprintSession.close();
        masterTeamSession.close();
        teamDetailSession.close();
        
        DummyJasonObj dummyJasonObj = new DummyJasonObj();
        dummyJasonObj.setValue(sprintId.toString());
        
        return dummyJasonObj;
    }

    @RequestMapping(value = "/getSprintJson", method = RequestMethod.GET)
    public List<SprintGoal> getJprintJson() {
        List<SprintGoal> sprintGoals = new ArrayList<>();
        sprintGoals.add(new SprintGoal());
        sprintGoals.add(new SprintGoal());
        sprintGoals.add(new SprintGoal());
        return sprintGoals;
    }

    @RequestMapping(value = "/getMasterGoals", method = RequestMethod.GET)
    public List<SprintGoal> getMasterGoals() {
        List<SprintGoal> sprintGoals = new ArrayList<>();
        List<MasterGoal> masterGoals = getSprintService().getSprintGoals();
        for (MasterGoal masterGoal : masterGoals) {
            sprintGoals.add(convertMasterGoalToSprintGoal(masterGoal));
        }
        return sprintGoals;
    }

    @RequestMapping(value = "/getTeams", method = RequestMethod.GET)
    public List<TeamTO> getTeams() {
        List<TeamTO> teamTOs = new ArrayList<TeamTO>();
        List<MasterTeamMember> masterTeamMembers = databaseService.getHibernateFactory().openSession().createCriteria(MasterTeamMember.class).list();
        Map<MasterTeam, List<MasterTeamMember>> teamMap = new HashMap<MasterTeam, List<MasterTeamMember>>();
        for(MasterTeamMember masterTeamMember : masterTeamMembers) {
            if(!teamMap.containsKey(masterTeamMember.getMasterTeam())) {
                teamMap.put(masterTeamMember.getMasterTeam(), new ArrayList<MasterTeamMember>());
            } 
            teamMap.get(masterTeamMember.getMasterTeam()).add(masterTeamMember);
        }
        for (Map.Entry<MasterTeam, List<MasterTeamMember>> entry : teamMap.entrySet()) {
            MasterTeam masterTeam = entry.getKey();
            TeamTO teamTO = convertMasterTeamToTeamTO(masterTeam);
            List<MasterTeamMember> values = entry.getValue();
            for (MasterTeamMember masterTeamMember : values) {
                teamTO.getTeamMemberTOs().add(convertMasterTeamMemberToTeamMember(masterTeamMember));
            }
            teamTOs.add(teamTO);
        }
        
        return teamTOs;
    }
    
    @RequestMapping(value = "/getTeamMembers", method = RequestMethod.GET)
    public List<TeamMemberTO> getTeamMembers() {
        List<TeamMemberTO> teamMemberTOs = new ArrayList<TeamMemberTO>();
        List<MasterTeamMember> masterTeamMembers = databaseService.getHibernateFactory().openSession().createCriteria(MasterTeamMember.class).list();
        for (MasterTeamMember masterTeamMember : masterTeamMembers) {
            teamMemberTOs.add(convertMasterTeamMemberToTeamMember(masterTeamMember));
        }
        return teamMemberTOs;
    }
    
    @RequestMapping(value = "/getSprintJsonStructure", method = RequestMethod.GET)
    public SprintTO getSprintJsonStructure() {
        SprintTO sprintTO = new SprintTO();

        SprintParameterTO sprintParameter1 = new SprintParameterTO();
        SprintParameterTO sprintParameter2 = new SprintParameterTO();

        SprintGoalTO sprintGoal = new SprintGoalTO();
        sprintGoal.getSprintParameters().add(sprintParameter1);
        sprintGoal.getSprintParameters().add(sprintParameter2);

        sprintTO.getSprintGoalTOs().add(sprintGoal);
        
        return sprintTO;

    }

    private TeamMemberTO convertMasterTeamMemberToTeamMember(MasterTeamMember masterTeamMember) {
        TeamMemberTO teamMemberTO = new TeamMemberTO();
        teamMemberTO.setId(masterTeamMember.getId());
        teamMemberTO.setEmailId(masterTeamMember.getEmailId());
        teamMemberTO.setEmpID(masterTeamMember.getEmpID());
        teamMemberTO.setEmpName(masterTeamMember.getEmpName());
        teamMemberTO.setTeamName(masterTeamMember.getMasterTeam().getName());
        return teamMemberTO;
    }

    private TeamTO convertMasterTeamToTeamTO(MasterTeam masterTeam) {
        TeamTO teamTO = new TeamTO();
        teamTO.setId(masterTeam.getId());
        teamTO.setDescription(masterTeam.getDescription());
        teamTO.setName(masterTeam.getName());
        teamTO.setStatus(masterTeam.getStatus());
        return teamTO;
    }

    public SprintGoal convertMasterGoalToSprintGoal(MasterGoal masterGoal) {
        SprintGoal sprintGoal = new SprintGoal();
        sprintGoal.setDescription(masterGoal.getDescription());
        sprintGoal.setExpectedTotal(masterGoal.getExpectedTotal());
        sprintGoal.setGoalName(masterGoal.getGoalName());
        List<SprintParameter> sprintParameters = new ArrayList<SprintParameter>();
        if (null != masterGoal.getMasterParameters()) {
            for (MasterParameter masterParameter : masterGoal.getMasterParameters()) {
                sprintParameters.add(convertMasterParameterToSprintParameter(masterParameter));
            }
        }
        sprintGoal.setSprintParameters(sprintParameters);
        sprintGoal.setWeightage(masterGoal.getWeightage());
        return sprintGoal;
    }

    public SprintParameter convertMasterParameterToSprintParameter(MasterParameter masterParameter) {
        SprintParameter sprintParameter = new SprintParameter();
        sprintParameter.setDescription(masterParameter.getDescription());
        sprintParameter.setEndValue(masterParameter.getEndValue());
        sprintParameter.setExpectedTotal(masterParameter.getExpectedTotal());
        sprintParameter.setIsHigherTheBetter(masterParameter.getIsHigherTheBetter());
        sprintParameter.setName(masterParameter.getName());
        sprintParameter.setParameterType(masterParameter.getParameterType());
        sprintParameter.setStartValue(masterParameter.getStartValue());
        sprintParameter.setUnits(masterParameter.getUnits());
        sprintParameter.setWeightage(masterParameter.getWeightage());
        return sprintParameter;
    }

    @RequestMapping(value = "/getSprintParameters", method = RequestMethod.GET)
    public List<SprintParameter> createSprintParameters() {
        List<MasterGoal> masterGoals = getSprintService().getSprintGoals();
        List<SprintParameter> sprintParameters = new ArrayList<SprintParameter>();
        if (null == masterGoals) {
            return sprintParameters;
        }

        for (MasterGoal masterGoal : masterGoals) {
            for (MasterParameter masterParameter : masterGoal.getMasterParameters()) {
                sprintParameters.add(convertMasterParameterToSprintParameter(masterParameter));
            }
        }
        return sprintParameters;
    }

    @RequestMapping(value = "/createMasterData", method = RequestMethod.GET)
    public String createMasterData() {

        // MasterGoal : Start
        MasterGoal quality = getMasterGoal("Quality", "Quality Of Deliverables", new BigDecimal(30));
        MasterGoal delivery = getMasterGoal("Delivery", "Timely Delivery", new BigDecimal(30));
        MasterGoal innovation = getMasterGoal("Innovation & KM", "Innovation of new ideas", new BigDecimal(40));
        // MasterGoal : End

        // MasterParameter : Quality : Start
        MasterParameter qualityParam1 = getMasterParameter("Number of defects", "Indicates the number of defect expeceted.", quality, 10, 15, RANGE,
                null, false, null);
        MasterParameter qualityParam2 = getMasterParameter("Rework Efforts", "Indicates how much of rework effort is expected in hours.", quality,
                12, 12, FIXED, null, false, HOURS);
        MasterParameter qualityParam3 = getMasterParameter("Technical Debt", "Indicates how much technical debt added or reduced.", quality, 10, 20,
                RANGE, null, false, PERCENTAGE);
        MasterParameter qualityParam4 = getMasterParameter("Automate Unit Testing", "Indicates how much many test cases are automated", quality, 0,
                0, FIXED, null, true, INSTANCE);
        MasterParameter qualityParam5 = getMasterParameter("Number of Test Cases Run", "Indicates how many test cases are run.", quality, 5, 5,
                FIXED, null, true, null);
        // MasterParameter : Quality : End

        quality.getMasterParameters().add(qualityParam1);
        quality.getMasterParameters().add(qualityParam2);
        quality.getMasterParameters().add(qualityParam3);
        quality.getMasterParameters().add(qualityParam4);
        quality.getMasterParameters().add(qualityParam5);

        saveObject(quality);

        // MasterParameter : Delivery : Start
        MasterParameter deliveryParam1 = getMasterParameter("Product Baggage", "Has team solved the Product Baggage such as leggacy issue.",
                delivery, 0, 0, FIXED, null, true, INSTANCE);
        MasterParameter deliveryParam2 = getMasterParameter("Volume Testing",
                "Has performance of the process in improved? Has performance testing done?", delivery, 10, 20, RANGE, null, true, null);
        MasterParameter deliveryParam3 = getMasterParameter("Impediments", "Capture all the impediments in terms of hours lost for sprint work.",
                delivery, 0, 0, FIXED, null, false, HOURS);
        MasterParameter deliveryParam4 = getMasterParameter("Stories commited vs Accepted",
                "How many stories are delivered.To Expectation.Beyond Expectation.Above Expectation.", delivery, 50, 50, FIXED, null, false, null);
        MasterParameter deliveryParam5 = getMasterParameter("Build Stability",
                "Is build broken while check in the code.This will impact the QA and other teams as testing environmet is not running.", delivery, 0,
                0, RANGE, null, false, INSTANCE);
        // MasterParameter : Delivery : End

        delivery.getMasterParameters().add(deliveryParam1);
        delivery.getMasterParameters().add(deliveryParam2);
        delivery.getMasterParameters().add(deliveryParam3);
        delivery.getMasterParameters().add(deliveryParam4);
        delivery.getMasterParameters().add(deliveryParam5);

        saveObject(delivery);

        // Level : Start
        MasterLevel masterLevel1 = getMasterLevel("Innovation", "Level of innovation.");
        MasterLevelDetail masterLevelDetail1 = getMasterLevelDetail("Team Level", "1) Value addition at Team Level", new BigDecimal(30), masterLevel1);
        MasterLevelDetail masterLevelDetail2 = getMasterLevelDetail("Project Level", "2) Value addition at Project Level", new BigDecimal(50),
                masterLevel1);
        MasterLevelDetail masterLevelDetail3 = getMasterLevelDetail("BU level", "3) Value addition at BU level", new BigDecimal(60), masterLevel1);
        MasterLevelDetail masterLevelDetail4 = getMasterLevelDetail("Company level", "4) Value additiona Company level", new BigDecimal(70),
                masterLevel1);

        saveObject(masterLevel1);
        saveObject(masterLevelDetail1);
        saveObject(masterLevelDetail2);
        saveObject(masterLevelDetail3);
        saveObject(masterLevelDetail4);
        // Level : End

        // MasterParameter : Innovation & KM : Start
        MasterParameter innovationParam1 = getMasterParameter("Value Addition To the Development",
                "Does team innovated which can be reused for further development purose", innovation, null, null, LEVEL, masterLevel1, null, null);
        MasterParameter innovationParam2 = getMasterParameter("Value Addition To the Testing",
                "Does team innovated which can be reused for further Testing purose", innovation, null, null, LEVEL, masterLevel1, null, null);
        MasterParameter innovationParam3 = getMasterParameter("Value Addition To KM", "Does team contributed for Knowleaged Management", innovation,
                null, null, LEVEL, masterLevel1, null, null);
        // MasterParameter : Innovation & KM : End

        innovation.getMasterParameters().add(innovationParam1);
        innovation.getMasterParameters().add(innovationParam2);
        innovation.getMasterParameters().add(innovationParam3);

        saveObject(innovation);

        // MasterTeam : Start
        MasterTeam team1 = getMasterTeam("Team LA Lakers", "Scrum Master is Rohit", "Y");
        MasterTeam team2 = getMasterTeam("Team Chicago Bulls", "Scrum Master is Sachin", "Y");
        MasterTeam team3 = getMasterTeam("Team Houstan Rockets", "Scrum Master is Binny", "Y");

        saveObject(team1);
        saveObject(team2);
        saveObject(team3);
        // MasterTeam : Start

        // MasterTeamMember : Start
        MasterTeamMember masterTeamMember1 = getMasterTeamMember("Ashish Jain", "Ashish Jain", "Y", "ashish.jain@fisgloabal.com", team1);
        MasterTeamMember masterTeamMember2 = getMasterTeamMember("Avadhut Deshpande", "Avadhut Deshpande", "Y", "Avadhut.Deshpande@fisgloabal.com",
                team1);
        MasterTeamMember masterTeamMember3 = getMasterTeamMember("Bipin Hinge", "Bipin Hinge", "Y", "Bipin.Hinge@fisgloabal.com", team1);
        MasterTeamMember masterTeamMember4 = getMasterTeamMember("Vaishali Purohit", "Vaishali Purohit", "Y", "Vaishali.Purohit@fisgloabal.com",
                team1);
        MasterTeamMember masterTeamMember5 = getMasterTeamMember("Taufique Shaikh", "Taufique Shaikh", "Y", "Taufique.Shaikh@fisgloabal.com", team1);

        MasterTeamMember masterTeamMember6 = getMasterTeamMember("Hemant Pagare", "Hemant Pagare", "Y", "Hemant.Pagare@fisgloabal.com", team2);
        MasterTeamMember masterTeamMember7 = getMasterTeamMember("Manjit Kumar", "Manjit Kumar", "Y", "Manjit.Kumar@fisgloabal.com", team2);
        MasterTeamMember masterTeamMember8 = getMasterTeamMember("Piyush Lokhande", "Piyush Lokhande", "Y", "Piyush.Lokhande@fisgloabal.com", team2);
        MasterTeamMember masterTeamMember9 = getMasterTeamMember("Rakesh Sharma", "Rakesh Sharma", "Y", "Rakesh.Sharma@fisgloabal.com", team2);
        MasterTeamMember masterTeamMember10 = getMasterTeamMember("Vinod Rasane", "Vinod Rasane", "Y", "Vinod.Rasane@fisgloabal.com", team2);

        MasterTeamMember masterTeamMember11 = getMasterTeamMember("Sunil Chavan", "Sunil Chavan", "Y", "Sunil Chavan@fisgloabal.com", team3);
        MasterTeamMember masterTeamMember12 = getMasterTeamMember("Sudhir Mane", "Sudhir Mane", "Y", "Sudhir Mane@fisgloabal.com", team3);
        MasterTeamMember masterTeamMember13 = getMasterTeamMember("Deepali Khape", "Deepali Khape", "Y", "Deepali.Khape@fisgloabal.com", team3);
        MasterTeamMember masterTeamMember14 = getMasterTeamMember("Ami Shah", "Ami Shah", "Y", "Ami.Shah@fisgloabal.com", team3);
        MasterTeamMember masterTeamMember15 = getMasterTeamMember("Anup Jain", "Anup Jain", "Y", "Anup.Jain@fisgloabal.com", team3);

        saveObject(masterTeamMember1);
        saveObject(masterTeamMember2);
        saveObject(masterTeamMember3);
        saveObject(masterTeamMember4);
        saveObject(masterTeamMember5);

        saveObject(masterTeamMember6);
        saveObject(masterTeamMember7);
        saveObject(masterTeamMember8);
        saveObject(masterTeamMember9);
        saveObject(masterTeamMember10);

        saveObject(masterTeamMember11);
        saveObject(masterTeamMember12);
        saveObject(masterTeamMember13);
        saveObject(masterTeamMember14);
        saveObject(masterTeamMember15);
        // MasterTeamMember : End

        return "data created";
    }

    private SprintDetail getSprintDetail(BigDecimal actualTotal, Date endDate, String name, Integer noOfDays, Integer noOfTeamMembers,
            BigDecimal sprintTotal, Date startDate) {
        SprintDetail sprintDetail = new SprintDetail();
        sprintDetail.setActualTotal(actualTotal);
        sprintDetail.setEndDate(endDate);
        sprintDetail.setName(name);
        sprintDetail.setNoOfDays(noOfDays);
        sprintDetail.setNoOfTeamMembers(noOfTeamMembers);
        sprintDetail.setSprintTotal(sprintTotal);
        sprintDetail.setStartDate(startDate);
        return sprintDetail;
    }

    private static MasterTeamMember getMasterTeamMember(String name, String description, String status, String emailId, MasterTeam masterTeam) {
        MasterTeamMember masterTeamMember = new MasterTeamMember();
        masterTeamMember.setEmpName(name);
        masterTeamMember.setDescription(description);
        masterTeamMember.setStatus(status);
        masterTeamMember.setEmailId(emailId);
        masterTeamMember.setMasterTeam(masterTeam);
        return masterTeamMember;
    }

    private static MasterTeam getMasterTeam(String name, String description, String status) {
        MasterTeam masterTeam = new MasterTeam();
        masterTeam.setName(name);
        masterTeam.setDescription(description);
        masterTeam.setStatus(status);
        return masterTeam;
    }

    private static MasterLevelDetail getMasterLevelDetail(String name, String description, BigDecimal percentage, MasterLevel masterLevel) {
        MasterLevelDetail masterLevelDetail = new MasterLevelDetail();
        masterLevelDetail.setName(name);
        masterLevelDetail.setDescription(description);
        masterLevelDetail.setPercentage(percentage);
        masterLevelDetail.setMasterLevel(masterLevel);
        return masterLevelDetail;
    }

    public static MasterLevel getMasterLevel(String name, String description) {
        MasterLevel masterLevel = new MasterLevel();
        masterLevel.setName(name);
        masterLevel.setDescription(description);
        return masterLevel;
    }

    public static MasterParameter getMasterParameter(String name, String description, MasterGoal masterGoal, Integer startValue, Integer endValue,
            String parameterType, MasterLevel levelId, Boolean higherTheBetter, String unit) {
        MasterParameter masterParameter = new MasterParameter();
        masterParameter.setName(name);
        masterParameter.setDescription(description);
        masterParameter.setMasterGoal(masterGoal);
        masterParameter.setStartValue(startValue);
        masterParameter.setEndValue(endValue);
        masterParameter.setParameterType(parameterType);
        masterParameter.setLevelId(levelId);
        masterParameter.setIsHigherTheBetter(higherTheBetter);
        masterParameter.setUnits(unit);
        return masterParameter;
    }

    public void saveObject(Object object) {
        Session session = getDatabaseService().getHibernateFactory().openSession();
        session.beginTransaction();
        session.save(object);
        session.getTransaction().commit();
        session.close();
    }

    private static MasterGoal getMasterGoal(String name, String description, BigDecimal weightage) {
        MasterGoal masterGoal = new MasterGoal();
        masterGoal.setGoalName(name);
        masterGoal.setDescription(description);
        masterGoal.setWeightage(weightage);
        ;
        return masterGoal;
    }

    /**
     * @return the databaseService
     */
    public DatabaseService getDatabaseService() {
        return databaseService;
    }

    /**
     * @param databaseService the databaseService to set
     */
    @Autowired
    public void setDatabaseService(DatabaseService databaseService) {
        this.databaseService = databaseService;
    }

}
