package com.sungard.recycle.dto;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by Rakesh.Sharma on 6/11/2016.
 */
@Entity
@Table(name="Master_Goal")
public class MasterGoal {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE,generator = "master_goal_gen")
    @SequenceGenerator(name = "master_goal_gen", sequenceName = "master_goal_seq", allocationSize = 1, initialValue = 0)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;
    private String name;
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getWeightage() {
        return weightage;
    }

    public void setWeightage(BigDecimal weightage) {
        this.weightage = weightage;
    }

    private BigDecimal weightage;

}
