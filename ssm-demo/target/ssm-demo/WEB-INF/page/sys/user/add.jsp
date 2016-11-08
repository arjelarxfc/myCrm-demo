<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>人员添加</title>
<link href="${pageContext.request.contextPath}/ui/css/style_cn.css" rel="stylesheet" type="text/css">

<!--处理日期 开始 -->
<script src="${pageContext.request.contextPath}/ui/js/jquery-1.4.2.js" type="text/javascript"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/ui/js/date_input/jquery.datepick.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/ui/js/date_input/jquery.datepick-zh-CN.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/ui/js/date_input/calendar.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/ui/js/date_input/jquery.datepick.css" type="text/css">
<!--处理日期结束  -->
</head>
<body>
<form name="form1" method="post" action="add">
<div class="mtitle">
	<div class="mtitle-row">&nbsp;</div>
	人员-添加
</div>
<br>
<div class="control">
	<button id="addUser" type='button' class='button' onMouseOver="this.className='button_over';" 
	        onMouseOut="this.className='button';"  onClick="">
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
				<td class="red">用户名：</td>
				<td><input id="username" type="text"  name="name"  id="name" style="width:90%"/></td>
				<td class="red">中文名：</td>
				<td><input id="cnName" name="cnname" style="width:90%"/></td>
			</tr>
			<tr>
				<td class="red">密码：</td>
				<td> <input id="pwd" name="password" id="password" type="password" style="width:90%" /></td>
				<td>推荐人：</td>
				<td><input  name="commendman" type="text" id="commendman" style="width:90%"/></td>
			</tr>
			<tr>
				<td>移动电话：</td>
				<td><input  name="movetelePhone" type="text" id="movetelePhone" style="width:90%"/></td>
				<td>电子邮件：</td>
				<td><input  name="email"  type="text" id="email" style="width:90%"/></td>
			</tr>
			<tr>
				<td>家庭地址：</td>
				<td><input  name="address" type="text" id="address" style="width:90%"/></td>
				<td>家庭电话：</td>
				<td><input  name="telephone"  id="telephone" style="width:90%"/></td>
			</tr>
			<tr>
				<td>现住宅地址：</td>
				<td><input  name="nowAddress" type="text" id="nowAddress" style="width:90%"/></td>
				<td>现住宅电话：</td>
				<td><input  name="nowtelePhone" type="text" id="nowtelePhone" style="width:90%"/></td>
			</tr>
			<tr>
				<td>身份证号码：</td>
				<td><input  name="identityCode"  type="text" id="identityCode" style="width:90%"/></td>
				<td>社会保险号：</td>
				<td><input  name="insuranceCode"  type="text" id="insuranceCode" style="width:90%"/></td>
			</tr>
			<tr>
				<td>紧急联系人：</td>
				<td><input  name="instancyLinkman"  type="text" id="instancyLinkman" style="width:90%"/></td>
				<td>紧急联系电话：</td>
				<td><input  name="instancytelePhone" type="text" id="instancytelePhone" style="width:90%"/></td>
			</tr>
			<tr>
				<td>起始有效期：</td>
				<td><input  name="beginDate"  type="text" id="beginDate" style="width:90%"/></td>
				<td>终止有效期：</td>
				<td><input  name="endDate"  type="text" id="endDate" style="width:90%"/></td>
			</tr>
			<tr>
				<td class="red">操作权限组：</td>
				<td>
					<select id="sysRoleSelect" name="sysRoleId"></select>
               </td>
					<td class="red">所属部门：</td>
				<td>
					<select id="sysUserGroupSelect" name="sysUserGroupId"></select>
                </td>
			</tr>
			<tr>
				<td id="userStatus" class="red">状态：</td>
				<td>
					<input type="radio" name="status" id="" value="Y"/>启用 
					<input type="radio" name="status" id="" value="N"/>停用
				</td>
			</tr>
  		</table>
		</div>
	</td>
  </tr>
