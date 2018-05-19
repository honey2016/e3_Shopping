package com.e3.service;

import com.e3.common.pojo.CatPojo;

import java.util.List;

/**
 * Created by SMD on 2018/5/14.
 */
public interface ItemCatService {

    /* 根据父类节点id查询当前所属父类下的所有 */
    List<CatPojo> getAll(long parentId);

}
