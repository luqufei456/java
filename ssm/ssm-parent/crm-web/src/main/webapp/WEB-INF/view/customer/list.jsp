<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<TITLE>客户列表</TITLE>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<LINK href="${pageContext.request.contextPath }/css/Style.css" type=text/css rel=stylesheet>
	<LINK href="${pageContext.request.contextPath }/css/Manage.css" type=text/css
		  rel=stylesheet>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.4.4.min.js"></script>
	<SCRIPT language=javascript>
        //点击上一页、下一页 - 输入页码.. 表单重新提交   customer/list.action
        function to_page(page){
            if(page){
                $("#pageNum").val(page);
            }
            document.customerForm.submit();
        }

        $(function() {
            $("#gogo").click(function() {
                var inputPage = $("#page").val();
                if(inputPage >= 1 && inputPage <= "${pageInfo.pages}") {
                    $("#pageNum").val(inputPage);
                    document.customerForm.submit();
                }
            })

            $("#pageSizeChange").change(function() {
                $("#pageNum").val(1);
                document.customerForm.submit();
            })
        })
	</SCRIPT>

	<META content="MSHTML 6.00.2900.3492" name=GENERATOR>
</HEAD>
<BODY>
<FORM id="customerForm" name="customerForm"
	  action="${pageContext.request.contextPath }/customer/list.action"
	  method=post>
	<%-- ${pageInfo.startRow} --%>

	<input id="pageNum" name="pageNum" type="hidden" value="${pageInfo.pageNum}">
	<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
		<TBODY>
		<TR>
			<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_019.jpg"
							  border=0></TD>
			<TD width="100%" background="${pageContext.request.contextPath }/images/new_020.jpg"
				height=20></TD>
			<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_021.jpg"
							  border=0></TD>
		</TR>
		</TBODY>
	</TABLE>
	<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
		<TBODY>
		<TR>
			<TD width=15 background=${pageContext.request.contextPath }/images/new_022.jpg><IMG
					src="${pageContext.request.contextPath }/images/new_022.jpg" border=0></TD>
			<TD vAlign=top width="100%" bgColor=#ffffff>
				<TABLE cellSpacing=0 cellPadding=5 width="100%" border=0>
					<TR>
						<TD class=manageHead>当前位置：客户管理 &gt; 客户列表</TD>
					</TR>
					<TR>
						<TD height=2></TD>
					</TR>
				</TABLE>
				<TABLE borderColor=#cccccc cellSpacing=0 cellPadding=0
					   width="100%" align=center border=0>
					<TBODY>
					<TR>
						<TD height=25>
							<TABLE cellSpacing=0 cellPadding=2 border=0>
								<TBODY>
								<TR>
									<TD>客户名称：</TD>
									<TD>
										<!-- 数据回显 -->
										<INPUT class=textbox id=sChannel2 style="WIDTH: 180px" maxLength=50 name="custName" value="${customer.custName}"></TD>
									<TD><INPUT class=button id=sButton2 type=submit
											   value=" 搜索" name=sButton2></TD>
								</TR>
								</TBODY>
							</TABLE>
						</TD>
					</TR>

					<TR>
						<TD>
							<TABLE id=grid
								   style="BORDER-TOP-WIDTH: 0px; FONT-WEIGHT: normal; BORDER-LEFT-WIDTH: 0px; BORDER-LEFT-COLOR: #cccccc; BORDER-BOTTOM-WIDTH: 0px; BORDER-BOTTOM-COLOR: #cccccc; WIDTH: 100%; BORDER-TOP-COLOR: #cccccc; FONT-STYLE: normal; BACKGROUND-COLOR: #cccccc; BORDER-RIGHT-WIDTH: 0px; TEXT-DECORATION: none; BORDER-RIGHT-COLOR: #cccccc"
								   cellSpacing=1 cellPadding=2 rules=all border=0>
								<TBODY>
								<TR
										style="FONT-WEIGHT: bold; FONT-STYLE: normal; BACKGROUND-COLOR: #eeeeee; TEXT-DECORATION: none">
									<TD>客户名称</TD>
									<TD>客户级别</TD>
									<TD>客户来源</TD>
									<TD>客户行业</TD>
									<TD>电话</TD>
									<TD>客户地址</TD>
									<TD>客户网址</TD>
									<TD>操作</TD>
								</TR>
								<c:forEach items="${requestScope.pageInfo.list}" var="customer">
									<TR
											style="FONT-WEIGHT: normal; FONT-STYLE: normal; BACKGROUND-COLOR: white; TEXT-DECORATION: none">
										<TD>${customer.custName }</TD>
										<TD>${customer.baseDict_custLevel.dictItemName }</TD>
										<TD>${customer.baseDict_custSource.dictItemName }</TD>
										<TD>${customer.baseDict_custIndustry.dictItemName }</TD>
										<TD>${customer.custPhone }</TD>
										<TD>${customer.custAddress }</TD>
										<TD>${customer.custWebsite }</TD>
										<TD>
											<a href="${pageContext.request.contextPath }/customer/edit/${customer.custId}.action">修改</a>
											&nbsp;&nbsp;
											<a href="${pageContext.request.contextPath }/customer/del/${customer.custId}.action">删除</a>
										</TD>
									</TR>
								</c:forEach>

								</TBODY>
							</TABLE>
						</TD>
					</TR>

					<TR>
						<TD><SPAN id=pagelink>
											<DIV
													style="LINE-HEIGHT: 20px; HEIGHT: 20px; TEXT-ALIGN: right">
												共[<B>${pageInfo.total}</B>]条记录, 共[<B>${pageInfo.pages}</B>]页
												,每页显示
												<select id="pageSizeChange" name="pageSize">
													<option value="5" <c:if test="${pageInfo.pageSize==5}">selected</c:if>>5</option>
													<option value="10" <c:if test="${pageInfo.pageSize==10}">selected</c:if>>10</option>
													<option value="15" <c:if test="${pageInfo.pageSize==15}">selected</c:if>>15</option>
												</select>
												条
												&nbsp;&nbsp;&nbsp;
												<c:if test="${pageInfo.pageNum != 1}">
													[<A href="javascript:to_page(${1})">首页</A>]
													[<A href="javascript:to_page(${pageInfo.pageNum-1})">前一页</A>]
												</c:if>
												<B>${pageInfo.pageNum}</B>
												<c:if test="${pageInfo.pageNum != pageInfo.pages}">
													[<A href="javascript:to_page(${pageInfo.pageNum+1})">后一页</A>]
													[<A href="javascript:to_page(${pageInfo.pages})">尾页</A>]
												</c:if>
												&nbsp;&nbsp;&nbsp;
												到
												<input type="text" size="3" id="page" name="page" value="${page}"/>
												页
												<input id="gogo" type="button" value="Go"/>
											</DIV>
									</SPAN></TD>
					</TR>
					</TBODY>
				</TABLE>
			</TD>
			<TD width=15 background="${pageContext.request.contextPath }/images/new_023.jpg"><IMG
					src="${pageContext.request.contextPath }/images/new_023.jpg" border=0></TD>
		</TR>
		</TBODY>
	</TABLE>
	<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
		<TBODY>
		<TR>
			<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_024.jpg"
							  border=0></TD>
			<TD align=middle width="100%"
				background="${pageContext.request.contextPath }/images/new_025.jpg" height=15></TD>
			<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_026.jpg"
							  border=0></TD>
		</TR>
		</TBODY>
	</TABLE>
</FORM>
</BODY>
</HTML>