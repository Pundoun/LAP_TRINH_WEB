<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/commons/taglib.jsp"%>

<form action="<c:url value="/admin/category/update"/>" method="post">

	<input type="text" name="categoryid" hidden="hidden" value="${cate.categoryid}"><br>
	<label for="fname">Category name:</label><br> 
	<input type="text" id="categoryname" name="categoryname" value="${cate.categoryname}"><br> 
	<label for="lname">Link images:</label><br> 
	
		<c:if test="${cate.images.substring(0,5) == 'https' }">
			<c:url value="${cate.images }" var="imgUrl"></c:url>
		</c:if>
		<c:if test="${cate.images.substring(0,5)!= 'https' }">
			<c:url value="/image?fname=${cate.images }" var="imgUrl"></c:url>
		</c:if>

		<img height="150" width="200" src="${imgUrl}" />
	
	<input type="text" id="images" name="images" value="${cate.images}"><br> 
	
	<label for="images1">Upload file:</label><br>
	<input type="file" id="images1" name="images1" value="${cate.images}"> <br>
	
	<label for="lname">Status:</label><br>
	<input type="radio" id="ston" name="status" value="1"> 
	<label for="css">Hoạt động</label><br> 
	<input type="radio" id="stoff" name="status" value="0">
	<label for="javascript">Khóa</label><br>
	<hr>
	<input type="submit" value="Submit"><br>
</form>