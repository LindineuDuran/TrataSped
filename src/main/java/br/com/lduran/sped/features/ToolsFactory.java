package br.com.lduran.sped.features;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.lduran.sped.listas.AvailableProcesses;
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
	public StringBuilder makePattern(List<String> grupo)
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
	 * Get the groups of the listed AvailableProcesses
	 *
	 * @param selectedValuesList
	 * @return
	 */
	public List<String> obtemAvailableProcesses(List<String> selectedValuesList)
	{
		List<String> grupo = new LinkedList<>();

		for (Object item : selectedValuesList)
		{
			grupo.addAll(AvailableProcesses.stream().filter(d -> d.name().equals(item.toString())).map(d -> d.getGrupo()).flatMap(x -> x.stream()).collect(Collectors.toList()));
		}
		return grupo;
	}

	/**
	 * Get the description of the Property Indicator enum
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
}