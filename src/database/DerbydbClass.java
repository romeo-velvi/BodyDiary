package database;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DerbydbClass extends DBdao{

	private static DerbydbClass instance;
	private static Connection to_db;
	private static String path  = "jdbc:derby:newDBderby;create=true";
	
	public DerbydbClass() {
		DerbydbClass.to_db = null;
		try {
			DerbydbClass.to_db = DriverManager.getConnection(DerbydbClass.path);
		} catch (SQLException e) {
			System.out.println("Problema connessione BD: "+e);
			return;
		}
		System.out.println("DB connection ok!");
	}
	
	public DerbydbClass getInstance(){
		if(instance == null) {
			instance = new DerbydbClass();
		}
		return instance;
	}
	
	public  Connection getConnection() {
		return to_db;
	}
	
	public void setConnection(Connection to_db) {
		DerbydbClass.to_db = to_db;
	}
	
	public  Boolean close_db() {
		try {
			to_db.close();
		} catch (SQLException e) {
			System.out.println("Problema chiusura db: "+e);
		}
		return true;
	}
	
	public void clearTable(String tablename) throws SQLException {
		String query; 
		query="DELETE FROM "+ tablename;
		executeQuery(query);
		System.out.println("Clear"+ tablename + "eseguito");
	}
	
	public  void deleteAllTable() throws SQLException {
		try {
		String query, tablename;
		tablename = "USERDATA";
		query="DROP TABLE "+tablename;
		executeQuery(query);
		System.out.println("DROP "+ tablename + " eseguito");
		tablename = "USERMEASURE";
		query="DROP TABLE "+tablename;
		executeQuery(query);
		System.out.println("DROP "+ tablename + " eseguito");
		tablename = "USERGOALS";
		query="DROP TABLE "+tablename;
		executeQuery(query);
		System.out.println("DROP "+ tablename + " eseguito");
		} catch (Exception e) {
			System.out.println("Problema cancellazione tabelle db: "+e);
		}
	}	
	
	private Boolean executeQuery(String query) throws SQLException {
		// creating statements
		Statement stmt = to_db.createStatement();
		try {
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println("Problema caricaemnto query: "+e);
			return false;
		}
		return true;
	}
	
	public void createTables() {
		String sql = "CREATE TABLE UserData "
				+ "( "
					+ "email VARCHAR(255) PRIMARY KEY,"
					+ "password VARCHAR(255) NOT NULL,"
					+ "name VARCHAR(50) NOT NULL,"
					+ "surname VARCHAR(50) NOT NULL,"
					+ "gender VARCHAR(20) NOT NULL,"
					+ "birth_date DATE NOT NULL"
				+ ")";
		try {
			executeQuery(sql);
		} catch (SQLException e) {
			System.out.println("sql create table UserData error");
		}
		
		sql = "CREATE TABLE UserMeasure "
				+ "( "
					+ "id_measure INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),"
					+ "email 	VARCHAR(255) NOT NULL,"
					+ "date			DATE NOT NULL,"
					+ "weight 		DOUBLE NOT NULL ,"
					+ "thighs 		DOUBLE NOT NULL ,"
					+ "chest 		DOUBLE NOT NULL ,"
					+ "height 		DOUBLE NOT NULL ,"
					+ "forearms 	DOUBLE NOT NULL ,"
					+ "biceps 		DOUBLE NOT NULL ,"
					+ "hips 		DOUBLE NOT NULL ,"
					+ "waistline 	DOUBLE NOT NULL ,"
					+ "calfs 		DOUBLE NOT NULL ,"
				+ "PRIMARY KEY (id_measure))";
		try {
			executeQuery(sql);
		} catch (SQLException e) {
			System.out.println("sql create table UserMeasure error");
		}
		
		sql = "CREATE TABLE UserGoals "
				+ "( "
					+ "id_goal INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),"
					+ "email 	VARCHAR(255) NOT NULL,"
					+ "date			DATE NOT NULL,"
					+ "type 		VARCHAR(50) NOT NULL ,"
					+ "goal 		DOUBLE NOT NULL ,"
					+ "PRIMARY KEY (id_goal)"
				+ ")";
		try {
			executeQuery(sql);
		} catch (SQLException e) {
			System.out.println("sql create table UserMeasure error");
		}
	}
	
	public Boolean insertUserData(UserData ud) throws SQLException {
		String query="INSERT INTO UserData"
				+ "(email,password,name,surname,gender,birth_date)"
				+ "VALUES "
				+ "('"
					+ud.getMail()
					+"','"
					+ud.getPassword()
					+"','"
					+ud.getName()
					+"','"
					+ud.getSurname()
					+"','"
					+ud.getGender()
					+"','"
					+ud.getBirt_date()
					+"'"
				+")";
		
		if(executeQuery(query)==false) {
			System.out.println("Errore inserimento user data: ");
			return false;
		}
		return true;
	}
	
	public Boolean insertUserMeasurement(Measurement mm) throws SQLException {
		String query="INSERT INTO UserMeasure"
				+ "("
					+"email 	,"
					+"date		,"
					+"weight 	,"
					+"thighs 	    ,"
					+"chest 	,"
					+"height 	,"
					+"forearms  ,"
					+"biceps 	,"
					+"hips 	    ,"
					+"waistline ,"
					+"calfs 	"
				+ ")"
				+ "VALUES "
				+ "("
						+ "'"
						+ mm.getMail()
						+ "'"
					+ ", "
						+ "'"
						+ mm.getDate()
						+ "'"
					+ ","
						+ mm.getWeight()
					+ ","
						+ mm.getThighs()
					+ ","
						+ mm.getChest()
					+ ","
						+ mm.getHeight()
					+ ","
						+ mm.getForearms()
					+ ","
						+ mm.getBiceps()
					+ ","
						+ mm.getHips()
					+ ","
						+ mm.getWaistline()
					+ ","
						+ mm.getCalfs()
				+")";
		
		if(executeQuery(query)==false) {
			System.out.println("Errore inserimento user measurements: ");
			return false;
		}
		return true;
	}
	
	public  Boolean insertUserGoal(Goal gg) throws SQLException {
		String query="INSERT INTO UserGoals"
				+ "(email,date,type,goal)"
				+ "VALUES "
				+ "('"
					+gg.getEmail()
					+"','"
					+gg.getData_immissione()
					+"','"
					+gg.getTipo()
					+"',"
					+gg.getValue_atteso()
				+")";
		if(executeQuery(query)==false) {
			System.out.println("Errore inserimento user goals: ");
			return false;
		}
		return true;
	}
	
	public Boolean checkUser(String email, String pass) {
		Boolean b = false;
		String query = "SELECT COUNT(*) as OK FROM USERDATA WHERE "
				+ "EMAIL = "
				+ "'"+email+"'"
				+ " and "
				+ "PASSWORD = "
				+ "'"+pass+"'";
		Statement stmt; ResultSet rs; int x=0;
		try {
			stmt = to_db.createStatement();
			rs= stmt.executeQuery(query);
			rs.next();
			x =  rs.getInt("ok");
		} catch (SQLException e) {
			System.out.println("Error login data: "+e);
			return false;
		}
		
		if(x==1) {
			b=true;
		}
		return b;
	}
	
	public UserData retreiveUserData(String email, String pass) {
		UserData ud = null;
		Statement stmt; ResultSet rs;
		String query = "SELECT * FROM USERDATA WHERE EMAIL= '"+email+"'  and password = '"+pass+"'";
		try {
			stmt = to_db.createStatement();
			rs= stmt.executeQuery(query);
			rs.next(); // ESEGUIRE SEMPRE IL NEXT PER PRIMO !!
			ud = new UserData(
					rs.getString("name"), 
					rs.getString("surname"), 
					email, 
					pass, rs.getDate("birth_date"), 
					rs.getString("gender")
					);
		} 
		catch (SQLException e) {
			System.out.println("Error taking user data: "+e);
		}
		return ud;
	}

	public Measurement getLastMeasurement(String email) throws SQLException{
		Measurement m = null;
		String query = "SELECT "
				+"date		,"
				+"weight 	,"
				+"thighs 	    ,"
				+"chest 	,"
				+"height 	,"
				+"forearms  ,"
				+"biceps 	,"
				+"hips 	    ,"
				+"waistline ,"
				+"calfs 	" 
				+" FROM USERMEASURE WHERE EMAIL="
				+ "'"+email+"'"
				+ " ORDER BY date DESC FETCH FIRST ROW ONLY";
		Statement stmt = to_db.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		
		Date d;
		Double weight;    
		Double thighs	;	  
		Double chest; 	  
		Double height; 	  
		Double forearms;  
		Double biceps; 	  
		Double hips	;	  
		Double waistlin; 
		Double calfs; 
		
		rs.next();
		d = rs.getDate("date");
		weight = rs.getDouble("weight");  
		thighs =	rs.getDouble("thighs");	
		chest=	rs.getDouble("chest"); 	
		height=	rs.getDouble("height"); 	
		forearms=	rs.getDouble("forearms");
		biceps=	rs.getDouble("biceps"); 	
		hips=	rs.getDouble("hips")	;	
		waistlin=	rs.getDouble("waistline");
		calfs=	rs.getDouble("calfs");  
		
		m = new Measurement(email, weight, thighs, chest, height, forearms, biceps, hips, waistlin, calfs, d);

		return m;
	}
	
	public Iterator retreiveMeasure(String email) throws SQLException {
		String query = "SELECT "
				+"date		,"
				+"weight 	,"
				+"thighs 	    ,"
				+"chest 	,"
				+"height 	,"
				+"forearms  ,"
				+"biceps 	,"
				+"hips 	    ,"
				+"waistline ,"
				+"calfs 	" 
				+" FROM USERMEASURE WHERE EMAIL="
				+ "'"+email+"'"
				+ " ORDER BY date";
		Statement stmt = to_db.createStatement();
		
		Aggregate aggregate = new ConcreteAggregate();
		
		Date d;
		Double weight;    
		Double thighs	;	  
		Double chest; 	  
		Double height; 	  
		Double forearms;  
		Double biceps; 	  
		Double hips	;	  
		Double waistlin; 
		Double calfs; 
		
		ResultSet rs = stmt.executeQuery(query);
		while(rs.next()) {
			d = rs.getDate("date");
			weight = rs.getDouble("weight");  
			thighs =	rs.getDouble("thighs");	
			chest=	rs.getDouble("chest"); 	
			height=	rs.getDouble("height"); 	
			forearms=	rs.getDouble("forearms");
			biceps=	rs.getDouble("biceps"); 	
			hips=	rs.getDouble("hips")	;	
			waistlin=	rs.getDouble("waistline");
			calfs=	rs.getDouble("calfs");  
		
			aggregate.add(new Measurement(email, weight, thighs, chest, height, forearms, biceps, hips, waistlin, calfs,d));
		}
		Iterator it = aggregate.createIterator();
		return it;
	}
	
	public Iterator retreiveGoal(String email) throws SQLException {
		String query = "SELECT date,type,goal"
				+" FROM USERGOALS WHERE EMAIL="
				+ "'"+email+"'"
				+ " ORDER BY date";
		Statement stmt = to_db.createStatement();
		
		Aggregate aggregate = new ConcreteAggregate();
		
		Date d;
		String type;    
		Double goal;
		
		ResultSet rs = stmt.executeQuery(query);
		while(rs.next()) {
			d = rs.getDate("date");
			type = rs.getString("type");  
			goal =	rs.getDouble("goal");	
		
			aggregate.add(new Goal(email,type, d, goal));
		}
		Iterator it = aggregate.createIterator();
		return it;
	}

	@Override
	public Iterator getLast7Measurement(String email) throws SQLException {
		String query = "SELECT "
				+"date		,"
				+"weight 	,"
				+"thighs 	    ,"
				+"chest 	,"
				+"height 	,"
				+"forearms  ,"
				+"biceps 	,"
				+"hips 	    ,"
				+"waistline ,"
				+"calfs 	" 
				+" FROM USERMEASURE WHERE EMAIL="
				+ "'"+email+"'"
				+ " ORDER BY date DESC FETCH FIRST 7 ROW ONLY";
		Statement stmt = to_db.createStatement();
		
		Aggregate aggregate = new ConcreteAggregate();
		
		Date d;
		Double weight;    
		Double thighs	;	  
		Double chest; 	  
		Double height; 	  
		Double forearms;  
		Double biceps; 	  
		Double hips	;	  
		Double waistlin; 
		Double calfs; 
		
		ResultSet rs = stmt.executeQuery(query);
		while(rs.next()) {
			d = rs.getDate("date");
			weight = rs.getDouble("weight");  
			thighs =	rs.getDouble("thighs");	
			chest=	rs.getDouble("chest"); 	
			height=	rs.getDouble("height"); 	
			forearms=	rs.getDouble("forearms");
			biceps=	rs.getDouble("biceps"); 	
			hips=	rs.getDouble("hips")	;	
			waistlin=	rs.getDouble("waistline");
			calfs=	rs.getDouble("calfs");  
		
			aggregate.add(new Measurement(email, weight, thighs, chest, height, forearms, biceps, hips, waistlin, calfs,d));
		}
		Iterator it = aggregate.createIterator();
		return it;
	}
	

}
