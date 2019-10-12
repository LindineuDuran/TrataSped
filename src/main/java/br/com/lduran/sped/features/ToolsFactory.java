package br.com.lduran.sped.features;

import br.com.lduran.sped.listas.IndicadorPropriedade;

public class ToolsFactory
{
	private static ToolsFactory instance;

	private ToolsFactory()
	{

	}

	/**
	 * @return the instance
	 */
	public static ToolsFactory getInstance()
	{
		if (instance == null)
		{
			instance = new ToolsFactory();
		}

		return instance;
	}

	/**
	 * Check if a string is numeric [with regex]
	 *
	 * @param str
	 * @return
	 */
	public boolean isNumeric(String str)
	{
		return str.matches("-?\\d+(\\.\\d+)?"); // match a number with optional '-' and decimal.
	}

	/**
	 * Create RegEx from List<String>
	 *
	 * @param grupo
	 * @return
	 */
	public StringBuilder makePattern(String... grupo)
	{
		// Ex.: grupo = {"|9900|", "|C500|", "|D100|", "|D500|", "|D990|"};
		StringBuilder ptn = new StringBuilder("");
		for (String grp : grupo)
		{
			// Ensures no null items will come
			if (grp != null)
			{
				// Ex.: "\\|9900\\|"
				grp = grp.replace("|", "\\|");

				if (ptn.length() == 0)
				{
					// Ex.: "^\\|9900\\|"
					ptn.append("^");
					ptn.append(grp);
				}
				else
				{
					// Ex.: "^\\|9900\\||^\\|C500\\||^\\|D500\\|"
					ptn.append("|");
					ptn.append("^");
					ptn.append(grp);
				}
			}
		}
		return ptn;
	}

	/**
	 * Obtem a descrição do enum Indicador de Propriedade
	 *
	 * @param codigo
	 * @return
	 */
	public String obtemDescricaoIndicadorPropriedade(String codigo)
	{
		String descricao = "";

		for (IndicadorPropriedade ip : IndicadorPropriedade.values())
		{
			if (codigo.equalsIgnoreCase(ip.name()))
			{
				descricao = ip.getDescricao();
				break;
			}
		}

		return descricao;
	}

	// /**
	// * Obtem a descrição do enum SituacaoTributaria
	// * @param codigo
	// * @return
	// */
	// public String obtemSituacaoTributaria(String codigo)
	// {
	// String descricao = "";
	//
	// for (SituacaoTributaria st : SituacaoTributaria.values())
	// {
	// if (codigo.equalsIgnoreCase(st.name()))
	// {
	// descricao = st.getDescricao();
	// break;
	// }
	// }
	//
	// return descricao;
	// }

	// /**
	// * Obtem a descrição do enum AjustesApuracaoIPI
	// * @param codigo
	// * @return
	// */
	// public String obtemAjustesApuracaoIPI(String codigo)
	// {
	// String descricao = "";
	//
	// for (AjustesApuracaoIPI aai : AjustesApuracaoIPI.values())
	// {
	// if (codigo.equalsIgnoreCase(aai.name()))
	// {
	// descricao = aai.getDescricao();
	// break;
	// }
	// }
	//
	// return descricao;
	// }
}