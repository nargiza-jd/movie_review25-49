package kg.attractor.movie_review2549.service.impl;


import kg.attractor.movie_review2549.dao.MovieDao;
import kg.attractor.movie_review2549.dto.MovieDto;
import kg.attractor.movie_review2549.exceptions.MovieNotFoundException;
import kg.attractor.movie_review2549.model.Movie;
import kg.attractor.movie_review2549.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {
    private final MovieDao movieDao;

    @Override
    public MovieDto getMovieById(long id) {
        Movie movie = movieDao.getMovieById(id)
                .orElseThrow(MovieNotFoundException::new);
        return MovieDto.builder()
                .id(movie.getId())
                .name(movie.getName())
                .year(movie.getYear())
                .description(movie.getDescription())
                .build();
    }
}
