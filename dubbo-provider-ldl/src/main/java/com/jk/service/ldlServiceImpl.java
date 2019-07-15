package com.jk.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.jk.mapper.ldlMapper;
import com.jk.pojo.ldl_commodity_manage;
import com.jk.pojo.ldl_goods_classify;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

@Service(interfaceClass=ldlService.class)
@Component
public class ldlServiceImpl implements ldlService {

    @Autowired
    private ldlMapper ldlmapper;

    //管理分类
    @Override
    public HashMap<String, Object> queryclassify(Integer page, Integer rows) {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        int count = ldlmapper.findOrderCount(hashMap);
        List<ldl_goods_classify> list = ldlmapper.findOrderList((page-1)*rows,rows);
        hashMap.put("total", count);
        hashMap.put("rows", list);
        System.out.println(hashMap);
        return hashMap;
    }
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
        return ldlmapper.findArea(id);
    }

    @Override
    public void saveclassify(ldl_goods_classify goods) {
        ldlmapper.saveclassify(goods);
    }


}