</table>
<br>
<table width="100%" border="0" cellspacing="0" class="tabForm">
  <tr>
    <th colspan="4" align="left" class="th_head">
		<div id="menuArrow2" style="background:url(${pageContext.request.contextPath}/ui/images/down.gif) no-repeat center;float:left;">&nbsp;</div>
		<div id="menuTitle2" style="font-weight:bold">详细信息</div>
	</th>
  </tr>
  <tr>
  	<td>
		<div id="menu2">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td width="16%"></td>
				<td width="34%"></td>
				<td width="16%"></td>
				<td width="34%"></td>
			</tr>			
			<tr>
				<td>性别：</td>
				<td>
					<input type="radio" name="sex" id="" class="radio"/>男
					<input type="radio" name="sex" id="" class="radio"/>女
				<td>出生日期：</td>
				<td><input  name="birthday" type="text" class="dateClassStyle" id="birthday" style="width:90%"/></td>
			</tr>
			<tr>
				<td>职员类别：</td>
				<td>
					<input type="radio" name="personnelType" id="" class="radio"/>全职
					<input type="radio" name="personnelType" id="" class="radio"/>兼职
				</td>
				<td>职务：</td>
				<td><input name="duty" type="text" class="input" id="duty" style="width:90%"/></td>
			</tr>
			<tr>
				<td>入职时间：</td>
				<td><input name="workDate"  class="dateClassStyle" id="workDate" style="width:90%"/></td>
				<td>最高学历：</td>
				<td><input name="highSchool" type="text" class="input" id="highSchool" style="width:90%"/></td>
			</tr>
			<tr>
				<td>毕业学校：</td>
				<td><input name="finishSchool" type="text" class="input" id="finishSchool" cssStyle="width:90%"/></td>
				<td>毕业时间：</td>
				<td><input type="text" name="finishSchoolDate"  class="dateClassStyle" id="finishSchoolDate" style="width:90%"/></td>
			</tr>
			<tr>
				<td>配偶姓名：</td>
				<td><input type="text" name="consortName"  class="input" id="consortName" style="width:90%"/></td>
				<td>子女姓名：</td>
				<td><input type="text" name="youngoneName"  class="input" id="youngoneName" style="width:90%"/></td>
			</tr>
			<tr>
				<td>办公电话：</td>
				<td><input type="text" name="officetelePhone"  class="input" id="officetelePhone" style="width:90%"/></td>
				<td>配偶电话：</td>
				<td><input type="text" name="consorttelePhone"  class="input" id="consorttelePhone" style="width:90%"/></td>
			</tr>
			<tr>
				<td>业余爱好：</td>
				<td colspan="3"><input type="text" name="avocation"  class="input" id="avocation" style="width:90%"/></td>
			</tr>
			<tr>
				<td>配偶工作单位：</td>
				<td colspan="3"><input type="text" name="consortCompany"  class="input" id="consortCompany" style="width:90%"/></td>
			</tr>
			<tr>
				<td>备注：</td>
				<td colspan="3"><input type="text" name="remark" id="remark" rows="3" style="width:96%" /></td>
		    </tr>		
  		</table>
		</div>
	</td>
  </tr>
