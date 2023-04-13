package com.ebanma.cloud.usertestall;  
  
import com.ebanma.cloud.usertestall.domain.mapper.UserVOMapper;
import com.ebanma.cloud.usertestall.domain.vo.UserVO;
import com.ebanma.cloud.usertestall.domain.vo.UserVOExample;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;  
import org.apache.ibatis.session.SqlSessionFactory;  
import org.apache.ibatis.session.SqlSessionFactoryBuilder;  
import org.junit.jupiter.api.Test;  
  
import java.io.IOException;  
import java.io.InputStream;
import java.util.List;

public class MybatisTest {  
  
    /**  
     * 传统方式  
     */  
    @Test  
    public void test1() throws IOException {  
        // 1. 读取配置文件，读成字节输入流，注意：现在还没解析  
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis/mybatis-config.xml");  
  
        // 2. 解析配置文件，封装Configuration对象   创建DefaultSqlSessionFactory对象  
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);  
  
        // 3. 生产了DefaultSqlsession实例对象   设置了事务不自动提交  完成了executor对象的创建  
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 4.(1)根据statementid来从Configuration中map集合中获取到了指定的MappedStatement对象  
        //   (2)将查询任务委派了executor执行器  
        UserVO user = sqlSession.selectOne("com.ebanma.cloud.usertestall.domain.mapper.UserVOMapper.selectByPrimaryKey", 1L);
        System.out.println(user);
        UserVO user2 = sqlSession.selectOne("com.ebanma.cloud.usertestall.domain.mapper.UserVOMapper.selectByPrimaryKey", 3L);
        System.out.println(user2);  
  
        // 5.释放资源  
        sqlSession.close();  
    }  
  
    /**
     * mapper代理方式
     */
    @Test
    public void test2() throws IOException {

        InputStream inputStream = Resources.getResourceAsStream("mybatis/mybatis-config.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = factory.openSession();

        // 使用JDK动态代理对mapper接口产生代理对象
        UserVOMapper mapper = sqlSession.getMapper(UserVOMapper.class);

        //代理对象调用接口中的任意方法，执行的都是动态代理中的invoke方法
        List<UserVO> all = mapper.selectByExample(new UserVOExample());
        for (UserVO user : all) {
            System.out.println(user);
        }
    }

    /**
     * mybatis二级缓存效果测试
     */
    @Test
    public void test3() throws IOException {

        InputStream inputStream = Resources.getResourceAsStream("mybatis/mybatis-config.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession1 = factory.openSession();
        SqlSession sqlSession2 = factory.openSession();

        UserVO user1 = sqlSession1.selectOne("com.ebanma.cloud.usertestall.domain.mapper.UserVOMapper.selectByPrimaryKey", 1L);
        System.out.println(user1);

        sqlSession1.commit();

        UserVO user = new UserVO();
        user.setId(1L);
        user.setUsername("jack");
        // 增删改会清空二级缓存
        sqlSession1.update("com.ebanma.cloud.usertestall.domain.mapper.UserVOMapper.updateByPrimaryKey", user);

        UserVO user2 = sqlSession2.selectOne("com.ebanma.cloud.usertestall.domain.mapper.UserVOMapper.selectByPrimaryKey",
                1L);
        System.out.println(user2);

    }
}