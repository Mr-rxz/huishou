<%@ page language="java" import="java.util.*" import="com.huishou.pojo.*" pageEncoding="UTF-8"%>
<%
    HttpSession s = request.getSession(); 
	Distribution distribution = (Distribution)s.getAttribute("distribution");
%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
		<title>会收</title>
		<script src="js/mui.min.js"></script>
		<script src="js/jquery.min.js"></script>
		<link href="css/mui.min.css" rel="stylesheet" />
		<link href="css/style.css" rel="stylesheet" />
		<script type="text/javascript" charset="utf-8">
			mui.init();
		</script>
	</head>

	<body class="bgpink">
		<header class="mui-bar mui-bar-nav bgblue jiaoxiaohead">
			<a class="mui-action-back mui-icon"></a>
			<h1 class="mui-title">首页</h1>
		</header>
        
		<div class="mui-content padding4">
			<div class="mui-card baomingbox">
				<form action="order.action" >
				<ul class="mui-table-view">
					<!-- <li class="mui-table-view-cell mui-collapse">
                        <label >垃&nbsp;&nbsp;圾&nbsp;&nbsp;桶</label>
                        <input value="小号" disabled="true"/>
					</li> -->
					<li class="mui-table-view-cell mui-collapse">
                        <div class="mui-input-row">
                        <label >社&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;区</label>
                        <select name="communityid" >
                        	<option value="1">测试社区</option>
                        	<option value="2">哈理工荣成校区</option>
                        	<option value="3">十里河小区</option>
                        	<option value="4">成山奥苑</option>
                        </select>
						</div>
					</li>
					<li class="mui-table-view-cell mui-collapse">
                        <div class="mui-input-row">
                        <label >详细地址</label>
                        <%
                        if(distribution == null){
                        %>
                        <input type="text" name="address" class="mui-input-clear" placeholder="此处填写"/>
                        <%
                        }else{ 
                        %>
                        <input type="text" name="address" class="mui-input-clear" value="<%=distribution.getAddress()%>"/>
                        <%
                        }
                        %>
                        </div>
					</li>
					<!--<li class="mui-table-view-cell mui-collapse">
                        <label >数&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;量</label>
                        <input value="1"/>
					</li>  -->
					<li class="mui-table-view-cell mui-collapse">
                        <div class="mui-input-row">
                        <label >联系方式</label>
                        <%
                        if(distribution == null){
                        %>
                        <input type="text" name="telephone" class="mui-input-clear" placeholder="此处填写"/>
                        <%
                        }else{ 
                        %>
                        <input type="text" name="telephone" class="mui-input-clear" value="<%=distribution.getTelephone()%>"/>
                        <%
                        }
                        %>
                        </div>
					</li>
					<li class="mui-table-view-cell mui-collapse">
                        <div class="mui-input-row">
                        <label >时&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;间</label>
                        <select name="period">
                        	<option >8:00-10:00</option>
                        	<option >10:00-12:00</option>
                        	<option >12:00-14:00</option>
                        	<option >14:00-18:00</option>
                        	<option >18:00-22:00</option>
                        </select>
						</div>
					</li>
					<li class="mui-table-view-cell mui-collapse">
                        <div class="mui-input-row">
                        <label >称&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;呼</label>
                        <input type="text" name="username" class="mui-input-clear" placeholder="此处可以不写"/>
            			</div>
					</li>
					<li class="mui-table-view-cell mui-collapse"><center>
                        <input type="submit" id="confirm" value="确认"></center>
                    </li>
				</ul>
				</form>
			</div>
		</div>
        
        
        <nav class="mui-bar mui-bar-tab footernav ">
			<a class=" footernavli mui-active " href="index.jsp">
				<span class="footernavimg"><img src="img/footer1.png"></span>
				<span class="mui-tab-label footernavtxt">首页</span>
			</a>
			<a class="footernavli" href="getorder.action">
				<span class="footernavimg"><img src="img/footer2.png"></span>
				<span class="mui-tab-label footernavtxt">订单</span>
			</a>
			<a class="footernavli" href="personal.jsp">
				<span class="footernavimg"><img src="img/footer3.png"></span>
				<span class="mui-tab-label footernavtxt">个人</span>
			</a>
		</nav>
        
	</body>
	
<script type="text/javascript">
$(document).ready(function(){
$("#confirm").click(function(){
	var tel = $("input[name='telephone']").val();
	var ztel = /^[1-9][0-9]*$/;
	if($("input[name='address']").val() == ""){
		alert("详细地址不可为空");
		return;
	}
	if(!ztel.test(tel)){
		alert("联系方式格式不正确");
		return;
	}
	$('form').submit();
}); // end click
}); // end ready
</script>
</html>