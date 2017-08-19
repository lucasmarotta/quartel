package br.ufba.dcc.quartel.models;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="id")
public class Armamento extends Material
{
	private String serie;
	private String modelo;
	private String fabricante;
	
	public String getSerie() 
	{
		return serie;
	}
	
	public void setSerie(String serie) 
	{
		this.serie = serie;
	}
	
	public String getModelo() 
	{
		return modelo;
	}
	
	public void setModelo(String modelo) 
	{
		this.modelo = modelo;
	}
	
	public String getFabricante() 
	{
		return fabricante;
	}
	
	public void setFabricante(String fabricante) 
	{
		this.fabricante = fabricante;
	}

	@Override
	public String toString() 
	{
		return "Armamento [serie=" + serie + ", modelo=" + modelo + ", fabricante=" + fabricante + "]";
	}
}
