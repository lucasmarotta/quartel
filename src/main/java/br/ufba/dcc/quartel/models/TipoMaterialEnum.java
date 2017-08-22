package br.ufba.dcc.quartel.models;

public enum TipoMaterialEnum
{
	ARMAMENTO(1), MUNICAO(2), ACESSORIO(3);
	public Integer value;
	TipoMaterialEnum(Integer value) {
		this.value = value;
	}
}
