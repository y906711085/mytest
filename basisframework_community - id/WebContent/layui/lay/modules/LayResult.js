jQuery.extend({
	"Result": function(Result) {
		var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
		if(Result.ResultType == "Success") {
			parent.layer.close(index); //关闭父页面 
			parent.$('#dialogresult').val(true);
			parent.layer.msg(Result.Message, {
				icon: 1
			});
		} else {
			parent.layer.msg(Result.Message, {
				icon: 5,
				anim: 6
			});
		}
	}
});