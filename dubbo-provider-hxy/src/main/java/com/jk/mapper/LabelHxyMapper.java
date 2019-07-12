package com.jk.mapper;

import com.jk.pojo.LabelHxyBean;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface LabelHxyMapper {
    int countLabel(@Param("labelHxyBean") LabelHxyBean labelHxyBean);

    List<LabelHxyBean> findLabel(@Param("start")int start, @Param("rows")Integer rows, @Param("labelHxyBean")LabelHxyBean labelHxyBean);
    @Insert("insert into t_label(name,sort,img,createTime,remark)values(#{name},#{sort},#{img},SYSDATE(),#{remark})")
    void saveLabel(LabelHxyBean labelHxyBean);

    void deleteLabel(Integer[] ids);
     @Select("select * from t_label where id=#{value}")
    LabelHxyBean findByIdInfo(Integer id);

     @Update("update t_label set name=#{name},sort=#{sort},img=#{img} where id=#{id}")
    void updateLabel(LabelHxyBean labelHxyBean);

}
