package com.jk.service;


import com.jk.pojo.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public interface ldlService {


    HashMap<String, Object> querycommodity(Integer page, Integer rows, ldl_commodity_manage commodity);

    void deleteBook(Integer[] ids);

    void deleteclassifylist(Integer id);

    List<ldl_goods_classify> findArea(Integer id);

    void saveclassify(ldl_goods_classify goods);


    List<ldl_goods_classify> tree();

    HashMap<String, Object> findBrand(BrandHxyBean brandHxyBean);

    //----------------------------------------------------------
    HashMap<String, Object> findLabel(LabelHxyBean labelHxyBean);

    void saveLabel(LabelHxyBean labelHxyBean);

    void deleteLabel(Integer[] ids);

    LabelHxyBean findByIdInfo(Integer id);

    void updateLabel(LabelHxyBean labelHxyBean);
//----------导出导入
    void daochu(Integer[] ids);

    void joinche(Integer id);

    HashMap<String, Object> queryche(Integer page, Integer rows, ldl_commodity_manage commodity);

    void updateOne(Integer id);

    HashMap<String, Object> findRepertory(InventoryHxyBean inventoryHxyBean);
}
