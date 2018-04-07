package com.willstay.springbootapplicationrest.domain;

public class Owner {
    Long id;
    Long companyId;
    String firstName;
    String secondName;

    public Owner(Long id, Long companyId, String firstName, String secondName) {
        this.id = id;
        this.companyId = companyId;
        this.firstName = firstName;
        this.secondName = secondName;
    }

    public Owner() {
    }

    public Long getId() {
        return id;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }
}
