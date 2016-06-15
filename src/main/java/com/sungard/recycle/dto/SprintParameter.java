package com.sungard.recycle.dto;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by Rakesh.Sharma on 6/11/2016.
 */
@Entity
@Table(name="Sprint_Parameter")
public class SprintParameter {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE,generator = "sprint_parameter_gen")
    @SequenceGenerator(name = "sprint_parameter_gen", sequenceName = "sprint_parameter_seq", allocationSize = 1, initialValue = 0)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;
    private String name;
    @ManyToOne
    private SprintGoal sprintGoal;
    private Integer startValue;
    private Integer endValue;
    private String parameterType;
    private Boolean isHigherTheBetter;
    private BigDecimal weightage;
    private BigDecimal paramTotal;
    private String levelName;
    private Integer actualValue;
    private BigDecimal expectedTotal;
}
