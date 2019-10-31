package model;

public class ArtistInBand {
	private String artist;
	private String band;
	private String role;
	
	public ArtistInBand(String artist, String band, String role) {
		this.artist = artist;
		this.band = band;
		this.role = role;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getBand() {
		return band;
	}

	public void setBand(String band) {
		this.band = band;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	
	
}