</table>
<br>
<table width="100%" border="0" cellspacing="0" class="tabForm">
  <tr>
    <th colspan="4" align="left" class="th_head">
		<div id="menuArrow3" style="background:url(${pageContext.request.contextPath}/ui/images/down.gif) no-repeat center;float:left;">&nbsp;</div>
		<div id="menuTitle3" style="font-weight:bold">职业技能</div>
	</th>
  </tr>
  <tr>
  	<td>
		<div id="menu3">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td width="16%"></td>
				<td width="34%"></td>
				<td width="16%"></td>
				<td width="34%"></td>
			</tr>			
			<tr>
				<td>偏好特长：</td>
				<td><input type="text" name="strongSuit" id="strongSuit" rows="3" style="width:90%" /></td>
				<td>信息沟通：</td>
				<td><input type="text" name="commUniCate" id="commUniCate" rows="3" style="width:90%" /></td>
			</tr>
			<tr>
				<td>培训情况：</td>
				<td><input type="text" name="bringup" id="bringup" rows="3" style="width:90%" /></td>
				<td>组织能力：</td>
				<td><input type="text" name="organise" id="organise" rows="3" style="width:90%" /></td>
			</tr>
			<tr>
				<td>分析能力：</td>
				<td><input type="text" name="analyse" id="analyse" rows="3" style="width:90%" /></td>
				<td>计划能力：</td>
				<td><input type="text" name="planing" id="planing" rows="3" style="width:90%" /></td>
			</tr>
			<tr>
				<td>人员开发：</td>
				<td><input type="text" name="empolder" id="empolder" rows="3" style="width:90%" /></td>
				<td>人际关系：</td>
				<td><input type="text" name="relation" id="relation" rows="3" style="width:90%" /></td>
			</tr>
  		</table>
		</div>
	</td>
  </tr>
</table>
<br>
<table width="100%" border="0" cellspacing="0" class="tabForm">
  <tr>
    <th colspan="4" align="left" class="th_head">
		<div id="menuArrow4" style="background:url(${pageContext.request.contextPath}/ui/images/down.gif) no-repeat center;float:left;">&nbsp;</div>
		<div id="menuTitle4" style="font-weight:bold">系统信息</div>
	</th>
  </tr>
  <tr>
  	<td>
		<div id="menu4">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td width="16%"></td>
				<td width="34%"></td>
				<td width="16%"></td>
				<td width="34%"></td>
			</tr>
			<tr>
				<td>创建人：</td>
				<td><input type="text" name="creator"  class="disabled" id="creator"  readonly="true"/></td>
				<td>创建时间：</td>
				<td><input type="text" name="createTime"  class="disabled" id="createTime" readonly="true"/></td>
			</tr>
			<tr>
				<td>修改人：</td>
				<td><input type="text" name="updater"  class="disabled" id="updater" readonly="true"/>
				</td>
				<td>修改时间：</td>
				<td><input type="text" name="updateTime"  class="disabled" id="updateTime" readonly="true"/>
				</td>
			</tr>
  		</table>
		</div>
	</td>
  </tr>
</table>
<br>
</form>
<script src="${pageContext.request.contextPath}/ui/js/menu.js" type="text/javascript"></script>
<script type="text/javascript">
	$.ajax({
		url:"json/sysRoleSelect",
		dataType:"json",
		type : "get", 
		contentType : 'application/json',
		success: function(data){
			if(data.length==0){
				$("#sysRoleSelect").hide();
			}else{
				var length=data.length;
				$("#sysRoleSelect").html("");
				$.each(data,function(i,item){
					$("#sysRoleSelect").append("<option value='"+item.id+"'>"+item.name+"</option>");	
				});	
			}
		}
	});
	
	$.ajax({
		url:"json/sysUserGroupSelect",
		dataType:"json",
		type : "get", 
		contentType : 'application/json',
		success: function(data){
			if(data.length==0){
				$("#sysUserGroupSelect").hide();
			}else{
				var length=data.length;
				$("#sysUserGroupSelect").html("");
				$.each(data,function(i,item){
					$("#sysUserGroupSelect").append("<option value='"+item.id+"'>"+item.name+"</option>");	
				});	
			}
		}
	});

	//验证不能为空的
	$("#addUser").click(function(){
		var status=$("input[name='status']:checked").val();
		if($("#username").val()==""||$("#username").val()==null){
			alert("用户名没有吗！");
			return;	
		}
		if($("#cnName").val()==""||$("#cnName").val()==null){
			alert("中文名没有吗！");
			return;	
		}
		if($("#pwd").val()==""||$("#pwd").val()==null){
			alert("密码没有吗！");
			return;	
		}
		if(status==undefined){
			alert("状态没选！");
			return;
		}
		document.forms[0].submit();
	});
</script>
</body>
</html>