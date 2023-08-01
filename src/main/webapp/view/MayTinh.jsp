<%--
  Created by IntelliJ IDEA.
  User: LongTH
  Date: 27/07/2023
  Time: 03:51 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>May Tinh Manager</title>
</head>
<body>
<form action="/may-tinh/add" method="post">
    mã: <input type="text" name="ma" value="${lap.ma}"/>
    <br><br>
    tên: <input type="text" name="ten" value="${lap.ten}"/>
    <br><br>
    giá: <input type="text" name="gia" value="${lap.gia}"/>
    <br><br>
    bộ nhớ: <input type="text" name="boNho" value="${lap.boNho}"/>
    <br><br>
    màu sắc:
    <br><br>
    <input type="radio" name="mauSac" value="Đen" ${lap.mauSac=="Đen"?'checked':''}/>Đen
    <input type="radio" name="mauSac" value="Bạc" ${lap.mauSac=="Bạc"?'checked':''}/>Bạc
    <br><br>
    hãng:
    <select name="hang">
        <option value="MSI" ${lap.hang == "MSI" ? 'selected' : ''}>MSI</option>
        <option value="ASUS" ${lap.hang == "ASUS" ? 'selected' : ''}>ASUS</option>
        <option value="ACER" ${lap.hang == "ACER" ? 'selected' : ''}>ACER</option>
        <option value="DELL" ${lap.hang == "DELL" ? 'selected' : ''}>DELL</option>
    </select>
    <br><br>
    miêu tả: <input type="text" name="mieuTa" value="${lap.mieuTa}"/>
    <br><br>
    <button type="submit">add</button>
</form>
<table>
    <tr>
        <th>mã</th>
        <th>tên</th>
        <th>giá</th>
        <th>bộ nhớ</th>
        <th>màu sắc</th>
        <th>hãng</th>
        <th>miêu tả</th>
        <th colspan="3">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${mayTinh}" var="mt">
        <tr>
            <td>${mt.ma}</td>
            <td>${mt.ten}</td>
            <td>${mt.gia}</td>
            <td>${mt.boNho}</td>
            <td>${mt.mauSac}</td>
            <td>${mt.hang}</td>
            <td>${mt.mieuTa}</td>
            <td>
                <button><a href="/may-tinh/remove?DeleteMa=${mt.ma}">Delete</a></button>
                <button><a href="/may-tinh/detail?DetailMa=${mt.ma}">Detail</a></button>
                <button><a href="/may-tinh/view-update?UpdateMa=${mt.ma}">Update</a></button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
