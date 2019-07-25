package com.jk.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jk.pojo.*;
import com.jk.service.ldlService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import com.jk.utils.OSSClientUtil;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("ldl")
public class ldlController {

    @Reference
    private ldlService ldlService;

    //main
    @RequestMapping("main")
    public String mian(){
        return "main";
    }


    //管理分类查询
    @RequestMapping("toclassifyList")
    public String toclassifyList(){
        return "classifyList-ldl";
    }

    //商品分类删除
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
    //商品分类去新增类型toaddclassifyList-ldl页面
    @RequestMapping("toaddclassifyList")
    public String toaddclassifyList(){
        return "toaddclassifyList-ldl";
    }
    //商品分类地区
    @RequestMapping("findArea")
    @ResponseBody
    public List<ldl_goods_classify> findArea(Integer id){
        List<ldl_goods_classify> area = ldlService.findArea(id);
        return area;
    }
    //商品分类新增类型saveclassify
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
    //商品分类去批量新增toPLaddclass
    @RequestMapping("toPLaddclass")
    public String toPLaddclass(){
        return "PLaddclassif-ldl";
    }


    //商品分类tree
    @RequestMapping("tree")
    @ResponseBody
    public  List<ldl_goods_classify> tree(){
        return ldlService.tree();

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

    //品牌跳转
    @RequestMapping("findBrand")
    public String findBrand(){

        return "BrandList";
    }
    //品牌查询
    @RequestMapping("queryBrand")
    @ResponseBody
    public HashMap<String,Object> findBrand(BrandHxyBean brandHxyBean){

        return ldlService.findBrand(brandHxyBean);
    }
//----------------------------------------------------------------------------------------------------

    //标签 列表跳转页面
    @RequestMapping("toLabel")
    public String toLabel(){

        return "brand-label-ldl";
    }
    //标签
    @RequestMapping("queryLabel")
    @ResponseBody
    public HashMap<String,Object> queryLabel(LabelHxyBean labelHxyBean){
        System.out.println(labelHxyBean);
        return ldlService.findLabel(labelHxyBean);
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

                ldlService.updateLabel(labelHxyBean);
            }else{

                ldlService.saveLabel(labelHxyBean);
            }
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
            ldlService.deleteLabel(ids);
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
    //标签回显单条查询
    @RequestMapping("findInfo")
    @ResponseBody
    public LabelHxyBean findInfo(Integer id){
        LabelHxyBean byIdInfo = ldlService.findByIdInfo(id);
        System.out.println("回显"+byIdInfo);
        return byIdInfo;
    }

    //图片上传
    /**
     * OSS阿里云上传图片 updaloadImg
     */
    @RequestMapping("updaloadImg")
    @ResponseBody
    public String uploadImg(MultipartFile imgg)throws IOException {
        if (imgg == null || imgg.getSize() <= 0) {
            throw new IOException("file不能为空");
        }
        OSSClientUtil ossClient=new OSSClientUtil();
        String name = ossClient.uploadImg2Oss(imgg);
        String imgUrl = ossClient.getImgUrl(name);
        String[] split = imgUrl.split("\\?");
        System.out.println("图片"+split[0]);
        return split[0];
    }

    //导出
    @RequestMapping("daochu")
    @ResponseBody
    public Boolean daochu(Integer[]ids){

        try {
            ldlService.daochu(ids);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    //去导入页面
    @RequestMapping("toAddExcel")
    public String toAddExcel(){

        return "toAddcommodityExcel-ldl";
    }
    //导入
    @RequestMapping("addCommodity")
    @ResponseBody
    public Boolean addCommodity(HttpServletRequest request) throws Exception {
        MultipartHttpServletRequest multipart= (MultipartHttpServletRequest) request;
        MultipartFile file = multipart.getFile("upfile");
        if(file.isEmpty()){
            throw new Exception("文件不存在");
        }
        InputStream in = file.getInputStream();
        List<List<Object>> bankListByExcel2 = new ImportExcelUtil().getBankListByExcel2(in, file.getOriginalFilename());
        System.out.println(bankListByExcel2);
        List<ldl_commodity> commodityLists = new ArrayList<>();
        for (int i=0;i<bankListByExcel2.size();i++){
            System.out.println("长度为"+bankListByExcel2.size());
            List<Object> objects = bankListByExcel2.get(i);
            System.out.println(objects.get(1)+"=======");
            System.out.println( objects.get(2)+" ----00000000");
            ldl_commodity commoditys = new ldl_commodity();

            commoditys.setNumber(Integer.valueOf(objects.get(1).toString()));
            commoditys.setName((String)objects.get(2));
            commoditys.setDatetime((String)objects.get(3));
            commoditys.setState(Integer.valueOf(objects.get(4).toString()));
            commoditys.setGoodsname((String)objects.get(5));
            commoditys.setMoney(Integer.valueOf(objects.get(6).toString()));
            commoditys.setUrl((String)objects.get(7));
            commoditys.setCurrent(Integer.valueOf(objects.get(8).toString()));
            commoditys.setQuantity(Integer.valueOf(objects.get(9).toString()));
            //如果数据类 型为Integer 类型必须这样写
            commodityLists.add(commoditys);

        }

        try {
            System.out.println(commodityLists);
            /*ldlService.saveCommodity(commodityLists);*/
            in.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    //去购物车
    @RequestMapping("toche")
    public String toche(){

        return "toche-ldl";
    }
    //购物车具体实现
    @RequestMapping("joinche")
    @ResponseBody
    public boolean joinche(Integer id){
        try {
            ldlService.joinche(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    //查询购物车
    @RequestMapping("queryche")
    @ResponseBody
    public HashMap<String, Object> queryche(Integer page, Integer rows, ldl_commodity_manage commodity){

        return ldlService.queryche(page,rows,commodity);
    }
    //删除购物车updateOne
    @RequestMapping("updateOne")
    @ResponseBody
    public boolean updateOne(Integer id){
        try {
            ldlService.updateOne(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    @RequestMapping("toerweima")
    public String toerweima(){
        return "toerweima-ldl";
    }
    //-------------------------------
    //库存查询HXY
    @RequestMapping("queryRepertory")
    @ResponseBody
    public HashMap<String,Object> findRepertory(InventoryHxyBean inventoryHxyBean){

        return ldlService.findRepertory(inventoryHxyBean);
    }

    @RequestMapping("toInventory")
    public String toInventory(){

        return "InventoryList";
    }



}
