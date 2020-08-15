package com.bear.menu.plugin;

import com.bear.data.Item;
import com.bear.data.User;
import com.bear.sql.MyBatis;
import com.bear.sql.dao.EssentialDao;
import com.icecreamqaq.yuq.entity.Group;
import com.icecreamqaq.yuq.entity.Member;
import com.icecreamqaq.yuq.message.Message;

/**
 * 经济插件
 * @author xml
 */
public class Economy extends BasePlugin {

    @Override
    public void onEnable() {
        System.out.println("加载积分插件成功!");
    }

    @Override
    public void onDisable() {
        System.out.println("卸载积分插件成功!");
    }

    public Economy() {
        name = "经济";
        rootcommands = "积分";
    }

    @Override
    public boolean executeCommand(Member member, Group group, String message) {
        System.out.println("信息经济000");
        try {
            User user = MyBatis.getMyBatis().getEssentialDao().getUser(member.getId());

            if (user == null) {
                MyBatis.getMyBatis().getEssentialDao().register(member.getId());
            } else {

            }

            Item head = MyBatis.getMyBatis().getEssentialDao().getItemInfo(user.getHead());
            Item chest = MyBatis.getMyBatis().getEssentialDao().getItemInfo(user.getChest());
            Item pants = MyBatis.getMyBatis().getEssentialDao().getItemInfo(user.getPants());
            Item let = MyBatis.getMyBatis().getEssentialDao().getItemInfo(user.getLet());
            Item arms = MyBatis.getMyBatis().getEssentialDao().getItemInfo(user.getArms());

            String response = "----------"+member.getNameCard()+"积分信息---------\n" +
                    "金币:"+user.getMoney()+"\n" +
                    "头盔:"+head.getName()+"\n" +
                    "胸甲:"+chest.getName()+"\n" +
                    "裤子:"+pants.getName()+"\n" +
                    "靴子:"+let.getName()+"\n" +
                    "武器:"+arms.getName()+"\n";
            System.out.println("信息经济");
            Message message1 = new Message().plus(response);
            group.sendMessage(message1);
        }
        catch (Exception e){
            e.printStackTrace();
        }



        return super.executeCommand(member, group, message);
    }
}
