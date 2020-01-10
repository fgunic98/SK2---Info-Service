package com.noris.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.noris.dto.JokeDto;

@Repository
public interface JokeRepository extends MongoRepository<JokeDto, String> {
	
	Optional<JokeDto> findTopByOrderByCreatedDesc();

}
