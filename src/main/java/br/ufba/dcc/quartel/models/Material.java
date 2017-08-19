package br.ufba.dcc.quartel.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Material 
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
	
	@ManyToOne
	@JoinColumn(name="id_tipo_material")
	private TipoMaterial tipoMaterial;
	
	private Integer qtd;
	private Boolean ativo;
	
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
	
	public TipoMaterial getTipoMaterial() 
	{
		return tipoMaterial;
	}
	
	public void setTipoMaterial(TipoMaterial tipoMaterial) 
	{
		this.tipoMaterial = tipoMaterial;
	}
	
	public Integer getQtd() 
	{
		return qtd;
	}
	
	public void setQtd(Integer qtd) 
	{
		this.qtd = qtd;
	}
	
	public Boolean getAtivo() 
	{
		return ativo;
	}
	
	public void setAtivo(Boolean ativo) 
	{
		this.ativo = ativo;
	}

	@Override
	public String toString() 
	{
		return "Material [id=" + id + ", reserva=" + reserva + ", usuario=" + usuario + ", tipoMaterial=" + tipoMaterial
				+ ", qtd=" + qtd + ", ativo=" + ativo + "]";
	}
}
