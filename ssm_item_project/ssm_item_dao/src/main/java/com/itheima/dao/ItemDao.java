package com.itheima.dao;

import cn.itcast.ssm.domain.Items;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface ItemDao {
    @Select("select * from items")
    List<Items> findAll();

    @Update("update `items`set name = #{name},,price= #{price},pic= #{pic},createtime= #{createtime},detail= #{detail},where id =#{id}")
    void editItems(@Param("items") Items items, @Param("id") String id);

    @Select("select * from items where id =#{id}")
    Items findById(String id);
}
