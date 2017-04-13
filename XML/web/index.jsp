<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:choose>
            <c:when test="${movies == null}">
                <a href="FrontController">List movies from XML File</a>
            </c:when>
            <c:otherwise>
                <c:forEach items="${movies}" var="m">
                    ${m}<br/>
                </c:forEach>
            </c:otherwise>
        </c:choose>
    </body>
</html>
