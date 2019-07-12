package com.jk.service;

import com.jk.pojo.LabelHxyBean;

import java.util.HashMap;

public interface LabelHxyService {
    HashMap<String, Object> findLabel(LabelHxyBean labelHxyBean);

    void saveLabel(LabelHxyBean labelHxyBean);

    void deleteLabel(Integer[] ids);

    LabelHxyBean findByIdInfo(Integer id);

    void updateLabel(LabelHxyBean labelHxyBean);


}
