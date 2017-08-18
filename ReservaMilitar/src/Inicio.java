import Material.Acessorios;
import Material.Armamento;
import Material.Municao;
import Militar.Militar;
import Militar.MilitarAdmin;
import SistemaReserva.ListaMaterial;
import SistemaReserva.Reserva;
import SistemaReserva.Retirada;

public class Inicio {

	public static void main(String[] args) {
		//Instância da reserva
		Reserva reserva1 = new Reserva("123", "Primeira reserva");
		
		//Instância dos Materiais
		Armamento armamento1 = new Armamento(789, "ak47", "Fabrica de arma 1");
		Armamento armamento2 = new Armamento(634, "Glock", "Fabrica de arma 2");
		Armamento armamento3 = new Armamento(423, "M4a4", "Fábrica de arma 3");
		Municao municao1 = new Municao(12, "shotgun");
		Municao municao2 = new Municao(762, "rifle de assalto");
		Municao municao3 = new Municao(355, "rifle de sniper");
		Acessorios acessorios1 = new Acessorios("Binóculo");
		Acessorios acessorios2 = new Acessorios ("Colete");
		Acessorios acessorios3 = new Acessorios ("Capacete");
		
		//Instância dos militares
		Militar militar1 = new Militar("Cabo Armeiro", "Barreto");
		Militar militar2 = new Militar ("Comandante", "Hamilton");
		Militar militar3 = new Militar ("Soldado", "06");
		MilitarAdmin admin = new MilitarAdmin("Capitão", "Nascimento", "asdasd", "asdasd", "asdasd", "asdasd@asdas.com");
		
		//Lista dos materiais que os militares irão retirar
		ListaMaterial listaMaterial1 = new ListaMaterial();
		listaMaterial1.adicionaArmamento(armamento1);
		listaMaterial1.adicionaMunicao(municao1);
		//listaMaterial1.adicionaAcessorios(acessorios1);
		
		ListaMaterial listaMaterial2 = new ListaMaterial();
		listaMaterial2.adicionaArmamento(armamento2);
		listaMaterial2.adicionaMunicao(municao2);
		//listaMaterial2.adicionaAcessorios(acessorios2);
		
		ListaMaterial listaMaterial3 = new ListaMaterial();
		listaMaterial3.adicionaArmamento(armamento3);
		listaMaterial3.adicionaMunicao(municao3);
		//listaMaterial3.adicionaAcessorios(acessorios3);
		
		//Instância das retiradas dos militares
		Retirada retirada1 = new Retirada (militar1, "18/07", "12:00:00", admin, listaMaterial1); 
		Retirada retirada2 = new Retirada (militar2, "30/08", "13:30:00", admin, listaMaterial2);
		Retirada retirada3 = new Retirada (militar3, "10/05", "10:22:31", admin, listaMaterial3);
		
		/* ------------- Início do Programa -------------*/
		
		//Cadastramento inicial da Reserva
		System.out.println("Iniciando...");
		reserva1.cadastrarArmamento(armamento1);
		reserva1.cadastrarArmamento(armamento2);
		reserva1.cadastrarArmamento(armamento3);
		reserva1.cadastrarMunicao(municao1);
		reserva1.cadastrarMunicao(municao2);
		reserva1.cadastrarMunicao(municao3);
		reserva1.cadastrarAcessorios(acessorios1);
		reserva1.cadastrarAcessorios(acessorios2);
		reserva1.cadastrarAcessorios(acessorios3);
		
		//Checagem da reserva
		reserva1.imprime(reserva1.getReservaAtual());
		
		//Fazer retirada da reserva
		reserva1.retirarMaterial(retirada1);
		reserva1.retirarMaterial(retirada2);
		reserva1.retirarMaterial(retirada3);
		
		//Impressão da cautela
		reserva1.getCautela().imprimeCautela();
		
		reserva1.imprime(reserva1.getReservaAtual());
		reserva1.imprime(reserva1.getReservaMaterial());
	}

}
