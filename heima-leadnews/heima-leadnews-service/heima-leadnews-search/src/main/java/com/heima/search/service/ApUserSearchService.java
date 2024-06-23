package com.heima.search.service;

import com.heima.model.common.dtos.ResponseResult;
import com.heima.model.search.dtos.HistorySearchDto;
import org.springframework.stereotype.Service;

@Service
public interface ApUserSearchService {

    /**
     查询搜索历史
     @return
     */
    ResponseResult findUserSearch();


    /**
     删除搜索历史
     @param historySearchDto
     @return
     */
    ResponseResult delUserSearch(HistorySearchDto historySearchDto);
}
