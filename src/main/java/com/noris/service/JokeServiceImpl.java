package com.noris.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.noris.dto.JokeDto;
import com.noris.repository.JokeRepository;

@Service
@Transactional
public class JokeServiceImpl implements JokeService{
	
	@Autowired
	private JokeRepository jokeRepository;
	
	public JokeServiceImpl(JokeRepository jokeRepository) {
		this.jokeRepository = jokeRepository;
	}
	
	@Override
	public JokeDto getLatest() {
		if(jokeRepository.findTopByOrderById().isPresent()) return jokeRepository.findTopByOrderById().get();
		return null;
	}

	@Override
	public void add(JokeDto joke) {
		jokeRepository.save(joke);
	}

}
