jQuery.extend({
	"uploadresource": function(upload, root, options) {
		var defaults = {
			elem: '#upload',
			auto: false,
			bindAction: "#uploadBtn",
			multiple: true,
			accept: "file",
			choose: function(obj) {
				files = obj.pushFile(); // 将每次选择的文件追加到文件队列			
				// 读取本地文件
				obj.preview(function(index, file, result) {
					var tr = $(['<tr id="upload-' + index + '">', '<td>' + file.name + '</td>', '<td>' + (file.size / 1014).toFixed(1) + 'kb</td>', '<td>等待上传</td>', '<td>', '<button class="layui-btn layui-btn-mini layui-btn-normal file-setting" lay-file-index="' + index + '">设置属性</button>', '<button class="layui-btn layui-btn-mini file-reload layui-hide">重传</button>', '<button class="layui-btn layui-btn-mini layui-btn-danger file-delete">删除</button>', '</td>', '</tr>'].join(''));
					// 单个重传
					tr.find('.file-reload').on('click', function() {
						obj.upload(index, file);
					});

					// 删除
					tr.find('.file-delete').on('click', function() {
						delete files[index]; // 删除对应的文件
						tr.remove();
					});

					tr.find('.file-setting').on('click', function() {
						var index = $(this).attr("lay-file-index");
						layer.open({
							type: 2,
							resize: false, //不允许拉伸
							anim: 2,
							move: false,
							shade: 0.001,
							title: '设置资源属性',
							area: ['680px', '300px'],
							content: [root + '/Resource/Extra/' + index, 'no'],
							end: function() {
								//设置文件参数
								var label = $("#label").val();
								var grouptype = $("#grouptype").val();
								var description = $("#description").val();
								if(label != "" && grouptype != "") {
									var file = files[index];
									file.extra = {
										label: label,
										grouptype: grouptype,
										description: description
									};
								} else {
									parent.layer.msg("请设置资源属性", {
										icon: 5,
										anim: 6
									});
								}
							}
						});
					});

					fileList.append(tr);
				});
			},
			done: function(res, index, upload) {
				if(res.code == 0) { // 上传成功
					var tr = fileList.find('tr#upload-' + index),
						tds = tr.children();
					tds.eq(2).html('<span style="color: #5FB878;">上传成功</span>');
					tds.eq(3).html(''); // 清空操作
					delete files[index]; // 删除文件队列已经上传成功的文件
					return;
				}
				this.error(index, upload);
			},
			error: function(index, upload) {
				var tr = fileList.find('tr#upload-' + index),
					tds = tr.children();
				tds.eq(2).html('<span style="color: #FF5722;">上传失败</span>');
				tds.eq(3).find('.file-reload').removeClass('layui-hide'); // 显示重传
			}
		};
		var opts = $.extend(defaults, options);
		var fileList = $("#fileList");
		var files = [];
		upload.render(opts);
	}
});