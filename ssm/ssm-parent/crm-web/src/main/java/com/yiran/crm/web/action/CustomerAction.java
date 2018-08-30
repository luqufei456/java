package com.yiran.crm.web.action;

import com.github.pagehelper.PageInfo;
import com.yiran.crm.pojo.CstCustomer;
import com.yiran.crm.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.UUID;

@Controller
public class CustomerAction {
    @Resource
    private CustomerService customerService;

    @RequestMapping("/customer/add")
    public String addCustomer(CstCustomer customer, MultipartFile custFile, HttpServletRequest request) throws Exception{
        // 设置图片名称 不可重复 使用uuid
        // 获取唯一的32位字符串
        String picName = UUID.randomUUID().toString();
        // 获取原始文件名称
        String oriName = custFile.getOriginalFilename();
        System.out.println(oriName);
        // 如果有上传图片
        if (oriName != null && !oriName.equals("")){
            // 获取后缀名 .img 这样的
            String extName = oriName.substring(oriName.lastIndexOf("."));
            String custPic = picName + extName;
            // 存图片
            custFile.transferTo(new File(request.getServletContext().getRealPath("/upload/") + File.separator + custPic));
            // 在customer中添加图片名称
            customer.setCustPic(custPic);
        }
        customerService.addCustomer(customer);
        return "redirect:/customer/list.action";
    }

    /*
     * 点击 - 客户列表 - 无分页信息
     * 点击 - 页码 - 有分页信息
     * mybatis分页插件
     *      pageInfo - 接收页码相关数据
     *
     *  CstCustomer - 查询
     *  pageInfo - 接收分页相关参数进行查询达到分页的效果
     *  page - 存储页码
     */

    @RequestMapping("/customer/list")
    public String queryCustomers(PageInfo<CstCustomer> pageInfo, Model model, Integer page, CstCustomer customer){
        System.out.println("111");
        pageInfo = customerService.queryCustomers(pageInfo,customer);
        model.addAttribute("pageInfo",pageInfo);
        System.out.println(page);
        System.out.println(customer.getCustName());
        model.addAttribute("page", page);
        model.addAttribute("customer", customer);
        return "customer/list";
    }

}
