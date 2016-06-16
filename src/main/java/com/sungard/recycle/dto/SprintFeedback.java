package com.sungard.recycle.dto;

import javax.persistence.*;

/**
 * Created by Rakesh.Sharma on 6/11/2016.
 */
@Entity
@Table(name="Sprint_Feedback")
public class SprintFeedback {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE,generator = "sprint_feedback_gen")
    @SequenceGenerator(name = "sprint_feedback_gen", sequenceName = "sprint_feedback_seq", allocationSize = 1, initialValue = 0)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @ManyToOne
    private SprintDetail sprintDetail;

    @ManyToOne
    private MasterVotingQue votingQue;

    private Integer rating = 0;

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

    public MasterVotingQue getVotingQue() {
        return votingQue;
    }

    public void setVotingQue(MasterVotingQue votingQue) {
        this.votingQue = votingQue;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }
}
