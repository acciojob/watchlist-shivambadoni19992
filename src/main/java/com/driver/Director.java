package com.driver;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Director {
    private String name;
    private int numberOfMovies;
    private double imdbRating;

}
