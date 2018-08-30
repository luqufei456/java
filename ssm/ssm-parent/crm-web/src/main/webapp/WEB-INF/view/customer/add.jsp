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
	<script type="text/javascript">
        $(function() {
            //ajax - 级别 获取数据字典中数据
            $.ajax({
                url: "${pageContext.request.contextPath}/baseDict/queryTypeItems.action",
                type: "post",
                data:{"dictTypeCode" : "006"},
                success:function(data) {
                    $(data).each(function(index, obj) {
                        $("#custLevel").append("<option value='" + obj.dictId + "'>"+obj.dictItemName);
                    })
                },
                dataType: "json"
            });

            //来源
            $.ajax({
                url: "${pageContext.request.contextPath}/baseDict/queryTypeItems.action",
                type: "post",
                data:{"dictTypeCode" : "002"},
                success:function(data) {
                    $(data).each(function(index, obj) {
                        $("#custSource").append("<option value='" + obj.dictId + "'>"+obj.dictItemName);
                    })
                },
                dataType: "json"
            });

            //行业
            $.ajax({
                url: "${pageContext.request.contextPath}/baseDict/queryTypeItems.action",
                type: "post",
                data:{"dictTypeCode" : "001"},
                success:function(data) {
                    $(data).each(function(index, obj) {
                        $("#custIndustry").append("<option value='" + obj.dictId + "'>"+obj.dictItemName);
                    })
                },
                dataType: "json"
            });
        })
	</script>
	<META content="MSHTML 6.00.2900.3492" name=GENERATOR>
</HEAD>
<BODY>
<FORM id=form1 name=form1
	  action="${pageContext.request.contextPath}/customer/add.action"
	  <%-- 这里不加enctype="multipart/form-data 就无法上传文件 --%>
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
							<!-- 结合ajax - 验证企业已添加 -->
							<INPUT class=textbox id=sChannel2
								   style="WIDTH: 180px" maxLength=50 name="custName">
						</td>
						<td>客户级别 ：</td>
						<td>
							<!-- 数据字典 -->
							<!-- 通过逆向工程生成pojo（外键列） - mapper.xml - insert方法 -->
							<%-- 自定义方法
                                    通过对象来接收  baseDict_custSource.dictId
                                    sql语句：
                                        #{baseDict_custSource.dictId}
                             --%>
							<select id="custLevel" name="custLevel" style="WIDTH: 180px">

							</select>
						</td>
					</TR>

					<TR>
						<td>信息来源 ：</td>
						<td>
							<!-- 数据字典 -->
							<select id="custSource" name="custSource" style="WIDTH: 180px">

							</select>
						</td>
						<td>所属行业：</td>
						<td>
							<!-- 数据字典 -->
							<select id="custIndustry" name="custIndustry" style="WIDTH: 180px">

							</select>
						</td>
					</TR>

					<TR>
						<td>固定电话 ：</td>
						<td>
							<INPUT class=textbox id=sChannel2
								   style="WIDTH: 180px" maxLength=50 name="custPhone">
						</td>
						<td>所属地区 ：</td>
						<td>
							<INPUT class=textbox id=sChannel2
								   style="WIDTH: 180px" maxLength=50 name="custRegion">
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
						<td>企业法人 ：</td>
						<td>
							<INPUT class=textbox id=sChannel2
								   style="WIDTH: 180px" maxLength=50 name="custCorporation">
						</td>
						<td>注册资金 ：</td>
						<td>
							<INPUT class=textbox id=sChannel2
								   style="WIDTH: 180px" maxLength=50 name="custCapital">
						</td>
					</TR>
					<TR>
						<td>开户账号 ：</td>
						<td>
							<INPUT class=textbox id=sChannel2
								   style="WIDTH: 180px" maxLength=50 name="custBank">
						</td>
						<td>执照图片 ：</td>
						<td>
							<INPUT class=textbox id=sChannel2 type="file" name="custFile">
						</td>
					</TR>
					<TR>
						<td>客户简介 ：</td>
						<td>
							<textarea name="custMemo" style="WIDTH: 280px; height: 50px;"></textarea>
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