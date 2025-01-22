package com.baolqp.image_thumbnail.controller;

import com.baolqp.image_thumbnail.dto.request.ApiResponse;
import com.baolqp.image_thumbnail.dto.request.ImageCreationRequest;
import com.baolqp.image_thumbnail.dto.response.ImageResponse;
import com.baolqp.image_thumbnail.entity.Image;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.baolqp.image_thumbnail.service.ImageService;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/images")
public class ImageController {
    @Autowired
    ImageService _imageService;

    @PostMapping
    ApiResponse<ImageResponse> createImage(@RequestBody ImageCreationRequest request) {
        return _imageService.createImage(request);
    }

    @GetMapping
    ApiResponse<List<ImageResponse>> getImages() {
        return ApiResponse.<List<ImageResponse>>builder()
                .code(200)
                .message("Get all users successfully")
                .data(_imageService.getListImages())
                .build();
    }

}
