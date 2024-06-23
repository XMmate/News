package com.heima.model.sensitive.dtos;

import io.swagger.models.auth.In;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdSensitive {
    public Date createdTime;
    public Integer id;
    public String sensitives;
}
