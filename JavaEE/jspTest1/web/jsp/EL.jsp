<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="cn.yiran.web.domain.Product" %><%--
  Created by IntelliJ IDEA.
  User: 19769
  Date: 2018/7/17
  Time: 8:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    //从小到大的4个容器
    pageContext.setAttribute("name", "page-jack",pageContext.PAGE_SCOPE);
    pageContext.setAttribute("name", "request-jack",pageContext.REQUEST_SCOPE);
    pageContext.setAttribute("name", "session-jack",pageContext.SESSION_SCOPE);
    pageContext.setAttribute("name", "context-jack",pageContext.APPLICATION_SCOPE);
%>

<%-- 默认和pageContext一样，从page开始，对应pageContext的find方法 --%>
${name} <%-- page-jack --%>
<%-- 快速获取容器中的数据的方法 xxxScope.xx --%>
${sessionScope.name}
${name1}<%-- 没有的话页面上就是空，也不会是null --%>

<%-- EL表达式获取复杂数据 --%>
<%
    List list = new ArrayList();
    list.add("白米饭");
    list.add("黑米粥");
    list.add("西米露");
    pageContext.setAttribute("list",list);
%>

${list[1]} <%-- 黑米粥，这里是相当于存到第一个page，然后这里相当于find，从第一个开始找 --%>

<%
    Map map = new HashMap();
    map.put("sj1", "诺基亚");
    map.put("sj2", "黑莓");
    map.put("sj3", "摩托罗拉");
    map.put("sj4", "大哥大");
    map.put("aa.bb.cc", "波导手机中的战斗机");
    pageContext.setAttribute("map",map);
%>

<%-- 可以通过.key或者[key]来获取数据 --%>
${map.sj1}
${map["aa.bb.cc"]}

<%
    Product product = new Product();
    product.setPid(1);
    product.setPname("chunjue");
    product.setShop_price(200);
    pageContext.setAttribute("product",product);
%>

<%-- 通过相同的属性名称获取数据 --%>
${product.pid}
<%-- 所有可以使用点的地方，都可以使用[]获取数据 --%>
${product["pname"]}

<%-- 运算符 --%>
<%-- empty运算符：检查对象是否为null或"空" --%>
${empty product}
<%-- ${user!=null?user.name : ""} 三元运算 --%>
${product!=null?product.pname :""}

<%-- EL计算 --%>
<%-- 演示El执行运算 --%>
<%
    int x = 3;
    //String y = "4g";
    int y = 4;
    pageContext.setAttribute("x", x);
    pageContext.setAttribute("y", y);
%>
<%-- 使用EL表达式获取数据，最终都是讲数据转换成字符串，根据字符串，格式化数字，在进行计算 --%>
<%-- z的数据不存在，不存在的数据，不参与运算 --%>
${ x+y }
${ x-y }
${ x*y }
${ x/y }
${ x%y }

<%
    boolean flag = true;
    boolean info = false;
    pageContext.setAttribute("flag", flag);
    pageContext.setAttribute("info", info);
%>
${flag && info}
<%--  ${ !info} --%>
${flag || info}<br>
<%-- 注意：当算术运算的时候，如果字符串内容不能解析成数据，则报数字格式化异常。 --%>
<%-- 数字格式化错误：EL取出来的数据无法转换成数字 --%>


<%-- EL内置11个对象，其中4个为容器对象，这里就不测试了 --%>
<%-- param --> 获取用户提交的请求参数 --%>
请求参数：${ param }<br>

获取某个key对应的多个value值（获取页面中checkbox）：${ paramValues }<br>

获取请求头中的信息：${ header }<br>

某个请求头中的多个value值：${ headerValues } cookie ${ headerValues.cookie[0] }<br>

它获取到的一个cookie数组，获取所有的cookie数据：${ cookie }<br>

它就和JSP内置对象pageContext功能一致：${ pageContext }<br>

<%-- 就是web.xml里面设置的param --%>
获取的项目的全局配置参数：${ initParam }<br>

<%-- 获取项目上下文路径 --%>
获取项目上下文路径:${ pageContext.request.contextPath }<br>



