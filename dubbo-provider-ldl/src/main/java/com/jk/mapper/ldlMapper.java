package com.jk.mapper;

import com.jk.pojo.ldl_commodity_manage;
import com.jk.pojo.ldl_goods_classify;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.HashMap;
import java.util.List;

public interface ldlMapper {

    int findOrderCount(HashMap<String, Object> hashMap);

    List<ldl_goods_classify> findOrderList(@Param("page") int i, @Param("rows") Integer rows);


    int findUserTotal(@Param("commodity")ldl_commodity_manage commodity);

    List<ldl_commodity_manage> findUserPage(@Param("start")int start, @Param("rows")Integer rows, @Param("commodity")ldl_commodity_manage commodity);

    void deleteBook(Integer[] ids);

    @Delete("delete from ldl_goods_classify where id=#{value}")
    void deleteclassifylist(Integer id);

    @Select("select * from ldl_goods_classify where pid=#{value}")
    List<ldl_goods_classify> findArea(Integer id);

    @Insert("insert into ldl_goods_classify (name,generalstore,ownstores,pid)")
    void saveclassify(ldl_goods_classify goods);
}
