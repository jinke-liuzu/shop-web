package com.jk.service;


import com.jk.pojo.ldl_commodity_manage;
import com.jk.pojo.ldl_goods_classify;

import java.util.HashMap;
import java.util.List;

public interface ldlService {
    HashMap<String, Object> queryclassify(Integer page, Integer rows);


    HashMap<String, Object> querycommodity(Integer page, Integer rows, ldl_commodity_manage commodity);

    void deleteBook(Integer[] ids);

    void deleteclassifylist(Integer id);

    List<ldl_goods_classify> findArea(Integer id);

    void saveclassify(ldl_goods_classify goods);
}
