package br.com.lduran.sped.listas;

public enum IndicadorPropriedade
{
	IP0("ITEM DE PROPRIEDADE DO INFORMANTE E EM SEU PODER"), IP1("ITEM DE PROPRIEDADE DO INFORMANTE EM POSSE DE TERCEIROS"), IP2("ITEM DE PROPRIEDADE DE TERCEIROS EM POSSE DO INFORMANTE");

	private String descricao;

	/**
	 * @param descricao
	 */
	private IndicadorPropriedade(String descricao)
	{
		this.descricao = descricao;
	}

	/**
	 * @return the descricao
	 */
	public String getDescricao()
	{
		return this.descricao;
	}

	/**
	 * @param descricao the descricao to set
	 */
	public void setDescricao(String descricao)
	{
		this.descricao = descricao;
	}
}