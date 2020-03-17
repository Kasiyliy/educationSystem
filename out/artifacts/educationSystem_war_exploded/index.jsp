<%--
  Created by IntelliJ IDEA.
  User: air
  Date: 14.03.2020
  Time: 12:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="/addLesson" method="post">
  <input type="text" name="lessonTitle" placeholder="title">
  <input type="text" name="lessonDescription" placeholder="text">
  <input type="text" name="courseId" placeholder="course id">
  <input type="text" name="lessonOrdering" placeholder="order">
    <input type="submit" value="Save">
  </form>
  </body>
</html>
