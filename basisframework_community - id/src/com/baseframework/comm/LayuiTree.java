package com.baseframework.comm;

import java.util.List;

public class LayuiTree {

	private int id;
	
	private String name;
	
	private boolean spread;
	
	private List<LayuiNode> children;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isSpread() {
		return spread;
	}

	public void setSpread(boolean spread) {
		this.spread = spread;
	}

	public List<LayuiNode> getChildren() {
		return children;
	}

	public void setChildren(List<LayuiNode> children) {
		this.children = children;
	}
	
}
