<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib uri="http://www.springframework.org/tags/form"  prefix="form" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Admin Panel</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/newmovie.css" />

</head>
<body>


<jsp:include page="../../resources/template/header.jsp" />

<div class="newMovieFormField">
	<form:form id="newMovieForm" action="${pageContext.request.contextPath}/admin/newmovie/save" modelAttribute="newMovieObj" enctype="multipart/form-data" >
		<div class="titleInputField">
			<form:input path="title" placeHolder = "Title" />
		</div>
		<div class="nameHitReleaseDateInputFile">
			<form:input path="name" placeHolder = "Name" />
			<form:input path="hit" type="number" placeHolder = "Hit"/>
			<form:input path="releaseDate" placeHolder = "Release Date" pattern = "[0-9]{4}" title="Örnek Eşleştirme : 1995"/>
		</div>
		<div class="directorImdbPointInputField">
			<select id="Director" name="director.id">
				<option value="">Director</option>
				<c:forEach items="${directorList}" var="director" >
					<option value="${director.id}">${director.name}</option>
				</c:forEach>
			</select>
			<select id="ImdbPoint"  name="imdbPoint.id">
				<option value="">Imdb Point</option>
				<c:forEach items="${imdbPointList}" var="imdbPoint">
					<option value="${imdbPoint.id}">${imdbPoint.point}</option>
				</c:forEach>
			</select>
			<select id="Language"  name="language.id">
				<option value="">Language</option>
				<c:forEach items="${languageList}" var="language">
					<option value="${language.id}">${language.movieLanguage}</option>
				</c:forEach>
			</select>
		</div>
		<div  class="categoryInputField">
			<h3 align="center" style="font: bold 20px serif">Category</h3>
			<c:forEach items="${categoryList}" var="category">
				<label>
					<input type="checkbox" name="categoryIdOfTheMovie" value="${category.id}" />${category.name}
				</label>
			</c:forEach>
		</div>
		<div class="posterEmbedPathInputField">
			<form:input path="embedPath" placeHolder="Embed"/>
			<input type="file" id=posterImg name="posterImg" required style="margin: 3px 0 0 8px" />
		</div>
		<div class="subjectInputField">
			<form:textarea path="subject" placeHolder="subject" maxlength="600" title="Sayi 100 ile 600 arasında olacak"/>
		</div>
		<div class="submitInputfield">
			<input id="button" type="button" value="+" />
			<input id="submit" type="submit" value="Add" />
		</div>
		<div class="resultField">${result}</div>
	</form:form>
</div>
<div class="newEntityAddingField" style="display:none">
	<form id="newCategoryForm" action="${pageContext.request.contextPath}/admin/newcategory/save">
		<input class="text" type="text" name="name" placeHolder="Category" required/> <input class="submit" type="submit" value="Add" />
	</form>
	<form id="newDirectorForm" action="${pageContext.request.contextPath}/admin/newdirector/save">
		<input class="text" type="text" name="name" placeHolder="Director" required/> <input class="submit" type="submit" value="Add" />
	</form>
	<form id="newPointForm" action="${pageContext.request.contextPath}/admin/newimdbpoint/save">
		<input class="text" type="text" name="point" placeHolder="ImdbPoint" required pattern="[1-9]{1},[1-9]{1}" title="Uygunsuz biçim örnek : 9,9"/> <input class="submit" type="submit" value="Add" />
	</form>
	<form id="newLanguageForm" action="${pageContext.request.contextPath}/admin/newlanguage/save">
		<input class="text" type="text" name="movieLanguage" placeHolder="Language" required /> <input class="submit" type="submit" value="Add" />
	</form>
</div>
<jsp:include page="../../resources/template/footer.jsp" />
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/newmovie.js"></script>
</body>
</html>