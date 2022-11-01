package com.differentdoors.outsmart.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class WorkOrder {
    private String id;
    @JsonProperty("WorkEndDate")
    private String workEndDate;
    @JsonProperty("CustomerName")
    private String customerName;
    @JsonProperty("CustomerCity")
    private String customerCity;
    @JsonProperty("WorkDescription")
    private String workDescription;
    private String status;
    @JsonProperty("WorkDeadline")
    private String workDeadline;
    @JsonProperty("Deadline")
    private Date deadline;
    @JsonProperty("ShortWorkDescription")
    private String shortWorkDescription;

    public WorkOrder(){}

    public String getId() {
        return id;
    }

    public String getWorkEndDate() {
        return workEndDate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerCity() {
        return customerCity;
    }

    public String getWorkDescription() {
        return workDescription;
    }

    public String getWorkDeadline() {
        return workDeadline;
    }

    public String getShortWorkDescription() {
        return shortWorkDescription;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
