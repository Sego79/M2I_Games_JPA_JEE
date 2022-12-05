<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: zoran
  Date: 30/11/2022
  Time: 15:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Liste des jeux</title>
    <link href="<c:url value="/assets/CSS/style.css" />" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

</head>
<body>
<jsp:include page="header.jsp"></jsp:include>

<h1>List of games</h1>

<table class="table table-striped">
    <%--Header de notre tableau--%>
    <thead>
    <tr>
    <th>#</th>
    <th>Name</th>
    <th>Description</th>
    <th colspan="3" class="Titre_table">Actions</th>

    </thead>
    <%--Corps de notre tableau--%>
    <tbody>
    <c:forEach items="${games}" var="game">
        <tr>
         <td>${game.id}</td>
         <td>${game.name}</td>
         <td>${game.description}</td>
         <td>
             <a class="btn btn-primary" href="${pageContext.request.contextPath}/games/edit?id=${game.id}">
             </a>
             <button>Edit</button>
         </td>
         <td><form method="post" action="${pageContext.request.contextPath}/games/delete">
             <input type="hidden" value="${game.id}" name="IdGame">
             <button>Delete</button>
             </form>
         </td>
         <td>
             <a href="${pageContext.request.contextPath}/games/details?id=${game.id}">Détails</a>
         </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<a href="${pageContext.request.contextPath}/games/add">Add Game</a>

<%--Ajout d'un essai pour tester le login pour le "contexte d'application"--%>
<p>Nb Login Hit : ${applicationScope['nbLoginHit']}</p>
</body>
</html>
