package com.driver;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class MovieController {

    @Autowired
    MovieService movieService;

    @PostMapping("/movies/add-movie")
    public String addMovie(@RequestBody(required = true) Movie movie) {
        movieService.add_movie(movie);
        return "sucess";
    }

    @PostMapping("/movies/add-director")
    public ResponseEntity<String> addDirector(@RequestBody(required = true) Director director) {
        movieService.add_director(director);
        return new ResponseEntity<>("success", HttpStatus.ACCEPTED);
    }

    @PostMapping("/movies/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam("movie") String mov,@RequestParam("director") String dir) {
        movieService.add_pair(mov,dir);
        return new ResponseEntity<>("success", HttpStatus.ACCEPTED);
    }

    @GetMapping("/movies/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable("name") String name){

        return new ResponseEntity<>(movieService.get_movie(name),HttpStatus.ACCEPTED);
    }

    @GetMapping("/movies/get-director-by-name/{name}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable("name") String name){

        return new ResponseEntity<>(movieService.get_director(name),HttpStatus.ACCEPTED);
    }

    @GetMapping("/movies/get-movies-by-director-name/{director}")
    public ResponseEntity<ArrayList<String> > getMoviesByDirectorName(@PathVariable("director") String director){

        return new ResponseEntity<>(movieService.get_movie_by_name(director),HttpStatus.ACCEPTED);
    }

    @GetMapping("/movies/get-all-movies")
    public ResponseEntity<ArrayList<String> > findAllMovies(){

        return new ResponseEntity<>(movieService.get_All(),HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/movies/delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam("name") String name){
        movieService.deleteDirector(name);
        return new ResponseEntity<>("success",HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/movies/delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors(){
        movieService.deleteAll();
        return new ResponseEntity<>("success",HttpStatus.ACCEPTED);
    }


}
