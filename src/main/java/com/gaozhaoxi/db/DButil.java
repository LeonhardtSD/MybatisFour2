package com.gaozhaoxi.db;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;


/**
 * @author Leon
 */
public class DButil {
    private static SqlSessionFactory sqlSessionFactory=null;
    private static final Class CLASS_LOCK=DButil.class;

    public static SqlSessionFactory initSqlSessionFactory(){
        String resource="mybatis-config.xml";
        InputStream inputStream=null;
        try {
            inputStream= Resources.getResourceAsStream(resource );
        } catch (IOException e) {
            e.printStackTrace();
        }
        synchronized (CLASS_LOCK) {
            if (sqlSessionFactory==null)
            sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
        }
        return  sqlSessionFactory;
    }

    public static SqlSession openSqlSession(){
        if (sqlSessionFactory==null){
            initSqlSessionFactory();
        }

        return sqlSessionFactory.openSession();
    }

}
