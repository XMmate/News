package com.heima.model.behavior.dtos;

import io.swagger.models.auth.In;
import lombok.Data;

@Data
public class ReadBehavior {
    private Long articleId;
    private Integer count;
}
