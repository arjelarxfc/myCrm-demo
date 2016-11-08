<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>选择权限</title>
<link href="${pageContext.request.contextPath}/ui/css/style_cn.css" rel="stylesheet" type="text/css">
<script src="${pageContext.request.contextPath}/ui/js/jquery-1.11.3.min.js" type="text/javascript"></script>

<style type="text/css">
<!--
fieldset div {
	float:left;
	width:24%;
	line-height:25px;
	text-align:left;
}
td div {
	float:left;
	width:24%;
	line-height:25px;
	text-align:left;
}
-->
</style>
<script language="javascript">
   function goSelect(id){
      var valueStr=$("#"+id).val();
	  var array=valueStr.split(",");
	  //array[0]是模块名，array[1]是模块的功能操作名
	  if(array[0] != array[1]){
	     if($("#"+id)[0].checked){
		 	 var supid=array[0]+"_"+array[0];
		 	 $("#"+ supid).attr("checked","checked"); 
		 }else{
		 	 var $jihe=$("input[type='checkbox'][value^="+array[0]+"]:not([value$="+array[0]+"])"); 
			 var flag=false;
			 
			 $jihe.each(function(index,domEle){
				 if(this.checked){
				 	flag=true;
					return;
				 }
			 });
			 
			 if(!flag){
			 	  var supid=array[0]+"_"+array[0];
		 	       $("#"+ supid).attr("checked",null); 
			 }
		 }
	  }
	  
	  if(array[0]==array[1]){
	  	 if($("#"+id)[0].checked){
		     $("input[type='checkbox'][value^="+array[0]+"]").attr("checked","checked");   	
		 }else{
		 	  $("input[type='checkbox'][value^="+array[0]+"]").attr("checked",null); 
		 }
	  }
  }
  
  function SelectAllBox(){
     $("input[type=checkbox][name=popedomModule]").attr("checked","checked");
  }

  function UnSelectAllBox(){
	     $("input[type=checkbox][name=popedomModule]").attr("checked",null);
  }
  
</script>
</head>

<body>
<form name="ActionForm" method="post" action="updatePopedom">
	<input type="hidden" name="id" value="${sysRole.id}" />
	<br/>
	<div class="control">
		<button type='button' class='button' onMouseOver="this.className='button_over';" 
		onMouseOut="this.className='button';"  onClick="SelectAllBox()"><img src="${pageContext.request.contextPath}/ui/images/button/quanbuxz.png" border='0' align='absmiddle'>&nbsp;全部选中</button>
		<button type='button' class='button' onMouseOver="this.className='button_over';" 
		onMouseOut="this.className='button';"  onClick="UnSelectAllBox()"><img src="${pageContext.request.contextPath}/ui/images/button/quanbubxz.png" border='0' align='absmiddle'>&nbsp;全部不选中</button>
		<button id="save_button" type='button' class='button' onMouseOver="this.className='button_over';" 
		onMouseOut="this.className='button';" ><img src="${pageContext.request.contextPath}/ui/images/button/baocun.png" border='0' align='absmiddle'>&nbsp;保存</button>
		<button id="close_button" type='button' class='button' onMouseOver="this.className='button_over';" 
		onMouseOut="this.className='button';"><img src="${pageContext.request.contextPath}/ui/images/button/guanbi.png" border='0' align='absmiddle'>&nbsp;关闭</button>
	</div>

	<table width="100%" border="0" cellpadding="0" cellspacing="0" bgcolor="#6A82A8">
		<tr>
			<td align="center" height="25"><span style="color:#FFFFFF; font-weight:bold">操作权限组：${sysRole.name}</span></td>
		</tr>
	</table>
<div class="border" style="padding:3px">
<c:if test="${! empty sysPopedoms}">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td>
		  <c:forEach items="${sysPopedoms}" var="sysPopedomSup">
			<c:if test="${sysPopedomSup.sysPopedomKey.popedomModule==sysPopedomSup.sysPopedomKey.popedomPrivilege}">
				<fieldset style='padding:5px;clear:left;'>
				
				<!-- 遍历权限组包含的权限 处理父的复选框回显 -->
					<c:forEach items="${sysPopedomPriviles}" var="sysPopedomPrivile">
                          <c:if test="${sysPopedomSup.sysPopedomKey.popedomModule==sysPopedomPrivile.sysPopedomKey.popedomModule
                                       &&sysPopedomSup.sysPopedomKey.popedomPrivilege==sysPopedomPrivile.sysPopedomKey.popedomPrivilege}">
                              <c:set value="checked" var="xx" scope="page"/>
                          </c:if>	
				 	</c:forEach>
					 	
					<legend><input type='checkbox' class='checkbox' name='popedomModule'    ${xx}
							   value='${sysPopedomSup.sysPopedomKey.popedomModule},${sysPopedomSup.sysPopedomKey.popedomPrivilege}'
							   id='${sysPopedomSup.sysPopedomKey.popedomModule}_${sysPopedomSup.sysPopedomKey.popedomPrivilege}'  title="${sysPopedomSup.title}" 
							   onClick='goSelect(this.id)'>${sysPopedomSup.popedomName}
					</legend>
					<c:remove var="xx" scope="page"/>
				<!-- 遍历权限组包含的权限   处理父的复选框回显-->
					
					<c:forEach items="${sysPopedoms}" var="sysPopedomSub">   
					<!-- 模块名称和父级相同，而其自己的模块名和权限操作名不同 -->
						<c:if test="${sysPopedomSup.sysPopedomKey.popedomModule==sysPopedomSub.sysPopedomKey.popedomModule
							&&sysPopedomSub.sysPopedomKey.popedomModule!=sysPopedomSub.sysPopedomKey.popedomPrivilege}">
							
							<!-- 遍历权限组包含的权限 处理子的复选框回显 -->
						    <c:forEach items="${sysPopedomPriviles}" var="sysPopedomPrivile">
		                    	<c:if test="${sysPopedomSub.sysPopedomKey.popedomModule==sysPopedomPrivile.sysPopedomKey.popedomModule
	                        		&&sysPopedomSub.sysPopedomKey.popedomPrivilege==sysPopedomPrivile.sysPopedomKey.popedomPrivilege}">
	                        		<c:set value="checked" var="xxx" scope="page"/>
		                    	</c:if>
				 	        </c:forEach>
							
							<div><input type='checkbox' class='checkbox' name='popedomModule'   ${xxx}
							   value='${sysPopedomSub.sysPopedomKey.popedomModule},${sysPopedomSub.sysPopedomKey.popedomPrivilege}'
							   id='${sysPopedomSub.sysPopedomKey.popedomModule}_${sysPopedomSub.sysPopedomKey.popedomPrivilege}'  title="${sysPopedomSub.title}" 
							   onClick='goSelect(this.id)'>${sysPopedomSub.popedomName}</div>
							   
							<c:remove var="xxx" scope="page"/>
							<!-- 遍历权限组包含的权限 处理子的复选框回显 -->
						</c:if>
					</c:forEach>
				</fieldset>
			</c:if>
		 </c:forEach>
       </td>
	</tr>
</table>
</c:if>
</div>
</form>  
<script type="text/javascript">
  $("#save_button").click(function() {
	var inputs=$("input[type='checkbox'][class='checkbox'][name='popedomModule']");
	inputs.each(function(i,n){
		
	});
	document.ActionForm.submit();
  });
  $("#close_button").click(function() {
	  parent.close();
  });
</script>
</body>
</html>