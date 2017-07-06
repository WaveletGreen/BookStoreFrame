$(function() {
/*	$("#toOrderForm").submit(function() {
		var book_id = [];
		var i = 1;
		$("[name='book_id']").each(function() {
			if ($(this).is(":checked")) {
				book_id.push($(this).val());
				i++;
			}
		});
		var param;
		var string = '';
		for (var int = 0; int < book_id.length; int++) {
			param = jQuery.param({
				"book_id" : book_id[int]
			});
			string += param;
		}
		alert(string);
		location.href = "fancOrderFunction_putIntoUserCart?" + string;
		return false;
	});*/
	$("[name='book_id']").each(function() {
		$(this).bind("checked", function() {
			alert($(this).val());
		});
	});
});