package com.bear.sql.dao;

import com.bear.data.Item;
import com.bear.data.User;
import org.apache.ibatis.annotations.Param;

import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

/**
 * 必备数据库接口
 */
public interface EssentialDao {

    public void register(long account);

    public User getUser(long account);

    public Item getItemInfo(int itemid);

    public void registerItem(int itemid,String name,int type,String property,String description);
}
