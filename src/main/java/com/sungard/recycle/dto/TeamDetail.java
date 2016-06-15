package com.sungard.recycle.dto;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Rakesh.Sharma on 6/11/2016.
 */
@Entity
@Table(name="TEAM_DETAIL")
public class TeamDetail {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE,generator = "team_detail_gen")
    @SequenceGenerator(name = "team_detail_gen", sequenceName = "team_detail_seq", allocationSize = 1, initialValue = 0)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @ManyToOne
    private MasterTeam masterTeam;

    @OneToMany
    private List<MasterTeamMember> masterTeamMember;

    @ManyToOne
    private SprintDetail sprintDetail;

    private BigDecimal teamMemberTotal;
}
