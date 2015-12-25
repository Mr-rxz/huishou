<%@ page language="java" import="java.util.*" import="com.huishou.pojo.*" import="com.huishou.util.Constant" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
    HttpSession s = request.getSession(); 
	List<Orderinfo> orderlist = (List<Orderinfo>) s.getAttribute("orderlist");
	List<Orderinfo> createlist = new ArrayList<Orderinfo>();
	List<Orderinfo> receivelist = new ArrayList<Orderinfo>();
	List<Orderinfo> donelist = new ArrayList<Orderinfo>();
	int indexA = 0;
	int indexB = 0;
	int indexC = 0;
	if(orderlist != null){
		for(Orderinfo oi : orderlist){
			switch (oi.getState()) {
			case Constant.DISTRIBUTION_STATE_CREATE:
				createlist.add(oi);
				break;
			case Constant.DISTRIBUTION_STATE_RECEIVING:
				receivelist.add(oi);
				break;
			case Constant.DISTRIBUTION_STATE_DONE:
				donelist.add(oi);
				break;
			default:
				break;
			}// end switch 
		} // end for
	//System.out.println("Order.jsp : " + orderlist.size() + ":" + createlist.size() + ":" + receivelist.size() + ":" + donelist.size());
	} // end if
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
			<h1 class="mui-title">订单</h1>
		</header>
        
		<div class="mui-content padding4 bgpink">
			<div class="mui-slider-indicator">
				<div class="mui-indicator mui-active"></div>
				<div class="mui-indicator"></div>
				<div class="mui-indicator"></div>
				<div class="mui-indicator"></div>
			</div>
		</div>	
			
        <div id="sliderSegmentedControl" class="mui-slider-indicator mui-segmented-control mui-segmented-control-inverted kcsidertop">
            <a class="mui-control-item mui-active" href="#item1mobile ">已创建</a>
            <a class="mui-control-item" href="#item2mobile">已接单</a>
            <a class="mui-control-item" href="#item3mobile">已回收</a>
        </div>
        
        <div class="mui-slider-group kcslidermain">
            <div id="item1mobile" class="mui-slider-item mui-control-content mui-active">
                <ul class="mui-table-view kcslidermainli">
                    <c:forEach items="<%=createlist%>" var="rawData">
            		<form action="cancel.action">
                    <li class="mui-table-view-cell">
                        <span class="mbiaoqian bg1"><%out.print(++indexA);%></span>
                        ${rawData.address} <a href="”tel://${rawData.telephone}">${rawData.telephone}</a>
                       <span class="mui-badge mui-badge-inverted kcjiage">
                       	<input type="submit" id="cancel" value="取消"/>
                        <input name="orderid" value="${rawData.id}" style="display:none;" /></span>
                    </li>
                    </form>
					</c:forEach>
                    <!-- <li class="mui-table-view-cell">
                        <span class="mbiaoqian bg2">2</span>
                        小号 1个 2015-02-12 19:22:11
                        <span class="mui-badge mui-badge-inverted kcjiage"><i> + </i> 5 /<i>￥</i> 5 </span>
                    </li>
                    <li class="mui-table-view-cell">
                        <span class="mbiaoqian bg3">3</span>
                        小号 1个 2015-02-12 19:22:11
                        <span class="mui-badge mui-badge-inverted kcjiage"><i> + </i> 5 /<i>￥</i> 5 </span>
                    </li>
                    <li class="mui-table-view-cell">
                        <span class="mbiaoqian bg4">4</span>
                        小号 1个 2015-02-12 19:22:11
                        <span class="mui-badge mui-badge-inverted kcjiage"><i> + </i> 5 /<i>￥</i> 5 </span>
                    </li> -->
                </ul>
            </div>
            <div id="item2mobile" class="mui-slider-item mui-control-content">
                <ul class="mui-table-view kcslidermainli">
                	<c:forEach items="<%=receivelist%>" var="rawData">
                    <li class="mui-table-view-cell">
                        <span class="mbiaoqian bg2"><%out.print(++indexB);%></span>
                        ${rawData.address} ${rawData.telephone}
                        <span class="mui-badge mui-badge-inverted kcjiage"><i> + </i> 2 /<i>￥</i> 2 </span>
                    </li>
					</c:forEach>
                    <!--<li class="mui-table-view-cell"><span class="mbiaoqian bg1">1</span>普通版<span class="mui-badge mui-badge-inverted kcjiage"><i>￥</i> 3100</span>
                    </li>
                    <li class="mui-table-view-cell"><span class="mbiaoqian bg2">2</span>双休班 <span class="mui-badge mui-badge-inverted kcjiage"><i>￥</i> 3100</span>
                    </li>
                    <li class="mui-table-view-cell"><span class="mbiaoqian bg3">3</span>商务班<span class="mui-badge mui-badge-inverted kcjiage"><i>￥</i> 3100</span>
                    </li>
                    <li class="mui-table-view-cell"><span class="mbiaoqian bg4">4</span>精英班<span class="mui-badge mui-badge-inverted kcjiage"><i>￥</i> 3100</span>
                    </li>
                    <li class="mui-table-view-cell"><span class="mbiaoqian bg5">5</span>优化班<span class="mui-badge mui-badge-inverted kcjiage"><i>￥</i> 3100</span>
                    </li>
                    <li class="mui-table-view-cell"><span class="mbiaoqian bg6">6</span>班次升级<span class="mui-badge mui-badge-inverted kcjiage"><i>￥</i><b>补差价</b></span>
                    </li>  -->
                </ul>
            </div>
            <div id="item3mobile" class="mui-slider-item mui-control-content">
                <ul class="mui-table-view kcslidermainli">
                	<c:forEach items="<%=donelist%>" var="rawData">
                    <li class="mui-table-view-cell">
                        <span class="mbiaoqian bg3"><%out.print(++indexC);%></span>
                        ${rawData.address} ${rawData.telephone}
                        <span class="mui-badge mui-badge-inverted kcjiage"><i> + </i> 2 /<i>￥</i> 2 </span>
                    </li>
					</c:forEach>
                    <!-- <li class="mui-table-view-cell"><span class="mbiaoqian bg1">1</span>全天练车<span class="mui-badge mui-badge-inverted kcjiage"><i>￥</i> 3100</span>
                    </li> -->
                </ul>
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
$("#cancel").click(function(){
	$('form').submit();
}); // end cancel click
}); // end ready
</script>

</html>