package kg.attractor.movie_review2549.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
@Builder
public class ImageDto {
    private MultipartFile file;
    private long movieId;
}