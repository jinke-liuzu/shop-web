package com.jk.service;

import com.alibaba.dubbo.config.annotation.Service;

import com.jk.mapper.LabelHxyMapper;
import com.jk.pojo.LabelHxyBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
@Service(interfaceClass=LabelHxyService.class)
@Component
public class LabelHxyServiceImpl  implements LabelHxyService{
    @Autowired
    private LabelHxyMapper labelHxyMapper;
    @Override
    public HashMap<String, Object> findLabel(LabelHxyBean labelHxyBean) {
        HashMap<String, Object> hashMap = new HashMap<>();
        int count= labelHxyMapper.countLabel(labelHxyBean);
        int start = (labelHxyBean.getPage()-1)*labelHxyBean.getRows();
        List<LabelHxyBean> list = labelHxyMapper.findLabel(start,labelHxyBean.getRows(),labelHxyBean);

        hashMap.put("total", count);
        hashMap.put("rows", list);

        return hashMap;
    }

    @Override
    public void saveLabel(LabelHxyBean labelHxyBean) {
        labelHxyMapper.saveLabel(labelHxyBean);
    }

    @Override
    public void deleteLabel(Integer[] ids) {
        labelHxyMapper.deleteLabel(ids);
    }

    @Override
    public LabelHxyBean findByIdInfo(Integer id) {

        return labelHxyMapper.findByIdInfo(id);
    }

    @Override
    public void updateLabel(LabelHxyBean labelHxyBean) {
        labelHxyMapper.updateLabel(labelHxyBean);
    }

}
