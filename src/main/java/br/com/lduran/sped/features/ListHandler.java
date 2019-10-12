package br.com.lduran.sped.features;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import br.com.lduran.sped.bean.ObjectBI;
import br.com.lduran.sped.bean.Organizacao;
import br.com.lduran.sped.services.BuildService;

public class ListHandler
{
	/**
	 * Filters data for the desired group
	 *
	 * @param dir
	 * @param file
	 * @param grupo
	 * @return
	 */
	private List<String> extractGroupInfo(List<String> file, String... grupo)
	{
		// Build the RegEx
		StringBuilder ptn = ToolsFactory.getInstance().makePattern(grupo);

		// Receive the pattern
		Pattern p = Pattern.compile(ptn.toString());

		// Filter the desired groups info
		try
		{
			List<String> auxList = file.stream().filter(p.asPredicate()).collect(Collectors.toList());

			return auxList;
		}
		catch (Exception e)
		{
			System.out.println("Error of Stream");

			List<String> auxList = new LinkedList<>();
			return auxList;
		}
	}

	/**
	 * receives digital tax bookkeeping data and returns organization type object
	 *
	 * @param file
	 * @return
	 */
	public List<? extends ObjectBI> processFileInfo(List<String> file, String objectType, String... grupo)
	{
		try
		{
			// process list info
			List<String> auxList = this.extractGroupInfo(file, grupo);

			BuildService bs = new BuildService();

			// generate List<Organizacao>
			List<? extends ObjectBI> objectList = bs.getObjectService(objectType).getObjectList(file);

			return objectList;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			List<? extends ObjectBI> objectList = new LinkedList<>();
			return objectList;
		}
	}

	/**
	 * Receive a List<String> and returns a List<Object>
	 *
	 * @param file
	 * @return
	 */
	public List<? extends ObjectBI> processFileInfo(Organizacao org, List<String> file, String objectType, String criteria, String... grupo)
	{
		// process list info
		List<String> auxList = this.extractGroupInfo(file, grupo);

		BuildService bs = new BuildService();

		List<? extends ObjectBI> objectList = new LinkedList<>();
		if (criteria.equals("Outros"))
		{
			// generate List<ObjectBI>
			objectList = bs.getObjectService(objectType).getObjectList(auxList);
		}
		else
		{
			// generate List<ObjectBI>
			objectList = bs.getObjectService(objectType).getObjectList(auxList, org, criteria);
		}

		return objectList;
	}

	/**
	 * Format the List<Object> as .csv
	 *
	 * @param dir
	 * @param nomeArquivo
	 * @param lstObjetosBI
	 * @param sobreescreve
	 * @throws IOException
	 */
	public List<String> formatReport(List<ObjectBI> lstObjetosBI, String objectType)
	{
		List<String> relatorio = new LinkedList<>();

		BuildService bs = new BuildService();
		String header = bs.getObjectService(objectType).getObjectHeader();
		relatorio.add(header);

		if (!lstObjetosBI.isEmpty())
		{
			for (ObjectBI line : lstObjetosBI)
			{
				relatorio.add(bs.getObjectService(objectType).getObjectContent(line));
			}
		}

		return relatorio;
	}
}
