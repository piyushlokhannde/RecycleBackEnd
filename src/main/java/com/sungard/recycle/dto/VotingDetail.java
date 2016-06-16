package com.sungard.recycle.dto;

import javax.persistence.*;

/**
 * Created by Rakesh.Sharma on 6/11/2016.
 */
@Entity
@Table(name = "Voting_Detail")
public class VotingDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "voting_detail_gen")
    @SequenceGenerator(name = "voting_detail_gen", sequenceName = "voting_detail_seq", allocationSize = 1, initialValue = 0)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @ManyToOne
    private SprintDetail sprintDetail;

    @ManyToOne
    private TeamMember teamMember;

    @ManyToOne
    private MasterVotingQue votingQue;

    private Integer votingPoints = 0;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SprintDetail getSprintDetail() {
        return sprintDetail;
    }

    public void setSprintDetail(SprintDetail sprintDetail) {
        this.sprintDetail = sprintDetail;
    }

    public TeamMember getTeamMember() {
        return teamMember;
    }

    public void setTeamMember(TeamMember teamMember) {
        this.teamMember = teamMember;
    }

    public MasterVotingQue getVotingQue() {
        return votingQue;
    }

    public void setVotingQue(MasterVotingQue votingQue) {
        this.votingQue = votingQue;
    }

    public Integer getVotingPoints() {
        return votingPoints;
    }

    public void setVotingPoints(Integer votingPoints) {
        this.votingPoints = votingPoints;
    }
}
