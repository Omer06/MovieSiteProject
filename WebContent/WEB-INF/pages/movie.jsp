<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>${movieObj.name}</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/movie.css" />

</head>
<body>
	
<jsp:include page="../resources/template/header.jsp" />

	<div class="name" style="display: none">${movieObj.title}</div>
	
	<div class="movieInfo">
		<div class="moviePoster">
			<img src="${pageContext.request.contextPath}/posterimg/${movieObj.posterPath}" height="320" width="220">
		</div>
		<div class="generalInfo">
			<table style="width: 100%">
				<tr>
					<td colspan="2" align="center" id="generalInfoTitle">Genel Bilgi</td>
				</tr>
				<tr>
					<td>Film : </td> <td id="info">${movieObj.name}</td>
				</tr>
				<tr>
					<td style="width: 80px">Yönetmen : </td> <td id="info">${movieObj.director.name}</td>
				</tr>
				<tr>
					<td>Yapım : </td> <td id="info">${movieObj.releaseDate}</td>
				</tr>
				<tr>
					<td>İmdb : </td> <td id="info">${movieObj.imdbPoint.point}</td>
				</tr>
				<tr>
					<td>Dil : </td> <td id="info">${movieObj.language.movieLanguage}</td>
				</tr>
				<tr>
					<td>İzlenme : </td> <td id="info">${movieObj.hit}</td>
				</tr>
				<tr>
					<td>Kategori : </td> <td id="info">
						<c:forEach items="${movieObj.categoryList}" var="category">
							<a href="${pageContext.request.contextPath}/category/${fn:toLowerCase(category.name)}/movielist?page_no=1">${category.name}</a> 
						</c:forEach>
					</td>
				</tr>
			
			</table>
		</div>
	</div>
	
	<div class="movie">
		<iframe width="650" height="420" src="${movieObj.embedPath}" frameborder="1" allowfullscreen></iframe>
	</div>
	
	<div class="movieSubject">
			<span class="subjectTitle">Konu :</span> ${movieObj.subject}
	</div>
	
	<div class="commentWrapper" id="commentWrapper">
		<div class="commentFieldTitle">Film Hakkında Ne Düşünüyorsun ? </div>
		<div class="commentFormField">
			<form class="commentForm" id="commentForm" action="${pageContext.request.contextPath}/admin/newcomment/save" method="post">
				<div style="display: none">
					<input type="hidden" name="movie_id" value="${movieObj.id}"/>
				</div>
				<div class="audienceNameField">
					<input type="text" name="audienceName" required placeHolder ="Adınızı Giriniz..."/>
				</div>
				<div class="commentField">
					<textarea rows="4" cols="50" maxlength="240" name="comment" placeHolder ="Görüşünüzü Yazınız..."></textarea>
				</div>
				<div class="sendField">
					<input type="submit" value="Yorum Yap" />
				</div>
		</form>
		</div>
		<c:if test="${empty movieObj.commentList}">
			<div class="result">
				Bu filme henüz yorum eklenmemiş...
			</div>
		</c:if>
		<c:if test="${not empty movieObj.commentList}">
			<c:forEach items="${movieObj.commentList}" var="comment">
				<div class="comments">
					<div class="audienceNameField">${comment.audienceName}</div>
					<div class="dateField">${comment.date}</div>
					<div class="commentField">${comment.comment}</div>
				</div>
			</c:forEach>
		</c:if>
	</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/movie.js"></script>
<jsp:include page="../resources/template/footer.jsp" />
</body>
</html>