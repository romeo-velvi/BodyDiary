package database;
import java.sql.Date;

public class UserData {
	
	private static UserData instance;
	private String 	name;
	private String 	surname;
	private String 	mail;
	private String 	password;
	private Date 	birt_date;
	private String 	gender; 
	
	public UserData(String name, String surname, String mail, String password, Date birt_date, String gender) {
		super();
		this.name = name;
		this.surname = surname;
		this.mail = mail;
		this.password = password;
		this.birt_date = birt_date;
		this.gender = gender;
	}
	
	public static void setInstance(UserData ud) {
		instance = ud;
	}
	
	public static UserData getInstance() {
		return instance;
	}
	
	public static UserData setInstance(String name, String surname, String mail, String password, Date birt_date, String gender) {
		instance= new UserData(name, surname, mail, password, birt_date, gender);
		return instance;
	}

	public static void erease() {
		instance=null;    
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getBirt_date() {
		return birt_date;
	}

	public void setBirt_date(Date birt_date) {
		this.birt_date = birt_date;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}
