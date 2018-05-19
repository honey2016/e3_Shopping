package com.e3.service;

import com.e3.common.pojo.PagesInfo;
import com.e3.pojo.TbItem;
import java.util.List;

/**
 * Created by SMD on 2018/5/11.
 */
public interface ItemService {

    TbItem getAll(Long id);

    PagesInfo getPage(Integer page,Integer rows);
}
