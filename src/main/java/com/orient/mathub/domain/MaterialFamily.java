package com.orient.mathub.domain;

import com.tinkerpop.frames.Property;
import com.tinkerpop.frames.VertexFrame;

public interface MaterialFamily extends VertexFrame{
	
	@Property("name")
	public void setName(String name);
	@Property("name")
	public String getName();

}
