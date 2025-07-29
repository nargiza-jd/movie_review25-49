package kg.attractor.movie_review2549.service;

import kg.attractor.movie_review2549.exceptions.ErrorResponseBody;
import org.springframework.validation.BindingResult;

public interface ErrorService {
    ErrorResponseBody makeResponse(BindingResult bindingResult);

    ErrorResponseBody makeResponse(Exception e);
}
