package util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Properties;

public class FileIO {
	public static void loadParameters(String configFile) {
		/*
		 *	int N = 20;
		 *	int numResources = 4;
		 *	int numFirms = 100;
		 *	String influenceMatrixFile = "inf/matrix12.txt";
		 *	int iterations = 100;
		 *  int adaptation = "resources";
		 *  String outfile = "output.txt";
		*/
		if (!configFile.equals("")) {
			Properties p = new Properties();
			try {
				p.load(new FileInputStream(configFile));
				// simulation parameters
				if (p.getProperty("N") != null) { Globals.setN(Integer.parseInt(p.getProperty("N"))); }
				if (p.getProperty("outfile") != null) { Globals.setOutfile(p.getProperty("outfile")); }
					else { Globals.setOutfile(""); }
				if (p.getProperty("influenceMatrixFile") != null) { Globals.setInfluenceMatrix(p.getProperty("influenceMatrixFile")); }
				if (p.getProperty("iterations") != null) { Globals.setIterations(Integer.parseInt(p.getProperty("iterations"))); }

				// FORMAT 1: firm parameters -- ecosystem == "homo" or "homogeneous"
				// initResources is now an array of initial resources by firm type
				// if (p.getProperty("initResources") != null) { Globals.setInitResources(Integer.parseInt(p.getProperty("initResources"))); }
				// // numFirms is now an array of number of firms by type
				// if (p.getProperty("numFirms") != null) { Globals.setNumFirms(Integer.parseInt(p.getProperty("numFirms"))); }
				// // if (p.getProperty("adaptation") != null) { Globals.setAdaptation(p.getProperty("adaptation")); }
				// if (p.getProperty("innovation") != null) { Globals.setInnovation(Double.parseDouble(p.getProperty("innovation"))); }
				// if (p.getProperty("resourcesIncrement") != null) { Globals.setResourcesIncrement(Integer.parseInt(p.getProperty("resourcesIncrement"))); }
				// if (p.getProperty("searchScope") != null) { Globals.setSearchScope(Integer.parseInt(p.getProperty("searchScope"))); }
				// if (p.getProperty("resourceDecision") != null) { Globals.setResourceDecision(p.getProperty("resourceDecision")); }
				// if (p.getProperty("resourceThreshold") != null) { Globals.setResourceThreshold(Double.parseDouble(p.getProperty("resourceThreshold"))); }
				// if (p.getProperty("searchThreshold") != null) { Globals.setSearchThreshold(Double.parseDouble(p.getProperty("searchThreshold"))); }
				
				// FORMAT 2: firm parameters by type -- ecosystem == "heterogeneous" or "hetero"
				if (p.getProperty("firms") != null) { Globals.setParameters(p.getProperty("firms")); } 
					else { Globals.setParameters("1,3,0.0,1,1,0.1,abs,0.5"); } // defalut values for test
			} catch (Exception e) {
				System.err.println(e.getMessage());
				e.printStackTrace();
			} // END try..catch
		}  // end if confFile
	}
	
	public static void printParameters() {
		System.out.println("N: " + Globals.getN());
		System.out.println("iterations: " + Globals.getIterations());
		System.out.println("outfile: " + Globals.getOutfilename());
		System.out.println("influenceMatrixFile: " + Globals.getInfluenceMatrix());
		
		// System.out.println("numFirms: " + Globals.getNumFirms());
		// System.out.println("initResources: " + Globals.getInitResources());
		// System.out.println("innovation: " + Globals.getInnovation());
		// System.out.println("resourcesIncrement: " + Globals.getResourcesIncrement());
		// System.out.println("searchScope: " + Globals.getSearchScope());
		// // System.out.println("adaptation: " + Globals.getAdaptation());
		// System.out.println("resourceDecision: " + Globals.getResourceDecision());
		// System.out.println("resourceThreshold: " + Globals.getResourceThreshold());
	}

	public static void main(String[] args) {
		// for test only
		loadParameters(args[0]);
		printParameters();
	}

}