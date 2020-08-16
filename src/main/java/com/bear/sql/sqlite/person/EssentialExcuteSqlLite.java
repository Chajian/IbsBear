package com.bear.sql.sqlite.person;

import com.bear.data.Back;
import com.bear.data.BackItem;
import com.bear.data.Item;
import com.bear.data.User;
import com.bear.sql.sqlite.ExcuteSqlLite;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *  处理sqlite的用户对象拓展功能
 */
public class EssentialExcuteSqlLite extends ExcuteSqlLite {

    public EssentialExcuteSqlLite(Connection connection, String table) {
        super(connection, table);
    }

    //通过账号获取对象
    public synchronized User getUser(Long account) throws SQLException {
        UserTable("ibs_user");
        User user = null;
        String[] marks = new String[]{"account"};//获取用户的数据
        if(account!=null){
            ResultSet resultSet = find(marks,new Long[]{account});
            if(resultSet.first()) {
                user = new User(resultSet.getLong("account"), resultSet.getDouble("money"), resultSet.getInt("head")
                        , resultSet.getInt("chest"), resultSet.getInt("pants"), resultSet.getInt("let"),
                        resultSet.getInt("arms"), resultSet.getInt("backid"));
            }
        }
        return user;
    }

    public synchronized Item getItem(int itemid) throws SQLException{
        UserTable("ibs_items");
        Item item = null;
        String[] marks = new String[]{"itemid"};
        ResultSet resultSet = find(marks,new Integer[]{itemid});
        if(resultSet.first()){
            item = new Item(resultSet.getInt("itemid"),resultSet.getString("name"),resultSet.getInt("type"),
                    resultSet.getString("property"),resultSet.getString("description"));
        }
        return item;
    }

    public synchronized Back getBack(int backid) throws SQLException {
        UserTable("ibs_back");
        Back back = null;
        String[] marks = new String[]{"backid"};
        ResultSet resultSet = find(marks, new Integer[]{backid});
        if (resultSet.first()) {
            back = new Back(resultSet.getInt("backid"), resultSet.getString("backname"), resultSet.getInt("size"), resultSet.getLong("account"));
        }
        return back;
    }

//    public synchronized BackItem getBackItem(int position)throws SQLException{
//
//    }

    //检查用户
    public synchronized boolean checkUser(Long account) throws SQLException {
        UserTable("ibs_user");
        ResultSet resultSet = null;
        if(account!=null)
            resultSet = find(new String[]{"account"},new Long[]{account});
        return resultSet.first();
    }

    public synchronized boolean checkItem(int itemid) throws SQLException {
        UserTable("ibs_items");
        ResultSet resultSet = null;
        resultSet = find(new String[]{"itemid"},new Integer[]{itemid});
        return resultSet.first();
    }

    public synchronized boolean checkBack(int backid) throws SQLException{
        UserTable("ibs_back");
        ResultSet resultSet = null;
        resultSet = find(new String[]{"backid"},new Integer[]{backid});
        return resultSet.first();
    }

    public synchronized boolean checkBackItem(int position)throws SQLException{
        UserTable("ibs_backitem");
        ResultSet resultSet = null;
        resultSet = find(new String[]{"position"},new Integer[]{position});
        return resultSet.first();
    }

    /**
     *  判断账号是否注册
     * @param account 账号
     * @return 存在返回true，否则返回false
     */
    public synchronized boolean isBeing(Long account)throws SQLException{
        UserTable("ibs_user");
        if(account!=null){
            ResultSet resultSet = find(new String[]{"account"},new Long[]{account});
            return resultSet.first();
        }
        return false;
    }

    //注册用户
    public synchronized boolean registerUser(User user)throws SQLException{
        UserTable("ibs_user");
        if(user!=null && !isBeing(user.getAccount())){

            Long account = user.getAccount();
            double money = user.getMoney();
            int head = user.getHead();
            int chest = user.getChest();
            int pants = user.getPants();
            int let = user.getLet();
            int arms = user.getArms();
            int backid = user.getBackid();

            String[] marks = new String[]{"account","money","head","chest","pants","let","arms","backid"};
            return add(marks,new Object[]{account,money,head,chest,pants,let,arms,backid});
        }
        return false;
    }

    public synchronized boolean registerItem(Item item)throws SQLException{
        UserTable("ibs_items");
        if(item!=null && !checkItem(item.getItemid())){
            int itemid = item.getItemid();
            String name = item.getName();
            int type = item.getType();
            String property = item.getProperty();
            String descriptoin = item.getDes();

            String[] marks = new String[]{"itemid","name","type","property","description"};
            return add(marks,new Object[]{itemid,name,type,property,descriptoin});
        }
        return false;
    }

    public synchronized boolean registerBack(Back back)throws SQLException{
        UserTable("ibs_back");
        if(back!=null && !checkBack(back.getBackid())){
            int backid = back.getBackid();
            String backname = back.getBackname();
            int size = back.getSize();
            long account = back.getAccount();

            String[] marks = new String[]{"backid","backname","size","account"};
            return add(marks,new Object[]{backid,backname,size,account});
        }
        return false;
    }

    public synchronized boolean registerBackItem(BackItem backItem)throws SQLException{
        UserTable("ibs_backitem");
        if(backItem!=null && !checkBackItem(backItem.getPosition())){
            int itemid = backItem.getItemid();
            int backid = backItem.getBackid();
            int position = backItem.getPosition();
            int size = backItem.getSize();

            String[] marks = new String[]{"itemid","backid","position","size"};
            return add(marks,new Object[]{itemid,backid,position,size});
        }
        return false;
    }


    //通过账号删除用户
    public synchronized boolean deleteUser(Long account)throws SQLException{
        UserTable("ibs_user");
        if(isBeing(account)){
            return delete(new String[]{"account"},new Long[]{account});
        }
        return false;
    }

    //从数据库中判断用户是否在线
//    public synchronized boolean isOnline(String account)throws SQLException{
//        User user = getUser(account);
//        return user.CheckOnline();
//    }

//    //设置用户在线状态
//    public synchronized void setOnline(String account,int online)throws SQLException{
//        change(new String[]{"online"},new Object[online],"WHERE account = "+account);
//    }

//    /*将对方互相添加为好友
//     *
//     * @param requester 发送请求者
//     * @param agreer 接受者
//     * @return
//     * @throws SQLException
//     */
//    public synchronized boolean addFriend(String requester,String agreer)throws SQLException{
//        ResultSet resultSet_requester = find(new String[]{"account"},new String[]{requester});
//        ResultSet resultset_agreer = find(new String[]{"account"},new String[]{agreer});
//        if(resultSet_requester.first()&& resultset_agreer.first()){
//            String requester_friends = resultSet_requester.getString("friends");
//            String agreer_friends = resultset_agreer.getString("friends");
//            if(!requester_friends.contains(agreer)&&!agreer_friends.contains(requester)){
//                //如果同意者不是请求者的好友,将彼此添加到对方的好友列表
//                requester_friends += ","+agreer;
//                agreer_friends += ","+requester;
//                change(new String[]{"friends"},new String[]{requester_friends},"WHERE account = "+requester);
//                change(new String[]{"friends"},new String[]{agreer_friends},"WHERE account = "+agreer);
//                return true;
//            }
//        }
//        return false;
//    }

//    /**
//     *
//     * @param requester 用户id1
//     * @param agreer 用户id2
//     * @return
//     * @throws SQLException
//     */
//    public synchronized boolean isFriend(String requester,String agreer)throws SQLException{
//        UserTable(friends_table);
////        ResultSet resultSet = find()
//        return false;
//    }
}
