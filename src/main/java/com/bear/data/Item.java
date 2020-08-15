package com.bear.data;

import java.util.List;

/**
 * 物品信息
 * @author xml
 */
public class Item {

    int itemid;
    String name;
    int type;
    String property;
    String des;

    public int getItemid() {
        return itemid;
    }

    public void setItemid(int itemid) {
        this.itemid = itemid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemid=" + itemid +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", property=" + property +
                ", des='" + des + '\'' +
                '}';
    }
}
