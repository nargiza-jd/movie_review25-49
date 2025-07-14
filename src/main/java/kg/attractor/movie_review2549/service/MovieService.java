package kg.attractor.movie_review2549.service;

import kg.attractor.movie_review2549.util.FileUtil;
import kg.attractor.movie_review2549.dto.MovieDto;
import kg.attractor.movie_review2549.model.Director;
import kg.attractor.movie_review2549.model.Movie;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {
    private final List<Movie> movies;

    public MovieService() {
        this.movies = new FileUtil().getMovies();
    }

    public List<Movie> getAllMovies() {
        return movies;
    }

    public Movie getMovieById(int id) {
        return movies.stream().filter(m -> m.getId() == id).findAny().orElseThrow();
    }

    public void createMovie(MovieDto movieDto) {
        movies.add(
                Movie.builder()
                        .id(movies.size() + 1)
                        .name(movieDto.getName())
                        .year(LocalDate.now().getYear())
                        .description(movieDto.getDescription())
                        .cast(new ArrayList<>())
                        .director(new Director())
                        .build()
        );
    }
}
