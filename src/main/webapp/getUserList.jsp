<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<%@ page import="com.springbook.biz.user.UserVO" %>
<%@ page import="java.util.List" %>

<html>
<head>
    <title>Insert title here</title>
</head>
<body>

<center>
    <h1>사용자 목록</h1>
    <h3>테스트님 환영합니다...<a href="logout.do">Log-out</a></h3>

    <%--    <form action="getUserList.jsp" method="post">--%>
    <%--        <table border="1" cellpadding="0" cellspacing="0" width="700">--%>
    <%--            <tr>--%>
    <%--                <td align="right">--%>
    <%--                    <select name="searchCondition">--%>
    <%--                        <option value="TITLE">제목--%>
    <%--                        <option value="CONTENT">내용--%>
    <%--                    </select>--%>
    <%--                    <input name="searchKeyword" type="text"/>--%>
    <%--                    <input type="submit" value="검색"/>--%>
    <%--                </td>--%>
    <%--            </tr>--%>
    <%--        </table>--%>
    <%--    </form>--%>

    <table border="1" cellpadding="0" cellspacing="0" width="700">
        <tr>
            <th bgcolor="orange" width="100">ID</th>
            <th bgcolor="orange" width="200">PASSWORD</th>
            <th bgcolor="orange" width="150">NAME</th>
            <th bgcolor="orange" width="150">ROLE</th>
        </tr>

        <c:forEach items="${userList}" var="user">
            <tr>
                <td align="left"><a href="/getUser.do?id=${user.id}">${user.id}</a></td>
                <td>${user.password}</td>
                <td>${user.name}</td>
                <td>${user.role}</td>
            </tr>
        </c:forEach>
    </table>

    <br>

</center>

<hr>
<center>
    <a href="insertUser.jsp">사용자 등록</a>&nbsp;&nbsp;&nbsp;
</center>

</body>
</html>
