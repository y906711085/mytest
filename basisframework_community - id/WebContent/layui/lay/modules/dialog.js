jQuery.extend({
	"dialog": function(options) {
		var defaults = {
			type: 2,
			resize: false, //不允许拉伸
			anim: 2,
			area: ['600px', '400px'],
			shade: [0.4, '#393D49'],
			move:false
		};
		var opts = $.extend(defaults, options);
		layer.open(opts);
	}
});