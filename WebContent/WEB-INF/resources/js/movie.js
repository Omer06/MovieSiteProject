$(document).ready(function(){
	$(".movieTitle").html("<h4>" + $(".name").text() + "</h4>");
	
	
	{
		// Film sayfasındaki genel bilgi alanını kapsayan tablonun satır renkleri ayarı
		$(".generalInfo tr").each(function(i){
			if(i % 2 == 1) {
				$(this).css("background-color","#DEDEDE");
			}
		});
		
		$(":input[type='submit']").mousedown(function(){
			$(this).css("background-color" ,"#F1F1F1");
		}).mouseup(function(){
			$(this).css("background-color" ,"#E3E3E3");
		});
	}
	
	
	{
		// film sayfasındaki yorum ayarı ajax kullanıldı
		$("#commentForm").submit(function(){
			$.ajax({
				type : $("#commentForm").attr("method"),
				url : $("#commentForm").attr("action"),
				data : $("#commentForm").serialize(),
				success : function(response) {
					$(".comments").remove();
					$(".result").remove();
					$(".commentWrapper").append("<div class='result' style='color:red;font:16px serif'>"+ response.message +"</div>")
					for(var i =0; i<response.commentList.length;i++){
						$(".commentWrapper").append("<div class='comments'> <div class='audienceNameField'>"+ response.commentList[i].audienceName +"</div> <div class='dateField'>"+ response.commentList[i].date +"</div>  <div class='commentField'>"+ response.commentList[i].comment +"</div> </div>")
					}
					 // form alanındaki verileri temizliyoruz
					$(":text").val("");
					$("textarea").val("");
				},
			
				error : function() {
					$(".commentWrapper").append("<div class='result' style='color:red;font:16px serif'>Yorumu eklerken beklenmedik bir hata oluştu</div>")
				}
			});

			return false;
		});
	}
	
});