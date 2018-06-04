<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spring Boot</title>
</head>
<body>
    Time : ${time}
    <br>
    Message : ${message}
    <br>
    <img alt="读取默认配置中的图片" src="${pageContext.request.contextPath}/6.jpg" >
    <br>
    <img alt="读取自定义myres中的图片" src="${pageContext.request.contextPath}/myres/5.jpg" >
    <%-- <script type="text/javascript" src="${pageContext.request.contextPath }/webjars/jquery/3.3.1/jquery.js"></script> --%>
    <script type="text/javascript" src="${pageContext.request.contextPath }/webjarslocator/jquery/jquery.js"></script>
    <%-- <script type="text/javascript" src="${pageContext.request.contextPath }${urls.getForLookupPath('/webjars/jquery/jquery.js') }"></script> --%>
</body>
</html>