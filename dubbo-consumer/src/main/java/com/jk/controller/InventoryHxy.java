package com.jk.controller;




import com.alibaba.dubbo.config.annotation.Reference;
import com.jk.pojo.InventoryHxyBean;

import com.jk.pojo.LabelHxyBean;
import com.jk.service.InventoryHxyService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;


@Controller
@RequestMapping("inventory")
public class InventoryHxy {
    @Reference
    private InventoryHxyService inventoryHxyService;
    //库存查询HXY
    @RequestMapping("queryRepertory")
    @ResponseBody
    public HashMap<String,Object> findRepertory(InventoryHxyBean inventoryHxyBean){

        return inventoryHxyService.findRepertory(inventoryHxyBean);
    }

    @RequestMapping("toInventory")
    public String toInventory(){

        return "InventoryList";
    }


}
