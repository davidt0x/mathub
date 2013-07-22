package com.orient.mathub;

import java.text.DateFormat;
import java.util.Date;
import java.util.Vector;

import com.orient.mathub.domain.CanonicalFeature;
import com.orient.mathub.domain.DataObject;
import com.orient.mathub.domain.DataProcess;
import com.orient.mathub.domain.DataProcessRun;
import com.orient.mathub.domain.GriddedSpace;
import com.orient.mathub.domain.Material;
import com.orient.mathub.domain.MaterialFamily;
import com.orient.mathub.domain.Sample;
import com.tinkerpop.blueprints.Graph;
import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.blueprints.impls.orient.OrientGraph;
import com.tinkerpop.frames.FramedGraph;
import com.tinkerpop.frames.FramedGraphFactory;

/**
 * Hello world!
 *
 */
public class App 
{
	private static final String DB_PATH = "remote:localhost/mathub";
//	private static final String DB_PATH = "local:databases/mathub";
	private final String username = "admin";
	private final String password = "admin";
	
	private FramedGraph<Graph> manager;
	private Graph graph;
	
	public void connectDatabase(){
		
		graph = new OrientGraph(DB_PATH, username, password);
		FramedGraphFactory f = new FramedGraphFactory();
		manager = f.create(graph);
	}
	
	public void createDatabase(){

		// create an sample
		Sample sample = manager.addVertex(null, Sample.class);
		sample.setName("M40-1");
		sample.setDescription("This a a single piece of 40% rolled and annealed Iron.");
		sample.setOwnerUID(809);
		sample.setProfileImgURL("http://image.com");
		
		/*
		 * 		DateFormat formatter = DateFormat.getDateTimeInstance(DateFormat.LONG,
				DateFormat.LONG);
		 */
		DateFormat formatter = DateFormat.getDateTimeInstance(DateFormat.LONG,
				DateFormat.LONG);
		Date d = new Date();
		System.out.println(formatter.format(d));
		//create material
		Material material = manager.addVertex(null, Material.class);
		material.setName("Iron");
		material.setDescription("Decription of Iron from wiki");
		Vector<String> v = new Vector<String>();
		v.addElement("wiki.org");
		material.setReferenceURLs(v);
		material.setChemicalFormula("Fe");
		
		//create a material family
		MaterialFamily mf = manager.addVertex(null, MaterialFamily.class);
		mf.setName("metal");
		
		manager.addEdge(material, material.asVertex(), mf.asVertex(), "isA");		
		manager.addEdge(sample, sample.asVertex(), material.asVertex(), "isMadeOf");
		
		//create original data object
		DataObject d1 = manager.addVertex(null, DataObject.class);
		d1.setObjectID(709);
		d1.setName("M40Scan1.ang");
		d1.setOwnerUID(809);
		/*
		 * Date created and date modified
		 */
		d1.setPermission("rw -r -r");
		d1.setProfileImgURL("file://M40Scan1.ang");
		d1.setIsSimulated(false);
		
		manager.addEdge(sample, sample.asVertex(), d1.asVertex(), "hasA");
		
		//create a Data Process Run
		DataProcessRun dpr = manager.addVertex(null, DataProcessRun.class);
		dpr.setDataProcessRunID(46);
		dpr.setOwnerUID(809);
		/*
		 * Date Run
		 */
		
		manager.addEdge(d1, d1.asVertex(), dpr.asVertex(), "argumentInto");
		
		
		//create a Data Process
		DataProcess dp = manager.addVertex(null, DataProcess.class);
		dp.setDataProcessID(1);
		dp.setName("ANG File Converter");
		dp.setCreatorUID(600);
		/*
		 * Date Run
		 */
		dp.setScriptFile("converterANG.m");
		dp.setLanguage("MATLAB");
		dp.setCommand("matlab -r converterANG.m");
		
		manager.addEdge(dpr, dpr.asVertex(), dp.asVertex(), "instanceOf");
		
		
		//create the 2nd Data Object
		DataObject d2 = manager.addVertex(null, DataObject.class);
		d2.setObjectID(710);
		d2.setName("M40Scan1.ang");
		d2.setOwnerUID(809);
		/*
		 * Date created and date modified
		 */
		d2.setPermission("rw -r -r");
		d2.setProfileImgURL("file://uuiausuoi123.h5");
		d2.setIsSimulated(false);
		
		manager.addEdge(dpr, dpr.asVertex(), d2.asVertex(), "argumentOut");
		
		
		//create a Gridded Space
		GriddedSpace gs = manager.addVertex(null, GriddedSpace.class);
		Vector<Integer> dim = new Vector<Integer>();
		dim.addElement(556);
		dim.addElement(976);
		gs.setDimensions(dim);
		Vector<Double> step = new Vector<Double>();
		step.addElement(2.0);
		step.addElement(2.0);
		gs.setStepSizes(step);
		gs.setUnits("micro");
		
		manager.addEdge(d2, d2.asVertex(), gs.asVertex(), "spans");
		
		//create Canonical Feature
		CanonicalFeature cf = manager.addVertex(null, CanonicalFeature.class); 
		cf.setFeatureID(1);
		cf.setName(" Euler Angles");
		cf.setNumVariables(3);
		Vector<String> vname = new Vector<String>();
		vname.addElement("phi1");
		vname.addElement("PHI");
		vname.addElement("phi2");
		cf.setVariableNames(vname);
		
		Vector<String> vunit = new Vector<String>();
		vunit.addElement("radians");
		vunit.addElement("radians");
		vunit.addElement("radians");
		cf.setVariableUnits(vunit);
		
		Vector<String> vtype = new Vector<String>();
		vtype.addElement("float");
		vtype.addElement("float");
		vtype.addElement("float");
		cf.setVariableTypes(vtype);
		
		cf.setDataSetName("Euler");
		
		manager.addEdge(d2, d2.asVertex(), cf.asVertex(), "contains");
		
//		System.out.println(d2.getDataProcessRuns());
		for(DataProcessRun tmp: d2.getDataProcessRun()){
			System.out.println(tmp.getDataProcessRunID());
			System.out.println(tmp.getOwnerUID());
		}
//		System.out.println(dpr.getDataProcessRunID());
//		System.out.println(sample.getDataObject().getObjectID());
		System.out.println(d1.getSample().getDescription());
		
		graph.shutdown();
		manager.shutdown();
		
	}
	

	
	public static void main( String[] args )
    {
		App app = new App();
		app.connectDatabase();
		app.createDatabase();

    }
}
