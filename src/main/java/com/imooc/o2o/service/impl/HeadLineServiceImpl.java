package com.imooc.o2o.service.impl;

import com.imooc.o2o.dao.HeadLineDao;
import com.imooc.o2o.entity.HeadLine;
import com.imooc.o2o.service.HeadLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/**
 * @author itjunjun  2021/2/18 20:35
 */
@Service
public class HeadLineServiceImpl implements HeadLineService {

    @Autowired
    private HeadLineDao headLineDao;

    @Override
    public List<HeadLine> getHeadLineList(HeadLine headLineCondition) throws IOException {
        return headLineDao.queryHeadLine(headLineCondition);
    }
}
