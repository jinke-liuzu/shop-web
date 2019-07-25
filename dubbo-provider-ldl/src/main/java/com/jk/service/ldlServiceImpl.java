package com.jk.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.jk.mapper.ldlMapper;
import com.jk.pojo.*;
import com.jk.util.ExcelUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.*;

@Service(interfaceClass=ldlService.class)
@Component
public class ldlServiceImpl implements ldlService {

    @Autowired
    private ldlMapper ldlmapper;

////商品管理
    @Override
    public HashMap<String, Object> querycommodity(Integer page, Integer rows, ldl_commodity_manage commodity) {
        //查询总条数
        int total = ldlmapper.findUserTotal(commodity);
        //查询每页显示的list
        int start = (page-1)*rows;//开始位置
        List<ldl_commodity_manage> list = ldlmapper.findUserPage(start,rows,commodity);
        HashMap<String, Object> map = new HashMap<>();
        map.put("total", total);
        map.put("rows", list);
        return map;
    }
//批量删除商品
    @Override
    public void deleteBook(Integer[] ids) {
        ldlmapper.deleteBook(ids);
    }
    //分类删除
    @Override
    public void deleteclassifylist(Integer id) {
        ldlmapper.deleteclassifylist(id);
    }
//分类二级查询
    @Override
    public List<ldl_goods_classify> findArea(Integer id) {
        List<ldl_goods_classify> area = ldlmapper.findArea(id);
        return area;
    }

    @Override
    public void saveclassify(ldl_goods_classify goods) {
        ldlmapper.saveclassify(goods);
    }


    @Override
    public List<ldl_goods_classify> tree() {
        return ldlmapper.tree();
    }

    //品牌查询
    @Override
    public HashMap<String, Object> findBrand(BrandHxyBean brandHxyBean) {
        HashMap<String, Object> map = new HashMap<>();
        int count=ldlmapper.countBrand(brandHxyBean);
        int start=(brandHxyBean.getPage()-1)*brandHxyBean.getRows();
        List<BrandHxyBean>list=ldlmapper.findBrand(start,brandHxyBean.getRows(),brandHxyBean);

        map.put("total", count);
        map.put("rows", list);

        return map;
    }

    //----------------------------------------------------

    @Override
    public HashMap<String, Object> findLabel(LabelHxyBean labelHxyBean) {
        HashMap<String, Object> hashMap = new HashMap<>();
        int count= ldlmapper.countLabel(labelHxyBean);
        int start = (labelHxyBean.getPage()-1)*labelHxyBean.getRows();
        List<LabelHxyBean> list = ldlmapper.findLabel(start,labelHxyBean.getRows(),labelHxyBean);

        hashMap.put("total", count);
        hashMap.put("rows", list);

        return hashMap;
    }

    @Override
    public void saveLabel(LabelHxyBean labelHxyBean) {
        ldlmapper.saveLabel(labelHxyBean);
    }

    @Override
    public void deleteLabel(Integer[] ids) {
        ldlmapper.deleteLabel(ids);
    }

    @Override
    public LabelHxyBean findByIdInfo(Integer id) {

        return ldlmapper.findByIdInfo(id);
    }

    @Override
    public void updateLabel(LabelHxyBean labelHxyBean) {
        ldlmapper.updateLabel(labelHxyBean);
    }

    //导出
    @Override
    public void daochu(Integer[] ids) {
        List<ldl_commodity_manage>commodity= ldlmapper.daochu(ids);
        int count = ids.length;
        JSONArray ja = new JSONArray();
        for(int i=0;i<commodity.size();i++){
            JSONObject o=new JSONObject();
            o.put("id",commodity.get(i).getId());
            o.put("number",commodity.get(i).getNumber());
            o.put("name",commodity.get(i).getName());
            o.put("datetime",commodity.get(i).getDatetime());
            o.put("state",commodity.get(i).getState());
            o.put("goodsname",commodity.get(i).getGoodsname());
            o.put("money",commodity.get(i).getMoney());
            o.put("url",commodity.get(i).getUrl());
            o.put("current",commodity.get(i).getCurrent());
            o.put("quantity",commodity.get(i).getQuantity());
            ja.add(o);
        }
        Map<String,String> headMap = new LinkedHashMap<String,String>();
        headMap.put("id","id");
        headMap.put("number","编号");
        headMap.put("name","名称");
        headMap.put("datetime","创建时间");
        headMap.put("state","是否上架");
        headMap.put("goodsname","商品分类");
        headMap.put("money","价格");
        headMap.put("url","路径");
        headMap.put("current","库存");
        headMap.put("quantity","入库数量");

        String title = "测试";

        OutputStream outXlsx=null;
        try {
            /*String s = UUID.randomUUID().toString();*/
            outXlsx = new FileOutputStream("E://b.xls");
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(commodity);
        System.out.println("正在导出xlsx....");
        Date d2 = new Date();
        ExcelUtil excelutil = new ExcelUtil();
        excelutil.exportExcel(title,headMap,ja,null,0,outXlsx);
        System.out.println("共"+count+"条数据,执行"+(new Date().getTime()-d2.getTime())+"ms");
        try {
            outXlsx.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
//购物车修改
    @Override
    public void joinche(Integer id) {
                ldlmapper.undatebyid(id);
    }

    @Override
    public HashMap<String, Object> queryche(Integer page, Integer rows, ldl_commodity_manage commodity) {
        //查询总条数
        int total = ldlmapper.querychecount(commodity);
        //查询每页显示的list
        int start = (page-1)*rows;//开始位置
        List<ldl_commodity_manage> list = ldlmapper.queryche(start,rows,commodity);
        HashMap<String, Object> map = new HashMap<>();
        map.put("total", total);
        map.put("rows", list);
        return map;
    }
    //购物车修改到展示
    @Override
    public void updateOne(Integer id) {
        ldlmapper.updateOne(id);
    }
//-------------库存
    @Override
    public HashMap<String, Object> findRepertory(InventoryHxyBean inventoryHxyBean) {
            HashMap<String, Object> hashMap = new HashMap<>();
            int count= ldlmapper.countPage(inventoryHxyBean);
            int start = (inventoryHxyBean.getPage()-1)*inventoryHxyBean.getRows();

            List<InventoryHxyBean> list = ldlmapper.findInventoryPage(start,inventoryHxyBean.getRows(),inventoryHxyBean);

            hashMap.put("total", count);
            hashMap.put("rows", list);

            return hashMap;
        }
    }

