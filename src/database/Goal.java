package database;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Goal {
	
	private String email;
	private String tipo;
	private Date data_immissione;
	private Double value_atteso;
	private String stato;
	
	public void updateGoal(Measurement last) {
		Double latest = null;
		switch (tipo) {
		case "weight":
			latest=last.getWeight();
			break;
		case "legs":
			latest=last.getLegs();
			break;
		case "chest":
			latest=last.getChest();
			break;
		case "height":
			latest=last.getHeight();
			break;
		case "forearms":
			latest=last.getForearms();
			break;
		case "biceps":
			latest=last.getBiceps();
			break;
		case "hips":
			latest=last.getHips();
			break;
		case "waistline":
			latest=last.getWaistline();
			break;
		case "calfs":
			latest=last.getCalfs();
			break;
		default:
			System.out.println("TIPO goal non registrato !");
			break;
		}
		//System.out.println(latest+" -> "+value_atteso);
		if ( latest.equals(value_atteso) ) {
			this.stato = "Got it";
		}
		else {
			this.stato = "Working on";
		}
	}
	
	@Override
	public String toString() {
		return "Goal [tipo=" + tipo + ", data_immissione=" + data_immissione + ", value_atteso=" + value_atteso
				+ ", stato=" + stato + "]";
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Date getData_immissione() {
		return data_immissione;
	}

	public void setData_immissione(Date data_immissione) {
		this.data_immissione = data_immissione;
	}

	public Double getValue_atteso() {
		return value_atteso;
	}

	public void setValue_atteso(Double value_atteso) {
		this.value_atteso = value_atteso;
	}

	public String getStato() {
		return stato;
	}

	public void setStato(String stato) {
		this.stato = stato;
	}

	public static Date getCurrentTime() {
		LocalDate date = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy MM dd");
		String text = date.format(formatter);
		LocalDate parsedDate = LocalDate.parse(text, formatter);
   	   	Date d = Date.valueOf(parsedDate);
   	   	return d;
	}
	
	public Goal(String tipo, Date data, Double value_atteso) {
		this.setEmail(UserData.getInstance().getMail());
		this.setEmail(UserData.getInstance().getMail());
		this.tipo = tipo;
		this.data_immissione = data;
		this.value_atteso = value_atteso;
		this.stato="Working on";		
	}
	
	@SuppressWarnings("unused")
	private void checkState(Double valore_attuale) {
		if ( valore_attuale.equals(value_atteso) ) {
			this.stato = "Got it";
		}
		this.stato = "Working on";
	}
	
	public Goal() {	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


}
