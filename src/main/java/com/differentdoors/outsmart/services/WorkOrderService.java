package com.differentdoors.outsmart.services;

import com.differentdoors.outsmart.models.Filter;
import com.differentdoors.outsmart.models.SResults;
import com.differentdoors.outsmart.models.WorkOrder;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class WorkOrderService {
    @Value("${different_doors.outsmart.url}")
    private String URL;
    @Value("${different_doors.outsmart.token}")
    private String token;
    @Value("${different_doors.outsmart.software_token}")
    private String software_token;


    private final ObjectMapper objectMapper = JsonMapper.builder()
            .findAndAddModules()
            .serializationInclusion(JsonInclude.Include.NON_NULL)
            .build();

    @Autowired
    @Qualifier("Outsmart")
    private RestTemplate restTemplate;

    public SResults<WorkOrder> getWorkOrders(@Nullable String status, @Nullable String workStatus, @Nullable List<Filter> filters) throws JsonProcessingException {
        Map<String, String> urlParams = new HashMap<>();
        urlParams.put("path", "GetWorkorders");

        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(URL)
                .queryParam("token", token)
                .queryParam("software_token", software_token)
                .queryParam("update_status", false);

        if (status != null) {
            builder.queryParam("status", status);
        }

        if (workStatus != null) {
            builder.queryParam("workstatus", workStatus);
        }

        if (filters != null) {
            filters.forEach(f -> {
                builder.queryParam("key[]", f.getKey());
                builder.queryParam("value[]", f.getValue());
                builder.queryParam("operator[]", f.getOperator());
            });
        }
        return objectMapper.readValue(restTemplate.getForObject(builder.buildAndExpand(urlParams).toUri(), String.class), new TypeReference<SResults<WorkOrder>>() {});
    }
}
