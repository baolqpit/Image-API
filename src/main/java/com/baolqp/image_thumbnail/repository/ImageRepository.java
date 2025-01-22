package com.baolqp.image_thumbnail.repository;

import com.baolqp.image_thumbnail.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageRepository extends JpaRepository<Image, String> {
    boolean existsByUrl(String url);

    @Override
    List<Image> findAll();
}
