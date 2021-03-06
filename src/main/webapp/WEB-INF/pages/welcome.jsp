<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!doctype html>
<!--[if lt IE 7]> <html class="ie6 oldie"> <![endif]-->
<!--[if IE 7]>    <html class="ie7 oldie"> <![endif]-->
<!--[if IE 8]>    <html class="ie8 oldie"> <![endif]-->
<!--[if gt IE 8]><!-->
<html class="">
<!--<![endif]-->
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!--苹果手机全屏问题-->
<meta content="width=device-width; initial-scale=1.0; maximum-scale=1.0; user-scalable=0" name="viewport" />        
<meta content="yes" name="apple-mobile-web-app-capable" />
<meta content="black" name="apple-mobile-web-app-status-bar-style" /> 
<meta content="telephone=no" name="format-detection" /> 

<title>投票</title>
<link href="<%=request.getContextPath() %>/css/boilerplate.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath() %>/css/style.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath() %>/css/animate.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath() %>/css/sweet-alert.css" rel="stylesheet" type="text/css">
<!--[if lt IE 9]>
<script src="//html5shiv.googlecode.com/svn/trunk/html5.js"></script>
<![endif]-->

</head>
<body style="background:#c30d23; z-index: 1;"  >

<div id="audio_btn" class="video_exist off play_yinfu" style="display: block;">
    <div id="yinfu" class="rotate"></div>
    <audio loop src="<%=request.getContextPath() %>/music/bg_2.mp3" id="media" autoplay preload="preload"></audio>
</div>

    <div id="title1" class="fluid fadeInLeft animated" style="display: block;">
        <div id="div1" class="">
            <img src="<%=request.getContextPath() %>/images/title_1.png" style="width: 58%;">
        </div>
        
    </div>
    
    <div class="gridContainer clearfix">
      <div id="div2" class="fluid bounceInLeft animated">
        <img src="<%=request.getContextPath() %>/images/log_1.png" style="width: 88%;">
      </div>
      <div id="div2_1" class="fluid bounceInRight animated">
        <img src="<%=request.getContextPath() %>/images/log_2.png" style="width: 88%;">
      </div>
    </div>
    
    
    <div class="gridContainer clearfix">
      <div id="div3" class="fluid flipInX animated">
        <img src="<%=request.getContextPath() %>/images/title_3.png" style="width:80%;">
      </div>
    </div>
    
    <div class="gridContainer clearfix" style="z-index:99;">
      <div id="div4" class="fluid bounceIn animated" style="z-index:999;">
        <a href="tocontent" class="go btn" style="z-index:9999;">参与投票</a>
      </div>
    </div>
    
    <div class="gridContainer clearfix" style="z-index:99;">
      <div id="div4" class="fluid bounceIn animated" style="z-index:999;animation-delay:4s;
	-webkit-animation-delay:4s;
	-moz-animation-delay:4s;
	margin-top: 2em;
	z-index:10;">
        <a  class="go btn" style="z-index:9999;" onClick="swal('投票规则', '本活动的名词将由现场观众和场外观众共同参与投票最终产生本届合肥魔术师大赛的前三名，参与投票的场外观众将有机会获得10元话费的奖励！')">投票规则</a>
      </div>
    </div>


<script src="<%=request.getContextPath() %>/js/respond.min.js"></script>
<script src="<%=request.getContextPath() %>/js/jquery.min.js"></script>
<script src="<%=request.getContextPath() %>/js/respond.min.js"></script>
<script src="<%=request.getContextPath() %>/js/sweet-alert.min.js"></script>
<script>
$("#audio_btn").click(function(){    
    var music = document.getElementById("media");     
    if(music.paused){    
        music.play();
		$("#yinfu").addClass('rotate');
		$("#audio_btn").addClass('play_yinfu');
        $("#music_btn").attr("src","play.gif");    
    }else{    
        music.pause();  
		$("#yinfu").removeClass('rotate');
		$("#audio_btn").removeClass('play_yinfu');  
        $("#music_btn").attr("src","pause.gif");    
    }    
});    
</script>
</body>
</html>
