
$(document).ready(function(){
	
	  $("#searchForm").submit(function(){
	      	
	      	$.ajax({
					type : $("#searchForm").attr("method"),
					url : $("#searchForm").attr("action"),
					data : $("#searchForm").serialize(),
					success : function(response) {
						$(".movies").html("");
						if( response.movieList.length > 0) {
							for(var i = 0; i< response.movieList.length;i++) {
								$(".movies").append("<div class='searchmovie'>" +
										"<div class='posterOfTheMovie'>" +
										"<a href='/ExampleApplication/movie/getmovie?movie_id="+ response.movieList[i].id +"'><img src='/ExampleApplication/posterimg/"+ response.movieList[i].posterPath +"' height='100%' width='100%' style='border-radius:5px'></a>" +
										"</div>" +
										"<div class='infoOfTheMovie'>" +
										"<ul>" +
										"<li>Film : "+ response.movieList[i].name +"</li>" +
										"<li>Dil : "+ response.movieList[i].language.movieLanguage +"</li>" +
										"<li>İzlenme : "+ response.movieList[i].hit +"</li>" +
										"<li>İmdb : "+ response.movieList[i].imdbPoint.point +" </li>" +
										"</ul>" +
										"</div>" +
										"<div class='loadingDateOfTheMovie'>"+ response.movieList[i].loadingDate + "</div>" +
										"</div>");          
							}
						}
						else {
							alert("Aradığınız film sitemizde mevcut değildir.\n \n" +
									"Arzu/Taleb menüsünden bize bildirirseniz memnun oluruz.")
						}
					},
					error : function() {
						alert("film aranırken beklenmedik bi hata oluştu.")
					}
				});
	      		return false;
	      });
	  
		{
			//Film posterlerinin üzerine gelince tetiklenecek methodlar
			$("img").mouseover(function(){
				$(this).fadeTo(240,0.7);
			}).mouseout(function(){
				$(this).fadeTo(240,1);
			});
		}
	
});