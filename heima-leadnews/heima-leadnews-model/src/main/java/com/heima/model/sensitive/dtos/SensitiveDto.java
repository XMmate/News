package com.heima.model.sensitive.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SensitiveDto {
    public String name;
    public Integer page;
    public Integer size;
}
