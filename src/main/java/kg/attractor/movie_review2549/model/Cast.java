package kg.attractor.movie_review2549.model;

import lombok.Data;

@Data
public class Cast {
    private String fullName;
    private String role;

    @Override
    public String toString() {
        String format = String.format("%s в роли %s", fullName, role);
        return format;
    }
}
