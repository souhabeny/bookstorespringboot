
$(document).ready(function() {      
      
     $( ".btnedit" ).click(function(event) {
	event.preventDefault();
	
  var href=$(this).attr("href");

	$.get(href,function(categorie,status){
			$('#idedit').val(categorie.id);
			$('#nomedit').val(categorie.nom);
			$('#descedit').val(categorie.description);
			//alert("hiii"+categorie.id+" "+categorie.nom+" "+categorie.description+""+status);
			
		});
	//$('#modalupdate').modal();
	$('#modalupdate').modal('show');
}); 
  
});
