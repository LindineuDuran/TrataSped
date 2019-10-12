package br.com.lduran.sped.features;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class FileHandler
{
	/**
	 * it reads text files using stream features and RegEx
	 *
	 * @param filePath
	 * @return
	 * @throws IOException
	 */
	public List<String> readStream(String filePath, String... grupo) throws IOException
	{
		Path path = Paths.get(filePath);

		// Make the RegEx
		StringBuilder ptn = ToolsFactory.getInstance().makePattern(grupo);

		// Get the pattern
		Pattern p = Pattern.compile(ptn.toString());

		List<String> listFile = Files.lines(path, StandardCharsets.ISO_8859_1).filter(p.asPredicate()).collect(Collectors.toList());

		return listFile;
	}

	/**
	 * Gravação de arquivo gerado durante processamento por meio de stream
	 *
	 * @param filePath
	 * @param dados
	 * @throws IOException
	 */
	public void writeStream(String filePath, List<String> dados, boolean sobreescreve) throws IOException
	{
		Path path = Paths.get(filePath);

		if (dados.size() > 0)
		{
			if (sobreescreve)
			{
				try
				{
					Files.write(path, dados);
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}
			else
			{
				try
				{
					if (Files.exists(path))
					{
						dados.remove(0);
					}

					Files.write(path, dados, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}
		}
	}
}
