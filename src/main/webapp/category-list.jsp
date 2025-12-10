<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="model.entity.CategoryBean" %>

<!-- ページの設定 -->
<!-- contentType: 出力するHTMLの文字コードをUTF-8に指定 -->
<!-- import: JSP内で使うクラスをインポート（ListとCategoryBean） -->

<html>
<head>
<meta charset="UTF-8">
<title>カテゴリリスト</title>
<style>
    /* テーブルの見た目を整えるCSS */
    table {
        border-collapse: collapse; /* 枠線を重ねて表示 */
        width: 300px;              /* テーブル幅 */
    }
    th, td {
        border: 1px solid black;   /* 枠線を黒で表示 */
        padding: 6px;              /* 内側余白 */
        text-align: left;          /* 左寄せ */
    }
</style>
</head>
<body>

<h1>カテゴリリスト</h1>

<%
    // サーブレットから渡されたリクエスト属性 "categoryList" を受け取る
    // これは List<CategoryBean> 型にキャストして使う
    List<CategoryBean> list = (List<CategoryBean>) request.getAttribute("categoryList");
%>

<table>
    <tr>
        <th>カテゴリID</th>
        <th>カテゴリ名</th>
    </tr>
    <%
        // 取得したカテゴリ一覧を1件ずつループして表示
        for (CategoryBean cb : list) {
    %>
    <tr>
        <!-- CategoryBeanのgetterで値を取り出し、HTMLに埋め込む -->
        <td><%= cb.getCategoryId() %></td>
        <td><%= cb.getCategoryName() %></td>
    </tr>
    <% } %>
</table>

</body>
</html>