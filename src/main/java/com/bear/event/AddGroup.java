package com.bear.event;

import com.IceCreamQAQ.Yu.annotation.Event;
import com.IceCreamQAQ.Yu.annotation.EventListener;
import com.icecreamqaq.yuq.entity.Member;
import com.icecreamqaq.yuq.event.GroupMemberJoinEvent;

import java.util.ArrayList;
import java.util.List;

/**
 * 申请加入群聊
 */
@EventListener
public class AddGroup  {

    /*有效群列表*/
    List<Long> groups = new ArrayList<>();
    /*屏蔽关键字名称*/
    List<String> ban_names = new ArrayList<>();


    /**
     * 入群申请
     * @param joinEvent 入群事件
     */
    @Event
    public void addGroupMessage(GroupMemberJoinEvent joinEvent){
        if(groups.contains(joinEvent.getGroup().getId())){
            Member member = joinEvent.getMember();
            if(ban_names.contains(member.getName())){
                joinEvent.setCancel(true);
            }
        }
    }

}
