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
<title>投票</title>
<link href="<%=request.getContextPath() %>/css/boilerplate.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath() %>/css/style.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath() %>/css/sweet-alert.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="<%=request.getContextPath() %>/bootstrap-3.3.7-dist/css/bootstrap.min.css"/>
<!--[if lt IE 9]>
<script src="//html5shiv.googlecode.com/svn/trunk/html5.js"></script>
<![endif]-->
<script src="<%=request.getContextPath() %>/js/respond.min.js"></script>
<script src="<%=request.getContextPath() %>/js/sweet-alert.min.js"></script>
<script src="<%=request.getContextPath() %>/js/jquery-1.12.4.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script type="text/javascript">
var code="";
var codes="";
$(function(){
	$(".topiao").click(function(){
		codes=$(this).next().text();
	});
	$("#send").on("click", function(){
		var flag=checkPhone()&getStatus();
		if(flag){
			var tel=$("#tel").val();
		    $.ajax({
		        url: "sendSms",
		        async : false, 
		        type: "post",  
		        dataType: "json", 
		        data: {"phone":tel},  
		        //请求成功后的回调函数 
		        success: function (res) {  
		            code=JSON.stringify(res);//json转化为字符串
		            code=code.substring(15,21);//截取字符串
		            if(checkTel()){
			    		swal('', '您的短信验证码已发送成功，请您注意查收！', 'success');
		            }else{
		            	swal('', '您的手机号格式不正确，不能发送验证码！', 'fail');
		            }
		        },  
				error:function(res){
		    		swal('', '您的短信验证码发送失败，请您重新获取验证码！', 'fail');
				}
		    });
		}
	});
	$("#tel").blur(function(){
		checkTel();
	});
	$("#tel").focus(function(){
		var sp=$(this).next();
		sp.empty();
	});
	$("#codeValue").blur(function(){
		checkCodeValue();
	});
	$("#codeValue").focus(function(){
		var sp=$(this).next();
		sp.empty();
	});
	$("#submit").click(function(){
		var flag=checkTel()&checkCodeValue()&checkPhone()&getStatus();
		if(flag){
			var tel=$("#tel").val();
		    $.ajax({
		        url: "submit",
		        async : false, 
		        type: "post",  
		        dataType: "json", 
		        data: {
		        	"tel":tel,
		        	"code":codes
		        },  
		        //请求成功后的回调函数 
		        success: function (res) {  
		            if(res=="ok"){
		            	swal('投票成功!', '非常感谢,么么哒！', 'success');
		    		}else{
		    			swal('投票失败!', '', 'fail');
		    		}
		            $("#modal").hide();
		            window.location.reload();
		        }
		    });
		}
	});  
	
});
var countdown=60;
function settime(ph) {
	var flag=checkTel()&checkPhone()&getStatus(); 
	 if(flag){
		 if (countdown == 0) {
	    	  ph.removeAttribute("disabled");//删除disabled属性
	    	  $("#send").text("重新获取"); 
	    	  $("#send").css("width","110px");   
	            countdown = 60;
	            return false; 
	      }else {
	    	  ph.setAttribute("disabled", true);// 添加属性参数1 属性 参数2 赋值。不能单机
	    	  $("#send").text("重新获取(" + countdown + ")"); 
	    	  $("#send").css("width","110px");  
	          countdown--; 
	      }
	      setTimeout(function() { 
	            settime(ph); 
	      },1000);
	 }
}
function checkTel(){
	var tel=$("#tel");
	var sp=tel.next();
	var v=tel.val();
	sp.empty();
	var st="";
	var reg=/^[1][3,4,5,7,8][0-9]{9}$/;
	if(v.length<=0){
		st="手机号不能为空！";
		sp.html(st).css("color","red");
		return false;
	}
	if(!reg.test(v)){
		st="手机号格式不正确！";
		sp.html(st).css("color","red");
		return false;
	}
	return true;
} 
function checkCodeValue(){
	var codeValue=$("#codeValue");
	var sp=codeValue.next();
	var v=codeValue.val();
	sp.empty();
	var st="";
	if(v.length<=0){
		st="验证码不能为空！";
		sp.html(st).css("color","red");
		return false;
	}
	if(v!=code){
		st="验证码不正确！";
		sp.html(st).css("color","red");
		return false;
	}
	return true;
}
function checkPhone(){
	var tel=$("#tel").val();
	var flag=false;
	$.ajax({
        url: "checkPhone",
        async : false, 
        type: "post",  
        dataType: "json", 
        data: {
        	"tel":tel,
        },  
        //请求成功后的回调函数 
        success: function (res) {  
        	if(res=="ok"){
    			flag=true;
    		}
        }
    });
	return flag;
}
function getStatus(){
	var tel=$("#tel").val();
	var flag=false;
	$.ajax({
        url: "getStatus",
        async : false, 
        type: "post",  
        dataType: "json", 
        data: {
        	"tel":tel,
        },  
        //请求成功后的回调函数 
        success: function (res) {  
        	if(res=="ok"){
    			flag=true;
    		}else{
    			swal('', '您已参与过投票，不能再投！', 'fail');
    		}
        }
    });
	return flag;
}
</script>
<style type="text/css">
	#modal{
		margin: 150px auto;
		height: 500px;
	}
	#myModalLabel{
		text-align: center;
	}
	label{
		width: 100px;
	}
	.modal-body p{
		width: 100%;
	}
	#send{
		display:block;
		margin: 0 auto;
	}
	.sp{
		display: block;
		width: 100%;
		height: 20px;
		color: red;
	}
