import com.yiran.spring.action.ItemAction;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-bean.xml")
public class SpringTest1 {
    @Autowired
    private ItemAction itemAction;

    @Test
    public void test1(){
        itemAction.addItem();
        // itemAction.updateItem();
    }
}
