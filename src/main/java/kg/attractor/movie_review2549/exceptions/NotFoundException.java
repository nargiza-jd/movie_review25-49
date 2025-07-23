package kg.attractor.movie_review2549.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String prefix) {
        super(prefix + " not found");
    }
}
