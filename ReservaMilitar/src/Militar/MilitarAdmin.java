package Militar;
public class MilitarAdmin extends Militar {

	private String nomeCompleto;
	private String login;
	private String senha;
	private String email;
	
	public MilitarAdmin(String posto, String nomeGuerra, String nomeCompleto, String login, String senha, String email) {
		super(posto, nomeGuerra);
		this.nomeCompleto = nomeCompleto;
		this.login = login;
		this.senha = senha;
		this.senha = email;
	}

	//GETTERS
	public String getNomeCompleto() {
		return nomeCompleto;
	}
	public String getLogin() {
		return login;
	}
	public String getSenha() {
		return senha;
	}
	public String getEmail() {
		return email;
	}

	//SETTERS
	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}