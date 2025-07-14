package kg.attractor.movie_review2549.dto;

import kg.attractor.movie_review2549.model.Cast;
import kg.attractor.movie_review2549.model.Director;
import lombok.Data;

import java.util.List;

@Data
public class MovieDto {
    private Integer id;
    private String name;
    private Integer year;
    private String description;
    private Director director;
    private List<Cast> cast;

}
