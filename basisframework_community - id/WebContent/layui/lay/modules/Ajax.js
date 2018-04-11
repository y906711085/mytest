jQuery.extend({
	"Request": function(options) {
		var defaults = {
			type: "post",
			dataType: "json",
			success: function(data, textStatus) {

			},
			error: function(XMLHttpRequest, textStatus, errorThrown) {
				if(console) {
					console.log(XMLHttpRequest)
				}
			}
		};
		var opts = $.extend(defaults, options);
		$.ajax(opts);
	}
});