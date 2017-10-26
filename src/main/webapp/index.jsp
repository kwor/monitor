<html>
<head>
<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

</head>
<body>
<h2>接口列表</h2>
<br/>
<a href="/monitor/SNCode/85000DSN179G2627">按照序列号获取所有数据</a>
<br/>
<a href="/monitor/SNCode/85000DSN179G2627/0/1">获取多少到多少条</a>
<br/>
<a href="/monitor/SNCode/85000DSN177G2784/DataFrom/1479427738/DataTo/1479427739">根据时间查询单个设备信息</a>
<br/>
<a href="/monitor/DataFrom/1508858619/DataTo/1508858619">根据时间查询所有设备信息</a>
<br/>
<a href="/monitor/all">获取所有逆变器信息</a>
<form action="/monitor/getinfo" method="post">
<input type="text" name="test">
<input type="submit" value="suc">

</form>
</body>
</html>
