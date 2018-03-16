package com.didispace.dao.impl;

public class TestPlan {
    private Integer id;

    private String plantime;

    private String projectname;

    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlantime() {
        return plantime;
    }

    public void setPlantime(String plantime) {
        this.plantime = plantime == null ? null : plantime.trim();
    }

    public String getProjectname() {
        return projectname;
    }

    public void setProjectname(String projectname) {
        this.projectname = projectname == null ? null : projectname.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}