package br.ufba.dcc.quartel.models;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="id")
public class Acessorio extends Material 
{
	private String descricao;

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
		return "Acessorio [descricao=" + descricao + "]";
	}
}
