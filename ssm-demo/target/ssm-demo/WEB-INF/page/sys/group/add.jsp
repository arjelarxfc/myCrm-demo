<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>部门新建</title>
<link href="${pageContext.request.contextPath}/ui/css/style_cn.css" rel="stylesheet" type="text/css">
</head>
<body>
<form name="form1" method="post" action="add">
<div class="mtitle">
	<div class="mtitle-row">&nbsp;</div>
	部门新建
</div> 
<br>
<div class="control"> 
	<button type='button' class='button' onMouseOver="this.className='button_over';" 
	        onMouseOut="this.className='button';"  onClick="document.forms[0].submit()">
	        <img src="${pageContext.request.contextPath}/ui/images/button/baocun.png" border='0' 
	             align='absmiddle'>&nbsp;保存</button>
	<button type='button' class='button' onMouseOver="this.className='button_over';" 
	        onMouseOut="this.className='button';"  onClick="history.go(-1);">
	        <img src="${pageContext.request.contextPath}/ui/images/button/fanhui.png" border='0' 
	             align='absmiddle'>&nbsp;返回</button>
</div>
<table width="100%" border="0" cellspacing="0" class="tabForm">
  <tr>
    <th colspan="4" align="left" class="th_head">
		<div id="menuArrow1" style="background:url(${pageContext.request.contextPath}/ui/images/down.gif) no-repeat center;float:left;">&nbsp;</div>
		<div id="menuTitle1" style="font-weight:bold">基本信息</div>
	</th>
  </tr>
  <tr>
  	<td>
		<div id="menu1">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td width="16%"></td>
				<td width="34%"></td>
				<td width="16%"></td>
				<td width="34%"></td>
			</tr>			
			<tr>
				<td class="red">部门名称</td>
				<td><input name="name" type="text" style="width:90%"/></td>
				<td>部门负责人</td>
				<td><input name="principal" type="text" style="width:90%"/></td>
			</tr>
			<tr>
				<td height="40" valign="top">部门职能</td>
				<td colspan="3"><input name="incumbent" type="text" rows="3" style="width:96%"/></td>
			</tr>
			<tr>
				<td height="40" valign="top">备注</td>
				<td colspan="3"><input name="remark" id="remark" type="text" rows="3" /></td>
			</tr>
  		</table>
		</div>
	</td>
  </tr>
</table>
<br>
</form>
</body>
</html>