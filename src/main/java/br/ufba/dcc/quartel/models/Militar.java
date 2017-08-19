package br.ufba.dcc.quartel.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Militar 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="id_reserva")
	private Reserva reserva;
	
	@ManyToOne
	@JoinColumn(name="id_usuario")
	private Usuario usuario;
	
	private String posto;
	private String nomeGuerra;
	
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
	
	public Usuario getUsuario() 
	{
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) 
	{
		this.usuario = usuario;
	}
	
	public String getPosto() 
	{
		return posto;
	}
	
	public void setPosto(String posto) 
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

	@Override
	public String toString() 
	{
		return "Militar [id=" + id + ", reserva=" + reserva + ", usuario=" + usuario + ", posto=" + posto
				+ ", nomeGuerra=" + nomeGuerra + "]";
	}
	
	
}
