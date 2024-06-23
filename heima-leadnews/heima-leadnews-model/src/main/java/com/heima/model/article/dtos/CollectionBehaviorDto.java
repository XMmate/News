package com.heima.model.article.dtos;

import lombok.Data;
import sun.dc.pr.PRError;

import java.util.Date;

@Data
public class CollectionBehaviorDto {
    private Long entryId;
    private short operation;
    private Date publishedTime;
    private short type;
}
