package kg.attractor.movie_review2549.model;

import lombok.Data;

@Data
public class Director {
    private String fullName;

    @Override
    public String toString() {
        return String.format("Режиссер: %s", fullName);
    }
}
