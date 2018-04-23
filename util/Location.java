package util;

public class Location {
	String[] location; // N bit location with either ' ', '0' or '1'; ' ' (empty space) means that this resource is not a part of the firm or consumer
	
	public Location(String[] loc) {
		location = new String[Globals.N];
		System.arraycopy(loc, 0, location, 0, loc.length);
	}

	public String[] getLocation() {
		return location;
	}
	
	public String getLocationAt(int index) {
		return location[index]; 
	}

	public String getLocationAt(int index, InfluenceMatrix im) {
		String retString = "";
		Interdependence intdep = im.getDependenceAt(index);
		
		for (int i = index; i < index + Globals.N; i++){
			if (intdep.isDependent(i % Globals.N)) {
				retString += location[i % Globals.N];
			}
		}
		return retString;
	}

	public boolean isValidResource(int index) {
		if (location[index].equals(" ")) { 
			return false;
		} else {
			return true;
		}
	}

	public String toString() {
		String retString = "";
		for (int i = 0; i < location.length; i++) {
			if (location[i].equals(" ")) {
				retString += " ";
			} else {
				retString += location[i];
			}
		}
		return retString;
	}

}
