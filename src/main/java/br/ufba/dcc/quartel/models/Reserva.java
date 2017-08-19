package br.ufba.dcc.quartel.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Reserva 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private String sigla;
	private String descricao;
	
	public Integer getId() 
	{
		return id;
	}
	
	public void setId(Integer id) 
	{
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

	@Override
	public String toString() 
	{
		return "Reserva [id=" + id + ", sigla=" + sigla + ", descricao=" + descricao + "]";
	}
}
