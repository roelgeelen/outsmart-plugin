package com.differentdoors.outsmart.services;

import com.differentdoors.outsmart.models.Filter;
import com.differentdoors.outsmart.models.SResult;
import com.differentdoors.outsmart.models.SResults;
import com.differentdoors.outsmart.models.objects.Relation;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.lang.Nullable;
import org.springframework.retry.RetryException;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RelationService {
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
    @Retryable(value = ResourceAccessException.class, maxAttempts = 3, backoff = @Backoff(delay = 1000))
    public SResults<Relation> getRelation(@Nullable List<Filter> filters) throws Exception {
        Map<String, String> urlParams = new HashMap<>();
        urlParams.put("path", "relations");

        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(URL)
                .queryParam("token", token)
                .queryParam("software_token", software_token);

        if (filters != null) {
            filters.forEach(f -> {
                builder.queryParam("key[]", f.getKey());
                builder.queryParam("value[]", f.getValue());
                builder.queryParam("operator[]", f.getOperator());
            });
        }

        return objectMapper.readValue(restTemplate.getForObject(builder.buildAndExpand(urlParams).toUri(), String.class), new TypeReference<SResults<Relation>>() {});
    }
    @Retryable(value = ResourceAccessException.class, maxAttempts = 3, backoff = @Backoff(delay = 1000))
    public SResult<Integer> createRelation(Relation relation) throws Exception {
        Map<String, String> urlParams = new HashMap<>();
        urlParams.put("path", "relations");

        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(URL)
                .queryParam("token", token)
                .queryParam("software_token", software_token);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Object> entity = new HttpEntity<>(objectMapper.writeValueAsString(relation), headers);

        return objectMapper.readValue(restTemplate.postForObject(builder.buildAndExpand(urlParams).toUri(), entity, String.class), new TypeReference<SResult<Integer>>() {});
    }

    @Recover
    public RetryException recover(Exception t){
        return new RetryException("Maximum retries reached: " + t.getMessage());
    }
}
