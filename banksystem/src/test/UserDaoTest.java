import banksystem.dao.UserDao;
import banksystem.mapper.UserMapper;
import banksystem.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.InputStream;
import java.util.List;

public class UserDaoTest {
    private static Logger logger = Logger.getLogger(UserDaoTest.class);

    public static void main(String[] args) {
        //testMybatis();
        testSpringMybatis();
    }

    private static void testSpringMybatis(){
        ApplicationContext context = new ClassPathXmlApplicationContext("conf/spring-mybatis.xml");
        SqlSessionFactory factory = (SqlSessionFactory) context.getBean("sqlSessionFactory");
        //获得会话对象
        SqlSession session = factory.openSession(true);
        try {
            //通过MyBatis实现接口UserDAO，返回实例
            UserMapper userDao = session.getMapper(UserMapper.class);
            User user = userDao.selectUseByName("zhang");
            System.out.println(user);
        } finally {
            session.close();
        }

    }


    private static void testMybatis(){
        System.out.println("hi");
        // 获得环境配置文件流
        InputStream config = UserDaoTest.class.getClassLoader().getResourceAsStream("conf/mybatis/mybatis.xml");
        // 创建sql会话工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(config);
        //获得会话对象
        SqlSession session = factory.openSession(true);
        try {
            //通过MyBatis实现接口UserDAO，返回实例
            UserMapper userMapper = session.getMapper(UserMapper.class);
            User user = userMapper.selectUseByName("zhang");
            logger.info(user);
            System.out.println(user);
        } finally {
            session.close();
        }
    }
}