package com.differentdoors.outsmart.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Filter {
    private String key;
    private String value;
    private String operator;
}
