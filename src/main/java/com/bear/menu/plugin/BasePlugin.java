package com.bear.menu.plugin;

import com.bear.menu.api.Plugin;
import com.icecreamqaq.yuq.entity.Group;
import com.icecreamqaq.yuq.entity.Member;

/**
 * 基本插件的实现
 */
public class BasePlugin implements Plugin {

    public String rootcommands = null;
    /*验证指令的正则表达式*/
    String verify_commands = "";
    String name;
    @Override
    public void onEnable() {

    }

    @Override
    public void onDisable() {

    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getRootCommands() {
        return rootcommands;
    }

    public synchronized boolean executeCommand(Member member, Group group,String message){
        return false;
    }
}
