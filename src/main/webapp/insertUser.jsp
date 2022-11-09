<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<html>
<head>
    <title>Insert title here</title>
</head>
<body>
<center>
    <h1>사용자 등록</h1>
    <a href="logout.do">Log-out</a>
    <hr>
    <form action="insertUser.do" method="post">

        <table border="1" cellpadding="0" cellspacing="0">
            <tr>
                <td bgcolor="orange" width="70">ID</td>
                <td align="left">
                    <input type="text" name="id"/>
                </td>
            </tr>
            <tr>
                <td bgcolor="orange">PASSWORD</td>
                <td align="left">
                    <input type="text" name="password"/>
                </td>
            </tr>
            <tr>
                <td bgcolor="orange">NAME</td>
                <td align="left">
                    <input type="text" name="name"/>
                </td>
            </tr>
            <tr>
                <td bgcolor="orange">ROLE</td>
                <td align="left">
                    <input type="text" name="role"/>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="사용자 등록"/>
                </td>
            </tr>
        </table>
    </form>
    <hr>
    <a href="getUserList.do">사용자 목록 가기</a>
</center>
</body>
</html>
