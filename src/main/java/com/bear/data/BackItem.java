package com.bear.data;


/**
 * 背包物品
 */
public class BackItem {

    int itemid;
    int backid;
    int position;
    int size;

    public BackItem(int itemid, int backid, int position, int size) {
        this.itemid = itemid;
        this.backid = backid;
        this.position = position;
        this.size = size;
    }

    public int getItemid() {
        return itemid;
    }

    public void setItemid(int itemid) {
        this.itemid = itemid;
    }

    public int getBackid() {
        return backid;
    }

    public void setBackid(int backid) {
        this.backid = backid;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
