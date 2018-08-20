import com.yiran.bank.action.BankAction;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-bean.xml","classpath:spring-transaction.xml"})
public class Test1 {
    @Resource
    private BankAction bankAction;

    @Test
    public void testTransferMoney(){
        String myBankId = "chunjue";
        String otherBankId = "yiran";
        double money = 8000;
        bankAction.transferMoney(myBankId,otherBankId,money);
    }
}
