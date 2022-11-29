package com.differentdoors.outsmart.models.objects;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.*;

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
    @JsonProperty("WorkorderNo")
    private String workOrderNo;

    @JsonFormat(pattern = "dd-MM-yyyy")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @JsonProperty("WorkDate")
    private Date workDate;

    @JsonProperty("WorkTime")
    private String workTime;
    @JsonProperty("EmployeeNr")
    private String employeeNr;

    @JsonFormat(pattern = "dd-MM-yyyy")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @JsonProperty("WorkEndDate")
    private Date workEndDate;

    @JsonProperty("CustomerDebtorNr")
    private String customerDebtorNr;
    @JsonProperty("CustomerName")
    private String customerName;
    @JsonProperty("CustomerStreet")
    private String customerStreet;
    @JsonProperty("CustomerZIP")
    private String customerZIP;
    @JsonProperty("CustomerCity")
    private String customerCity;
    @JsonProperty("CustomerNameInvoice")
    private String customerNameInvoice;
    @JsonProperty("CustomerContactPerson")
    private String customerContactPerson;
    @JsonProperty("CustomerContactPersonInvoice")
    private String customerContactPersonInvoice;
    @JsonProperty("CustomerDebtorNrInvoice")
    private String customerDebtorNrInvoice;
    @JsonProperty("CustomerStreetInvoice")
    private String customerStreetInvoice;
    @JsonProperty("CustomerZIPInvoice")
    private String customerZIPInvoice;
    @JsonProperty("CustomerCityInvoice")
    private String customerCityInvoice;
    @JsonProperty("PaymentMethod")
    private String paymentMethod;
    @JsonProperty("WorkDescription")
    private String workDescription;
    private String status;

    @JsonFormat(pattern = "dd-MM-yyyy")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @JsonProperty("WorkDeadline")
    private Date workDeadline;

    @JsonProperty("PriorityCode")
    private boolean priorityCode;
    @JsonProperty("PriorityMessage")
    private String priorityMessage;
    @JsonProperty("ShortWorkDescription")
    private String shortWorkDescription;
    @JsonProperty("InternalWorkDescription")
    private String internalWorkDescription;
    @JsonProperty("WorkStatus")
    private String workStatus;
    @JsonProperty("CustomerCountry")
    private String customerCountry;
    @JsonProperty("CustomerPhone")
    private String customerPhone;
    @JsonProperty("CustomerEmail")
    private String customerEmail;
    @JsonProperty("CustomerEmailInvoice")
    private String customerEmailInvoice;
    @JsonProperty("CustomerCountryInvoice")
    private String customerCountryInvoice;
    @JsonProperty("CustomerPhoneInvoice")
    private String customerPhoneInvoice;
    @JsonProperty("TypeOfWork")
    private String typeOfWork;
    @JsonProperty("FreeFields")
    private FreeFields freeFields;

    private static final List<String> wood = new ArrayList<>() {
        {
            add("Montage ODHD");
            add("Montage ODHT");
            add("Montage SDH");
            add("Montage SDHZ");
            add("Montage VDH");
        }
    };

    @JsonIgnore
    public boolean isWood() {
        return wood.contains(this.getTypeOfWork());
    }
}
