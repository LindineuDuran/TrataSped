package br.com.lduran.sped.features;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
	public List<String> readStream(String filePath, String ...grupo) throws IOException
	{
		Path path = Paths.get(filePath);

		// Make the RegEx
		StringBuilder ptn = ToolsFactory.getInstance().makePattern(grupo);

		// Get the pattern 
		Pattern p = Pattern.compile(ptn.toString());

		List<String> listFile = Files.lines(path, StandardCharsets.ISO_8859_1).filter(p.asPredicate()).collect(Collectors.toList());

		return listFile;
	}
}
