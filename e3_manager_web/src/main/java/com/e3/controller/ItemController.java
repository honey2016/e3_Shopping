package com.e3.controller;

import com.e3.common.pojo.PagesInfo;
import com.e3.pojo.TbItem;
import com.e3.service.ItemService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by SMD on 2018/5/11.
 */
@Controller
public class ItemController {

    @Resource
    private ItemService itemService;

    /* 测试 */
    @RequestMapping("item/{itemId}")
    public String getItemById(@PathVariable Long itemId, Model model){
        TbItem item = itemService.getAll(itemId);
        model.addAttribute("item",item);
        return "index";
    }

    @RequestMapping("/")
    public String getIndex(){
        return "index";
    }

    /* path 获取  item/list*/
    @RequestMapping("/{path}")
    public String gotoview(@PathVariable String path){
        /* item/list.jsp */
        return path;
    }

    @RequestMapping("/item/list")
    @ResponseBody
    public PagesInfo showAll(@RequestParam(value = "pages",defaultValue = "1") Integer pages, Integer rows){
        PagesInfo page = itemService.getPage(pages, rows);
        return page;
    }
}
