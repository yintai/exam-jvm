<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE>
<html>
  <head>
    <title>蒲公英</title>    
	<meta http-equiv="pragma" content="no-cache">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, user-scalable=no" />
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link type="text/css" rel="stylesheet" href="/static/css/common_html5.css"/>
	<link type="text/css" rel="stylesheet" href="/static/css/iconfont2.css">
	<link type="text/css" rel="stylesheet" href="/static/css/iconfont.css">
	<link type="text/css" rel="stylesheet" href="/static/css/idangerous.swiper.css">
	<script type="text/javascript" src="/static/js/jquery-1.8.3.min.js"></script>
	<script type="text/javascript" src="/static/js/jquery_plugin/jquery.template.min.js"></script>
	<script type="text/javascript" src="/static/js/idangerous.swiper-2.1.min.js"></script>
	<script type="text/javascript" src="/static/js/iscroll.js"></script>
	<script type="text/javascript" src="/static/js/subject.js"></script>
	<style type="text/css">
		.subject .time span.swiper-active-switch {
	  		background:#bebebe;
		}
	</style>
  </head>
  
  <body>


<header>
    <article class="wrap">
    <section class="sectionOne"><a class="iconfont" href="javascript:void(0)" onclick="history.go(-1);" style="display:none;">&#xe679;</a></section>
    <section class="sectionTwo">
     <h1><span>专题</span></h1>
    </section>
    <section class="sectionThree"><a class="iconfont" href="#"></a></section>
	</article>
</header>
<script>
/*$(document).ready(function(){
var a=$(window).height();
if(a<=530){
	$(".img_box").height(240);
}
})*/
</script>
<div class="main" style="overflow-x:hidden;">
<div class="subject">
 <div class="time clearfix">
   <div class="fl today">今日推荐</div> 
   <div class="fl date">
     <div class="fl day"></div>
     <div class="month fl"></div>
   </div> 
   <div class="page fl">
      <div class="clearfix pagination"><span class="on">&nbsp;</span><span>&nbsp;</span><span>&nbsp;</span></div>
      <!-- <div class="clearfix"><span>&nbsp;</span><span>&nbsp;</span></div> -->
   </div>
 </div>
 <div class="swiper-container">
 <script type="text/javascript">
  	var iHeight = $(document).height() * 0.82;
    $(".swiper-container").css("height",iHeight +"px");
  </script>
 <div class="swiper-wrapper"></div></div>
 <!-- <div class="big_pic">
 <a href="#" id="a_topic">
  <div class="img_box">
    <div class="swiper-container" id="content" style="overflow:hidden";>
    <script type="text/javascript">
  	var iHeight = $(document).height() * 0.6;
    $("#content").css("height",iHeight +"px");
    $('.swiper-wrapper img').css({'height':iHeight+'px'});
  </script>
      <div class="swiper-wrapper">
      </div>     
    </div>
   <span class="price"><em>佣金</em><c class="priceNum"></c></span>
   <div class="tag clearfix">
   	 <div class="fl"><span><img src="/static/images/icon_share_white.png"></span> <c class="sharenum"></c></div>
   	 <div class="fl"><span class="iconfont2"><img src="/static/images/icon_eye_white.png"></span> <c class="scannum"></c></div>
   	 <div class="fr"><span class="iconfont2"><img src="/static/images/icon_heng.png"></span><span class="iconfont2"><img src="/static/images/icon_shu.png"></span></div>
   </div>
  </div>  
</a>
 </div>
 
 <div><a class="subject-btn" href="#"></a></div>
 <div class="share clearfix">
    <div id="wrapper">
       <div class="logo">
       <a  href="javascript:void(0)" onclick="shareTopic(3)"><img src="/static/images/icon_pengyouquan.png"><span  shid="2" style="display:none;"><img src="/static/images/icon_share_top.png"></span></a>
        <a href="javascript:void(0)" onclick="shareTopic(2)"><img src="/static/images/icon_wei.png"><span  shid="3" style="display:none;"><img src="/static/images/icon_share_top.png"></span></a>
        <a href="javascript:void(0)"  onclick="shareTopic(1)"><img src="/static/images/icon_qq.png"><span  shid="1" style="display:none;"><img src="/static/images/icon_share_top.png"></span></a>
        <a  href="javascript:void(0)" onclick="shareTopic(5)"><img src="/static/images/icon_xinlang.png"><span shid="5" style="display:none;"><img src="/static/images/icon_share_top.png"></span></a>
        <a class="iconfont2 qq" href="javascript:void(0)" onclick="shareTopic(4)"><img src="/static/images/icon_kongjian.png"><span shid="4" style="display:none;"><img src="/static/images/icon_share_top.png" ></span></a>
        <a class="iconfont2 qq" href="javascript:void(0)" onclick="shareTopic(6)"><img src="/static/images/icon_lianjie.png"><span shid="6" style="display:none;"><img src="/static/images/icon_share_top.png"></span></a>
       </div>
    </div>-->
    <script type="text/javascript">
    /*
    sharedChannels 1 QQ 2 微信好友 3 朋友圈 4 QQ空间 5 微博 6复制链接
    */
    oData = $.parseJSON('<c:out value="${topic}" escapeXml="false" />');
    data = '<c:out value="${data}" />';console.log(oData);console.log(data);
    userId = '<c:out value="${userId}" />';
    deviceType='<c:out value="${deviceType}" />';
    type = '<c:out value="${type}" />';console.log(oData);console.log(data);console.log(type);
	var mySwiper = null;
	//第一参数必需是滑动元素的父元素的id。
	//主要参数一览：
	//hScroll: true, 左右滑动，默认为true
	//vScroll: true,上下滑动
	//hScrollbar: true, 是否显示y轴滚动条，默认为显示
	//vScrollbar: true,是否显示X轴滚动条，默认为显示
</script>
<script type="text/x-jquery-template" id="template_slide_images">
	{{each(index,item) data}}
		<div class="swiper-slide subjectpic"><img src="{{= item.imageUrl}}" /></div>
	{{/each}}
</script>
 <!-- </div> --> 
 
 <!-- <div class="none" style="display:none;"><img src="/static/images/pic_fail.png">英雄，你以“脱”到底啦~~</div> -->
</div> 
</div>

</body>
</html>
