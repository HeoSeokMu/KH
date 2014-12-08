<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<script src="/KH_School/member/script/addr.js"></script>

<style type='text/css'>

  A:link { text-decoration:none; color:#111111;}
  A:visited { text-decoration:none; color:#111111;}
  A:active { text-decoration:underline; color:#111111;}
  A:hover {color:skyblue; text-decoration:underline;}

 </style>

<form action="searchAddrPro.kh" method="post" name="juso_input">

<table align="center">
<tr align="center" bgcolor="77CC55">
	<td><br />
	<font size="5"><b>주 소 검 색</b></font><br /><br />
	<font size="2">주소를 읍, 면, 동 까지만 검색해주세요.</font><br /><br />
	<input type="text" name="addrSearch">
	<input type="submit" value="검색" onClick="">
	<br />&nbsp;
	</td>
</tr>

<tr bgcolor="BBEE99">
	<td>	
		<table align="center" width="550">
			
			<tr align="center">
				<td colspan="2">
					<hr>
				</td>
			</tr>
			<tr align="center">
				<td width="100px">우편번호</td>
				<td>주 소</td>
			</tr>
			<tr align="center">
				<td colspan="2">
					<hr>
				</td>
			</tr>
			<c:if test="${not empty postlist}">
			<c:forEach var="list" items="${postlist}">
				<tr>
					<td align="center"><a href="#" onClick="sendAddr('${list.zipcode}');">${list.zipcode}</a>
					<input type="hidden" name="addrSum${list.zipcode}" value="${list.zipcode},${list.addr}">
					</td>
					<td align="left"><a href="#" onClick="sendAddr('${list.zipcode}');"><font size="2">${list.addr}</font></a>
					</td>
				</tr>

				<tr align="center">
					<td colspan="2">
						<hr>
					</td>
				</tr>
			</c:forEach>
			</c:if>
			
			<c:if test="${empty postlist}">
				<tr align="center">
					<td colspan="2">검색된 결과가 없습니다.</td>
				</tr>

				<tr align="center">
					<td colspan="2">
						<hr>
					</td>
				</tr>
			</c:if>
		</table>
	</td>
</tr>
</table>
</form>