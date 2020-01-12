package com.noris.scheduler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.noris.dto.JokeDto;
import com.noris.service.JokeService;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * 
 * @author Coa
 * Scheduler klasa za rukovanje sa intervalima hvatanja sala
 *
 */
@Component
public class JokeScheduler {
	
	@Autowired
    private RestTemplate norisApiClient;
	
    private JokeService jokeService;

    public JokeScheduler(JokeService jokeService) {

        this.jokeService = jokeService;
    }

    @Scheduled(initialDelay = 10000, fixedRate = 10000)
    public void getJoke() throws JsonProcessingException {
    	
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
            headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
            HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

            ResponseEntity<JokeDto> response = norisApiClient.exchange("https://api.chucknorris.io/jokes/random", HttpMethod.GET,entity,JokeDto.class);
            if (response.getStatusCode().equals(HttpStatus.OK)) {
            	
            	System.out.println(response);
            	jokeService.add(response.getBody());
            }
        } catch (Exception ex) {
           ex.printStackTrace();

        }
    }
}
