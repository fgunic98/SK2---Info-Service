package com.noris.dto;

/**
 * 
 * @author Coa
 * Klasa za rukovanje sa sala objektima
 *
 */
public class JokeDto {

    private String id;
    private String joke;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUtcDate() {
        return joke;
    }

    public void setUtcDate(String joke) {
        this.joke = joke;
    }
}

