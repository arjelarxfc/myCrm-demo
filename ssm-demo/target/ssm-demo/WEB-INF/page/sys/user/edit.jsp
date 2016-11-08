<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>人员修改</title>
<link href="${pageContext.request.contextPath}/ui/css/style_cn.css" rel="stylesheet" type="text/css">
<script src="${pageContext.request.contextPath}/ui/js/popshow.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/ui/js/win.js" type="text/javascript"></script>

<!--处理日期 开始 -->
<script src="${pageContext.request.contextPath}/ui/js/jquery-1.4.2.js" type="text/javascript"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/ui/js/date_input/jquery.datepick.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/ui/js/date_input/jquery.datepick-zh-CN.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/ui/js/date_input/calendar.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/ui/js/date_input/jquery.datepick.css" type="text/css">
<!--处理日期结束  -->
</head>

<body>
<form name="form1" method="post" action="update">
<input id="sysUserId" type="hidden" name="id" value="${sysUser.id}"/>
<div class="mtitle">
	<div class="mtitle-row">&nbsp;</div>
	人员-修改
</div>
<br>
<div class="control">
   <!-- 组织修改密码的链接 
   <s:url value="/sys/user/loadPassword.jsp" var="url">
       <s:param name="id" value="id"></s:param>
       <s:param name="name" value="name"></s:param>
       <s:param name="cnname" value="cnname"></s:param>
   </s:url>-->
   
	<button type='button' class='button' onMouseOver="this.className='button_over';" onMouseOut="this.className='button';"  
	        onClick="document.forms[0].submit();">
	        <img src="${pageContext.request.contextPath}/ui/images/button/baocun.png" border='0' 
	        align='absmiddle'>&nbsp;保存</button>
	<button type='button' class='button' onMouseOver="this.className='button_over';" onMouseOut="this.className='button';"  
	        onClick="OpenDiv('${url}')">
	        <img src="${pageContext.request.contextPath}/ui/images/button/xgmm.png" border='0' 
	        align='absmiddle'>&nbsp;修改密码</button>
	<button type='button' class='button' onMouseOver="this.className='button_over';" onMouseOut="this.className='button';"  
	        onClick="OpenWin('/sys/user/user.do?method=print&id=12')">
	        <img src="${pageContext.request.contextPath}/ui/images/button/dayin.png" border='0' 
	        align='absmiddle'>&nbsp;打印</button>
	<button type='button' class='button' onMouseOver="this.className='button_over';" onMouseOut="this.className='button';"  
	       onClick="history.go(-1);">
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
				<td><input type="text"  name="name"  id="name"  class="disabled" value="${sysUser.name}" style="width:90%"  readonly="true"/></td>
				<td class="red">中文名：</td>
				<td>
				   <input  name="cnName"  id="cnname"  class="input" value="${sysUser.cnName}" style="width:90%"/>
				</td>
			</tr>
			<tr>
				<td class="red">密码：</td>
				<td><input type="password" name="password" id="password" value="${sysUser.password}" class="disabled" 
				style="width:90%"  readonly="true"/></td>
				<td>推荐人：</td>
				<td><input type="text" name="commendMan" value="${sysUser.commendMan}" class="input" id="commendman" style="width:90%"/></td>
			</tr>
			<tr>
				<td>移动电话：</td>
				<td><input type="text" name="movetelePhone" value="${sysUser.movetelePhone}" class="input" id="movetelePhone" style="width:90%"/></td>
				<td>电子邮件：</td>
				<td><input type="text" name="email" value="${sysUser.email}" class="input" id="email" style="width:90%"/></td>
			</tr>
			<tr>
				<td>家庭地址：</td>
				<td><input type="text" name="address" value="${sysUser.address}" class="input" id="address" style="width:90%"/></td>
				<td>家庭电话：</td>
				<td><input type="text" name="telephone" value="${sysUser.telephone}" class="input" id="telephone" style="width:90%"/></td>
			</tr>
			<tr>
				<td>现住宅地址：</td>
				<td><input type="text" name="nowAddress" value="${sysUser.nowAddress}" class="input" id="nowAddress" style="width:90%"/></td>
				<td>现住宅电话：</td>
				<td><input type="text" name="nowtelePhone" value="${sysUser.nowtelePhone}" class="input" id="nowtelePhone" style="width:90%"/></td>
			</tr>
			<tr>
				<td>身份证号码：</td>
				<td><input type="text" name="identityCode" value="${sysUser.identityCode}" class="input" id="identityCode" style="width:90%"/></td>
				<td>社会保险号：</td>
				<td><input type="text" name="insuranceCode" value="${sysUser.insuranceCode}" class="input" id="insuranceCode" style="width:90%"/></td>
			</tr>
			<tr>
				<td>紧急联系人：</td>
				<td><input type="text" name="instancyLinkman" value="${sysUser.instancyLinkman}" class="input" id="instancyLinkman" style="width:90%"/></td>
				<td>紧急联系电话：</td>
				<td><input type="text" name="instancytelePhone" value="${sysUser.instancytelePhone}" class="input" id="instancytelePhone" style="width:90%"/></td>
			</tr>
			<tr>
				<td>起始有效期：</td>
				<td><input type="text" name="beginDate" value="${sysUser.beginDate}" class="dateClassStyle" id="beginDate" style="width:90%"/></td>
				<td>终止有效期：</td>
				<td><input type="text" name="endDate"  class="dateClassStyle" value="${sysUser.endDate}" id="endDate" style="width:90%"/></td>
			</tr>
			<tr>
				<td class="red">操作权限组：</td>
				<td>
					<input id="sysRoleId" type="hidden" value="${sysUser.sysRoleModel.id}">
					<select id="sysRoleSelect" name="sysRoleId"></select>
               </td>
					<td class="red">所属部门：</td>
				<td>
					<input id="sysUserGroupId" type="hidden" value="${sysUser.sysUserGroupModel.id}">
				 	<select id="sysUserGroupSelect" name="sysUserGroupId"></select>
                </td>
			</tr>
			<tr>
				<td class="red">状态：</td>
				<td>
					<input id="sysUserStatus" class="status" type="hidden" value="${sysUser.status}">
					<input class="" type="radio" name="status" id="" value="Y"/>启用
					<input class="" type="radio" name="status" id="" value="N"/>停用
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
					<input id="sysUserSex" class="status" type="hidden" value="${sysUser.sex}">
					<input type="radio" name="sex" id="" value="male"/>男
					<input type="radio" name="sex" id="" value="female"/>女
				</td>
				<td>出生日期：</td>
				<td><input type="text" name="birthday" value="${sysUser.nowtelePhone}" class="dateClassStyle" id="birthday" style="width:90%"/></td>
			</tr>
			<tr>
				<td>职员类别：</td>
				<td>
					<input id="sysUserPersonnelType" class="status" type="hidden" value="${sysUser.personnelType}">
					<input type="radio" name="personnelType" id="" value="fullTime"/>全职
					<input type="radio" name="personnelType" id="" value="partTime"/>兼职
				</td>
				<td>职务：</td>
				<td><input type="text" name="duty" id="duty" value="${sysUser.duty}" style="width:90%"/></td>
			</tr>
			<tr>
				<td>入职时间：</td>
				<td><input type="text" name="workDate" value="${sysUser.workDate}" class="dateClassStyle" id="workDate" style="width:90%"/></td>
				<td>最高学历：</td>
				<td><input type="text" name="highSchool" value="${sysUser.highSchool}" class="input" id="highSchool" style="width:90%"/></td>
			</tr>
			<tr>
				<td>毕业学校：</td>
				<td><input type="text" name="finishSchool" value="${sysUser.finishSchool}" class="input" id="finishSchool" style="width:90%"/></td>
				<td>毕业时间：</td>
				<td><input type="text" name="finishSchoolDate" value="${sysUser.finishSchoolDate}" cssClass="dateClassStyle" id="finishSchoolDate" style="width:90%"/></td>
			</tr>
			<tr>
				<td>配偶姓名：</td>
				<td><input type="text" name="consortName" value="${sysUser.consortName}" class="input" id="consortName" style="width:90%"/></td>
				<td>子女姓名：</td>
				<td><input type="text" name="youngoneName" value="${sysUser.youngoneName}" class="input" id="youngoneName" style="width:90%"/></td>
			</tr>
			<tr>
				<td>办公电话：</td>
				<td><input type="text" name="officetelePhone" value="${sysUser.officetelePhone}" class="input" id="officetelePhone" style="width:90%"/></td>
				<td>配偶电话：</td>
				<td><input type="text" name="consorttelePhone" value="${sysUser.consorttelePhone}" class="input" id="consorttelePhone" style="width:90%"/></td>
			</tr>
			<tr>
				<td>业余爱好：</td>
				<td colspan="3"><input type="text" name="avocation" value="${sysUser.avocation}" class="input" id="avocation" style="width:90%"/></td>
			</tr>
			<tr>
				<td>配偶工作单位：</td>
				<td colspan="3"><input type="text" name="consortCompany" value="${sysUser.consortCompany}" class="input" id="consortCompany" style="width:90%"/></td>
			</tr>
			<tr>
				<td>备注：</td>
				<td colspan="3"><input type="text" name="remark" id="remark" rows="3" value="${sysUser.remark}" style="width:96%" /></td>
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
				<td><input type="text" name="strongSuit" id="strongSuit" value="${sysUser.strongSuit}" rows="3" style="width:90%" /></td>
				<td>信息沟通：</td>
				<td><input type="text" name="commUniCate" id="commUniCate" value="${sysUser.commUniCate}" rows="3" style="width:90%" /></td>
			</tr>
			<tr>
				<td>培训情况：</td>
				<td><input type="text" name="bringup" id="bringup" value="${sysUser.bringup}" rows="3" style="width:90%" /></td>
				<td>组织能力：</td>
				<td><input type="text" name="organise" id="organise" value="${sysUser.organise}" rows="3" style="width:90%" /></td>
			</tr>
			<tr>
				<td>分析能力：</td>
				<td><input type="text" name="analyse" id="analyse" value="${sysUser.analyse}" rows="3" style="width:90%" /></td>
				<td>计划能力：</td>
				<td><input type="text" name="planing" id="planing" value="${sysUser.planing}" rows="3" style="width:90%" /></td>
			</tr>
			<tr>
				<td>人员开发：</td>
				<td><input type="text" name="empolder" id="empolder" value="${sysUser.empolder}" rows="3" style="width:90%" /></td>
				<td>人际关系：</td>
				<td><input type="text" name="relation" id="relation" value="${sysUser.relation}" rows="3" style="width:90%" /></td>
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
				<td><input type="text" name="creator" value="${sysUser.creator}"  class="disabled" id="creator"  readonly="readonly"/></td>
				<td>创建时间：</td>
				<td><input type="text" name="createTime" value="${sysUser.createTime}" class="disabled" id="createTime" readonly="readonly"/></td>
			</tr>
			<tr>
				<td>修改人：</td>
				<td>
				  <input type="hidden" name="updaterStr"  />
				  <input type="text" name="updater" value="${sysUser.updater}" class="disabled" id="updater" readonly="readonly"/>
				</td>
				<td>修改时间：</td>
				<td>
				  <input type="hidden" name="updateTimeStr"  />
				  <input type="text"  name="updateTime"  class="disabled" id="updateTime" value="${sysUser.updateTime}" readonly="readonly"/>
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
<div id="popshow" style='border:1px solid #6A82A8;width=650px;position: absolute; visibility: hidden; left: 0; top: 0; z-index: 10;'>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr style='background-color:#6A82A8;'>
		<th width='80%' height="25" align='left' onMouseDown="initializedragie(popshow)" style="cursor:move" onselectstart="return false">
		<font color='#FFFFFF'>&nbsp;修改密码</font>
		</th>
		<td align='right' onselectstart="return false">	
			<a href='#' onClick="close_window();">
			<img src="${pageContext.request.contextPath}/ui/images/xpclose.jpg" width="20" height="20" border="0" onClick="" align="absmiddle"></a>
		</td>
	</tr>
	<tr>
		<td colspan="2" onselectstart="return false">
		<div id='gedit'></div>
		</td>
	</tr>
