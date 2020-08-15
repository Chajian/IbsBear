package com.bear.util;

/**
 * 正则表达式规则
 */
public enum StringRule {
    SEARCHKEY("^[a-zA-Z0-9_\\u4e00-\\u9fa5]*?[\\u4e00-\\u9fa5]*?要被替换的关键字哦*?[\\u4e00-\\u9fa5]","关键字查询"),
    TRANSLATEMESSAGE("^\\[.*?\\]","将sourceMessage替换为真正的消息");

    /*正则规则*/
    String rule;
    /*正则名字*/
    String name;

    StringRule(String rule, String name) {
        this.rule = rule;
        this.name = name;
    }

    /**
     * 将关键字替换为自己想要的
     * @param key
     */
    public String replaceKey(String key){
        return rule.replace("要被替换的关键字哦",key);
    }

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
