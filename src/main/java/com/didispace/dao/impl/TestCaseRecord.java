package com.didispace.dao.impl;

public class TestCaseRecord {
    private Integer id;

    private String classname;

    private String interfacename;

    private String testcaseid;

    private String testpoint;

    private Integer planId;

    private String resultSign;

    private String errordes;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname == null ? null : classname.trim();
    }

    public String getInterfacename() {
        return interfacename;
    }

    public void setInterfacename(String interfacename) {
        this.interfacename = interfacename == null ? null : interfacename.trim();
    }

    public String getTestcaseid() {
        return testcaseid;
    }

    public void setTestcaseid(String testcaseid) {
        this.testcaseid = testcaseid == null ? null : testcaseid.trim();
    }

    public String getTestpoint() {
        return testpoint;
    }

    public void setTestpoint(String testpoint) {
        this.testpoint = testpoint == null ? null : testpoint.trim();
    }

    public Integer getPlanId() {
        return planId;
    }

    public void setPlanId(Integer planId) {
        this.planId = planId;
    }

    public String getResultSign() {
        return resultSign;
    }

    public void setResultSign(String resultSign) {
        this.resultSign = resultSign == null ? null : resultSign.trim();
    }

    public String getErrordes() {
        return errordes;
    }

    public void setErrordes(String errordes) {
        this.errordes = errordes == null ? null : errordes.trim();
    }
}