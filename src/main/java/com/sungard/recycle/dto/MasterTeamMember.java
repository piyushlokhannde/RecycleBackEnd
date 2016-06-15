package com.sungard.recycle.dto;

import javax.persistence.*;

/**
 * Created by Rakesh.Sharma on 6/11/2016.
 */
@Entity
@Table(name="Master_Team_Member")
public class MasterTeamMember {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE,generator = "master_team_member_gen")
    @SequenceGenerator(name = "master_team_member_gen", sequenceName = "master_team_member_seq", allocationSize = 1, initialValue = 0)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;
    private String name;
    private String description;
    private String status;
    private String emailId;
}

