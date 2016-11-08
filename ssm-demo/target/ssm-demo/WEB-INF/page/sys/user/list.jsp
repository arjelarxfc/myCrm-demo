<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>人事管理</title>
<script src="${pageContext.request.contextPath}/ui/js/jquery-1.4.2.js" type="text/javascript"></script>
<link href="${pageContext.request.contextPath}/ui/css/style_cn.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
function forward(strURL){
     window.location=strURL;
}

//删除
function deleteIds(){
	var con=confirm("确定删除吗？");
	if(con){
        document.forms[1].action="delete";
	    document.forms[1].submit();
	}else{
		return;
	}
}

//启用
function  enable(){
	var con=confirm("确定启动吗？");
	if(con){
		document.forms[1].action="enable";
	    document.forms[1].submit();
	}else{
		return;	
	}
}

//停用
function  disable(){
	var con=confirm("确定停用吗？");
	if(con){
	  	document.forms[1].action="disable";
    	document.forms[1].submit();
	}else{
		return;		
	}
}

</script>
</head>

<body>
<div class="mtitle">
	<div class="mtitle-row">&nbsp;</div>
	<span class="menu_selected">人事管理</span>
</div>
<br>
<table width="100%" border="0" cellspacing="0" cellpadding="0" class="tabForm">
  <tr>
    <th class="th_head">
		<div id="menuArrow1" style="background:url(${pageContext.request.contextPath}/ui/images/down.gif) no-repeat center;float:left;">&nbsp;</div>
		<div id="menuTitle1" style="font-weight:bold">人员搜索</div>
	</th>
    <th class="th_head" >
	</th>
  </tr>
  <tr>
	  <td colspan="2">
		<form name="form1" method="post" action="sysUserAction_list.do">
		  <table id="base" width="100%" border="0" cellspacing="0" cellpadding="0" name="base">
			<tr>
		  	    <td width="13%" nowrap="nowrap">用户名：</td>
		   	    <td width="12%" nowrap="nowrap">
		   	        <input name="name" id="name" style="width:100px" value=""/>
				</td>
		  	    <td width="13%" nowrap="nowrap">中文名：</td>
				<td width="12%" nowrap="nowrap">
				    <input name="cnname" id="cnname" style="width:100px"  value=""/>
				</td>
				<td width="13%" nowrap="nowrap">所属部门：</td>
				<td width="12%" nowrap="nowrap">
				   <c:if test="${! empty sysUserGroupSelect}">
					   <!-- <s:select list="sysUserGroupSelect"  id='groupId'  name="groupId" cssStyle='width:90%'
							          listKey="id" listValue="name" headerKey=""  headerValue="--------">
					   </s:select> -->
					   <select id='groupId'  name="groupId" style="width:90%">
					   	    <option value ="volvo">Volvo</option>
							<option value ="saab">Saab</option>
							<option value="opel">Opel</option>
							<option value="audi">Audi</option>
					   </select>
				   </c:if>
					</td>
		  	    <td width="25%" align="center">
					<div class="control">
						<button type='button' class='button' onMouseOver="this.className='button_over';" 
						        onMouseOut="this.className='button';" onClick="toSearch(1,${pageBean.maxSize})">
						        <img src="${pageContext.request.contextPath}/ui/images/button/sousuo.png" border='0' 
						        align='absmiddle'>&nbsp;搜索</button>
		      		    <button type='button' class='button' 
		      			        onMouseOver="this.className='button_over';" onMouseOut="this.className='button';" 
		          			    onClick="forward('user.do?method=search')">
		          			    <img src="${pageContext.request.contextPath}/ui/images/button/qingkong.png" border='0' 
		          			    align='absmiddle'>&nbsp;清空</button>
					</div>
				</td>
			</tr>
			<tr>
				<td>状态：</td>
				<td>	<%-- <s:radio list="#{'Y':'启用','N':'停用'}"  name="status" id="status"  
						         listKey="key" listValue="value" /> --%>
					启用&nbsp;<input id="" type="radio" name="status" value="Y"/>
					停用&nbsp;<input id="" type="radio" name="status" value="N"/>		         
				</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
			</tr>
		  </table>
		</form>
	  </td>
  </tr>
