<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<header>
    <a href="${pageContext.request.contextPath}/games">Home</a>
    <a href="${pageContext.request.contextPath}/games/add">Add</a>
    <c:choose><c:when test="${empty sessionScope.userName}"><a href="${pageContext.request.contextPath}/login">Log in</a>
    </c:when><c:otherwise><form method="post" action="${pageContext.request.contextPath}/logout">
        <input type="submit" value="Logout">
    </form>
    </c:otherwise></c:choose>
</header>

