package com.jk.service;


import com.alibaba.dubbo.config.annotation.Service;


import com.jk.mapper.InventoryHxyMapper;


import com.jk.pojo.InventoryHxyBean;
import com.jk.pojo.LabelHxyBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;


@Service(interfaceClass=InventoryHxyService.class)
@Component
public class InventoryHxyServiceImpl implements InventoryHxyService{
    @Autowired
    private InventoryHxyMapper inventoryHxyMapper;


    @Override
    public HashMap<String, Object> findRepertory(InventoryHxyBean inventoryHxyBean) {
        HashMap<String, Object> hashMap = new HashMap<>();
         int count= inventoryHxyMapper.countPage(inventoryHxyBean);
        int start = (inventoryHxyBean.getPage()-1)*inventoryHxyBean.getRows();

        List<InventoryHxyBean> list = inventoryHxyMapper.findInventoryPage(start,inventoryHxyBean.getRows(),inventoryHxyBean);

        hashMap.put("total", count);
        hashMap.put("rows", list);

        return hashMap;
    }


}
