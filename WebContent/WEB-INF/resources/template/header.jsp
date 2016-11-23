<%@page import="com.entities.Movie"%>
<%@page import="com.servicesImpl.MovieServiceImpl"%>
<%@page import="com.daoImpl.MovieDaoImpl"%>
<%@page import="com.servicesImpl.EntityServiceImpl"%>
<%@page import="com.entities.Category"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.springframework.web.servlet.support.RequestContextUtils"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	
	
	<%
		request.getSession().setAttribute("categoryList", (ArrayList<Category>) ((EntityServiceImpl)RequestContextUtils.getWebApplicationContext(request).getBean("entityServiceImpl")).getList("category"));
		request.getSession().setAttribute("populerMovieList", (ArrayList<Movie>) ((MovieServiceImpl)RequestContextUtils.getWebApplicationContext(request).getBean("movieServiceImpl")).getPopulerMovies());
	%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/template.css" />
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/common.css" />
</head>
<body>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jqueryLib.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jssor.slider.mini.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/template.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/common.js"></script>


<div class="top">
	<div class="header">
		<div class="logo"></div>
		<div class="menu">
			<ul>
				<li id="girisYap"><a href="${pageContext.request.contextPath}/">AnaSayfa</a></li>
				<li><a href="#">Hakkımızda</a></li>
				<li><a href="#">İletişim</a></li>
				<li><a href="">Arzu/Talep</a></li>
			</ul>
		</div>
	</div>
	<div class="search">
			<form id="searchForm" action="${pageContext.request.contextPath}/search" method="post">
				<table>
					<tr>
						<td>Film Ara : </td> <td><input id="text" type="text" name="movie_name" placeHolder="Film Adı"/></td><td><input id="submit" type="submit" value=""/></td>
					</tr>
				</table>
			</form>
	</div>
</div>

<div class="middle">
	<div class="popularMoviesTitle">Popüler Filmler</div>
 	<div class="popularMoviesField">
 		<div id="jssor_1" style="position: relative; margin:0 auto; top: 0px; left: 0px; width: 1900px; height: 570px; overflow: hidden; visibility: hidden;">
        <!-- Loading Screen -->
        <div data-u="loading" style="position: absolute; top: 0px; left: 0px;">
            <div style="filter: alpha(opacity=70); opacity: 0.7; position: absolute; display: block; top: 0px; left: 0px; width: 100%; height: 100%;"></div>
            <div style="position:absolute;display:block;background:url('/ExampleApplication/resources/image/loading.gif') no-repeat center center;top:0px;left:0px;width:100%;height:100%;"></div>
        </div>
        <div data-u="slides" style="cursor: default; position: relative; top: 0px; left: 0px; width: 1900px; height: 580px; overflow: hidden;">
            <c:forEach items="${populerMovieList}" var="movie">
            	 <div style="display: none;">
                	<a href="${pageContext.request.contextPath}/movie/getmovie?movie_id=${movie.id}"><img data-u="image" src="${pageContext.request.contextPath}/posterimg/${movie.posterPath}" style="border-radius:20px"></a>
            	</div>
            </c:forEach>
            <a data-u="add" href="http://www.jssor.com" style="display:none">Jssor Slider</a>
        
        </div>
        <!-- Bullet Navigator -->
        <div data-u="navigator" class="jssorb03" style="bottom:10px;right:10px;">
            <!-- bullet navigator item prototype -->
            <div data-u="prototype" style="width:21px;height:21px;">
                <div data-u="numbertemplate"></div>
            </div>
        </div>
        <!-- Arrow Navigator -->
        <span data-u="arrowleft" class="jssora03l" style="top:0px;left:8px;width:55px;height:55px;" data-autocenter="2"></span>
        <span data-u="arrowright" class="jssora03r" style="top:0px;right:8px;width:55px;height:55px;" data-autocenter="2"></span>
    </div>
 	</div>
 	<div class="content">
 		<div class="moviesField">
 			<div class="movieTitle">Filmler</div>
 			<div class="movies">
