<%--
  Created by IntelliJ IDEA.
  User: LongTH
  Date: 27/07/2023
  Time: 03:51 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update May Tinh</title>
</head>
<body>
<form action="/may-tinh/update" method="post">
    mã: <input type="text" name="ma" value="${mt.ma}"/>
    <br><br>
    tên: <input type="text" name="ten" value="${mt.ten}"/>
    <br><br>
    giá: <input type="text" name="gia" value="${mt.gia}"/>
    <br><br>
    bộ nhớ: <input type="text" name="boNho" value="${mt.boNho}"/>
    <br><br>
    màu sắc:
    <br><br>
    <input type="radio" name="mauSac" value="Đen" ${mt.mauSac=="Đen"?'checked':''}/>Đen
    <input type="radio" name="mauSac" value="Bạc" ${mt.mauSac=="Bạc"?'checked':''}/>Bạc
    <br><br>
    hãng:
    <select name="hang">
        <option value="MSI" ${mt.hang == "MSI" ? 'selected' : ''}>MSI</option>
        <option value="ASUS" ${mt.hang == "ASUS" ? 'selected' : ''}>ASUS</option>
        <option value="ACER" ${mt.hang == "ACER" ? 'selected' : ''}>ACER</option>
        <option value="DELL" ${mt.hang == "DELL" ? 'selected' : ''}>DELL</option>
    </select>
    <br><br>
    miêu tả: <input type="text" name="mieuTa" value="${mt.mieuTa}"/>
    <br><br>
    <button type="submit">update</button>
</form>
</body>
</html>
