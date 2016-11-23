$(document).ready(function(){
	
	$(".movieTitle").html("<h4>" + $(".name").text() + "</h4>");
	
	{
		
		// filmin tarihine göre ne kadar zaman önce yüklendiğini ayarlayan method
		$(".loadingDateOfTheMovie").each(function(){ // bu satırla bütün loadingDateOfTheMovie divlerini getiriyoruz. (çünkü filmin yüklenme tarihi orda yazıyor)
			var loadingDate = $(this).text(); // ilgili filmin yüklenme tarihini burdan alıyoruz ve işlemlere başlıyoruz

			
			var nowDate = new Date(); // şuan ki tarihi alıyoruz
			
			// filmin yüklendiği tarih örneği <div class="loadingDateOfTheMovie">1995-03-01</div>
			var passYear =  nowDate.getFullYear() - loadingDate.split("-")[0]; // şuanki yıldan , filmin yüklendiği yıldan  çıkarıyoruz
			var passMonth = (nowDate.getMonth() + 1) - loadingDate.split("-")[1]; // şuanki aydan , filmin yüklendiği ayı  çıkarıyoruz
			var passDay =   nowDate.getDate() - loadingDate.split("-")[2]; //// şuanki günden , filmin yüklendiği günü  çıkarıyoruz
			
			if(passYear > 0) { 
				$(this).html(passYear + " yıl önce eklendi.");
			}
			else if(passMonth > 0){
				$(this).html(passMonth + " ay önce eklendi.");
			}
			else if(passDay > 0) {
				$(this).html(passDay + " gün önce eklendi.");
			}
			else {
				$(this).html("Bugün eklendi.");
			}
			// if else ile kontroll ediyoruz ve ilgili div'i kaç gün yada kaç ay geçtiyse biçimlendiriyoruz
		});
	}
	
	
	
	{
		// category sayfasındaki pagination ayarları
		var url = $(".getUrl").text();
		var totalMovie = $(".totalMovie").text();
		var totalPage = Math.round(totalMovie / 21) + 1 ;
	
		$('#pagination').twbsPagination({
	        totalPages: totalPage,
	        visiblePages: 4,
	        href: url + '?page_no={{number}}'
		});
	}
});