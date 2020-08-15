package com.bear;

import com.bear.sql.MyBatis;
import com.icecreamqaq.yuq.mirai.YuQMiraiStart;

public class BearMain {
    public static void main(String[] args) {
        YuQMiraiStart.start(args);
        MyBatis.getMyBatis().getEssentialDao();
    }
}
