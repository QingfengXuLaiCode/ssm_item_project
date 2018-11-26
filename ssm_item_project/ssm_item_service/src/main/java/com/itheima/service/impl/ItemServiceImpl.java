package com.itheima.service.impl;

import cn.itcast.ssm.domain.Items;
import com.itheima.dao.ItemDao;
import com.itheima.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author k zhang
 * @date 2018/11/21
 **/
@Service
@Transactional
public class ItemServiceImpl implements ItemService {
    @Autowired
   private ItemDao itemDao;
    @Override
    public List<Items> findAll() {
        return itemDao.findAll();
    }

    @Override
    public void editItems(Items items, String id) {
        System.out.println(items);
        itemDao.editItems(items, id);
    }

    @Override
    public Items findById(String id) {
        return itemDao.findById(id);
    }

}
