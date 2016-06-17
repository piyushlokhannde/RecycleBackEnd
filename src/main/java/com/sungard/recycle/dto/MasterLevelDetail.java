package com.sungard.recycle.dto;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by Rakesh.Sharma on 6/11/2016.
 */
@Entity
@Table(name="Master_Level_Detail")
public class MasterLevelDetail {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE,generator = "master_level_detail_gen")
    @SequenceGenerator(name = "master_level_detail_gen", sequenceName = "master_level_detail_seq", allocationSize = 1, initialValue = 0)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;
    private String name;
    private String description;
    @ManyToOne
    private MasterLevel masterLevel;
    private BigDecimal percentage = new BigDecimal(0.0);
    
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

    public MasterLevel getMasterLevel() {
        return masterLevel;
    }

    public void setMasterLevel(MasterLevel masterLevel) {
        this.masterLevel = masterLevel;
    }

    public BigDecimal getPercentage() {
        return percentage;
    }

    public void setPercentage(BigDecimal percentage) {
        this.percentage = percentage;
    }
}
