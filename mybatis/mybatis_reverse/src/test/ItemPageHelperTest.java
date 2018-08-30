import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yiran.reverse.mapper.ItemMapper;
import com.yiran.reverse.pojo.Item;
import com.yiran.reverse.pojo.ItemExample;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-mapper.xml", "classpath:spring-service.xml"})
public class ItemPageHelperTest {
    @Resource
    private ItemMapper itemMapper;

    /* 商品查询 - 分页 */
    @Test
    public void testQueryItemsByPage(){
        /*
        * 页码 -- 页面(上一页 下一页等..) 页面显示数 2
        * ItemAction
        *       PageInfo<Item> queryItemsByPage(Integer pageNum, Integer pageSize, ItemVo itemVo)
        * */
        Integer pageNum = 1;
        Integer pageSize = 2;

        // 创建多条件查询
        ItemExample itemExample = new ItemExample();
        // 按id倒序排列
        itemExample.setOrderByClause("itemId desc");
        // 总和条件设置
        ItemExample.Criteria criteria = itemExample.createCriteria();

        // offsetPage(开始条数索引，查询的条数   mysql从0开始)
        PageHelper.offsetPage((pageNum -1) * pageSize,pageSize);
        List<Item> items = itemMapper.selectByExampleWithBLOBs(itemExample);

        /* 遍历这里，发现和下面的结果是一样的。
         * 刚开始使用selectByExample查询，输出发现少了itemInfo字段，去Mapper中一看，
         * 原来selectByExample使用的resultMap是没有查询itemInfo这个字段的
         * 我们使用selectByExampleWithBLOBs方法即可
         * */
        for (Item item : items){
            System.out.println(item);
        }

        // 从这里可以看出，pageHelper是对itemMapper的查询语句进行了又一次的封装
        PageInfo<Item> pageInfo = new PageInfo<>(items);
        System.out.println(pageInfo);
        /* 可以通过getList取出当前页面的item */
        // 直接输出会显示成这样，这是因为pageHelper重写了toString方法
        // list=Page{count=true, pageNum=1, pageSize=2, startRow=0, endRow=2, total=4,
        // pages=2, reasonable=false, pageSizeZero=false}

        // 这里的items 和上面的item 查询出来的结果相同，所以不需要重复获取。
        List<Item> items1 = pageInfo.getList();
        /*
        * PageInfo中有各种各样的参数，相当于帮我们封装好了一个完整的page类
        *
        * PageInfo{pageNum=1, pageSize=2, size=2, startRow=1, endRow=2, total=4, pages=2,
        * list=Page{count=true, pageNum=1, pageSize=2, startRow=0, endRow=2, total=4, pages=2,
        * reasonable=false, pageSizeZero=false}, prePage=0, nextPage=2, isFirstPage=true,
        * isLastPage=false, hasPreviousPage=false, hasNextPage=true, navigatePages=8,
        * navigateFirstPage=1, navigateLastPage=2, navigatepageNums=[1, 2]}
        * */
    }
}
