package com.bear.menu;

import com.IceCreamQAQ.Yu.annotation.Event;
import com.IceCreamQAQ.Yu.annotation.EventListener;
import com.bear.menu.plugin.BasePlugin;
import com.bear.menu.plugin.Economy;
import com.bear.sql.sqlite.person.EssentialSqlLite;
import com.bear.util.Translate;
import com.icecreamqaq.yuq.entity.Group;
import com.icecreamqaq.yuq.entity.Member;
import com.icecreamqaq.yuq.event.GroupMessageEvent;

import java.util.HashMap;

@EventListener
public class Menu {
    /*菜单加载的插件*/
    HashMap<String, BasePlugin> plugins = new HashMap<>();

    /*菜单加载的命令
    * <String,BasePlugin> String 根命令 BasePlugin 命令所绑定的插件
    * */
    HashMap<String,BasePlugin> commands = new HashMap<>();

    HashMap<String,Long> enablegroups = new HashMap<>();

     {
        Economy economy = new Economy();
        plugins.put("积分", economy);
        enablegroups.put("插件",492960241L);
        EssentialSqlLite.getEssentialSqlLite();

         initPlugin();
         initCommands();
        System.out.println("群聊");
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
            if(!commands.containsKey(plugin.getRootCommands()))
                commands.put(plugin.getRootCommands(),plugin);
            else
                System.out.println(plugin.getName()+"插件有冲突");
        }
    }

    @Event
    public void run(GroupMessageEvent event){
        //step 1
        //通过消息匹配对应的插件，从而运行对应插件的execute()
        String message = Translate.getRealMessage(event.getMessage().sourceMessage.toString());
        Member member = event.getSender();
        Group group = event.getGroup();
        System.out.println("执行经济插件");
        if(enablegroups.values().contains(group.getId())) {
            for (String rootcommands : commands.keySet()) {
                System.out.println(rootcommands+":"+message);
                if (message.equals(rootcommands)) {
                    BasePlugin basePlugin = commands.get(rootcommands);
                    basePlugin.executeCommand(member, group, message);
                    System.out.println("执行经济插件");
                }
            }
        }
    }
}
