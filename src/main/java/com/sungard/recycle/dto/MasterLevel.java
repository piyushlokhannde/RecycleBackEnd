package com.sungard.recycle.dto;

import javax.persistence.*;

/**
 * Created by Rakesh.Sharma on 6/11/2016.
 */
@Entity
@Table(name="Master_Level")
public class MasterLevel {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE,generator = "master_level_gen")
    @SequenceGenerator(name = "master_level_gen", sequenceName = "master_level_seq", allocationSize = 1, initialValue = 0)
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
}
