package com.aleks.EverythingToPng.service.impl;

import com.aleks.EverythingToPng.exception.ResourceNotFoundException;
import com.aleks.EverythingToPng.model.Image;
import com.aleks.EverythingToPng.repository.ImageRepository;
import com.aleks.EverythingToPng.service.ImageService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImageServiceImpl implements ImageService {

    private ImageRepository imageRepository;

    public ImageServiceImpl(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    @Override
    public Image saveImage(Image image) {
        return imageRepository.save(image);
    }

    @Override
    public List<Image> getAllImages() {
        return imageRepository.findAll();
    }

    @Override
    public Image getImageById(long id) {
        return imageRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Image", "Id", id));
    }

    @Override
    public Image updateImage(Image image, long id) {
        //Check if image with given id exists in database
        Image existingImage = imageRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Image", "Id", id));
        existingImage.setFileName(image.getFileName());
        existingImage.setFileType(image.getFileType());
        existingImage.setFileData(image.getFileData());

        //Save image to database
        imageRepository.save(existingImage);
        return existingImage;
    }

    @Override
    public Image deleteImage(long id) {

        //Check if image exists in database
        imageRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Image", "Id", id));

        imageRepository.deleteById(id);
        return null;
    }
}
