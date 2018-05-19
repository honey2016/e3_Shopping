package com.e3.service.impl;

import com.e3.common.pojo.CatPojo;
import com.e3.mapper.TbItemCatMapper;
import com.e3.pojo.TbItemCat;
import com.e3.pojo.TbItemCatExample;
import com.e3.pojo.TbItemExample;
import com.e3.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SMD on 2018/5/14.
 */
@Service
public class ItemCatServiceImpl implements ItemCatService {

    @Autowired
    private TbItemCatMapper itemCatMapper;

    @Override
    public List<CatPojo> getAll(long parentId) {
        TbItemCatExample itemExample = new TbItemCatExample();
        //创建查询条件,根据父类id进行查询
        TbItemCatExample.Criteria criteria = itemExample.createCriteria();
        TbItemCatExample.Criteria equalTo = criteria.andParentIdEqualTo(parentId);
        List<TbItemCat> list = itemCatMapper.selectByExample(itemExample);
        /* 将pojolist转换成包装类list */
        List<CatPojo> catList = new ArrayList<>();
        CatPojo catPojo = null;
        for (TbItemCat tt:list) {
            catPojo = new CatPojo();
            catPojo.setId(tt.getId());
            catPojo.setText(tt.getName());
            catPojo.setState(tt.getIsParent()==false?"open":"closed");
            catList.add(catPojo);
        }
        return catList;
    }
}
