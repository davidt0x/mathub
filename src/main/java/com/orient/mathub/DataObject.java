package com.orient.mathub;

import java.util.Date;

import com.tinkerpop.frames.Adjacency;
import com.tinkerpop.frames.Property;

public interface DataObject {
	
	@Property("id")
	public void setId(int id);
	@Property("id")
	public int getId();
	
	@Property("name")
	public void setName(String name);
	@Property("name")
	public String getName();
	
	@Property("OwnerUID")
	public void setOwnerUID(int id);
	@Property("OwnerUID")
	public int getOwnerUID();
	
	@Property("dateCreated")
	public void setDateCreated(Date d);
	@Property("dateCreated")
	public Date getDateCreated();

	@Property("dateModified")
	public void setDateModified(Date d);
	@Property("dateModified")
	public Date getDateModified();
	
	@Property("permission")
	public void setPermission(String permission);
	@Property("permission")
	public String getPermission();
	
	@Property("dataFileURL")
	public void setProfileImgURL(String url);
	@Property("dataFileURL")
	public String getProfileImgURL();
	
	@Adjacency(label="contains")
	public void setCanonicalFeature(CanonicalFeature cf);
	
	/*@Adjacency(label="spans")
	public void set
	*/
	
	

}
