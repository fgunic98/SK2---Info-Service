package com.noris.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.noris.dto.JokeDto;
import com.noris.repository.JokeRepository;

@Service
@Transactional
public class JokeServiceImpl implements JokeService{
	
	private JokeRepository jokeRepository;
	
	public JokeServiceImpl(JokeRepository jokeRepository) {
		this.jokeRepository = jokeRepository;
	}
	
	@Override
	public JokeDto getLatest() {
		if(jokeRepository.findTopByOrderByCreatedDesc().isPresent()) return jokeRepository.findTopByOrderByCreatedDesc().get();
		return null;
	}

	@Override
	public void add(JokeDto joke) {
		jokeRepository.save(joke);
	}

}
