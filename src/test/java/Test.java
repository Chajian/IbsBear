import com.bear.data.Item;
import com.bear.sql.dao.EssentialDao;
import com.bear.sql.sqlite.person.EssentialSqlLite;

import java.sql.SQLException;

public class Test {
    public static void main(String[] args) {
//        System.out.println(myBatis.getEssentialDao().getUser(936796603L).toString());
//        Pattern pattern = Pattern.compile(StringRule.TRANSLATEMESSAGETWO.getRule());
//        Matcher matcher = pattern.matcher("[ \"fs\" ]");
//        if(matcher.find())
//        System.out.println(matcher.group().replace("\"",""));
        try {
            Item item = new Item(00000000,"空气",0,"","啥也没有");
            item = EssentialSqlLite.getEssentialSqlLite().getExcuteSql().getItem(00000000);
//            boolean isexcity = EssentialSqlLite.getEssentialSqlLite().getExcuteSql().deleteUser(user.getAccount());
            System.out.println(item);
//            EssentialSqlLite.getEssentialSqlLite().getExcuteSql().registerItem(item);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
