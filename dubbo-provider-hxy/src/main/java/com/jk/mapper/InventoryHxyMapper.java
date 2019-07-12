package com.jk.mapper;

import com.jk.pojo.InventoryHxyBean;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface InventoryHxyMapper {
    int countPage(@Param("inventoryHxyBean")InventoryHxyBean inventoryHxyBean);

    List<InventoryHxyBean> findInventoryPage(@Param("start")int start, @Param("rows")Integer rows, @Param("inventoryHxyBean")InventoryHxyBean inventoryHxyBean);


}
