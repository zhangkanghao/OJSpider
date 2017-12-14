package com.imudges.zkh.model;

public class proInfo {

    private String id;
    private String name;
    private String timeLimit;
    private String memoryLimit;
    private String submit;
    private String solved;
    private String description;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(String timeLimit) {
        this.timeLimit = timeLimit;
    }

    public String getMemoryLimit() {
        return memoryLimit;
    }

    public void setMemoryLimit(String memoryLimit) {
        this.memoryLimit = memoryLimit;
    }

    public String getSubmit() {
        return submit;
    }

    public void setSubmit(String submit) {
        this.submit = submit;
    }

    public String getSolved() {
        return solved;
    }

    public void setSolved(String solved) {
        this.solved = solved;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        String problem;
        problem="----------------------------------------------------------------\n";
        problem+="名称:"+name+"\n";
        problem+="时间限制:"+timeLimit+"\n内存限制:"+memoryLimit+"\n";
        problem+="提交:"+submit+"\n解决:"+solved+"\n";
        problem+="题目描述:"+description+"\n";
        return problem;
    }
}
