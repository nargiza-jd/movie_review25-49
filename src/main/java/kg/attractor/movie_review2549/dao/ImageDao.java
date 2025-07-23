package kg.attractor.movie_review2549.dao;


import kg.attractor.movie_review2549.model.Image;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
@RequiredArgsConstructor
public class ImageDao {
    private final JdbcTemplate jdbcTemplate;
    public void save(String filename, long movieId) {
        String sql = "insert into movie_images(file_name, movie_id) " +
                "values(?, (select id from movie where id=?))";
        jdbcTemplate.update(sql, filename, movieId);
    }

    public Optional<Image> findByFileName(String fileName) {
        String sql = "select * from movie_images where file_name = ?";
        return Optional.ofNullable(
                DataAccessUtils.singleResult(
                        jdbcTemplate.query(
                                sql,
                                new BeanPropertyRowMapper<>(Image.class),
                                fileName
                        )
                )
        );
    }

    public Optional<Image> findById(long id) {
        String sql = "select * from movie_images where id = ?";
        return Optional.ofNullable(
                DataAccessUtils.singleResult(
                        jdbcTemplate.query(
                                sql,
                                new BeanPropertyRowMapper<>(Image.class),
                                id
                        )
                )
        );
    }

    public Optional<Image> findByMovieId(long movieId) {
        String sql = "select * from movie_images where movie_id=?";
        return Optional.ofNullable(
                DataAccessUtils.singleResult(
                        jdbcTemplate.query(
                                sql,
                                new BeanPropertyRowMapper<>(Image.class),
                                movieId
                        )
                )
        );
    }
}
