

import com.yiran.mybatis.dao.UserDao;
import com.yiran.mybatis.dao.impl.UserDaoImpl;
import com.yiran.mybatis.mapper.UserMapper;
import com.yiran.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class Test1 {
    private UserDao userDao = new UserDaoImpl();

    @Test
    public void testDao() throws Exception {
        User user = new User();
        user.setUserId(1);
        user.setUserName("依然");

        User existUser = userDao.login(user);
        System.out.println(existUser);
    }

    private SqlSessionFactory sqlSessionFactory;

    /* 定义一个初始化方法，在test方法运行前运行，用于初始化SqlSessionFactory */
    @Before
    public void init() throws Exception {
        // 创建SqlSessionFactoryBuilder
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        // 加载SqlMapConfig.xml配置文件
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 创建SqlSessionFactory
        this.sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
    }

    @Test
    public void dynamicTest() throws Exception{
        // 获取sqlSession，和spring整合后由spring管理
        SqlSession sqlSession = this.sqlSessionFactory.openSession();
        // 从sqlSession中获取Mapper接口的代理对象
        // 底层会自动实现该接口的动态实现类
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        // 执行查询方法
        User selectUser = new User();
        selectUser.setUserId(1);
        User user = userMapper.queryUserById(selectUser);
        System.out.println(user);

        // 和spring整合后由spring管理
        sqlSession.close();
    }

    @Test
    public void testQueryUserByUsername() {
        // 获取sqlSession，和spring整合后由spring管理
        SqlSession sqlSession = this.sqlSessionFactory.openSession();
        // 从sqlSession中获取Mapper接口的代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        // 执行查询方法
        String userName = "依";
        List<User> list = userMapper.queryUserByUserName(userName);
        for (User user : list) {
            System.out.println(user);
        }
        // 和spring整合后由spring管理
        sqlSession.close();
    }

    @Test
    public void testSaveUser() {
        // 4. 创建SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 5. 执行SqlSession对象执行保存
        // 创建需要保存的User
        User user = new User();
        user.setUserName("小依然");
        user.setSex("1");
        user.setBirthday(new Date());
        user.setAddress("蜀国");

        sqlSession.insert("saveUser", user);
        System.out.println(user);

        // 需要进行事务提交
        sqlSession.commit();

        // 7. 释放资源
        sqlSession.close();
    }


}
