<%@ page language="java" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/myitcast.tld"  prefix="itcast"%>
<html>
<head>
 <title>菜单</title>
 <link rel="stylesheet" href="${pageContext.request.contextPath}/menu/css/jquery.treeview.css" />
 <link rel="stylesheet" href="${pageContext.request.contextPath}/menu/css/screen.css" />
 <script src="${pageContext.request.contextPath}/menu/js/jquery-1.4.2.js" type="text/javascript"></script>
 <script src="${pageContext.request.contextPath}/menu/js/jquery.treeview.js" type="text/javascript"></script>
<script type="text/javascript">
	$( function() {
		$("#tree").treeview( {
			collapsed : true,//初始化时的折叠状态
			animated : "medium",//设置展开子节点时的显示速度
			control : "#sidetreecontrol",
			persist : "location",//记忆折叠的方式
		//	unique: true //展开同级节点的唯一性
		});
	})
</script>
</head>
<body  ondblclick="ToggleNav();">
<c:if test="${! empty sysMenus}">
<div id="main">
<div id="sidetree">
	<div class="treeheader">操作菜单</div>
		<div id="sidetreecontrol"><a href="?#">Collapse All</a> | <a href="?#">Expand All</a></div>
			<ul id="tree">
			    <c:forEach items="${sysMenus}" var="sysMenu">
			        <c:if test="${sysMenu.sysMenuKey.menuModule==sysMenu.sysMenuKey.menuPrivilege}">
					   <itcast:checkMemu  module="${sysMenu.sysMenuKey.menuModule}"   privilege="${sysMenu.sysMenuKey.menuPrivilege}">
						    <li><img src="${pageContext.request.contextPath}/ui/images${sysMenu.icon}" width="17" height="17">
						    <strong>${sysMenu.menuName}</strong>
						    <c:forEach items="${sysMenus}" var="sysMenuSub">
						      <c:if test="${sysMenuSub.sysMenuKey.menuModule!=sysMenuSub.sysMenuKey.menuPrivilege
						                    &&sysMenu.sysMenuKey.menuModule==sysMenuSub.sysMenuKey.menuModule}">
								 <itcast:checkMemu  module="${sysMenuSub.sysMenuKey.menuModule}"   privilege="${sysMenuSub.sysMenuKey.menuPrivilege}">
									<ul>
										<li><img src="${pageContext.request.contextPath}/ui/images${sysMenuSub.icon}" width="17" height="17">
										<a href="${pageContext.request.contextPath}${sysMenuSub.url}"  target="${sysMenuSub.target}">${sysMenuSub.menuName}</a></li>
									</ul>
							     </itcast:checkMemu>
							  </c:if>	
							</c:forEach>
						    </li>
					   </itcast:checkMemu>
				    </c:if>
			    </c:forEach>
			</ul>
		</div>
	</div>
</c:if>		
<div id="divCollapsedNav" class="navTocColor" style="display:none;width:100%;height:100%;"> 
  <a href="javascript:ToggleNav();" title="展开导航框架" id="linkNavClosed">
      <img src="${pageContext.request.contextPath}/menu/images/toc2.gif" alt="展开导航框架" border="3"></img>
  </a> 
</div>
<script src="${pageContext.request.contextPath}/menu/js/left.js"></script>
</body>
</html>