package com.bear.sql.sqlite.person;

import com.bear.sql.factory.PersonSqlFactory;

/**
 * 基础必备数据库
 */
public class EssentialSqlLite {

    public static EssentialSqlLite essentialSqlLite;

    EssentialExcuteSqlLite excuteSql;

    EssentialCreateSqlLite createSqlLite;

    public EssentialSqlLite() {
        PersonSqlFactory personSqlFactory = new PersonSqlFactory();
        createSqlLite = personSqlFactory.getCreateSql();
        excuteSql = personSqlFactory.getExcuteSql(createSqlLite.create());
    }

    public EssentialExcuteSqlLite getExcuteSql() {
        return excuteSql;
    }

    public EssentialCreateSqlLite getCreateSqlLite() {
        return createSqlLite;
    }

    public static EssentialSqlLite getEssentialSqlLite() {
        if(essentialSqlLite == null)
            essentialSqlLite = new EssentialSqlLite();
        return essentialSqlLite;
    }
}