</table>
<br>
<h3><img src="${pageContext.request.contextPath}/ui/images/menu/khlb.png" border="0">&nbsp;人员列表</h3>
<div class="control">
	<button type='button' class='button' onMouseOver="this.className='button_over';" 
	        onMouseOut="this.className='button';"  
	        onClick="forward('${pageContext.request.contextPath}/crm/sys/user/addpage')">
	        <img src="${pageContext.request.contextPath}/ui/images/button/xinjian.png" border='0' 
	        align='absmiddle'>&nbsp;新建</button>
	<button type='button' class='button' onMouseOver="this.className='button_over';" 
	        onMouseOut="this.className='button';"  onClick="enable()">
	        <img src="${pageContext.request.contextPath}/ui/images/button/qiyong.png" border='0' 
	        align='absmiddle'>&nbsp;启用</button>
	<button type='button' class='button' onMouseOver="this.className='button_over';" 
	        onMouseOut="this.className='button';"  onClick="disable()">
	        <img src="${pageContext.request.contextPath}/ui/images/button/tingyong.png" border='0' 
	        align='absmiddle'>&nbsp;停用</button>
	<button type='button' class='button' onMouseOver="this.className='button_over';" 
	        onMouseOut="this.className='button';"  
	        onClick="deleteIds()">
	        <img src="${pageContext.request.contextPath}/ui/images/button/shanchu.png" border='0' 
	        align='absmiddle'>&nbsp;删除</button>
</div>
<!-- list -->
<div class="border">
<form name="form2" method="post" action="delete">
<table width="100%" border="0" cellspacing="0" cellpadding="0" id="PowerTable" class="PowerTable">
	<!-- title -->
	<tr>
    	<td width="4%" class="listViewThS1">
   	    	<input name="checkall"  id="checkall"  type="checkbox"  onClick="checkAll();"/></td>
  	    <td width="13%" class="listViewThS1">用户名</td>
  	    <td width="13%" class="listViewThS1">中文名</td>
  	    <td width="15%" class="listViewThS1">操作权限组</td>
        <td width="10%" class="listViewThS1">所属部门</td>
        <td width="10%" class="listViewThS1">起始有效期</td>
		<td width="10%" class="listViewThS1">终止有效期</td>
		<td width="10%" class="listViewThS1">状态</td>
	</tr>
	<!-- data -->
 
  <c:if test="${! empty sysUsers}">
	  <c:forEach items="${sysUsers}" var="sysUser">
		<tr>
	    	<td>
	    	   <input name="ids" type="checkbox" value="${sysUser.id}" onclick="changeCheckCount();"/>
			</td>
	  	    <td><a href="edit?id=${sysUser.id}">${sysUser.name}</a></td>
	  	    <td>${sysUser.cnName}</td>
			<td>${sysUser.sysRoleModel.name}</td>
			<td>${sysUser.sysUserGroupModel.name}</td>
			<td>${sysUser.beginDate}</td>
			<td>${sysUser.endDate}</td>
			<td>
				<c:choose>  
				   <c:when test="${sysUser.status=='Y'}">
				   	<img src="${pageContext.request.contextPath}/ui/images/accept_inline.gif" width="13" height="13" border="0">
				   </c:when>  
				   <c:otherwise>
				   	<img src="${pageContext.request.contextPath}/ui/images/close_dashboard.gif" width="13" height="13" border="0">
				   </c:otherwise>  
				</c:choose>
			</td>
		</tr>
	  </c:forEach> 
	</c:if>
</table>
</form>
</div>
<script type="text/javascript">
   function changeCheckCount(){
       var count=0;
	   $("input[type='checkbox'][name='ids']").each(function(index,data){
            if(this.checked){
            	count++;  
            }
	   });
	   $("#slt_ids_count2").empty();
 	   $("#slt_ids_count2").append(count);

       if(count== $("input[type='checkbox'][name='ids']").length){
    	   $("#checkall").attr("checked","checked");
       }else{
    	   $("#checkall").attr("checked",null);
       }
   }
   
   function  checkAll(){
      if($("#checkall")[0].checked){
    	  $("input[type='checkbox'][name='ids']").attr("checked","checked");
    	  $("#slt_ids_count2").empty();
    	  $("#slt_ids_count2").append($("input[type='checkbox'][name='ids']").length);
      }else{
    	  $("input[type='checkbox'][name='ids']").attr("checked",null);
    	  $("#slt_ids_count2").empty();
    	  $("#slt_ids_count2").append(0);
      }
   }
 </script>
</body>
</html>