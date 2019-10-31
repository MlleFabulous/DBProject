package model;

public class Band {
	private String name;
	private String country;
	private String info;
	private String contactPerson;

	public Band(String name, String country, String info, String contactPerson) {
		this.name = name;
		this.country = country;
		this.info = info;
		this.contactPerson = contactPerson;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}



}
