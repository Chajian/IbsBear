package com.bear.menu;

import com.IceCreamQAQ.Yu.annotation.Event;
import com.IceCreamQAQ.Yu.annotation.EventListener;
import com.bear.menu.api.BasePlugin;
import com.bear.menu.api.Plugin;
import com.bear.util.BearThreadPool;
import com.icecreamqaq.yuq.entity.Group;
import com.icecreamqaq.yuq.entity.Member;
import com.icecreamqaq.yuq.event.GroupMessageEvent;
import com.icecreamqaq.yuq.message.Message;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

@EventListener
public class Menu {
    public static Menu menu = null;
    /*菜单加载的插件*/
    HashMap<String, BasePlugin> plugins = new HashMap<>();

    /*菜单加载的命令
    * <String,BasePlugin> String 根命令 BasePlugin 命令所绑定的插件
    * */
    HashMap<String,BasePlugin> commands = new HashMap<>();


    public Menu() {
        initPlugin();
        initCommands();
        menu = this;
    }

    /**
     * 初始化插件
     */
    public void initPlugin(){
        for(BasePlugin plugin:plugins.values()){
            System.out.println("加载插件:"+plugin.getName());
            plugin.onEnable();
//            BearThreadPool.getBearThreadPool().putRunnable(plugin);
        }
    }

    /**
     * 卸载
     */
    public void uninitPlugin(){
        for(BasePlugin plugin:plugins.values()){
            System.out.println("卸载插件:"+plugin.getName());
            plugin.onDisable();
        }
    }

    public void initCommands(){
        for(BasePlugin plugin:plugins.values()){
            System.out.println("加载插件命令:"+plugin.getName());
            if(commands.containsKey(plugin.getRootCommands()))
                commands.put(plugin.getRootCommands(),plugin);
            else
                System.out.println(plugin.getName()+"插件有冲突");
        }
    }

    @Event
    public void run(GroupMessageEvent event){
        String message = event.getMessage().sourceMessage.toString();

    }

    public static Menu getMenu() {
        if(menu == null)
            menu = new Menu();
        return menu;
    }
}
