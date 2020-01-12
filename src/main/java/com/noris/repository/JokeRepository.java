package com.noris.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.noris.dto.JokeDto;

@Repository
public interface JokeRepository extends JpaRepository<JokeDto, Long> {
	
	Optional<JokeDto> findTopByOrderById();

}
