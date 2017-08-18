package Material;

public class Municao extends MaterialRetirado{
	private int calibre;
	private String descricao;
	
	public Municao(int calibre, String descricao) {
		this.calibre = calibre;
		this.descricao = descricao;
	}
	
	//GETTERS
	public int getCalibre() {
		return calibre;
	}
	public String getDescricao() {
		return descricao;
	}
	
	//SETTERS
	public void setCalibre(int calibre) {
		this.calibre = calibre;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
