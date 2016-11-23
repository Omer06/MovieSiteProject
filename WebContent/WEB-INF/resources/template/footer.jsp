<%@page import="java.util.ArrayList"%>
<%@page import="com.entities.Category"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
</div>
 		</div>
 		<div class="optional">
 			<div class="categoryField">
 				<div class="categoryTitle">Kategoriler</div>
 				<div class="categorys">
 					<ul>
 						<c:forEach items="${categoryList}" var="category">
 							<li><a href="${pageContext.request.contextPath}/category/${fn:toLowerCase(category.name)}/movielist?page_no=1">${category.name}</a></li>
 						</c:forEach>
 					</ul>
 				</div>
 			</div>
 			<div class="optionField">
 				<div class="optionTitle">Seçenekler</div>
 				<div class="options"></div>
 			</div>
 		</div>
 	</div>
 	<div class="newMoviesFieldTitle">Yeni Eklenenler</div>
 	<div class="newMoviesField">
 		<c:forEach items="${newMovieList}" var="movie"> 
 			<div class="newMovie">
 				<div align="center" class="newMovieName">${movie.name}</div>
 				<div class="newMoviePoster">
 					<a href="${pageContext.request.contextPath}/movie/getmovie?movie_id=${movie.id}"><img src="${pageContext.request.contextPath}/posterimg/${movie.posterPath}" height="100%" width="100%" style="border-radius:5px"></a>
 				</div>
 				<div class="newMoviePointAndHit">
 					<ul>
 						<li>Imdb : ${movie.imdbPoint.point}</li>
 						<li>Izlenme : ${movie.hit}</li>
 					</ul>
 				</div>
 				<div class="newMovieLanguage" align="center">
 					${movie.language.movieLanguage }
 				</div>
 			</div>
 		</c:forEach>
 	</div>
</div>
</body>
</html>