package com.gaozhaoxi.typehandler;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Leon
 */

@MappedJdbcTypes({JdbcType.VARCHAR})
@MappedTypes({List.class})
public class MyListTypeHandler implements TypeHandler<List<String>>{

    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, List<String> strings, JdbcType jdbcType) throws SQLException {
        StringBuffer stringBuffer=new StringBuffer();
        for (String s:strings){
            stringBuffer.append(s).append(",");
        }
        //删除该字符串最后一个字符，即删除“,”
        stringBuffer.deleteCharAt(stringBuffer.length()-1);
        //2.设置给ps
        preparedStatement.setString(i,String.valueOf(stringBuffer));
    }

    @Override
    public List<String> getResult(ResultSet resultSet, String s) throws SQLException {
        String string=resultSet.getString(s);
        List<String> list=new ArrayList<>();

        //用spilt分开字符串
        String[] substring=string.split(",");
        for (int i=0;i<substring.length;i++){
            list.add(substring[i]);
        }
//        System.out.println(list.toString());
        return list;
    }

    @Override
    public List<String> getResult(ResultSet resultSet, int i) throws SQLException {
        //相比上述写法，下面写法更加直观和简洁
        String[] substring=resultSet.getString(i).split(",");
        List<String> list= Arrays.asList(substring);
        return list;
    }

    @Override
    public List<String> getResult(CallableStatement callableStatement, int i) throws SQLException {
        String[] substring=callableStatement.getString(i).split(",");
        return Arrays.asList(substring);
    }
}
