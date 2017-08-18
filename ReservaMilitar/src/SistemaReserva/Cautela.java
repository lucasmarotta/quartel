package SistemaReserva;

import java.util.ArrayList;
import java.util.Iterator;

import Material.Acessorios;
import Material.Armamento;
import Material.Municao;
import Militar.Militar;

public class Cautela {

	private ArrayList<Retirada> listaRetirada = new ArrayList<Retirada>();

	//GETTER
	public ArrayList<Retirada> getListaRetirada() {
		return listaRetirada;
	}

	//SETTER
	public void setListaRetirada(ArrayList<Retirada> listaRetirada) {
		this.listaRetirada = listaRetirada;
	}

	//M�TODOS
	public void cadastraRetirada(Retirada retirada) {
		listaRetirada.add(retirada);
	}
	
	public void devolveRetirada(Retirada retirada) {
		Iterator<Retirada> itrListaRetirada = listaRetirada.iterator();
		while (itrListaRetirada.hasNext()) {
			Militar militar = itrListaRetirada.next().getMilitar();
			if (militar == retirada.getMilitar()) {
				
			}
		}
	}
	
	public void imprimeCautela () {
		System.out.println("\nImpress�o da cautela:");
		if (!listaRetirada.isEmpty()) {
			Iterator<Retirada> itrRetirada = listaRetirada.iterator();
			int count = 1;
			while (itrRetirada.hasNext()) {
				Retirada retirada = itrRetirada.next();
				Militar militar = retirada.getMilitar();
				Iterator<Armamento> itrArmamento = retirada.getListaArmamento().listIterator();
				Iterator<Municao> itrMunicao = retirada.getListaMunicao().listIterator();
				Iterator<Acessorios> itrAcessorios = retirada.getListaAcessorios().listIterator();
				
				System.out.println("\t" + count + " - Retirada do Militar: " + militar.getNomeGuerra() + " | Posto: " + militar.getPosto());
				
				while (itrArmamento.hasNext()) {
					Armamento arma = itrArmamento.next();
					System.out.println("\t\tArmamento: | Numero de serie: " + arma.getNumSerie() + " | Modelo: " + arma.getModelo() + " | Fabricante: " + arma.getFabricante() +
							" | Data Retirada: " + arma.getDataRetirada() +
							" | Hora Retirada: " + arma.getHoraRetirada() +
							" | Militar Respons�vel: " + arma.getMilitarResponsavel().getNomeGuerra());
				}
				
				while (itrMunicao.hasNext()) {
					Municao municao = itrMunicao.next();
					System.out.println("\t\tMuni��o: | Calibre: " + municao.getCalibre() + " | Descri��o: " + municao.getDescricao() + 
							" | Data Retirada: " + municao.getDataRetirada() +
							" | Hora Retirada: " + municao.getHoraRetirada() +
							" | Militar Respons�vel: " + municao.getMilitarResponsavel().getNomeGuerra());
				}
				while (itrAcessorios.hasNext()) {
					Acessorios acessorios = itrAcessorios.next();
					System.out.println("\t\tAcess�rio: | Descri��o: " + acessorios.getDescricao() + 
							" | Data Retirada: " + acessorios.getDataRetirada() +
							" | Hora Retirada: " + acessorios.getHoraRetirada() +
							" | Militar Respons�vel: " + acessorios.getMilitarResponsavel().getNomeGuerra());
				}
				
				count++;
			}
			System.out.println("\n");
		}
		else
			System.out.println("Cautala Vazia!");
	}
}
