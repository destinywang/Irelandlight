<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/12/21
  Time: 5:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>json交互测试</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/JS/jquery-1.10.1.min.js"></script>
    <script type="text/javascript">
        //请求json,输出json
        function requestJson(){
            $.ajax({
                type:'post',
                url:'/requestJson',
                contentType:'application/json;charset=utf-8',
                //数据格式是json串
                data:'{"use":"吃","taste":"香甜","preference":"沙迪克"}',
                success:function (data) {
                    alert(data);
                }
            });
        }

        //请求key/value，输出json
       function responseJson2(){
           $.ajax({
              type:'post',
               url:'/responseJson',
               data:'use=吃,taste=内存，perference=模块V',
               success:function (data) {
                   alert(data);
               }
           });
       }

        function responseJson(){
            $.ajax({
                type:'post',
                url:'/responseJson',
                //数据格式是json串
                data:'use=吃&taste=香甜&perference=dfmi',
                success:function (data) {
                    alert(data);
                }
            });
        }
    </script>
</head>

<body>
<script type="text/javascript">
    function da() {
       $.ajax({
           type:'POST',
           url:'/test',
           success:function (data) {
               alert(data);
           }
       })
    }
</script>
<input type="button" onclick="requestJson()" value="请求Json,输出json"/>
<input type="button" onclick="responseJson()" value="请求key/value，输出json"/>
<input type="button" onclick="da()" value="kkk"/>
</body>
</html>
