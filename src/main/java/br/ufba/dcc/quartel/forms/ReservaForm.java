package br.ufba.dcc.quartel.forms;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import br.ufba.dcc.quartel.models.Reserva;

public class ReservaForm 
{
	private Integer id;
	
	@NotNull
	@NotEmpty
	@Size(min=2, max=10)
	private String sigla;
	
	@NotNull
	@NotEmpty
	@Size(min=4, max=255)
	private String descricao;
	
	
	
	public Integer getId() 
	{
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSigla() 
	{
		return sigla;
	}
	
	public void setSigla(String sigla) 
	{
		this.sigla = sigla;
	}

	public String getDescricao() 
	{
		return descricao;
	}

	public void setDescricao(String descricao) 
	{
		this.descricao = descricao;
	}

	public Reserva generateReserva()
	{
		Reserva reserva = new Reserva();
		if(id != null) {
			reserva.setId(id);
		}
		reserva.setDescricao(descricao);
		reserva.setSigla(sigla);
		return reserva;
	}
	
	public static Map<String, String> generateReservaSelect(List<Reserva> reservas)
	{
		Map<String, String> reservaSelect = new LinkedHashMap<String, String>();
		if(!reservas.isEmpty()) {
			reservaSelect.put("0", "Selecione uma reserva");
			for (Reserva reserva : reservas) 
			{
				reservaSelect.put(reserva.getId().toString(), reserva.getSigla());
			}			
		}
		return reservaSelect;
	}

	@Override
	public String toString() 
	{
		return "ReservaForm [id=" + id + ", sigla=" + sigla + ", descricao=" + descricao + "]";
	}
}
