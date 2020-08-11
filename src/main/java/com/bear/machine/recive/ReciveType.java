package com.bear.machine.recive;

/**
 * 接收信息类型
 */
public enum ReciveType {
    /*私人聊天*/
    PRIVATEMESSAGE("私人聊天"),
    /*群聊*/
    GROUPMESSAGE("群聊"),
    /*星级聊天*/
    STARMESSAGE("星级聊天"),


    JOINGROUP("入群申请"),
    ADDFRIEND("添加好友申请");


    /*类型名称*/
    String name;

    ReciveType(String name) {
        this.name = name;
    }
}
