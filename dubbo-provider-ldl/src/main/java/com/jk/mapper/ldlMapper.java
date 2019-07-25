package com.jk.mapper;

import com.jk.pojo.*;
import org.apache.ibatis.annotations.*;

import java.util.HashMap;
import java.util.List;

public interface ldlMapper {



    int findUserTotal(@Param("commodity")ldl_commodity_manage commodity);

    List<ldl_commodity_manage> findUserPage(@Param("start")int start, @Param("rows")Integer rows, @Param("commodity")ldl_commodity_manage commodity);

    void deleteBook(Integer[] ids);

    @Delete("delete from ldl_goods_classify where id=#{value}")
    void deleteclassifylist(Integer id);

    @Select("select id,text from ldl_goods_classify where pid=#{value}")
    List<ldl_goods_classify> findArea(Integer id);

    @Insert("insert into ldl_goods_classify (name,generalstore,ownstores,pid)")
    void saveclassify(ldl_goods_classify goods);


    @Select("select  * from ldl_goods_classify order by id")
    List<ldl_goods_classify> tree();


    int countBrand(@Param("brandHxyBean")BrandHxyBean brandHxyBean);

    List<BrandHxyBean> findBrand(@Param("start")int start, @Param("rows") Integer rows, @Param("brandHxyBean") BrandHxyBean brandHxyBean);

    //---------------------------------------------------------------------

    int countLabel(@Param("labelHxyBean") LabelHxyBean labelHxyBean);

    List<LabelHxyBean> findLabel(@Param("start")int start, @Param("rows")Integer rows, @Param("labelHxyBean")LabelHxyBean labelHxyBean);

    @Insert("insert into t_label(name,sort,img,createTime,remark)values(#{name},#{sort},#{img},SYSDATE(),#{remark})")
    void saveLabel(LabelHxyBean labelHxyBean);

    void deleteLabel(Integer[] ids);
    @Select("select * from t_label where id=#{value}")
    LabelHxyBean findByIdInfo(Integer id);

    @Update("update t_label set name=#{name},sort=#{sort},img=#{img} where id=#{id}")
    void updateLabel(LabelHxyBean labelHxyBean);

    List<ldl_commodity_manage> daochu(Integer[] ids);

    @Update("update ldl_commodity_manage set chezt=1 where id=#{value}")
    void undatebyid(Integer id);

    int querychecount(@Param("commodity")ldl_commodity_manage commodity);

    List<ldl_commodity_manage> queryche(@Param("start")int start, @Param("rows")Integer rows, @Param("commodity")ldl_commodity_manage commodity);

    @Update("update ldl_commodity_manage set chezt=0 where id=#{value}")
    void updateOne(Integer id);
//-----库存
    int countPage(@Param("inventoryHxyBean")InventoryHxyBean inventoryHxyBean);

    List<InventoryHxyBean> findInventoryPage(@Param("start")int start, @Param("rows")Integer rows, @Param("inventoryHxyBean")InventoryHxyBean inventoryHxyBean);
}
