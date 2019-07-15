package com.jk.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jk.pojo.ldl_commodity_manage;
import com.jk.pojo.ldl_goods_classify;
import com.jk.service.ldlService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("ldl")
public class ldlController {

    @Reference
    private ldlService ldlService;
    //管理分类查询
    @RequestMapping("toclassifyList")
    public String toclassifyList(){
        return "classifyList-ldl";
    }


    @RequestMapping("queryclassify")
    @ResponseBody
    public HashMap<String,Object> queryclassify(Integer page, Integer rows){

        return  ldlService.queryclassify(page,rows);
    }
    //分类删除
    @RequestMapping("deleteclassifylist")
    @ResponseBody
    public boolean deleteclassifylist(Integer id){
        try {
            ldlService.deleteclassifylist(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    //商品管理
    @RequestMapping("tocommodity")
    public String tocommodity(){
        return "commodity-ldl";
    }

    @RequestMapping("querycommodity")
    @ResponseBody
    public HashMap<String, Object> querycommodity(Integer page, Integer rows, ldl_commodity_manage commodity){

        return ldlService.querycommodity(page,rows,commodity);
    }
    //批量删除商品
    //批量删除
    @RequestMapping("deleteBook")
    @ResponseBody
    public    Boolean   deleteBook(Integer[] ids){
        try {
            ldlService.deleteBook(ids);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    //去新增类型toaddclassifyList-ldl页面
    @RequestMapping("toaddclassifyList")
    public String toaddclassifyList(){
        return "toaddclassifyList-ldl";
    }
    //类型二级查询
    //地区
    @RequestMapping("findArea")
    @ResponseBody
    public List<ldl_goods_classify> findArea(Integer id){
        List<ldl_goods_classify> area = ldlService.findArea(id);
        System.err.println(area);
        return area;
    }
    //新增类型saveclassify
    @RequestMapping("saveclassify")
    @ResponseBody
    public boolean saveclassify(ldl_goods_classify goods){
       try {
           ldlService.saveclassify(goods);
           return true;
       }catch (Exception e){
           e.printStackTrace();
           return false;
       }
    }
    //去批量新增toPLaddclass
    @RequestMapping("toPLaddclass")
    public String toPLaddclass(){
        return "PLaddclassif-ldl";
    }
}
