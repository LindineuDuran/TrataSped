package br.com.lduran.sped.listas;

public enum AvailableProcesses
{
	Organizacoes("|0000|", "|0005|"),
	Participantes("|0150|"),
	Produtos("|0200|"),
	MovimentacoesComerciais("|C100|", "|C170|", "|C190|"),
	EscrituracoesContabeis("|C400|", "|C405|", "|C410|", "|C420|", "|C490|"),
	AguaLuz("|C500|", "|C590|"),
	CupomFiscal("|C800|", "|C850|"),
	Transporte("|D100|", "|D190|"),
	Comunicacao("|D500|", "|D590|"),
	ApuracaoICMS("|E100|", "|E110|", "|E111|", "|E116|"),
	ApuracaoICMS_DIFAL_FCP("|E300|", "|E310|", "|E311|", "|E316|"),
	ApuracaoICMS_ST("|E200|", "|E210|", "|E220|", "|E250|"),
	ApuracaoIPI("|E500|", "|E510|", "|E520|", "|E530|", "|E531|"),
	Inventario("|H001|", "|H005|", "|H010|");

	private String[] grupo;

	/**
	 * @param grupo
	 */
	private AvailableProcesses(String ...grupo)
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
