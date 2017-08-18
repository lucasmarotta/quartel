package Militar;

public class Militar {
	
	private String posto;
	private String nomeGuerra;
	
	
	//CONSTRUCTOR
	public Militar (String posto, String nomeGuerra) {
		this.posto = posto;
		this.nomeGuerra = nomeGuerra;
	}
	
	
	//GETERS
	public String getPosto() {
		return posto;
	}
	public String getNomeGuerra() {
		return nomeGuerra;
	}
	
	//SETTERS
	public void setPosto(String posto) {
		this.posto = posto;
	}
	public void setNomeGuerra(String nomeGuerra) {
		this.nomeGuerra = nomeGuerra;
	}


}