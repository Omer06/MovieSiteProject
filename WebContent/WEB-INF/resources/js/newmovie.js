$(document).ready(function() {
	$(".movieTitle").html("Yeni Film Ekle");

	
	{
		// bu blok yeni entityler ekleyeceğimiz frumlarım gösteriyor/gizliyor
		$("#button").click(function(){
			if($("#button").val() == "+")
			{
				$(".newEntityAddingField").show(250);
				$("#button").val("-");
			}
			else {
				$(".newEntityAddingField").hide(250);
				$("#button").val("+");
			}
			
		});
		
	}
	
	{
		//bu blok yeni entity alanındaki butonları takip ediyor
		$(".newEntityAddingField form :text").keyup(function(){
			if($(this).val() != "") {
				$(this).next().fadeIn("slow");
			}
			else{
				$(this).next().fadeOut("slow");
			}
		});
	}
	
	{
		//bu blok yeni film alanındaki tüm input textarea vb. tüm alanları kontrol(validate) ediyor
		var checkBoxControllResult = false;
		
		 $("#newMovieForm").submit(function(){
			 var errorText = "";
			 
			 
			 $("#title , #name , #hit , #releaseDate , #embedPath , #posterPath , #subject").each(function(){
				 if($(this).val() == "") {
					 errorText += $(this).attr("placeHolder") + " Alanını Girmeyi Unuttunuz. <br/>"
				 }
			 });
			 
			 $("select").each(function(){
				 if($(this).val() == ""){
					 errorText += $(this).attr("id") + " Seçmeyi Unuttunuz. <br/>";
				 }
			 });
			 
			 	if(!checkBoxControll())
				 {
					 errorText += "Kategorileri Seçmeyi Unuttunuz. <br/>";
				 }
			 	
			 	var ext = $('#posterImg').val().split('.').pop().toLowerCase();
			 	
			 	if($.inArray(ext, ['gif','png','jpg','jpeg']) == -1) {
			 	    errorText += "Seçdiğiniz Dosyanın : gif , png , jpg , jpeg. <br/>";
			 	}
				 
					 
			 
				 
			 
			 $(".resultField").html(errorText);
			 return errorText == "";
		 });
		 
		 
		 function checkBoxControll() {
			 checkBoxControllResult = false;
			 
			 $(":checkbox").each(function(){
				 if($(this).is(":checked")){
					 checkBoxControllResult = true;
				 }
			 });
	
			 return checkBoxControllResult;
		 }
	}
	
	
});