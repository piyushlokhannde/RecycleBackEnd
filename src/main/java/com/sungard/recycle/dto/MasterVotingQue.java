package com.sungard.recycle.dto;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Rakesh.Sharma on 6/11/2016.
 */
@Entity
@Table(name="Master_Voting_Que")
public class MasterVotingQue {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE,generator = "master_voting_que_gen")
    @SequenceGenerator(name = "master_voting_que_gen", sequenceName = "master_voting_que_seq", allocationSize = 1, initialValue = 0)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    private String question;

    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
