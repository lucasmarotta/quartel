package Material;

public class Acessorios extends MaterialRetirado{
	private String descricao;

	public Acessorios (String descricao) {
		this.descricao = descricao;
	}
	
	//GETTER
	public String getDescricao() {
		return descricao;
	}

	//SETTER
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
