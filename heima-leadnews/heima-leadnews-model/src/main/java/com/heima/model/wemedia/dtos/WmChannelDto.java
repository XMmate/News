package com.heima.model.wemedia.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WmChannelDto {
    public String name;
    public Integer page;
    public Integer size;
}
