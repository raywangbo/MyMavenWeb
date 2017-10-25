import com.ym.mapper.UserMapper;
import com.ym.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Ray on 2017/10/23.
 */
public class test implements UserMapper{

    @Test
    public void testMybatis(){
        System.out.println(findUserByAccount("admin"));
    }

    @Override
    public Integer userLogin(User user) {
        return null;
    }

    @Override
    public User findUserByAccount(String account) {

        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user = sqlSession.selectOne("UserMapper.findUserByAccount",account);
        return user;
    }
}
