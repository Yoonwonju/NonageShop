<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>우편 번호 검색</title>
<link rel="stylesheet" type="text/css" href="css/findZipNum.css">
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script> 
<script type="text/javascript">
	function result(zipNum,sido,gugun,dong) {
	    $("#zipNum", window.opener.document).val(zipNum);
	    $("#addr1", window.opener.document).val(sido + " " + gugun + " " + dong);
	   self.close();
	};
</script>
</head>
<body>
<div id="popup">
  <h1>우편번호검색</h1>
  <form method=post name=formm action="findZipNum.do">
    동 이름 : <input name="dong" type="text">
            <input type="submit" value="찾기"  class="submit">
  </form>
  <table id="zipcode">
    <tr>
      <th>우편번호</th>
      <th>주소</th>
    </tr>
    <c:forEach items="${addressList}" var="address">
    <tr>
      <td>${address.zipNum}</td>
        <td>
          <a href="#" onclick="return result('${address.zipNum}','${address.sido}', '${address.gugun}','${address.dong}')">
            ${address.sido} ${address.gugun} ${address.dong} 
          </a>
        </td>
    </tr>
    </c:forEach>
  </table>
</div>
</body>
</html>