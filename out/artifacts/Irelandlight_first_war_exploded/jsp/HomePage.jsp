<%@ page import="java.util.List" %>
<%@ page import="com.irelandlight.model.HomePageImage" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/12/20
  Time: 16:06
  To change this template use File | Settings | File Templates.
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>BAKED GOODS</title>

</head>
<link href="../css/common.css" rel="stylesheet" >
<link href="../css/homePage.css" rel="stylesheet">
<link href="../css/header.css" rel="stylesheet">
<link href="http://at.alicdn.com/t/font_5l7p7cfv8nsqyqfr.css" rel="stylesheet">
<body>
<div class="all-page">
    <header class="clearfix">
        <img src="../img/logo2.jpg" class="logo">
        <a href="frontMessage.html"><i class="iconfont icon-xiaoxi" id="message"></i></a>
        <a href="userCenter.html"><i class="iconfont icon-dengluicon01" id="in"></i></a>
    </header>
    <div >
        <div class="fu">
            <ul id="carousel-figure" class="clearfix">
                <c:forEach var="im" items="${homePageImage}">
                    <li><img src="${im.url}"> </li>
                </c:forEach>
            </ul>
        </div>

        <ul id="points">
            <li></li>
            <li></li>
            <li></li>
        </ul>
    </div>
    <div class="news m-c w-95">
        <i class="iconfont icon-jikediancanicon17 dis-b fs-4 fw" id="news"></i>
        <span>
            <c:forEach var="newsInfo" items="${news}">
                 <span class="dis-b lh-4 fs-3 col-sk">${newsInfo.newsContent}</span>
            </c:forEach>
        </span>
    </div>
    <div class="content">
        <p class="cnt-p col-sk fs-3 lh-7 fw">热门商品 Hot Cake</p>
        <ul class="cnt-main w-95 m-c clearfix">
            <c:forEach var="mess" items="${hotGoods}">
                <li>
                    <a href="goodsDetail.html"><img src="${mess.goodsImageUrl}" class="dis-b"></a>
                    <p>${mess.goodsName}</p>
                    <p>${mess.goodsPrice}</p>
                </li>
            </c:forEach>

        </ul>
    </div>
    <p class="phone fs-2 lh-3 col-sh bg-qh tet-c">客服电话：8008208820</p>
    <footer>
        <ul class="dis-f">
            <li>
                <a href="nameList.html"><i class="iconfont icon-dingdan" id="n-l"></i></a>
                <p>蛋糕名录</p>
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
    var speed = 5;
    var allPic = null;
    setTimeout(function (){
        setInterval(function (){
            $("#carousel-figure").css("left", parseInt($("#carousel-figure").css("left")) - speed);
        },10)
        if (parseInt($("#carousel-figure").css("left")) < -$(".fu").width()) {
            $("#carousel-figure").css("left", 0);
        }
    },1000)

    // clearInterval(allPic);


</script>
</body>
</html>
