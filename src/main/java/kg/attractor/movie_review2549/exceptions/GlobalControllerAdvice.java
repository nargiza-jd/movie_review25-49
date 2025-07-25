package kg.attractor.movie_review2549.exceptions;

import kg.attractor.movie_review2549.service.ErrorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@RequiredArgsConstructor
public class GlobalControllerAdvice {
    private final ErrorService errorService;

    @ExceptionHandler(NotFoundException.class)
    public ErrorResponse handleNotFoundException(NotFoundException ex) {
        return ErrorResponse.builder(ex, HttpStatus.NOT_FOUND, ex.getMessage()).build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponseBody> validationHandler(MethodArgumentNotValidException ex) {
        return new ResponseEntity<>(errorService.makeResponse(ex.getBindingResult()), HttpStatus.BAD_REQUEST);
    }
}
