package database;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Measurement {

	private String email; 
	private Date date;
	private Double weight;
	private Double legs;	
	private Double chest; 	
	private Double height; 	
	private Double forearms; 
	private Double biceps; 	
	private Double hips;	
	private Double waistline;
	private Double calfs; 	
	

	public static Date getCurrentTime() {
		LocalDate date = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy MM dd");
		String text = date.format(formatter);
		LocalDate parsedDate = LocalDate.parse(text, formatter);
   	   	Date d = Date.valueOf(parsedDate);
   	   	return d;
	}

	@Override
	public String toString() {
		return "Measurement [mail=" + email + ", date=" + date + ", weight=" + weight + ", legs=" + legs + ", chest="
				+ chest + ", height=" + height + ", forearms=" + forearms + ", biceps=" + biceps + ", hips=" + hips
				+ ", waistline=" + waistline + ", calfs=" + calfs + "]";
	}
	
	public Double getMeasureByType(String tipo) {
		Double d = -1.0;
		switch (tipo) {
		case "weight":
			d=this.getWeight();
			break;
		case "legs":
			d=this.getLegs();
			break;
		case "chest":
			d=this.getChest();
			break;
		case "height":
			d=this.getHeight();
			break;
		case "forearms":
			d=this.getForearms();
			break;
		case "biceps":
			d=this.getBiceps();
			break;
		case "hips":
			d=this.getHips();
			break;
		case "waistline":
			d=this.getWaistline();
			break;
		case "calfs":
			d=this.getCalfs();
			break;
		default:
			System.out.println("TIPO non registrato !");
			break;
		}
		return d;
	}

	public Measurement () {	}
	
	public Measurement(String email, Double weight, Double legs, Double chest, Double height, Double forearms, Double biceps,
			Double hips, Double waistline, Double calfs, Date d) {
		super();
		this.email = email;
		this.weight = weight;
		this.legs = legs;
		this.chest = chest;
		this.height = height;
		this.forearms = forearms;
		this.biceps = biceps;
		this.hips = hips;
		this.waistline = waistline;
		this.calfs = calfs;
		this.date = d;
	}
	
	
	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public Double getWeight() {
		return weight;
	}


	public void setWeight(Double weight) {
		this.weight = weight;
	}


	public Double getLegs() {
		return legs;
	}


	public void setLegs(Double legs) {
		this.legs = legs;
	}


	public Double getChest() {
		return chest;
	}


	public void setChest(Double chest) {
		this.chest = chest;
	}


	public Double getHeight() {
		return height;
	}


	public void setHeight(Double height) {
		this.height = height;
	}


	public Double getForearms() {
		return forearms;
	}


	public void setForearms(Double forearms) {
		this.forearms = forearms;
	}


	public Double getBiceps() {
		return biceps;
	}


	public void setBiceps(Double biceps) {
		this.biceps = biceps;
	}


	public Double getHips() {
		return hips;
	}


	public void setHips(Double hips) {
		this.hips = hips;
	}


	public Double getWaistline() {
		return waistline;
	}


	public void setWaistline(Double waistline) {
		this.waistline = waistline;
	}


	public Double getCalfs() {
		return calfs;
	}


	public void setCalfs(Double calfs) {
		this.calfs = calfs;
	}

	public String getMail() {
		return email;
	}

	public void setMail(String mail) {
		this.email = mail;
	}


}
