package com.didispace.test.dao.impl;

public class TestRunConfig {
    private Integer id;

    private String projectname;

    private Integer runtype;

    private String runcmd;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProjectname() {
        return projectname;
    }

    public void setProjectname(String projectname) {
        this.projectname = projectname == null ? null : projectname.trim();
    }

    public Integer getRuntype() {
        return runtype;
    }

    public void setRuntype(Integer runtype) {
        this.runtype = runtype;
    }

    public String getRuncmd() {
        return runcmd;
    }

    public void setRuncmd(String runcmd) {
        this.runcmd = runcmd == null ? null : runcmd.trim();
    }
}