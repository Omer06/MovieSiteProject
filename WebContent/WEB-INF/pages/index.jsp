<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib  uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>AnaSayfa</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/index.css" />
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/pagination.css" />
</head>
<body>
<jsp:include page="../resources/template/header.jsp"/>
	

<c:forEach items="${movieList}" var="movie">
		<div class="movie">
			<div class="posterOfTheMovie">
				<a href="${pageContext.request.contextPath}/movie/getmovie?movie_id=${movie.id}"><img src="${pageContext.request.contextPath}/posterimg/${movie.posterPath}" height="100%" width="100%" style="border-radius:5px"></a>
			</div>
			<div class="infoOfTheMovie">
				<ul>
					<li>Film : ${movie.name}</li>
					<li>Dil : ${movie.language.movieLanguage}</li>
					<li>İzlenme : ${movie.hit}</li>
					<li>İmdb : ${movie.imdbPoint.point}</li>
				</ul>
			</div>
			<div class="loadingDateOfTheMovie">${movie.loadingDate}</div>
		</div>
	</c:forEach>
	<div class="paginationWrapper" align="center">
		<div style="display: none" class="getUrl">${pageContext.request.contextPath}/index</div>
		<div style="display: none" class="totalMovie">${totalMovie}</div>
		<div class="paginationHolder" align="center">
		<ul id="pagination"></ul>
		</div>
	</div>
<jsp:include page="../resources/template/footer.jsp"/>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.twbsPagination.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/index.js"></script>
</html>