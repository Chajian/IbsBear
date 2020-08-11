import com.bear.util.StringRule;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) {
        String rule = StringRule.TRANSLATEMESSAGE.replaceKey("");
        Pattern pattern = Pattern.compile(rule);
        Matcher matcher = pattern.matcher("[234234]sdfsdf");
        System.out.println(matcher.replaceAll(""));
    }
}
