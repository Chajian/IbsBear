package com.bear.sql.factory;

import com.bear.sql.BaseCreateSql;
import com.bear.sql.BaseExcuteSql;
import com.bear.sql.sqlite.person.EssentialCreateSqlLite;
import com.bear.sql.sqlite.person.EssentialExcuteSqlLite;

import java.sql.Connection;

/**
 *  玩家数据库对象工厂
 * @author yezi
 */
public class PersonSqlFactory implements BaseSqlFactory{

    @Override
    public BaseCreateSql getCreateSql(String url, String sql_name, String sql_commend) {
        return new EssentialCreateSqlLite(url, sql_name);
    }
    public EssentialCreateSqlLite getCreateSql() {
        return new EssentialCreateSqlLite("jdbc:mysql://localhost:3306/ibsbear", "ibsbear");
    }

    @Override
    public BaseExcuteSql getExcuteSql(Connection connection, String table) {
        return new EssentialExcuteSqlLite(connection, table);
    }


    public EssentialExcuteSqlLite getExcuteSql(Connection connection){
        return new EssentialExcuteSqlLite(connection, "ibs_user");
    }
}
