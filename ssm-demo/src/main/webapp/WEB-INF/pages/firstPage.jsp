<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
	<title>firstPage</title>	
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!--<link rel="stylesheet" type="text/css" href="./styles.css">-->
	<!-- Bootstrap -->
	<link href="../../plugin/bootstrap/css/bootstrap.css" rel="stylesheet" media="screen">
	<style type="text/css">
	.transparent_class {
    /* Required for IE 5, 6, 7 */
    /* ...or something to trigger hasLayout, like zoom: 1; */
    width:300px;
    height:300px;
    line-height:300px;
    text-align:center;
    background:#000;
    color:#fff;
    /* older safari/Chrome browsers */
    -webkit-opacity: 0.5;
    /* Netscape and Older than Firefox 0.9 */
    -moz-opacity: 0.5;
    /* Safari 1.x (pre WebKit!) 老式khtml内核的Safari浏览器*/
    -khtml-opacity: 0.5;
    /* IE9 + etc...modern browsers */
    opacity: .5;
    /* IE 4-9 */
    filter:alpha(opacity=50);
    /*This works in IE 8 & 9 too*/
    -ms-filter:"progid:DXImageTransform.Microsoft.Alpha(Opacity=50)";
    /*IE4-IE9*/
    filter:progid:DXImageTransform.Microsoft.Alpha(Opacity=50);
} 
	#test{
		background-color:#0000CC;
		filter:alpha(opacity=50); 
		-moz-opacity:0.5; 
		opacity:0.5;
		width:100px;
		height:100px;
	}
     html,body{
      height: 100%;
      overflow:hidden;
     }
   /* html ::-webkit-scrollbar { 
      width:5px;
      height:5px;
    }
    html ::-webkit-scrollbar-button       {  display: none; }
    html ::-webkit-scrollbar-track        { background:#1B1B1B;}
    html ::-webkit-scrollbar-track-piece  {  }
    html ::-webkit-scrollbar-thumb {
      background:#F50B86;
      border-radius:4px;
    }
    html ::-webkit-scrollbar-corner       { background:#1B1B1B; }
    html ::-webkit-resizer                { background:#1B1B1B; }*/
	</style>
	<script src="../../plugin/js/jquery-1.8.0.js"></script>
    <script src="../../plugin/bootstrap/js/bootstrap.min.js"></script>
  </head>
  <body>
  	<ul id="ul1" class="nav nav-pills nav-justified navbar-fixed-top" style="margin:0px;background-color:rgb(76,76,76);border-width:0;position: fixed;z-index:102;width:100%;">
	  <li role="" class="active"><a href="firstPage.html"  class="muted">HOME</a></li>
	  <li role=""><a href="moviePg.html" class="muted">MOVIE</a></li>
	  <li role=""><a href="aboutPg.html"  class="muted">ABOUT</a></li>
	  <li role=""><a href="contactPg.html"  class="muted">CONTACT</a></li>
	</ul>
	<div id="opacityDiv" style="width:100%;height: 100%;background-color:rgb(2,2,2);filter:alpha(opacity=30,style=0);opacity:0.7;z-index:100;left:0px;margin-top:0px;position:absolute;"></div>
	<div id="imgDiv" style="position:absolute;background-image:url(../image/original/firstP1.jpg);background-attachment:scroll;background-repeat:repeat;width:100%;height:100%;background-size:110% 110%; background-position:0 -40px;">
	</div>
  <div style="width:100%;height:100%;padding-top:40px; background-color:#1B1B1B;box-sizing:border-box;">
    <p class="text-center" style="">
      <img src="../image/logo2.png" style="width:8%;height:7%;position:relative;padding-top: 30px;z-index:101;"><br/>
      <span style="color:rgb(255,255,255);font-size:19px;position:relative;top:23px;z-index:101">Every scene is full of moving</span><br/>
      <img src="../image/theBest1.png" style="width:21%;height:16%;position:relative;margin-top: 80px;z-index:101;"><br/>
      <a href="#"><img src="../image/AppStore1.png" style="width:15%;height:11%;position:relative;margin-top: 50px;z-index:101;"></a><br/>
      <span style="color:rgb(255,255,255);font-size:17px;position:relative;top:16px;z-index:101">Make a Movie,Tell My Story</span>
    </p>
  </div>
	<!-- <button id="go"> Run</button>
	<div id="block">Hello!</div>
	<div id="div1" style="background-color:pink;width: 300px;height:220px;position:relative;left: 50px;">
	</div> -->
  <script src="./scroll.js"></script>
  </body>
</html>