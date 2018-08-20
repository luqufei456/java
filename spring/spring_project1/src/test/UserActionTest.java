import com.yiran.spring.action.UserAction;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserActionTest {
    @Test
    public void testLogin(){
        UserAction action = new UserAction();
        action.login();
    }

    /*

      控制反转 IoC

    * 通过spring的工厂获得Bean -- BeanFactory
    * ApplicationContext直译
    * */
    @Test
    public void testSpringLogin(){
        // 加载配置文件，构建spring工厂 -- 创建对象
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        // 获取对象 第二个参数指定获取的类型为
        // scope - singleton 加载配置文件时创建一次
        //         prototype 获取对象时创建
        UserAction action1 = applicationContext.getBean("userAction",UserAction.class);
        action1.login();

        // 获取对象
        UserAction action2 = applicationContext.getBean("userAction",UserAction.class);
        action2.login();

        // true 工厂默认情况只创建一个对象，不会占用很多内存，对象在构造spring工厂时创建一个
        // 如果设置xml中该工厂的scope为prototype，则在获取对象时会创建一个新的对象。构造spring工厂时不会创建
        System.out.println(action1==action2);

        // 关闭容器 -- 一般不会用
        // ((ClassPathXmlApplicationContext)applicationContext).close();
    }

    // 对象调用 --xml
    // DI - 依赖注入 (Dependency Injection)
    // 1: setter方法
    @Test
    public void testSpringDTLogin(){
        // 加载配置文件，构建spring工厂 -- 创建对象
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserAction action = applicationContext.getBean("userAction",UserAction.class);
        action.login();
    }
}
