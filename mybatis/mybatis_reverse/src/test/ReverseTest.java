import com.yiran.reverse.mapper.ItemMapper;
import com.yiran.reverse.mapper.TorderMapper;
import com.yiran.reverse.mapper.TuserMapper;
import com.yiran.reverse.pojo.Item;
import com.yiran.reverse.pojo.ItemExample;
import com.yiran.reverse.pojo.Torder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-mapper.xml", "classpath:spring-service.xml"})
public class ReverseTest {

    @Resource
    private TuserMapper tuserMapper;
    @Resource
    private ItemMapper itemMapper;

    /* 根据id查询item */
    @Test
    public void testQueryItemById(){
        int itemId = 1;
        Item item = itemMapper.selectByPrimaryKey(itemId);
        System.out.println(item);
    }

    /* 根据条件筛选item，但是这里不设置任何条件 */
    @Test
    public void testQueryItems(){
        // selectByExample方法 可以进行多条件查询 这里不定义任何条件，相当于查询所有item
        List<Item> items = itemMapper.selectByExample(null);
        System.out.println(items.size());
    }

    /* 设置条件根据id倒序，将新商品放在前面 */
    @Test
    public void testQueryItemsOrderDesc(){
        // 新建ItemExample，其中可以加入各种条件来进行查询
        ItemExample itemExample = new ItemExample();
        // 这里设置排序条件 按id倒序排列 order by
        itemExample.setOrderByClause("itemId desc");
        List<Item> items = itemMapper.selectByExample(itemExample);
        System.out.println(items.size());
    }

    /* 多条件查询 */
    @Test
    public void testQueryItemsWhere(){
        //service - Vo、pojo中数据  - 带入Example
        ItemExample itemExample = new ItemExample();
        // 这里设置排序条件 按id倒序排列 order by
        itemExample.setOrderByClause("itemId desc");
        // 设置其他条件，可以用if语句来判断是否有该条件来决定是否添加该条件
        // ItemExample内置的Criteria属性，也为一个实体类，用于封装条件
        ItemExample.Criteria criteria = itemExample.createCriteria();
        // 比如我定义几个变量，代表有或没有该参数，当然这里定义都为true
        boolean flag1 = true;
        boolean flag2 = true;
        if (flag1){
            // 注意，方法中字段名称都为小写，username itemname itemid等。
            criteria.andItemnameLike("%鸡%");
        }
        if (flag2){
            // 这里的 itemprice 也一样为小写
            criteria.andItempriceBetween(2.0,20.0);
        }
        // 加入筛选条件
        List<Item> items = itemMapper.selectByExample(itemExample);
        System.out.println(items.size());
    }

    /* 多表关联查询 */
    @Resource
    private TorderMapper torderMapper;
    @Test
    public void testQueryOrderUserAddress(){
        Torder order = torderMapper.queryOrderUserAddress(1);
        System.out.println(order.getTotalnum() + "\t" + order.getTotalprice());
        System.out.println(order.getTuser().getUsername());
        System.out.println(order.getTaddress().getAddressdetail() + "\t" + order.getTaddress().getName());
    }
}
