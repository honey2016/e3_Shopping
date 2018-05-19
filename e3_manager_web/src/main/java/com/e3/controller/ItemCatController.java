package com.e3.controller;

import com.e3.common.pojo.CatPojo;
import com.e3.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by SMD on 2018/5/14.
 */
@Controller
public class ItemCatController {

    @Autowired
    private ItemCatService itemCatService;

    @RequestMapping("/item/cat/list")
    @ResponseBody
    public List<CatPojo> getGroup(@RequestParam(name = "id",defaultValue = "0") long parentId){
        List<CatPojo> list = itemCatService.getAll(parentId);
        return list;
    }
}
