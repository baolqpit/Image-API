package com.baolqp.image_thumbnail.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class ImageResponse {
    String id;
    String url;
    String placeholder;
}
