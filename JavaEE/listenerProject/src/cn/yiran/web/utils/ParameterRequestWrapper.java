package cn.yiran.web.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ParameterRequestWrapper extends HttpServletRequestWrapper {
    // 用于存放获取的所有参数的键值对
    private Map<String, String[]> params = new HashMap<>();

    private String[] fuckAll = new String[]{"你妹","傻逼"};

    public ParameterRequestWrapper (HttpServletRequest request){
        super(request);
        // 将request获取的参数的键值对存入map中
        this.params.putAll(request.getParameterMap());
    }

    @Override
    public String getParameter(String name) {
        String[] values = params.get(name);
        String value = null;
        if (values != null && values.length != 0){
            value = values[0];
            int len = fuckAll.length;
            for (int i = 0;i < len;i++){
                value = value.replace(fuckAll[i],"**");
            }
            return value;
        }
        return null;
    }
}
