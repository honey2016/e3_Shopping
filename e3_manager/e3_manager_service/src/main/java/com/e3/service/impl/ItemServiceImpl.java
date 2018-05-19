package com.e3.service.impl;

import com.e3.common.pojo.PagesInfo;
import com.e3.mapper.TbItemMapper;
import com.e3.pojo.TbItem;
import com.e3.pojo.TbItemExample;
import com.e3.service.ItemService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by SMD on 2018/5/11.
 */
@Service
public class ItemServiceImpl implements ItemService {

    @Resource
    private TbItemMapper tbItemMapper;

    @Override
    public TbItem getAll(Long id) {
        TbItem item = tbItemMapper.selectByPrimaryKey(id);
        return item;
    }

    @Override
    public PagesInfo getPage(Integer page,Integer rows) {
        //分页信息
        PageHelper.startPage(page,rows);
        //数据总个数
        TbItemExample itemExample = new TbItemExample();
        TbItemExample.Criteria criteria = itemExample.createCriteria();
        List<TbItem> list = tbItemMapper.selectByExample(itemExample);
        System.out.println(list+"=============");
        //使用工具进行分页：info已经存在结果
        PageInfo<TbItem> info = new PageInfo<TbItem>(list);
        //将info信息扔进自定义包装类
        PagesInfo pagesInfo = new PagesInfo();
        pagesInfo.setRows(list);
        pagesInfo.setTotal((int) info.getTotal());
        return pagesInfo;
    }
}
