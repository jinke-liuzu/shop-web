package com.jk.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jk.pojo.LabelHxyBean;

import com.jk.service.LabelHxyService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@Controller
@RequestMapping("label")
public class LabelHxy {
    @Reference
    private LabelHxyService iabelHxyService;
    //标签HXY
    @RequestMapping("queryLabel")
    @ResponseBody
    public HashMap<String,Object> queryLabel(LabelHxyBean labelHxyBean){

        return iabelHxyService.findLabel(labelHxyBean);
    }
    //标签 列表跳转页面
    @RequestMapping("toLabel")
    public String toLabel(){

        return "LabelList";
    }

    //标签 新增跳转页面
    @RequestMapping("toAddLabel")
    public String toAddLabel(){

        return "toAddLabel";
    }
    //标签新增
    @RequestMapping("saveLabel")
    @ResponseBody
    public Boolean saveLabel(LabelHxyBean labelHxyBean){

        try {
              if(labelHxyBean.getId()!=null){

                  iabelHxyService.updateLabel(labelHxyBean);
              }else{

                  iabelHxyService.saveLabel(labelHxyBean);
              }


            System.out.println("labelHxyBean = [" + labelHxyBean + "]");
              return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }



    }
      //标签批删
      @RequestMapping("deleteLabel")
      @ResponseBody
      public Boolean deleteLabel(Integer[]ids){

          try {
              iabelHxyService.deleteLabel(ids);
              return true;
          } catch (Exception e) {
              e.printStackTrace();
              return false;
          }

      }
      //修改跳转页面

    @RequestMapping("toupdateLabel")
    public String toupdateLabel(){

        return "toupLabel";
    }
    //标签单条查询
    @RequestMapping("findInfo")
    @ResponseBody
    public LabelHxyBean findInfo(Integer id){
        return iabelHxyService.findByIdInfo(id);



    }



}
