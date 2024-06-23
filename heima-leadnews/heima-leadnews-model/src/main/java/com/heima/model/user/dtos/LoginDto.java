package com.heima.model.user.dtos;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.Data;

@Data
public class LoginDto {
    @ApiModelProperty(value = "手机号",required = true)
    public String phone;
    @ApiModelProperty(value = "密码",required = true)
    public String password;
}
