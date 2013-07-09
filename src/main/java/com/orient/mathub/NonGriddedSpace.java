package com.orient.mathub;

import java.util.Vector;

import com.tinkerpop.frames.Property;

public interface NonGriddedSpace {
	
	@Property("dimensions")
	public void setDimensions(Vector<Integer> v);
	@Property("dimensions")
	public Vector<Integer> getDimensions();
	
	@Property("origin")
	public void setOrigin(Vector<Double> v);
	@Property("origin")
	public Vector<Double> getOrigin();
	
	@Property("units")
	public void setUnits(String units);
	@Property("units")
	public String getUnits();

}
