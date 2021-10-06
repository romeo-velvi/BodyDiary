package database;
import java.sql.Connection;
import java.sql.SQLException;

public abstract class DBdao {
	
	public abstract Connection getConnection();
	
	public abstract void setConnection(Connection to_db);
	
	public abstract Boolean close_db();
	
	public abstract void clearTable(String tablename) throws SQLException;
	
	public abstract void deleteAllTable() throws SQLException;
	
	public abstract void createTables();
	
	public abstract Boolean insertUserData(UserData ud)throws SQLException;
	
	public abstract Boolean insertUserMeasurement(Measurement mm) throws SQLException;
	
	public abstract Boolean insertUserGoal(Goal gg) throws SQLException;
	
	public abstract Boolean checkUser(String email, String pass);
	
	public abstract UserData retreiveUserData(String email, String pass) ;

	public abstract Measurement getLastMeasurement(String email) throws SQLException;
	
	public abstract Iterator retreiveMeasure(String email) throws SQLException;
	
	public abstract Iterator retreiveGoal(String email) throws SQLException;
	
	public abstract Iterator getLast7Measurement(String email) throws SQLException;
	
}
