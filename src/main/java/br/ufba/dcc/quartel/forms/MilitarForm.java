package br.ufba.dcc.quartel.forms;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.ufba.dcc.quartel.models.Militar;
import br.ufba.dcc.quartel.models.MilitarPosto;
import br.ufba.dcc.quartel.services.MilitarPostoService;
import br.ufba.dcc.quartel.services.ReservaService;
import br.ufba.dcc.quartel.services.UsuarioService;

@Component
public class MilitarForm
{
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private ReservaService reservaService;
	
	@Autowired
	private MilitarPostoService militarPostoService;

	@NotNull
	@Min(value=1, message="escolha uma reserva")
	private Integer reserva;
	
	@Min(0)
	private Integer usuario;

	@NotNull
	@Min(value=1, message="escolha um posto")
	private Integer posto;
	
	@NotNull
	@NotEmpty
	@Size(min=4, max=50)	
	private String nomeGuerra;
	
	public Integer getReserva() 
	{
		return reserva;
	}
	
	public void setReserva(Integer reserva) 
	{
		this.reserva = reserva;
	}
	
	public Integer getUsuario() 
	{
		return usuario;
	}
	
	public void setUsuario(Integer usuario) 
	{
		this.usuario = usuario;
	}
	
	public Integer getPosto() 
	{
		return posto;
	}
	
	public void setPosto(Integer posto) 
	{
		this.posto = posto;
	}
	
	public String getNomeGuerra() 
	{
		return nomeGuerra;
	}
	
	public void setNomeGuerra(String nomeGuerra) 
	{
		this.nomeGuerra = nomeGuerra;
	}
	
	public static Map<String,String> generatePostoSelect(List<MilitarPosto> postos)
	{
		Map<String, String> postoSelect = new LinkedHashMap<String, String>();
		if(!postos.isEmpty()) {
			postoSelect.put("0", "Selecione um posto");
			for (MilitarPosto posto : postos) 
			{
				postoSelect.put(posto.getId().toString(), posto.getNome());
			}			
		}
		return postoSelect;
	}	

	@Override
	public String toString() 
	{
		return "MilitarForm [reserva=" + reserva + ", usuario=" + usuario + ", posto=" + posto
				+ ", nomeGuerra=" + nomeGuerra + "]";
	}
}
