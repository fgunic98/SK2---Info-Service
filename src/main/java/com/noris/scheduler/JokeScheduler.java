package com.noris.scheduler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.noris.dto.JokeDto;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class JokeScheduler {

    private RestTemplate norisApiClient;
    private JmsTemplate jmsTemplate;
    private ObjectMapper objectMapper;
    private String emailQueueDestination;

    public JokeScheduler(RestTemplate norisApiClient, JmsTemplate jmsTemplate, ObjectMapper objectMapper,
                               @Value("${destination.sendEmails}") String emailQueueDestination) {

        this.norisApiClient = norisApiClient;
        this.jmsTemplate = jmsTemplate;
        this.objectMapper = objectMapper;
        this.emailQueueDestination = emailQueueDestination;
    }

    @Scheduled(initialDelay = 10000, fixedRate = 10000)
    public void getJoke() throws JsonProcessingException {
        ResponseEntity<JokeDto> matchesDtoResponseEntity = norisApiClient
                .exchange("", HttpMethod.GET, null, JokeDto.class);
        if (matchesDtoResponseEntity.getStatusCode().equals(HttpStatus.OK))
            jmsTemplate.convertAndSend(emailQueueDestination, objectMapper
                    .writeValueAsString(matchesDtoResponseEntity.getBody()));
    }
}
