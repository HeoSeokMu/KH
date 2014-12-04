<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
${b_num}
${b_name}
${email}

<form action="reservePro.kh" method="post" name="userinput">
<input type="hidden" name="b_num" value="${b_num}"/>
<input type="hidden" name="b_name" value="${b_name}"/>
<input type="hidden" name="email" value="${email}"/>
위 사항이 맞습니까???

<input type="submit" value="확인"/>
</form>