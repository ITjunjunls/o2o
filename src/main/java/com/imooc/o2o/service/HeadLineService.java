package com.imooc.o2o.service;

import com.imooc.o2o.entity.HeadLine;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/**
 * @author itjunjun  2021/2/18 20:33
 */

public interface HeadLineService {

    /**
     * 根据指定条件查询头条列表
     * @param headLineCondition
     * @return
     * @throws IOException
     */
    List<HeadLine> getHeadLineList(HeadLine headLineCondition) throws IOException;
}
