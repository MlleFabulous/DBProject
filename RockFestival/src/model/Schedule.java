package model;

public class Schedule {
	private String band;
	private String scene;
	private String start;
	private String end;
	private String day;

	public Schedule(String band, String scene, String start, String end, String day) {
		super();
		this.band = band;
		this.scene = scene;
		this.start = start;
		this.end = end;
		this.day = day;
	}
	
	public String getBand() {
		return band;
	}
	public void setBand(String band) {
		this.band = band;
	}
	public String getScene() {
		return scene;
	}
	public void setScene(String scene) {
		this.scene = scene;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	


}
