package com.aleks.EverythingToPng.repository;

import com.aleks.EverythingToPng.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {

}
