package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * Controller class for connecting and querying to an PostgreSQL database.
 * 
 * Note: best practice is to create an connection pool for connecting and querying to database (using e.g. APACHE DBCP or c3p0), 
 * since this is a project made in short time and the amount of stress put on the database is relatively low for this case,
 * such implementations will be ignored.
 */
public class PsqlController {
	private String credentials = "jdbc:postgresql://pgserver.mah.se/rockfestival_robin_maida?user=ah2881&password=qqolpct3";

	public PsqlController() {

	}

	//MARK: INSERT Statements
	/**
	 * Creates an Entity of artist in DB, using name of the artist
	 * @param name - name of the artist 
	 */
	public void insertArtist(String name) {
		Connection c = null;
		Statement stmt = null;
		try {
			Class.forName("org.postgresql.Driver");
			c = DriverManager.getConnection(credentials);
			c.setAutoCommit(false);

			stmt = c.createStatement();
			String sql = "INSERT INTO artist (name) "
					+ "VALUES ('"+name+"');";
			stmt.executeUpdate(sql);

			stmt.close();
			c.commit();
			c.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("created entity in TABLE artist");
	}

	/**
	 * Creates an entity of artist_in_band in DB. This means assigning
	 * an artist as member of an band. The band provided needs to exist in the
	 * database as well as the artist. NOTE the name of artist is to be provided,
	 * the method will match the id of the artist to provide in the DB.
	 * @param artist - name of the artist
	 * @param band - name of the band
	 */
	public void insertArtistInBand(String artist, String band) {
		Connection c = null;
		Statement stmt = null;
		try {
			Class.forName("org.postgresql.Driver");
			c = DriverManager.getConnection(credentials);
			c.setAutoCommit(false);

			stmt = c.createStatement();
			String sql = "INSERT INTO artist_in_band (artist, band) "
					+ "VALUES ((SELECT id FROM artist WHERE name='"+artist+"'), '"+band+"');";
			stmt.executeUpdate(sql);

			stmt.close();
			c.commit();
			c.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("created entity in TABLE artist_in_band");
	}

	public void insertBand(String name, String country, String info, String contactPerson) {
		Connection c = null;
		Statement stmt = null;
		try {
			Class.forName("org.postgresql.Driver");
			c = DriverManager.getConnection(credentials);
			c.setAutoCommit(false);

			stmt = c.createStatement();
			String sql = "INSERT INTO band (name, country, info, contact_person) "
					+ "VALUES ('"+name+"', '"+country+"', '"+info+"','"+contactPerson+"');";
			stmt.executeUpdate(sql);

			stmt.close();
			c.commit();
			c.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("created entity in TABLE band");
	}

	public void insertScene(String name, int capacity, String location) {
		Connection c = null;
		Statement stmt = null;
		try {
			Class.forName("org.postgresql.Driver");
			c = DriverManager.getConnection(credentials);
			c.setAutoCommit(false);

			stmt = c.createStatement();
			String sql = "INSERT INTO scene (name, capacity, location) "
					+ "VALUES ('"+name+"', "+capacity+", '"+location+"');";
			stmt.executeUpdate(sql);

			stmt.close();
			c.commit();
			c.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("created entity in TABLE scene");
	}

	public void insertSchedule(String band, String scene, String start, String end, String day) {
		Connection c = null;
		Statement stmt = null;
		try {
			Class.forName("org.postgresql.Driver");
			c = DriverManager.getConnection(credentials);
			c.setAutoCommit(false);

			stmt = c.createStatement();
			String sql = "INSERT INTO schedule (band, scene, start, \"end\", day) "
					+ "VALUES ('"+band+"','"+scene+" , '"+start+"', '"+end+"',UPPER('"+day+"'));";
			stmt.executeUpdate(sql);

			stmt.close();
			c.commit();
			c.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("created entity in TABLE schedule");
	}

	public void insertWorker(String personNbr, String name, String address) {
		Connection c = null;
		Statement stmt = null;
		try {
			Class.forName("org.postgresql.Driver");
			c = DriverManager.getConnection(credentials);
			c.setAutoCommit(false);

			stmt = c.createStatement();
			String sql = "INSERT INTO worker (person_nbr, name, address) "
					+ "VALUES ('"+personNbr+"', '"+name+"', '"+address+"');";
			stmt.executeUpdate(sql);

			stmt.close();
			c.commit();
			c.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("created entity in TABLE worker");
	}

	//MARK: UPDATE Statement
	public void updateTable(String table, String values, String where) {
		//if where = null, do without where clause, vice versa! 
	}

	//MARK: SELECT statement
	public Object[] selectTable(String table, String values, String where) {
		return null;
	}

	public static void main(String[] args) {
		PsqlController c = new PsqlController();
		c.insertWorker("19830903-3123", "Hans Byström", "Lundavägen 32 Lund");

	}



}
