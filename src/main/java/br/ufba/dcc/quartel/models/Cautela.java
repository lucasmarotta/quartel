package br.ufba.dcc.quartel.models;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Cautela 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="id_reserva")
	private Reserva reserva;
	
	@ManyToOne
	@JoinColumn(name="id_militar")
	private Militar militar;
	
	@ManyToOne
	@JoinColumn(name="id_material")
	private Material material;
	
	private LocalDateTime dataRetirada;
	private LocalDateTime dataDevolucao;
	private Integer qtd;
	
	public Integer getId() 
	{
		return id;
	}
	
	public void setId(Integer id) 
	{
		this.id = id;
	}
	
	public Reserva getReserva() 
	{
		return reserva;
	}
	
	public void setReserva(Reserva reserva) 
	{
		this.reserva = reserva;
	}
	
	public Militar getMilitar() 
	{
		return militar;
	}
	
	public void setMilitar(Militar militar) 
	{
		this.militar = militar;
	}
	
	public Material getMaterial() 
	{
		return material;
	}
	
	public void setMaterial(Material material) 
	{
		this.material = material;
	}
	
	public LocalDateTime getDataRetirada() 
	{
		return dataRetirada;
	}
	
	public void setDataRetirada(LocalDateTime dataRetirada) 
	{
		this.dataRetirada = dataRetirada;
	}
	
	public LocalDateTime getDataDevolucao() 
	{
		return dataDevolucao;
	}
	
	public void setDataDevolucao(LocalDateTime dataDevolucao) 
	{
		this.dataDevolucao = dataDevolucao;
	}
	
	public Integer getQtd() 
	{
		return qtd;
	}
	
	public void setQtd(Integer qtd) 
	{
		this.qtd = qtd;
	}

	@Override
	public String toString() 
	{
		return "Cautela [id=" + id + ", reserva=" + reserva + ", militar=" + militar + ", material=" + material
				+ ", dataRetirada=" + dataRetirada + ", dataDevolucao=" + dataDevolucao + ", qtd=" + qtd + "]";
	}
}
