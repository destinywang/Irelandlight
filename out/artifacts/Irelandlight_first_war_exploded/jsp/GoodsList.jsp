<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/12/22
  Time: 0:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>蛋糕名录</title>
</head>
<link href="../css/common.css" rel="stylesheet">
<link href="../css/header.css" rel="stylesheet">
<link href="../css/nameList.css" rel="stylesheet">
<link href="http://at.alicdn.com/t/font_5l7p7cfv8nsqyqfr.css" rel="stylesheet">

<body>
<div class="all-page">
    <header class="clearfix">
        <a href="homePage.html" class="dis-b f-l"><i class="iconfont icon-back" id="return"></i></a>
        <p>蛋糕名录</p>
    </header>
    <div class="content w-95 m-c">
        <div class="clearfix">
            <div class="search w-80 f-l">
                <input type="text" placeholder="奶油/巧克力/芝士/..." class="fs-1-8 lh-3">
                <a href="nameList.html"><i class="iconfont icon-sousuokuangsousuo" id="search"></i></a>
            </div>
            <div class="select f-r w-20">
                <span class="fs-2 lh-3 col-qk">筛选</span>
                <i class="iconfont icon-shaixuanshaixuan" id="select"></i>
            </div>
        </div>
        <div class="choice w-90 m-c">
            <p>
            <h4>用途：</h4>
            <span>生日</span><span>祝寿</span><span>宴会</span><span>婚庆</span><span>小蛋糕</span>
            </p>
            <p>
            <h4>风味：</h4>
            <span>生海绵</span><span>戚风</span><span>布丁</span><span>慕斯</span><span>芝士</span>
            </p>
            <p>
            <h4>偏爱：</h4>
            <span>乳脂奶油</span><span>巧克力</span><span>冰淇淋</span><span>水果</span><span>乳酪</span>
            <span>提拉米苏</span><span>抹茶</span><span>翻糖</span><span>原味</span>
            </p>
            <a href="nameList.html"><input type="submit" value="完成"></a>
        </div>
        <ul class="cnt-main w-95 m-c clearfix">
            <c:forEach var="goodsInfo" items="${cakeList}">
                <li>
                    <a href="goodsDetail.html"><img src="${goodsInfo.goodsImageUrl}" class="dis-b"></a>
                    <p>${goodsInfo.goodsName}</p>
                    <p>${goodsInfo.goodsPrice}</p>
                </li>
            </c:forEach>

        </ul>
        <i class="iconfont icon-gengduo-copy" id="more"></i>
    </div>

    <i class="iconfont icon-iconfonthuidaodingbueps" id="totop"></i>
    <p class="phone fs-2 lh-3 col-sh bg-qh tet-c">客服电话：8008208820</p>
    <footer>
        <ul class="dis-f">
            <li>
                <a href="myOder.html"><i class="iconfont icon-dingdan" id="m-o"></i></a>
                <p>我的订单</p>
            </li>
            <li>
                <a href="homePage.html"><i class="iconfont icon-fanhuishouye" id="r-h"></i></a>
                <p>返回主页</p>
            </li>
            <li>
                <a href="shopCart.html"><i class="iconfont icon-gouwuche" id="s-c"></i></a>
                <p>购物车</p>
            </li>
            <li>
                <a href="userCenter.html"><i class="iconfont icon-gerenzhongxin" id="u-c"></i></a>
                <p>个人中心</p>
            </li>
        </ul>
    </footer>
</div>



<script src="../JS/jquery-1.10.1.min.js"></script>
<script>
    var onoff = 1;
    $(".select").click(function (){

        if(onoff = 1){
            $(".choice").css("display","block");
            onoff = 0;
        }else{
            $(".choice").css("display","none");
            onoff = 1;
        }

    })
</script>



</body>
</html>