<%-- jstl标签 --%>
<%-- c:if --%>
<c:if test="true" var="item" scope="session"></c:if>
${applicationScope.item}<br>
${sessionScope.item}<br>

<%-- c:choose  c:when  c:otherwise --%>
<%--
c:choose  c:when  c:otherwise 相当于：
if(){

}else if(){

} else if(){

}
...
else{
}
--%>
<%
    int num = 4;
    pageContext.setAttribute("num", num);

    int flag1 = 1;
    pageContext.setAttribute("flag", flag1);
%>

<c:choose>
    <c:when test="${num==1 }">星期一</c:when>
    <c:when test="${num==2 }">星期二</c:when>
    <c:when test="${num==3 }">星期三</c:when>
    <c:when test="${num==4 }">星期四</c:when>
    <c:when test="${num==5 }">星期五</c:when>
    <c:when test="${num==6 }">星期六</c:when>
    <c:when test="${num==7 }">星期日</c:when>

    <c:when test="${flag==1 }">白天</c:when>
    <c:when test="${flag==2 }">黑夜</c:when>
    <c:otherwise>参数不合法</c:otherwise>
</c:choose>
<br>


<%-- c:set和c:out标签 --%>
<%-- set修改数据 --%>
<% pageContext.setAttribute("chunjue", new Product()); %>
${chunjue.pname }<br>
<c:set target="${chunjue }" property="pname" value="蠢觉"></c:set>
${chunjue.pname }<br>

<%-- 演示out标签 --%>
<%-- default设置没有数据的时候，默认输出 --%>
<%
    pageContext.setAttribute("str", null);
%>
<c:out value="${str }" default="《党的纲领性文件学习》"></c:out> <br>
<%-- escapeXml="true" 让浏览器不解析其中的html，会把整个标签当成字符串输出--%>
<c:out value="<a href='http://www.baidu.com'>测试</a>" escapeXml="flase"></c:out> <br>


<%-- c:forEach标签 --%>
<%
    for (int i = 1;i <= 5;i++){}
%>
<%-- var即为上面循环的i，begin即为初始值，end：终止值，step：步长 --%>
<%-- vs.index索引的这个值，是根据begin来定的，遍历集合时，也是因为集合初始索引为0，所以索引为0 --%>
<c:forEach var="i" begin="0" varStatus="vs" end="5" step="1">
    ${i},索引：${vs.index},迭代次数：${vs.count} <br>
</c:forEach>

<%-- forEach遍历对象集合 --%>
<%
    Product p1 = new Product();
    p1.setPname("p1");
    Product p2 = new Product();
    p2.setPname("p2");
    Product p3 = new Product();
    p3.setPname("p3");

    List<Product> productList = new ArrayList<>();
    productList.add(p1);
    productList.add(p2);
    productList.add(p3);
    pageContext.setAttribute("productList",productList,1);
%>
<c:forEach var="item" items="${productList}" varStatus="vs">
    姓名：${item.pname}; 索引：${vs.index},迭代次数:${vs.count}<br>
</c:forEach>

<%-- forEach遍历Map，遍历到的为一个Entry --%>
<c:forEach var="Entry" items="${map}" varStatus="vs">
    mapKey:${Entry.key};mapValue:${Entry.value};index:${vs.index} <br>
</c:forEach>


<%-- <c:forTokens>标签 --%>
使用"|"作为分隔符<br />
<c:forTokens var="token" items="spring,summer|autumn,winter" delims="|">
    ${token}&copy; <%-- copy一个圈里面一个c的符号 --%>
</c:forTokens><br />
<%-- spring,summer© autumn,winter©  --%>

使用"|"和","作为分隔符<br /><%-- 这里设置end为1，就遍历了2次 0 1 --%>
<c:forTokens var="token" items="spring,summer|autumn,winter" delims="|," end="1">
    ${token}&copy;
</c:forTokens><br />
<%-- spring© summer©  --%>

使用"-"作为分隔符<br />
<c:forTokens var="token" items="year--season--month-week" delims="-">
    ${token}&copy;
</c:forTokens>
<%-- year© season© month© week© --%>


<c:set var="aa" scope="page" value="aa"></c:set>

<%--  remove标签 --%>
<c:remove var="aa" scope="page" />
</body>
</html>
