package SistemaReserva;

import java.util.Iterator;

import Material.Acessorios;
import Material.Armamento;
import Material.Municao;

public class Reserva {

	private String sigla;
	private String descricao;
	private Cautela cautela;
	private ListaMaterial reservaAtual = new ListaMaterial();
	private ListaMaterial reservaMaterial = new ListaMaterial();
		
	public Reserva(String sigla, String descricao) {
		this.sigla = sigla;
		this.descricao = descricao;
		cautela = new Cautela();
	}
	
	//GETTERS
	public String getSigla() {
		return sigla;
	}
	public String getDescricao() {
		return descricao;
	}
	public Cautela getCautela() {
		return cautela;
	}
	public ListaMaterial getReservaAtual() {
		return reservaAtual;
	}
	public ListaMaterial getReservaMaterial() {
		return reservaMaterial;
	}
	
	//SETTERS
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public void setCautela(Cautela cautela) {
		this.cautela = cautela;
	}
	public void setReservaAtual(ListaMaterial reservaAtual) {
		this.reservaAtual = reservaAtual;
	}
	public void setReservaMaterial(ListaMaterial reservaMaterial) {
		this.reservaMaterial = reservaMaterial;
	}

	//MÉTODOS
	
	//CADASTRAMENTO
	public void cadastrarArmamento (Armamento armamento) {
		reservaAtual.listaArmamento.add(armamento);
		reservaMaterial.listaArmamento.add(armamento);
		System.out.println("Armamento |"+armamento.getNumSerie()+"|"+armamento.getModelo()+"|"+" cadastrado na reserva.");
	}
	public void cadastrarMunicao (Municao municao) {
		reservaAtual.listaMunicao.add(municao);
		reservaMaterial.listaMunicao.add(municao);
		System.out.println("Municao |"+municao.getCalibre()+"|"+municao.getDescricao()+"|"+" cadastrado na reserva.");
	}
	public void cadastrarAcessorios (Acessorios acessorio) {
		reservaAtual.listaAcessorios.add(acessorio);
		reservaMaterial.listaAcessorios.add(acessorio);
		System.out.println("Acessorio |"+acessorio.getDescricao()+" cadastrado na reserva.");
	}
	
	//RETIRADA
	public void retirarMaterial(Retirada retirada) {
		if (! (retirada.getListaArmamento().isEmpty() && retirada.getListaMunicao().isEmpty() && retirada.getListaAcessorios().isEmpty())) {
			cautela.cadastraRetirada(retirada);
			System.out.println(retirada.getListaArmamento().size() + " armamento(s) retirado");
			reservaAtual.listaArmamento.removeAll(retirada.getListaArmamento());
			reservaAtual.listaMunicao.removeAll(retirada.getListaMunicao());
			reservaAtual.listaAcessorios.removeAll(retirada.getListaAcessorios());
			}
	}
	
	//DEVOLUÇÃO
	public void devolveRetirada(Retirada retirada) {
		
	}
	
	//IMPRESSÃO
	public void imprime(ListaMaterial reserva) {
		System.out.println("Imprimindo status da reserva..");
		if (reserva.listaArmamento.isEmpty() && reserva.listaMunicao.isEmpty() && reserva.listaAcessorios.isEmpty()) {
			System.out.println("\tRESERVA VAZIA!!!");
		}
		else {
			if (!reserva.listaArmamento.isEmpty()) {
				int i=0;
				Iterator<Armamento> itrArmamento = reserva.listaArmamento.iterator();
				while (itrArmamento.hasNext()) {
					i++;
					Armamento arma = itrArmamento.next();
					System.out.println("\tArmamento "+ i + ":" + 
							"\t\tNúmero de Série: " + arma.getNumSerie() + 
							"\t\tModelo: " + arma.getModelo() + 
							"\t\tFabricante: " + arma.getFabricante());
				}
			}
			if(!reserva.listaMunicao.isEmpty()) {
				int i=0;
				Iterator<Municao> itrMunicao = reserva.listaMunicao.iterator();
				while (itrMunicao.hasNext()) {
					i++;
					Municao municao = itrMunicao.next();
					System.out.println("\tMunição: "+ i + ":" + 
							"\t\tCalibre: " + municao.getCalibre() + 
							"\t\tDescrição: " + municao.getDescricao());
				}
			}
			if (!reserva.listaAcessorios.isEmpty()) {
				int i=0;
				Iterator<Acessorios> itrAcessorios = reserva.listaAcessorios.iterator();
				while (itrAcessorios.hasNext()) {
					i++;
					Acessorios acessorios = itrAcessorios.next();
					System.out.println("\tAcessório: "+ i + ":" + 
							"\t\tDescrição: " + acessorios.getDescricao());
				}
			}
		}
	}

	
}
