package com.noris.controller;


import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.noris.dto.JokeDto;
import com.noris.service.JokeService;



@RestController
@RequestMapping("/joke")
public class JokeController {

    private JokeService jokeService;

    public JokeController(JokeService jokeService) {
        this.jokeService = jokeService;
    }

    @GetMapping
    public ResponseEntity<JokeDto> getJoke(Pageable pageable) {

        return new ResponseEntity<JokeDto>(jokeService.getLatest(), HttpStatus.OK);
    }
}
