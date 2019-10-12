package br.com.lduran.sped.listas;

public enum AvailableProcesses
{
	Organizacoes("|0000|", "|0005|"), Participantes("|0150|"), Produtos("|0200|"), Inventario("|H001|", "|H005|", "|H010|");

	private String[] grupo;

	/**
	 * @param grupo
	 */
	private AvailableProcesses(String... grupo)
	{
		this.grupo = grupo;
	}

	/**
	 * @return the grupo
	 */
	public String[] getGrupo()
	{
		return this.grupo;
	}
}
