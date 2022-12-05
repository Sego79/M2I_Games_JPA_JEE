<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zoran
  Date: 01/12/2022
  Time: 11:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Modification d'un jeu</title>
    <link href="<c:url value="/assets/css/style.css" />" rel="stylesheet" type="text/css">
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<h1>Formulaire de modification du jeu</h1>


<form action="${pageContext.request.contextPath}/games/edit" method="post">
<%-- l'ID peut être aussi mis dans l'URL d'action mais dans ce cas il sera visible--%>
    <input id="gameId" type="hidden" value="<c:out value="${id}"/>" name="gameId">

    <label for="gameName">Nom</label>
    <input id="gameName" type="text" name="gameName" value="<c:out value="${name}"/>">

    <label for="gameDescription">Description</label>
    <input id="gameDescription" type="text" name="gameDescription" value="<c:out value="${description}"/>">

    <button type="submit">Modifier</button>

</form>
</body>
</html>
