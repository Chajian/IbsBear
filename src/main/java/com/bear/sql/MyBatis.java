package com.bear.sql;

import com.bear.sql.dao.EssentialDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * 通过Mybatis获取信息
 * @author captain
 */
public class MyBatis {

    public static MyBatis myBatis;
    private SqlSession sqlSession;

    private MyBatis(){
        try {
        InputStream inputStream = Resources.getResourceAsStream("conf/mybatis-config.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(inputStream);
        sqlSession = factory.openSession();
        }
            catch (IOException e){
            e.printStackTrace();
        }
    }


    public EssentialDao getEssentialDao(){
        EssentialDao personDao = sqlSession.getMapper(EssentialDao.class);
        return personDao;
    }



    public static MyBatis getMyBatis() {
        if(myBatis==null)
            myBatis = new MyBatis();
        return myBatis;
    }

    /**
     * 当执行添加，删除等操作需要commit
     */
    public void commit(){
        sqlSession.commit();
    }
}
