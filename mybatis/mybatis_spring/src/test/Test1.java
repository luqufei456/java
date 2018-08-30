
import com.yiran.mybatis.mapper.ItemMapper;
import com.yiran.mybatis.mapper.OrderMapper;
import com.yiran.mybatis.pojo.Item;
import com.yiran.mybatis.pojo.Order;
import com.yiran.mybatis.pojo.OrderDetail;
import com.yiran.mybatis.pojo.User;
import com.yiran.mybatis.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mapper.xml","classpath:spring-service.xml"})
public class Test1 {

    @Resource
    private UserService userService;

    @Test
    public void testQueryUserById(){
        User user = userService.queryUserById(1);
        System.out.println(user);
    }

    @Resource
    private OrderMapper orderMapper;

    @Test
    public void testOrderUserAddress121(){
        Integer orderId = 1;
        Order order = orderMapper.queryOrderUserAddress(orderId);
        System.out.println(order);
    }

    @Test
    public void testqueryOrderItemsByOrderId(){
        Integer orderId = 1;
        List<Order> orders = orderMapper.queryOrderItemsByOrderId(orderId);
        for (Order order : orders){
            System.out.println(order.getOrderDetailList().get(0).getItem().getItemName());
        }
    }

    @Test
    public void testqueryOrderItemByOrderIdLazy(){
        Integer orderId = 1;
        Order order = orderMapper.queryOrderItemByOrderIdLazy(orderId);
        //System.out.println(order); 这个地方调用toString会调用懒加载，所以看上去好像没有延时调用
        /*
         * lazyLoadTriggerMethods：指定哪个对象的方法触发一次延迟加载。默认值：equals,clone,hashCode,toString
         * 所以，当打印对象时，由于触发了 toString 方法，所以触发了一次懒加载
         * */

        System.out.println(order.getTotalNum() + "\t" + order.getTotalPrice());

        List<OrderDetail> orderDetails = order.getOrderDetailList();
        for(OrderDetail detail : orderDetails) {
            System.out.println(detail.getItem().getItemName() + "\t" + detail.getItemNum());
        }
        System.out.println(order);
    }

    @Test
    public void testqueryOrderItemsUserAddressByOrderId(){
        Integer orderId = 1;
        Order order = orderMapper.queryOrderItemsUserAddressByOrderId(orderId);

        System.out.println(order.getTotalNum() + "\t" + order.getTotalPrice());

        List<OrderDetail> orderDetails = order.getOrderDetailList();
        for(OrderDetail detail : orderDetails) {
            System.out.println(detail.getItem().getItemName() + "\t" + detail.getItemNum());
        }
        System.out.println(order);
    }

    @Resource
    private ItemMapper itemMapper;

    @Test
    public void testQueryItems(){
        List<Item> items = itemMapper.queryItems();
        System.out.println(items);
        List<Item> items1 = itemMapper.queryItems();
        System.out.println(items1);
    }


}
