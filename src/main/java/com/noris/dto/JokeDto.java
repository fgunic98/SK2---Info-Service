package com.noris.dto;

import java.io.Serializable;

import javax.persistence.ManyToOne;

/**
 * 
 * @author Coa
 * Klasa za rukovanje sa sala objektima
 *
 */
public class JokeDto implements Serializable{

    private String id;
    private String joke;
    @ManyToOne
    private UserDto user;
    @ManyToOne
    private JokesDto jokeDto;
    
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJoke() {
        return joke;
    }

    public void setJoke(String joke) {
        this.joke = joke;
    }
}

