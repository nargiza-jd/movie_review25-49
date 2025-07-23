package kg.attractor.movie_review2549.service.impl;

import kg.attractor.movie_review2549.dao.ImageDao;
import kg.attractor.movie_review2549.dto.ImageDto;
import kg.attractor.movie_review2549.exceptions.ImageNotFoundException;
import kg.attractor.movie_review2549.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {
    private final ImageDao imageDao;

    @Override
    public ResponseEntity<?> getById(long id) {
        var image = imageDao.findById(id)
                .orElseThrow(ImageNotFoundException::new);
        return downloadFile(image.getFilename(), "images", MediaType.IMAGE_JPEG);
    }

    @Override
    public void create(ImageDto imageDto) {
        String filename = saveUploadedFile(imageDto.getFile(), "images");
        imageDao.save(filename, imageDto.getMovieId());
    }
}
