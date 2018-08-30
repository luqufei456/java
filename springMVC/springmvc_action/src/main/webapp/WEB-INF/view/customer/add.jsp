<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<TITLE>添加客户</TITLE> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="${pageContext.request.contextPath }/css/Style.css" type=text/css rel=stylesheet>
<LINK href="${pageContext.request.contextPath }/css/Manage.css" type=text/css
	rel=stylesheet>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.4.4.min.js"></script>

<META content="MSHTML 6.00.2900.3492" name=GENERATOR>
</HEAD>
<BODY>
	<FORM id=form1 name=form1
		action="${pageContext.request.contextPath}//customer/add.action"
		method=post enctype="multipart/form-data">
		

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
								<TD class=manageHead>当前位置：客户管理 &gt; 添加客户</TD>
							</TR>
							<TR>
								<TD height=2></TD>
							</TR>
						</TABLE>
						
						<TABLE cellSpacing=0 cellPadding=5  border=0>
						  
						    
							<TR>
								<td>客户名称：</td>
								<td>
								<INPUT class=textbox id=sChannel2
														style="WIDTH: 180px" maxLength=50 name="custName">
								</td>
								<td>客户级别 ：</td>
								<td>
									<script type="text/javascript">
										$(function() {
											//ajax - 获取数据字典中数据
											$.ajax({
												url: "${pageContext.request.contextPath}/baseDict/getBases.action",
												type: "post",
												data:{"baseId":1, "baseName":"啊啊啊"},
												success:function(data) {
													$(data).each(function(index, obj) {
														//alert(obj.baseId + " " + obj.baseName);
														$("#custLevel").append("<option value='" + obj.baseId + "'>"+obj.baseName);
													})
												},
												dataType: "json"
											})
										})
									</script>
									<!-- 数据字典 -->
									<select id="custLevel" name="custLevel" style="WIDTH: 180px">
										
									</select>
								</td>
							</TR>
							
							<TR>
								
								<td>信息来源 ：</td>
								<td>
								<INPUT class=textbox id=sChannel2
														style="WIDTH: 180px" maxLength=50 name="custSource">
								</td>
								<td>创办时间：</td>
								<td>
								<INPUT class=textbox id=sChannel2 type="date"
														style="WIDTH: 180px" maxLength=50 name="custDate">
								</td>
							</TR>
							
							<TR>
								
								
								<td>固定电话 ：</td>
								<td>
								<INPUT class=textbox id=sChannel2
														style="WIDTH: 180px" maxLength=50 name="custPhone">
								</td>
								<td>创办年限 ：</td>
								<td>
								<INPUT class=textbox id=sChannel2
														style="WIDTH: 180px" maxLength=50 name="custYear">
								</td>
							</TR>
							
							<TR>
								<td>联系地址 ：</td>
								<td>
								<INPUT class=textbox id=sChannel2
														style="WIDTH: 180px" maxLength=50 name="custAddress">
								</td>
								<td>邮政编码 ：</td>
								<td>
								<INPUT class=textbox id=sChannel2
														style="WIDTH: 180px" maxLength=50 name="custZip">
								</td>
							</TR>
							<TR>
								<td>客户传真 ：</td>
								<td>
								<INPUT class=textbox id=sChannel2
														style="WIDTH: 180px" maxLength=50 name="custFax">
								</td>
								<td>客户网址 ：</td>
								<td>
								<INPUT class=textbox id=sChannel2
														style="WIDTH: 180px" maxLength=50 name="custWebsite">
								</td>
							</TR>
							<TR>
								<td>主营 ：</td>
								<td>
									<!-- 后台管理员删除、购物车多选、兴趣爱好....  多选框 -->
									<INPUT class=textbox id=sChannel2 type="checkbox" name="custMain" value="Java软件开发">Java软件开发
									<INPUT class=textbox id=sChannel2 type="checkbox" name="custMain" value="IOS">IOS
									<INPUT class=textbox id=sChannel2 type="checkbox" name="custMain" value="测试">测试
									<INPUT class=textbox id=sChannel2 type="checkbox" name="custMain" value="销售">销售
								</td>
							</TR>
							<TR>
								<td>营业执照 ：</td>
								<td>
									<INPUT class=textbox id=sChannel2 type="file" name="custFile">
									<!-- 图片文件预览 -->
								</td>
							</TR>
							<tr>
								<td rowspan=2>
								<INPUT class=button id=sButton2 type=submit
														value=" 保存 " name=sButton2>
								</td>
							</tr>
						</TABLE>
						
						
					</TD>
					<TD width=15 background="${pageContext.request.contextPath }/images/new_023.jpg">
					<IMG src="${pageContext.request.contextPath }/images/new_023.jpg" border=0></TD>
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
