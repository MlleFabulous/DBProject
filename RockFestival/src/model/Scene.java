package model;

public class Scene {
	private String nbr;
	private String name;
	private String capacity;
	private String location;
	
	public Scene(String nbr, String name, String capacity, String location) {
		this.nbr = nbr;
		this.name = name;
		this.capacity = capacity;
		this.location = location;
	}

	public String getNbr() {
		return nbr;
	}

	public void setNbr(String nbr) {
		this.nbr = nbr;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCapacity() {
		return capacity;
	}

	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	

}