</style>
</head>
<body style="background:#c30d23">

<div id="audio_btn" class="video_exist off play_yinfu" style="display: block;">
    <div id="yinfu" class="rotate"></div>
    <audio loop src="<%=request.getContextPath() %>/music/bg_2.mp3" id="media" autoplay preload="preload"></audio>
</div>

<div id="content_title1" class="fluid clearfix" >
    <div class="content_title">
    	参与投票
    </div>
</div>

<div class="clearfix"></div>

<c:forEach items="${list}" var="xuanshou" varStatus="count" begin="0" step="1">
<div id="content_list" class="gridContainer clearfix bounceInDown animated">
	<div class="content_list_li">
    	<div class="content_list_li_left">
        	<span><img src="${xuanshou.pic }" ></span>
        </div>
        <div class="content_list_li_right">
        	<div class="content_list_li_right_li"><strong>编号：</strong>${xuanshou.code }</div>
            <div class="content_list_li_right_li"><strong>姓名：</strong>${xuanshou.name }</div>
            <div class="content_list_li_right_li"><strong>节目：</strong>${xuanshou.jiemu }</div>
            <div class="content_list_li_right_li_a"><a class="btn to t1 topiao" data-toggle="modal" data-target="#modal" >投我吧</a><span hidden="true">${xuanshou.code }</span></div>
            <div class="content_list_li_right_li"><strong>已获票数：</strong>${xuanshou.count }</div>
        </div>
        <div class="clearfix"></div>
    </div>
</div>
</c:forEach>

<!-- onClick="swal('投票成功!', '非常感谢,么么哒！', 'success')"     -->


<!-- 模态框（Modal） -->
	<div class="modal fade" id="modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	    <div class="modal-dialog">
	        <div class="modal-content">
	            <div class="modal-header">
	                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
	                <h4 class="modal-title" id="myModalLabel">投票前需输入您的手机号<br/>您将有机会获得<Strong style="color:red;">10元</Strong>话费</h4>
	            </div>
	            <div class="modal-body">
					<p>
						<label for="tel">请输入手机号：</label>
						<input  type="text" name="tel" id="tel" placeholder="请输入手机号" class="form-control" />
						<span class="sp"></span>
					</p>
					<p>
						<label for="codeValue">请输验证码：</label>
						<input  type="text" id="codeValue" placeholder="请输验证码" class="form-control" />
						<span class="sp"></span>
					</p>
					<p>
						<button type="button" class="btn btn-default" id="send" style="width: 100px;height: 35px;" onclick="settime(this)">获取验证码</button>
					</p>
				</div>
	            <div class="modal-footer">
	            	<button type="button" class="btn btn-default" id="submit" style="background-color: green;color: white;">投票</button>
	                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
	            </div>
	        </div><!-- /.modal-content -->
	    </div><!-- /.modal -->
	</div>
<div class="clearfix" style="height:2em;"></div>
</body>
</html>
