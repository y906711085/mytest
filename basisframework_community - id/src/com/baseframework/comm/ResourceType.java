package com.baseframework.comm;

public enum ResourceType {
	Text("文本", "Text"), Images("图像", "Images"), Viedo("视频", "Viedo"), Audio("音频", "Audio");
	private String name;
	private String type;

	// 构造方法
	private ResourceType(String name, String type) {
		this.name = name;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}
}
