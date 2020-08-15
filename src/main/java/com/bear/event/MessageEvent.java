package com.bear.event;

import com.IceCreamQAQ.Yu.annotation.Event;
import com.IceCreamQAQ.Yu.annotation.EventListener;
import com.bear.util.Translate;
import com.icecreamqaq.yuq.entity.Contact;
import com.icecreamqaq.yuq.event.PrivateMessageEvent;
import com.icecreamqaq.yuq.message.Message;

import java.util.ArrayList;
import java.util.List;

@EventListener
public class MessageEvent {

    /*识别聊天内容正则信息*/
    String verify_message = "";

    List<String> plugin_Message = new ArrayList<>();

    {
        plugin_Message.add("接单");
        plugin_Message.add("插件");
        plugin_Message.add("开发");
        plugin_Message.add("做吗？");
        System.out.println("sdfsd私聊");
    }

    /*处理接单*/
    @Event
    public void handleBus(PrivateMessageEvent event){
        Message message = event.getMessage();
        Contact contact = event.getSender();
        System.out.println("有人尝试私聊  "+"avatar:"+event.getSender().getAvatar()+"id:"+event.getSender().getId()+"   "+message.sourceMessage.toString());
        for(String target:plugin_Message) {
            if (Translate.hasString(message.sourceMessage.toString(),target)) {
                System.out.println("有人触发时间");
                contact.sendMessage(new Message().plus("派代机器人" +
                        "\n格式如下:" +
                        "\n派单:" +
                        "\n预算:xxx" +
                        "\n描述:xxx" +
                        "\n交货时间: xxx-xxx-xxx"));
            }
        }
    }

}
