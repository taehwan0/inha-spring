<jsp:useBean id="user" scope="request" type="com.springbook.biz.user.UserVO"/>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>


<html>
<head>
    <title>Insert title here</title>
</head>
<body>

<center>
    <h1>사용자 상세</h1>
    <a href="logout.do">Log-out</a>
    <hr>

    <form action="updateUser.do" method="get">

        <table border="1" cellpadding="0" cellspacing="0">
            <tr>
                <td bgcolor="orange" width="70">ID</td>
                <td align="left">
                    <input name="id" type="text" value="${user.id}" readonly>
                </td>
            </tr>
            <tr>
                <td bgcolor="orange">PASSWORD</td>
                <td align="left">
                    <input name="password" type="text" value="${user.password}"/>
                </td>
            </tr>
            <tr>
                <td bgcolor="orange">NAME</td>
                <td align="left">
                    <input name="name" type="text" value="${user.name}"/>
                </td>
            </tr>
            <tr>
                <td bgcolor="orange">ROLE</td>
                <td align="left">
                    <input name="role" type="text" value="${user.role}"/>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="사용자 수정"/>
                </td>
            </tr>
        </table>
    </form>
    <hr>

    <a href="insertUser.jsp">사용자 등록</a>&nbsp;&nbsp;&nbsp;
    <a href="deleteUser.do?id=${user.id}">사용자 삭제</a>&nbsp;&nbsp;&nbsp;
    <a href="getUserList.do">사용자 목록</a>
</center>

</body>
</html>
