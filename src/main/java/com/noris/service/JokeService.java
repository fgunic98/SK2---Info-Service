package com.noris.service;


import com.noris.dto.JokeDto;

public interface JokeService {
	
	JokeDto getLatest();
	void add(JokeDto userCreateDto);
}
