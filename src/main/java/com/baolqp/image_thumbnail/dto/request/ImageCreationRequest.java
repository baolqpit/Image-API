package com.baolqp.image_thumbnail.dto.request;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ImageCreationRequest {
    String url;
    String placeholder;
}
