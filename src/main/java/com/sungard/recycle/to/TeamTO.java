package com.sungard.recycle.to;

import java.util.ArrayList;
import java.util.List;

public class  TeamTO {
    private Long id;
    private String name;
    private String description;
    private String status;

    List<TeamMemberTO> teamMemberTOs = new ArrayList<TeamMemberTO>();

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the teamMemberTOs
     */
    public List<TeamMemberTO> getTeamMemberTOs() {
        return teamMemberTOs;
    }

    /**
     * @param teamMemberTOs the teamMemberTOs to set
     */
    public void setTeamMemberTOs(List<TeamMemberTO> teamMemberTOs) {
        this.teamMemberTOs = teamMemberTOs;
    }
}
