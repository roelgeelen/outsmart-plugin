package com.differentdoors.outsmart.models.objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Relation {
    private String name;
    private String debtor_number;
    private String contact;
    private String email;
    private String email_workorder;
    private String street;
    private String postal_code;
    private String city;
    private String phone_number;
    private String country;
}
