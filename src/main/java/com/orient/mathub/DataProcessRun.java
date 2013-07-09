package com.orient.mathub;

import java.util.Date;

import com.tinkerpop.frames.Adjacency;
import com.tinkerpop.frames.Property;

public interface DataProcessRun {


	@Property("id")
	public void setId(int id);
	@Property("id")
	public int getId();
	
	@Property("OwnerUID")
	public void setOwnerUID(int id);
	@Property("OwnerUID")
	public int getOwnerUID();
	
	@Property("date")
	public void setDate(Date date);
	@Property("date")
	public Date getDate();
	
	@Adjacency(label="instanceOf")
	public void setInstance(DataProcess dp);
	@Adjacency(label="instanceOf")
	public DataProcess getInstance();
	
}
