package Material;

import Militar.Militar;

public class MaterialRetirado {
	private String dataRetirada;
	private String horaRetirada;
	private Militar militarResponsavel;
	
	//GETTERS
	public String getDataRetirada() {
		return dataRetirada;
	}
	public String getHoraRetirada() {
		return horaRetirada;
	}
	public Militar getMilitarResponsavel() {
		return militarResponsavel;
	}
	
	//SETTERS 
	public void setDataRetirada(String dataRetirada) {
		this.dataRetirada = dataRetirada;
	}
	public void setHoraRetirada(String horaRetirada) {
		this.horaRetirada = horaRetirada;
	}
	public void setMilitarResponsavel(Militar militarResponsavel) {
		this.militarResponsavel = militarResponsavel;
	}
}
