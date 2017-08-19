package br.ufba.dcc.quartel.models;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="id")
public class Municao extends Material 
{
	private String calibre;
	private String descricao;
	
	public String getCalibre() 
	{
		return calibre;
	}
	
	public void setCalibre(String calibre) 
	{
		this.calibre = calibre;
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
		return "Municao [calibre=" + calibre + ", descricao=" + descricao + "]";
	}
}
