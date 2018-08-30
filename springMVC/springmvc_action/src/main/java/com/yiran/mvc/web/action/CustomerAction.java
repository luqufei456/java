package com.yiran.mvc.web.action;

import com.yiran.mvc.pojo.Customer;
import com.yiran.mvc.pojo.CustomerVo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
public class CustomerAction {
    /**
     *       c) 以pojo(实体对象)来进行接收,属性名与参数名要保持一致
     *          pojo对象中属性名和表单中input的name属性一致
     *
     *          springmvc - 默认类型转换
     *              基本类型 - 若数据填写为空，因为基本类型不可为null - 400错误
     *                  - 包装类即可
     *
     *          java.util.Date
     *              由于日期数据有很多种格式，springmvc无法自动转换字符串为日期，所以需要自己定义转换方法。
     *                  自定义DateConverter  utils下
    * */

    @RequestMapping("/customer/add")
    public String addCustomerAction(Customer customer, MultipartFile custFile, HttpServletRequest request) throws IOException{
        // 图片上传 设置图片名称，不能重复，可以使用uuid
        String picName = UUID.randomUUID().toString(); // 获取唯一的32位字符

        // 获取文件名
        String oriName = custFile.getOriginalFilename();
        // 获得文件后缀
        String extName = oriName.substring(oriName.lastIndexOf("."));
        /*
        * separatorChar
            public static final char separatorChar
            与系统有关的默认名称分隔符。此字段被初始化为包含系统属性 file.separator 值的第一个字符。在 UNIX 系统上，此字段的值为 '/'；在 Microsoft Windows 系统上，它为 '\'。

            separator
            public static final String separator
            与系统有关的默认名称分隔符，为了方便，它被表示为一个字符串。此字符串只包含一个字符，即 separatorChar。
        * */
        // 开始上传  getRealPath 获取文件的绝对路径
        custFile.transferTo(new File(request.getServletContext().getRealPath("/upload") + File.separator + picName + extName));

        System.out.println(customer);
        return "redirect:/customer/list.action";
    }

    //@RequestMapping(value = {"/list","listAll"}) 两种连接都可以访问
    //@RequestMapping(value = "/customer/list",method = RequestMethod.POST) // 限定只有post方法才能访问
    @RequestMapping("/customer/list")
    // public String queryCustomer(Model model,Customer cust,Integer minYear,Integer maxYear){
    public String queryCustomer(Model model, CustomerVo customerVo){
        /* Vo中的关联对象，在表单验证中提交时，不能直接写其关联对象的属性名，而要写对象名.属性名 */
        // 模拟数据库查询
        List<Customer> list = new ArrayList<>();
        Customer customer = new Customer();
        customer.setCustId(1L);
        customer.setCustName("阿里巴巴");
        customer.setCustAddress("杭州");
        customer.setCustDate(java.sql.Date.valueOf("1998-08-08"));
        customer.setCustYear(10);
        customer.setCustPhone("1008611");
        customer.setCustSource("签约客户");
        customer.setCustLevel("尊享");
        list.add(customer);

        System.out.println(customerVo);

        model.addAttribute("list",list);
        return "customer/list";
    }

    @RequestMapping("/customer/qbid")
    //public String queryCustomerByName(Integer id)
    public String queryCustomerByName(@RequestParam(value = "id",defaultValue = "1")Integer id){
        System.out.println(id);
        return null;
    }

    /*
     * restful风格
     * 	{xxx}叫做占位符
     * 	形参中 @PathVariable() 对应参数数据
     */
    @RequestMapping("/customer/edit/{custId}")
    public String editCustomerById(@PathVariable Integer custId){
        System.out.println("--editCustomerById--" + custId);
        return "customer/edit";
    }

    @RequestMapping("/customer/del/{custId}")
    public String deleteCustomerById(@PathVariable Integer custId){
        System.out.println("--deleteCustomerById--" + custId);
        return "redirect:/customer/list.action";
    }

}
