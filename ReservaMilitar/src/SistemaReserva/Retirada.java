package SistemaReserva;

import java.util.ArrayList;
import java.util.Iterator;

import Material.Armamento;
import Material.MaterialRetirado;
import Material.Municao;
import Material.Acessorios;
import Militar.Militar;

public class Retirada extends MaterialRetirado{
	private Militar militar;
	private ListaMaterial listaRetirada;
	
	public Retirada (Militar militar, String dataRetirada, String horaRetirada, Militar militarResponsavel, ListaMaterial listaRetirada) {
		this.militar = militar;
		this.listaRetirada = listaRetirada;
		this.setDataRetirada(dataRetirada);
		this.setHoraRetirada(horaRetirada);
		this.setMilitarResponsavel(militarResponsavel);
		
		//Define os atributos de um material retirado (data, hora e responsavel)
		Iterator<Armamento> itrArmamento = listaRetirada.listaArmamento.iterator();
		Iterator<Municao> itrMunicao = listaRetirada.listaMunicao.iterator();
		Iterator<Acessorios> itrAcessorios = listaRetirada.listaAcessorios.iterator();
		while (itrArmamento.hasNext()) {
			Armamento arma = itrArmamento.next();
			arma.setDataRetirada(dataRetirada);
			arma.setMilitarResponsavel(militarResponsavel);
			arma.setHoraRetirada(horaRetirada);
		}
		while (itrMunicao.hasNext()) {
			Municao municao = itrMunicao.next();
			municao.setDataRetirada(dataRetirada);
			municao.setMilitarResponsavel(militarResponsavel);
			municao.setHoraRetirada(horaRetirada);
		}
		while (itrAcessorios.hasNext()) {
			Acessorios acessorios = itrAcessorios.next();
			acessorios.setDataRetirada(dataRetirada);
			acessorios.setHoraRetirada(horaRetirada);
			acessorios.setMilitarResponsavel(militarResponsavel);
		}
	}
	
	
	//GETTERS
	public Militar getMilitar() {
		return militar;
	}
	public ArrayList<Armamento> getListaArmamento () {
		return listaRetirada.listaArmamento;
	}
	public ArrayList<Municao> getListaMunicao() {
		return listaRetirada.listaMunicao;
	}
	public ArrayList<Acessorios> getListaAcessorios() {
		return listaRetirada.listaAcessorios;
	}
	
	//SETTERS
	public void setMilitar(Militar militar) {
		this.militar = militar;
	}
	public void setListaArmamento (ArrayList<Armamento> listaArmamento) {
		this.listaRetirada.listaArmamento = listaArmamento;
	}
	public void setListaMunicao (ArrayList<Municao> listaMunicao) {
		this.listaRetirada.listaMunicao= listaMunicao;
	}
	public void setListaAcessorios (ArrayList<Acessorios> listaAcessorios) {
		this.listaRetirada.listaAcessorios= listaAcessorios;
	}
	
	
	
}
