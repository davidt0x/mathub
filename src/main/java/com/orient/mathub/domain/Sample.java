package com.orient.mathub.domain;

import java.util.Date;

import com.tinkerpop.blueprints.Direction;
import com.tinkerpop.frames.Adjacency;
import com.tinkerpop.frames.Property;
import com.tinkerpop.frames.VertexFrame;
import com.tinkerpop.frames.annotations.gremlin.GremlinGroovy;

public interface Sample extends VertexFrame{
	
	@Property("name")
	public void setName(String name);
	@Property("name")
	public String getName();
	
	@Property("description")
	public void setDescription(String description);
	@Property("description")
	public String getDescription();
	
	@Property("OwnerUID")
	public void setOwnerUID(int id);
	@Property("OwnerUID")
	public int getOwnerUID();
	
	@Property("profileImgURL")
	public void setProfileImgURL(String url);
	@Property("profileImgURL")
	public String getProfileImgURL();
	
	@Property("dateCreated")
	public void setDateCreated(Date d);
	@Property("dateCreated")
	public Date getDateCreated();

	@Property("dateModified")
	public void setDateModified(Date d);
	@Property("dateModified")
	public Date getDateModified();
	
	@Adjacency(label="isMadeOf", direction=Direction.OUT)
	public void setMaterial(Material material);
	@Adjacency(label="isMadeOf", direction=Direction.OUT)
	public Material getMaterial();
	
	@Adjacency(label="hasA", direction=Direction.OUT)
	public void setDataObject(DataObject dataObject);
	@Adjacency(label="hasA", direction=Direction.OUT)
	public DataObject getDataObject();
	
}
