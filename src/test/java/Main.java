import com.gaozhaoxi.db.DButil;
import com.gaozhaoxi.entity.User;
import com.gaozhaoxi.mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Leon
 */
public class Main {
    @Test
    public void test1(){
        List<String> str=new ArrayList<>();
        str.add("足球");
        str.add("派遣");
        str.add("羽毛球");

        System.out.println(str);
    }

    @Test
    public void test2(){
        StringBuffer stringBuffer=new StringBuffer();
        StringBuffer s2=new StringBuffer();
        stringBuffer.append("Hello World!");
        s2=stringBuffer.deleteCharAt(5);//
        System.out.println(stringBuffer.toString());
        System.out.println(s2.toString());
        s2.append("a");
        System.out.println(s2.toString());

        s2.deleteCharAt(s2.length()-1);
        System.out.println(s2.toString());


    }

    @Test
    public void test3(){
        SqlSession sqlSession=null;
        try{
            sqlSession= DButil.openSqlSession();
            UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
            List<User> list=userMapper.getUser();
            System.out.println(list.toString());
            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
            sqlSession.rollback();
        }finally {
            if (sqlSession!=null){
                sqlSession.close();
            }
        }
    }

    @Test
    public void test4(){
        SqlSession sqlSession=null;
        try{
            sqlSession= DButil.openSqlSession();
            UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
            List<String> interest=new ArrayList<>();
            interest.add("冰壶");
            interest.add("乒乓球");
            User user=new User(null,"gl",interest);
            int i=userMapper.insertUser(user);
            System.out.println(i+"\\\\");
            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
            sqlSession.rollback();
        }finally {
            if (sqlSession!=null){
                sqlSession.close();
            }
        }
    }
}
