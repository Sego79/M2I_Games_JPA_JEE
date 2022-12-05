<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zoran
  Date: 01/12/2022
  Time: 11:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Détail du jeu</title>
    <link href="<c:url value="/assets/CSS/style.css" />" rel="stylesheet" type="text/css">
<%--
<link href="${pageContext.request.contextPath}/assets/css/style.css" rel="stylesheet" type="text/css">
--%>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<h1>${name}</h1>
<p>Description : ${description}</p>

<form method="post" action="${pageContext.request.contextPath}/games/delete">
    <input type="hidden" value="${id}" name="IdGame">
    <button>Delete</button>
</form>
<a href="${pageContext.request.contextPath}/games">Retour</a>

</body>
</html>
