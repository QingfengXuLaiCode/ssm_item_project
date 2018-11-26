package com.itheima.service;

import cn.itcast.ssm.domain.Items;

import java.util.List;

public interface ItemService {


    List<Items> findAll();

    void editItems( Items items,String id);
    Items findById(String id);
}
