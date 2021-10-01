package application;

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
	private static String name;
	private static String surname;
	private static String mail;
}
