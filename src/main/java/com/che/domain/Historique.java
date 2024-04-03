package com.che.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "historique")
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Historique implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "search_date")
    private LocalDateTime searchDate;

    @Column(name = "request")
    private String request;

    @Column(name = "response_date")
    private String responseDate;

    @Column(name = "response_day")
    private String responseDay;

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getSearchDate() {
        return searchDate;
    }

    public void setSearchDate(LocalDateTime searchDate) {
        this.searchDate = searchDate;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public String getResponseDate() {
        return responseDate;
    }

    public void setResponseDate(String responseDate) {
        this.responseDate = responseDate;
    }

    public String getResponseDay() {
        return responseDay;
    }

    public void setResponseDay(String responseDay) {
        this.responseDay = responseDay;
    }
}
