package application;

import java.sql.Date;

public class Goal {
	
	@Override
	public String toString() {
		return "Goal [tipo=" + tipo + ", data_immissione=" + data_immissione + ", value_atteso=" + value_atteso
				+ ", last_value=" + value_attuale + ", stato=" + stato + "]";
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

	public Double getLast_value() {
		return value_attuale;
	}

	public void setLast_value(Double last_value) {
		this.value_attuale = last_value;
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

	private String tipo;
	private Date data_immissione;
	private Double value_attuale;
	private Double value_atteso;
	private String stato;
	
	public Goal(String tipo, Date data, Double value_atteso, Double valore_attuale) {
		super();
		this.tipo = tipo;
		this.data_immissione = data;
		this.value_atteso = value_atteso;
		this.value_attuale=valore_attuale;
		
		if ( value_attuale.equals(value_atteso)   ) {
			this.stato = "Got it";
		}
		else {
			this.stato = "Working on";
		}
	}
	
	public Goal() {	}


}
