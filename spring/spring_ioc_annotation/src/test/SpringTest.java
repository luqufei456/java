import com.yiran.spring.action.UserAction;
import com.yiran.spring.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.Method;

public class SpringTest {
    @Test
    public void test1(){
        // Spring容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-bean.xml");
        // 获取bean
        UserService userService = applicationContext.getBean("userService",UserService.class);
        // 可以执行
        userService.save();
    }

    @Test
    public void test2() throws Exception{
        // spring容器
        // 此时init方法已被调用
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-bean.xml");
        // 获取bean
        UserAction userAction = applicationContext.getBean("userAction",UserAction.class);

        // 方案一：
        // ((ClassPathXmlApplicationContext)applicationContext).close();
        // 方案二：
        // 反射机制调用close方法，接口只是引用了一个对象。对象本身有这个方法。
        // 目标：通过接口引用，调用对象本来的拥有的方法
        // 1。获取对象具体类的某个方法:参数1方法名，参数2：方法里面的参数类型
        Method method = applicationContext.getClass().getMethod("close");
        // 参数1：拥有该方法的对象的名字,参数2：方法里面的参数的值
        method.invoke(applicationContext);
    }

    @Test
    public void test3(){
        // spring容器
        // 若为单例时，此时init方法已被调用
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-bean.xml");
        // 获取bean
        UserAction userAction1 = applicationContext.getBean("userAction",UserAction.class);
        UserAction userAction2 = applicationContext.getBean("userAction",UserAction.class);

        System.out.println(userAction1);
        System.out.println(userAction2);
        // false
        System.out.println(userAction1==userAction2);
    }

}
