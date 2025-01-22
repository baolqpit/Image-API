package com.baolqp.image_thumbnail.mapper;

import com.baolqp.image_thumbnail.dto.request.ImageCreationRequest;
import com.baolqp.image_thumbnail.dto.response.ImageResponse;
import com.baolqp.image_thumbnail.entity.Image;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ImageMapper {
    Image toImage(ImageCreationRequest request);

    ImageResponse toImageResponse(Image image);
}
