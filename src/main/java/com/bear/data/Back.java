package com.bear.data;

/**
 * 背包
 */
public class Back {

    int backid;
    String backname;
    int size;
    long account;


    public Back(int backid, String backname, int size, long account) {
        this.backid = backid;
        this.backname = backname;
        this.size = size;
        this.account = account;
    }

    public int getBackid() {
        return backid;
    }

    public void setBackid(int backid) {
        this.backid = backid;
    }

    public String getBackname() {
        return backname;
    }

    public void setBackname(String backname) {
        this.backname = backname;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public long getAccount() {
        return account;
    }

    public void setAccount(long account) {
        this.account = account;
    }
}