</table>
<iframe src="javascript:false" style="position:absolute; visibility:inherit; top:0px; left:0px; width:100%; height:100%; z-index:-1; filter='progid:DXImageTransform.Microsoft.Alpha(style=0,opacity=0)'; frameborder='0';"></iframe>
</div>
</body>
<script type="text/javascript">
	var sysUserGroupId=$("#sysUserGroupId").val();
	var sysRoleId=$("#sysRoleId").val();
	$.ajax({
		url:"json/sysRoleSelect?id="+$('#sysUserId').val()+"",
		dataType:"json",
		type : "get", 
		contentType : 'application/json',
		success: function(data){
			if(data==null || data.length==0){
				$("#sysRoleSelect").hide();
			}else{
				var length=data.length;
				$("#sysRoleSelect").html("");
				$.each(data,function(i,item){
					if(item.id==sysRoleId){
						$("#sysRoleSelect").append("<option selected value='"+item.id+"'>"+item.name+"</option>");	
					}else{
						$("#sysRoleSelect").append("<option value='"+item.id+"'>"+item.name+"</option>");	
					}
				});	
			}
		}
	});
	//下拉选
	$.ajax({
		url:"json/sysUserGroupSelect?id="+$('#sysUserId').val()+"",
		dataType:"json",
		type : "get", 
		contentType : 'application/json',
		success: function(data){
			if(data==null || data.length==0){
				$("#sysUserGroupSelect").hide();
			}else{
				$("#sysUserGroupSelect").html("");
				$.each(data,function(i,item){
					if(item.id==sysUserGroupId){
						$("#sysUserGroupSelect").append("<option selected value='"+item.id+"'>"+item.name+"</option>");	
					}else{
						$("#sysUserGroupSelect").append("<option value='"+item.id+"'>"+item.name+"</option>");	
					}
				});	
			}
		}
	});
	//设置单选按钮
	var status=$("#sysUserStatus").val();
	var personnelType=$("#sysUserPersonnelType").val();
	var sex=$("#sysUserSex").val();
	if(sex=='男'){
		sex='male';
	}else{
		sex='female';
	}
	//
	if($("input[type='radio'][name='status'][value='Y']").val()==status){
		$("input[type='radio'][name='status'][value='Y']").attr("checked",true);
	}else{
		$("input[type='radio'][name='status'][value='N']").attr("checked",true);
	}
	//
	if($("input[type='radio'][name='sex'][value='male']").val()==sex){
		$("input[type='radio'][name='sex'][value='male']").attr("checked",true);
	}else{
		$("input[type='radio'][name='sex'][value='female']").attr("checked",true);
	}
	//
	if($("input[type='radio'][name='personnelType'][value='partTime']").val()==personnelType){
		$("input[type='radio'][name='personnelType'][value='partTime']").attr("checked",true);
	}else{
		$("input[type='radio'][name='personnelType'][value='fullTime']").attr("checked",true);
	}
	
</script>
</html>