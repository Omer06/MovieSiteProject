$(document).ready(function(){
	
	{
		
		// filmin tarihine göre ne kadar zaman önce yüklendiğini ayarlayan method
		$(".loadingDateOfTheMovie").each(function(){
			var loadingDate = $(this).text(); // yüklenme tarihini burdan alıyoruz ve işlemlere başlıyoruz
			
			var nowDate = new Date();
			
			var passYear =  nowDate.getFullYear() - loadingDate.split("-")[0];
			var passMonth = (nowDate.getMonth() + 1) - loadingDate.split("-")[1];
			var passDay =   nowDate.getDate() - loadingDate.split("-")[2];
			
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