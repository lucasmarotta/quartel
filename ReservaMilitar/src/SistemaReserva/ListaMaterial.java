package SistemaReserva;
import java.util.ArrayList;

import Material.Acessorios;
import Material.Armamento;
import Material.Municao;

public class ListaMaterial {
	
	ArrayList<Armamento> listaArmamento = new ArrayList<Armamento>();
	ArrayList<Municao> listaMunicao = new ArrayList<Municao>();
	ArrayList<Acessorios> listaAcessorios = new ArrayList<Acessorios>();
	
	//GETTERS
	public ArrayList<Armamento> getListaArmamento() {
		return listaArmamento;
	}
	public ArrayList<Municao> getListaMunicao() {
		return listaMunicao;
	}
	public ArrayList<Acessorios> getListaAcessorios() {
		return listaAcessorios;
	}
	
	//SETTERS
	public void setListaArmamento(ArrayList<Armamento> listaArmamento) {
		this.listaArmamento = listaArmamento;
	}
	public void setListaMunicao(ArrayList<Municao> listaMunicao) {
		this.listaMunicao = listaMunicao;
	}
	public void setListaAcessorios(ArrayList<Acessorios> listaAcessorios) {
		this.listaAcessorios = listaAcessorios;
	}
	
	public void adicionaArmamento (Armamento armamento) {
		listaArmamento.add(armamento);
	}
	public void adicionaMunicao (Municao municao) {
		listaMunicao.add(municao);
	}
	public void adicionaAcessorios (Acessorios acessorio) {
		listaAcessorios.add(acessorio);
	}

}
