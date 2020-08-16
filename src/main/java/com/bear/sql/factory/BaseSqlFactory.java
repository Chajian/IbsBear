package com.bear.sql.factory;

import com.bear.sql.BaseCreateSql;
import com.bear.sql.BaseExcuteSql;

import java.sql.Connection;

/**
 *  创建sql对象的工厂接口
 * @author yezi
 */
public interface BaseSqlFactory {

    BaseCreateSql getCreateSql(String url, String sql_name, String sql_commend);

    BaseExcuteSql getExcuteSql(Connection connection, String table);

}
