package com.sungard.recycle.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Created by Rakesh.Sharma on 6/11/2016.
 */
@Entity
@Table(name = "TEAM_DETAIL")
@NamedQuery(name = "findAllTeamDetailForGivenId", query = "SELECT c FROM TeamDetail c WHERE c.sprintDetail.id = :sprintDetailId")
public class TeamDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "team_detail_gen")
    @SequenceGenerator(name = "team_detail_gen", sequenceName = "team_detail_seq", allocationSize = 1, initialValue = 0)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne
    private MasterTeam masterTeam;

    @OneToMany
    private List<TeamMember> teamMember;

    @ManyToOne
    private SprintDetail sprintDetail;

    public MasterTeam getMasterTeam() {
        return masterTeam;
    }

    public void setMasterTeam(MasterTeam masterTeam) {
        this.masterTeam = masterTeam;
    }

    public List<TeamMember> getTeamMember() {
        return teamMember;
    }

    public void setTeamMember(List<TeamMember> teamMember) {
        this.teamMember = teamMember;
    }

    public SprintDetail getSprintDetail() {
        return sprintDetail;
    }

    public void setSprintDetail(SprintDetail sprintDetail) {
        this.sprintDetail = sprintDetail;
    }
}
