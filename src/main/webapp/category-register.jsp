<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>カテゴリ登録</title>
</head>
<body>

<h2>カテゴリ登録</h2>

<%-- エラーメッセージ表示 --%>
<%
String error = (String) request.getAttribute("error");
if (error != null) {
%>
<p style="color:red;"><%= error %></p>
<%
}
%>

<form action="category-register" method="post">
  カテゴリID：<input type="text" name="id"><br><br>
  カテゴリ名：<input type="text" name="categoryName"><br><br>
  <input type="submit" value="登録">
</form>

</body>
</html>
