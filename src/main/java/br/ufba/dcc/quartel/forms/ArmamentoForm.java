package br.ufba.dcc.quartel.forms;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import br.ufba.dcc.quartel.models.Armamento;
import br.ufba.dcc.quartel.models.TipoMaterial;

public class ArmamentoForm 
{
	private Integer id;
	
	private Integer usuario;
	
	@NotNull
	@Min(value=1, message="escolha uma reserva")
	private Integer reserva;
	
	@NotNull
	@NotEmpty
	@Size(min=4, max=50)
	private String serie;
	
	@NotNull
	@NotEmpty
	@Size(min=4, max=50)
	private String modelo;
	
	@NotNull
	@NotEmpty
	@Size(min=4, max=50)
	private String fabricante;
	
	private Integer qtd;

	public Integer getId() 
	{
		return id;
	}

	public void setId(Integer id) 
	{
		this.id = id;
	}

	public Integer getUsuario() 
	{
		return usuario;
	}

	public void setUsuario(Integer usuario) 
	{
		this.usuario = usuario;
	}

	public Integer getReserva() 
	{
		return reserva;
	}

	public void setReserva(Integer reserva) 
	{
		this.reserva = reserva;
	}

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
	
	public Integer getQtd() 
	{
		return qtd;
	}

	public void setQtd(Integer qtd) 
	{
		this.qtd = qtd;
	}

	public static ArmamentoForm factoryArmamentoForm(Armamento armamento)
	{
		ArmamentoForm armamentoForm = new ArmamentoForm();
		armamentoForm.setFabricante(armamento.getFabricante());
		armamentoForm.setId(armamento.getId());
		armamentoForm.setReserva(armamento.getReserva().getId());
		armamentoForm.setUsuario(armamento.getUsuario().getId());
		armamentoForm.setModelo(armamento.getModelo());
		armamentoForm.setSerie(armamento.getSerie());
		armamentoForm.setQtd(1);
		return armamentoForm;
	}
	
	public static Map<String,String> generateTipoMaterial(List<TipoMaterial> tipoMateriais)
	{
		Map<String, String> materialSelect = new LinkedHashMap<String, String>();
		if(!tipoMateriais.isEmpty()) {
			materialSelect.put("0", "Selecione um material");
			for (TipoMaterial tipoMaterial : tipoMateriais) 
			{
				materialSelect.put(tipoMaterial.getId().toString(), tipoMaterial.getNome());
			}			
		}
		return materialSelect;
	}

	@Override
	public String toString() 
	{
		return "ArmamentoForm [id=" + id + ", usuario=" + usuario + ", reserva=" + reserva + ", serie=" + serie
				+ ", modelo=" + modelo + ", fabricante=" + fabricante + ", qtd=" + qtd + "]";
	}	
	
	
}
