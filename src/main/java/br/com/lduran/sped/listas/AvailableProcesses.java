package br.com.lduran.sped.listas;

import java.util.*;
import java.util.stream.Stream;

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
	 * Make a List<String> of groups
	 * 
	 * @return the grupo
	 */
	public List<String> getGrupo()
	{
		List<String> lstGrupo = new LinkedList<>();

		for (String grp : Arrays.asList(this.grupo))
		{
			lstGrupo.add(grp);
		}

		return lstGrupo;
	}

	/**
	 * Iterate the Enum Using Stream
	 * https://www.baeldung.com/java-enum-iteration
	 *
	 * @return
	 */
	public static Stream<AvailableProcesses> stream()
	{
		return Stream.of(AvailableProcesses.values());
	}
}
