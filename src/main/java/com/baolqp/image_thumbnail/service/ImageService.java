package com.baolqp.image_thumbnail.service;

import com.baolqp.image_thumbnail.dto.request.ApiResponse;
import com.baolqp.image_thumbnail.dto.request.ImageCreationRequest;
import com.baolqp.image_thumbnail.dto.response.ImageResponse;
import com.baolqp.image_thumbnail.entity.Image;
import com.baolqp.image_thumbnail.exception.AppException;
import com.baolqp.image_thumbnail.exception.ErrorCode;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import com.baolqp.image_thumbnail.mapper.ImageMapper;
import org.springframework.stereotype.Service;
import com.baolqp.image_thumbnail.repository.ImageRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ImageService {
    ImageRepository _imageRepository;
    ImageMapper _imageMapper;

    public ApiResponse<ImageResponse> createImage(ImageCreationRequest request) {
        if (_imageRepository.existsByUrl(request.getUrl())) {
            return ApiResponse.<ImageResponse>builder()
                    .code(ErrorCode.OBJECT_EXISTED.getCode())
                    .message(ErrorCode.OBJECT_EXISTED.getMessage())
                    .build();
        }

        Image image = _imageMapper.toImage(request);
        Image savedImage = _imageRepository.save(image);

        return ApiResponse.<ImageResponse>builder()
                .code(201)
                .message("Image created successfully")
                .data(_imageMapper.toImageResponse(savedImage))
                .build();
    }

    public List<ImageResponse> getListImages() {
        return _imageRepository
                .findAll()
                .stream()
                .map(_imageMapper::toImageResponse)
                .collect(Collectors.toList());
    }
}
