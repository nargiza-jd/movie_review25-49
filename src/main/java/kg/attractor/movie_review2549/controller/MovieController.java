package kg.attractor.movie_review2549.controller;

import kg.attractor.movie_review2549.dto.MovieDto;
import kg.attractor.movie_review2549.model.Movie;
import kg.attractor.movie_review2549.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("movies") // movies/
@RequiredArgsConstructor
public class MovieController {
    private final MovieService movieService;


//    @GetMapping // movies/
//    public List<Movie> getAllMovies() {
//        return movieService.getAllMovies();
//    }

    @GetMapping("{movieId}") // movies/1
    public MovieDto getMovie(@PathVariable Long movieId) {
        return movieService.getMovieById(movieId);
    }

//    @PostMapping
//    public HttpStatus addMovie(@RequestBody MovieDto movieDto) {
//        movieService.createMovie(movieDto);
//        return HttpStatus.CREATED;
//    }


}
