package application;

import java.sql.Date;

public class UserData {
	public static String getName() {
		return name;
	}
	public static void setName(String name) {
		UserData.name = name;
	}
	public static String getSurname() {
		return surname;
	}
	public static void setSurname(String surname) {
		UserData.surname = surname;
	}
	public static String getMail() {
		return mail;
	}
	public static void setMail(String mail) {
		UserData.mail = mail;
	}
	public static String getGender() {
		return gender;
	}
	public static void setGender(String gender) {
		UserData.gender = gender;
	}
	public static Date getBirt_date() {
		return birt_date;
	}
	public static void setBirt_date(Date birt_date) {
		UserData.birt_date = birt_date;
	}
	public static String getPassword() {
		return password;
	}
	public static void setPassword(String password) {
		UserData.password = password;
	}
	private static String name;
	private static String surname;
	private static String mail;
	private static String password;
	private static Date birt_date;
	private static String gender;
	
}
