package com.bear.data;

/**
 * 存储玩家信息
 */
public class User {
    long account;
    double money;
    int head;
    int chest;
    int pants;
    int let;
    int arms;
    int backid;

    public User(long account, double money, int head, int chest, int pants, int let, int arms, int backid) {
        this.account = account;
        this.money = money;
        this.head = head;
        this.chest = chest;
        this.pants = pants;
        this.let = let;
        this.arms = arms;
        this.backid = backid;
    }

    public long getAccount() {
        return account;
    }

    public void setAccount(long account) {
        this.account = account;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public int getHead() {
        return head;
    }

    public void setHead(int head) {
        this.head = head;
    }

    public int getChest() {
        return chest;
    }

    public void setChest(int chest) {
        this.chest = chest;
    }

    public int getPants() {
        return pants;
    }

    public void setPants(int pants) {
        this.pants = pants;
    }

    public int getLet() {
        return let;
    }

    public void setLet(int let) {
        this.let = let;
    }

    public int getArms() {
        return arms;
    }

    public void setArms(int arms) {
        this.arms = arms;
    }

    public int getBackid() {
        return backid;
    }

    public void setBackid(int backid) {
        this.backid = backid;
    }

    @Override
    public String toString() {
        return "User{" +
                "account=" + account +
                ", money=" + money +
                ", head=" + head +
                ", chest=" + chest +
                ", pants=" + pants +
                ", let=" + let +
                ", arms=" + arms +
                ", backid=" + backid +
                '}';
    }
}
