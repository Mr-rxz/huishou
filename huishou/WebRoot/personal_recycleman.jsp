<%@ page language="java" import="java.util.*" import="com.huishou.bean.*" pageEncoding="UTF-8"%>
<%
    HttpSession s = request.getSession(); 
    UserInfo_Web ui = (UserInfo_Web) s.getAttribute("user");
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
			<h1 class="mui-title">个人</h1>
		</header>
        
		<div class="mui-content indexpad">
			<div class=" bgblue userheader">
				<div class="usershezhi">
					<a href="#" class="mui-pull-right topchilun"></a>
				</div>
				<ul class="mui-table-view bgnone userinfo">
					<li class="mui-table-view-cell mui-media userinfoin">
						<div class="mui-media-object mui-pull-left userinfoinimg">
                            <img src="<%=ui.getHeadimgurl()%>">
                        </div>
						<div class="mui-media-body">
							<p class="userinfonh">姓名：<%=ui.getNickname() %></p>
							<p class='mui-ellipsis userinfot'>总金额：***</p>
							<p class='mui-ellipsis userinfot'>总积分：***</p>
						</div>
					</li>

				</ul>
			</div>
			<ul class="mui-table-view mui-table-view-chevron">
				<li class="mui-table-view-cell userlist">
                    <a href="#">
                    <img src="img/user1.png" class="mui-media-object mui-pull-left usericon usericonli">
                    收货地址</a>
                </li>
				<li class="mui-table-view-cell mui-collapse userlist">
					<a href="#">
                    <img src="img/user2.png" class="mui-media-object mui-pull-left usericon usericonli">
                    我的会收桶</a>
				</li>
				<li class="mui-table-view-cell mui-collapse userlist">
					<a href="#">
                    <img src="img/user4.png" class="mui-media-object mui-pull-left usericon usericonli">
                    用户反馈</a>
				</li>
				<li class="mui-table-view-cell mui-collapse userlist">
					<a href="#">
                    <img src="img/user7.png" class="mui-media-object mui-pull-left usericon usericonli">
                    联系我们</a>
				</li>
			</ul>
		</div>
		
        <nav class="mui-bar mui-bar-tab footernav ">
			<a class=" footernavli mui-active " href="#">
				<span class="footernavimg"><img src="img/footer1.png"></span>
				<span class="mui-tab-label footernavtxt">首页</span>
			</a>
			<a class="footernavli" href="getorder.action">
				<span class="footernavimg"><img src="img/footer2.png"></span>
				<span class="mui-tab-label footernavtxt">订单</span>
			</a>
			<a class="footernavli" href="personal_recycleman.jsp">
				<span class="footernavimg"><img src="img/footer3.png"></span>
				<span class="mui-tab-label footernavtxt">个人</span>
			</a>
		</nav>
	</body>
    
</html>