package test.common;

import org.junit.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: lulin
 * @Date: 3/7/2019 11:47 PM
 * @Version 1.0
 */
public class BaseTest
{
    @Before
    public void before(){
        String config[] = {"spring-mvc.xml",
                "spring-dbcp.xml",
                "spring-mybatis.xml"};
        ApplicationContext ctx=new ClassPathXmlApplicationContext(config);
    }

}
