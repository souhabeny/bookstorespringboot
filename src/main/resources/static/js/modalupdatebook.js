$(document).ready(function() {      
      
     $( ".btnedit" ).click(function(event) {
	event.preventDefault();
	
  var href=$(this).attr("href");

	$.get(href,function(book,status){
			$('#idedit').val(book.id);
			$('#titleedit').val(book.title);
			$('#authoredit').val(book.author);
			$('#priceedit').val(book.price);
			$('#pdateedit').val(book.pdate);
			$('#descriptionedit').val(book.description);
			$('#qteedit').val(book.qte);
			$('#categorie_idedit').val(book.categorie.id);
			//alert("hiii");
			
		});
	//$('#modalupdate').modal();
	$('#modalupdate').modal('show');
});   
});