package kg.attractor.movie_review2549.controller;

import kg.attractor.movie_review2549.dto.ImageDto;
import kg.attractor.movie_review2549.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("images")
@RequiredArgsConstructor
public class ImageController {

    private final ImageService imageService;

    @GetMapping // images/1
    public ResponseEntity<?> getImage(@RequestParam(name = "id") Long id) {
        return imageService.getById(id);
    }

    @PostMapping
    public HttpStatus create(ImageDto imageDto) {
        imageService.create(imageDto);
        return HttpStatus.CREATED;
    }
}