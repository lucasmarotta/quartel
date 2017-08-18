package Material;

public class Armamento extends MaterialRetirado{
	private int numSerie;
	private String modelo;
	private String fabricante;
	
	public Armamento (int numSerie, String modelo, String fabricante) {
		this.numSerie = numSerie;
		this.modelo = modelo;
		this.fabricante = fabricante;
	}
	
	//GETTERS
	public int getNumSerie() {
		return numSerie;
	}
	public String getModelo() {
		return modelo;
	}
	public String getFabricante() {
		return fabricante;
	}
	
	//SETTERS
	public void setNumSerie(int numSerie) {
		this.numSerie = numSerie;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}
	
	
}
