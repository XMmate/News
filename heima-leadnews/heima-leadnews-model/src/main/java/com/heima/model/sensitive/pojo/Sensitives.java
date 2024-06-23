package com.heima.model.sensitive.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("wm_sensitive")
public class Sensitives {
    public int id;
    public String sensitives;
    public Date created_time;
}
