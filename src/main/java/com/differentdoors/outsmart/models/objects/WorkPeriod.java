package com.differentdoors.outsmart.models.objects;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class WorkPeriod {
    @JsonProperty("Id")
    private String id;
    @JsonProperty("BeginTime")
    private String beginTime;
    @JsonFormat(pattern = "HH:mm")
    @DateTimeFormat(pattern = "HH:mm")
    @JsonProperty("TotalTime")
    private LocalTime totalTime;
    @JsonProperty("WorkRemark")
    private String workRemark;
    @JsonFormat(pattern = "dd-MM-yyyy")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @JsonProperty("WorkDate")
    private LocalDate workDate;
    @JsonProperty("EndTime")
    private String endTime;
    @JsonProperty("Travel")
    private String travel;
    @JsonProperty("HourType")
    private String hourType;
    @JsonProperty("EmployeeNr")
    private String employeeNr;
    @JsonProperty("Break")
    private String breakTime;
    @JsonProperty("ObjCode")
    private String objCode;
    @JsonProperty("ExternalId")
    private String externalId;
}
