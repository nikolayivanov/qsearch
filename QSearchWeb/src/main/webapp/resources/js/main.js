function postQuestionsViaAjax()
{	
	
	$.ajax({
		type: 'POST',
		url: 'get-results-ajax',
		contentType: "application/json",
		data: JSON.stringify({"query": $('#query').val()}),
		success: function(htmlfragment) {			
			$('#div-questions').html(htmlfragment);
		}
	});
}

//Binds to the global ajax scope
$(document).ajaxStart(function() {
	$("#spinner").show();
});

$(document).ajaxComplete(function() {
   $("#spinner").hide();
});