jQuery.extend({
	"loadflow": function(flow, options) {
		var defaults = {
			elem: '#Media', //流加载容器
			scrollElem: '#Media', //滚动条所在元素，一般不用填，此处只是演示需要。
			isAuto: true,
			isLazyimg: true,
			done: function(page, next) { //加载下一页
				//获取数据
				//获取图片数据
				$.post("$root.contextPath/Resource/ResourceMedia", {
					page: page,
					limit: 15,
					type: value
				}, function(result) {
					var lis = [];
					for(var i = 0; i < result.data.length; i++) {
						lis.push('<li onclick="selectItem(this);"><img lay-src="' + result.data[i].content + '" lay-id="' + result.data[i].Id + '"></li>')
					}
					next(lis.join(''), page < result.Pagination); //假设总页数为 6
				});

			}
		};
		var opts = $.extend(defaults, options);
		flow.load(opts);
	}
});