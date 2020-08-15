package com.bear.data;

/**
 * 装备属性
 */
public enum  ItemType {
    HEAD(1,"头盔"),
    CHEST(2,"胸甲"),
    PANTS(3,"裤子"),
    LET(4,"靴子"),
    ARMS(5,"武器");

    int Type;
    String name;

    ItemType(int type, String name) {
        Type = type;
        this.name = name;
    }

    public int getType() {
        return Type;
    }

    public void setType(int type) {
        Type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
