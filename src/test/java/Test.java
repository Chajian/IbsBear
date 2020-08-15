import com.bear.data.Item;
import com.bear.sql.MyBatis;
import com.bear.sql.dao.EssentialDao;
import com.bear.util.StringRule;
import com.bear.util.Translate;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) {
//        MyBatis myBatis = MyBatis.getMyBatis();
//        myBatis.getEssentialDao().r egister(936796603L);
//        myBatis.commit();
//        System.out.println(myBatis.getEssentialDao().getUser(936796603L).toString());
        Item i = MyBatis.getMyBatis().getEssentialDao().getItemInfo(00000001);
        System.out.println(i.toString());
    }
}
