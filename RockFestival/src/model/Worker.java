package model;

public class Worker {
	private String personNbr;
	private String name;
	private String address;
	
	public Worker(String personNbr, String name, String address) {
		this.personNbr = personNbr;
		this.name = name;
		this.address = address;
	}

	public String getPersonNbr() {
		return personNbr;
	}

	public void setPersonNbr(String personNbr) {
		this.personNbr = personNbr;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	

}
