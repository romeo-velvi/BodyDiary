package application;

import java.sql.Date;

public class Measurement {

	private String tipo;
	private Date date;
	private Double value;
	
	public Measurement() {}
	
	public Measurement(String tipo, Date data_misurazione) {
		super();
		this.tipo = tipo;
		this.date = data_misurazione;
	}
	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

}
