package com.orient.mathub;

import com.tinkerpop.frames.Adjacency;
import com.tinkerpop.frames.Property;
import com.tinkerpop.frames.VertexFrame;
import com.tinkerpop.frames.annotations.gremlin.GremlinGroovy;

public interface Material {
 
	@Property("name")
	public void setName(String name);
	@Property("name")
	public String getName();
	
	@Property("description")
	public void setDescription(String description);
	@Property("description")
	public String getDescription();
	
	@Property("referenceURLs")
	public void setReferenceURLs(Iterable<String> urls);
	@Property("referenceURLs")
	public Iterable<String> getRefenceURLs();
	
	
}
