package com.aleks.EverythingToPng.service;

import com.aleks.EverythingToPng.model.Image;

import java.util.List;

public interface ImageService {
    Image saveImage(Image image);
    List<Image> getAllImages();
    Image getImageById(long id);
    Image updateImage(Image image, long id);
    Image deleteImage(long id);
}
