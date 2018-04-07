package com.willstay.springbootapplicationrest.domain;

public class Account {
    Long id;
    Long ownerId;
    String name;
    Double rate;

    public Account(Long id, Long ownerId, String name, Double rate) {
        this.id = id;
        this.ownerId = ownerId;
        this.name = name;
        this.rate = rate;
    }

    public Account() {
    }

    public Long getId() {
        return id;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }
}
