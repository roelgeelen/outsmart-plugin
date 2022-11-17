package com.differentdoors.outsmart.models.objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class WorkOrder {
    private String id;
    @JsonProperty("ProjectNr")
    private String projectNr;
    @JsonProperty("WorkDate")
    private String workDate;
    @JsonProperty("WorkTime")
    private String workTime;
    @JsonProperty("EmployeeNr")
    private String employeeNr;
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
    @JsonProperty("InternalWorkDescription")
    private String internalWorkDescription;
}
