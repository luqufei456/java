import com.yiran.spring.action.UserAction;
import com.yiran.spring.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//spring - test junit进一步封装
@RunWith(SpringJUnit4ClassRunner.class) // junit整合spring的测试，开启spring的注解
@ContextConfiguration(locations = "classpath:spring-bean.xml") // 加载核心配置文件,自动构建spring容器
public class SpringTest2 {
    @Autowired
    private UserAction userAction;

    @Test
    public void testService(){
        userAction.save();
    }
}
