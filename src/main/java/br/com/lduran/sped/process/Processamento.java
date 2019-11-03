package br.com.lduran.sped.process;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.lduran.sped.bean.*;
import br.com.lduran.sped.dao.*;
import br.com.lduran.sped.exception.GlobalcodeException;
import br.com.lduran.sped.features.*;
import br.com.lduran.sped.listas.AvailableProcesses;

public class Processamento implements Runnable
{
	private String inputFile;
	private List<String> selectedValuesList;
	private boolean saveTXT;
	private boolean saveBD;

	/**
	 * @param inputFile
	 * @param selectedValuesList
	 * @param saveTXT
	 * @param saveBD
	 */
	public Processamento(String inputFile, List<String> selectedValuesList, boolean saveTXT, boolean saveBD)
	{
		this.inputFile = inputFile;
		this.selectedValuesList = selectedValuesList;
		this.saveTXT = saveTXT;
		this.saveBD = saveBD;
	}

	@Override
	public void run()
	{
		// ==================
		// read the text file
		// ==================
		FileHandler fh = new FileHandler();
		List<String> fileContent = new LinkedList<>();
		try
		{
			// get the groups of the listed AvailableProcesses
			List<String> grupo = ToolsFactory.getInstance().obtemAvailableProcesses(selectedValuesList);

			// get input file content
			if ((!inputFile.equals("")) && (!grupo.isEmpty()))
			{
				fileContent = fh.readStream(inputFile, grupo);
				JOptionPane.showMessageDialog(null, "File loaded: " + fileContent.size() + " lines");
			}
			else if (grupo.isEmpty())
			{
				JOptionPane.showMessageDialog(null, "Choose at least one process");
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Fill the Input File field!!!");
			}
		}
		catch (IOException e)
		{
			JOptionPane.showMessageDialog(null, e.getClass().getName() + "\r\n" + e.getMessage());
		}

		ListHandler lst = new ListHandler();

		// =================================
		// Make a Object from a List<String>
		// =================================
		if (fileContent.size() > 0)
		{
			// generate list of organizations
			List<String> grupo = AvailableProcesses.Organizacoes.getGrupo();
			List<Organizacao> organizacoes = (List<Organizacao>) lst.processFileInfo(fileContent, "Organizacoes", grupo);
			Organizacao org = new Organizacao();

			// generate list of participants
			grupo = AvailableProcesses.Participantes.getGrupo();
			List<Participante> participantes = (List<Participante>) lst.processFileInfo(org, fileContent, "Participantes", "Outros", grupo);

			// generate list of produtos
			grupo = AvailableProcesses.Produtos.getGrupo();
			List<Produto> produtos = (List<Produto>) lst.processFileInfo(org, fileContent, "Produtos", "Outros", grupo);

			// generate list of inventory
			grupo = AvailableProcesses.Inventario.getGrupo();

			if (organizacoes.size() > 0)
			{
				org = organizacoes.get(0);
			}

			List<Inventario> inventario = (List<Inventario>) lst.processFileInfo(org, fileContent, "Inventario", "Inventario", grupo);

			// make lists reports
			if (saveTXT)
			{
				saveProcessedReport(organizacoes, "Organizacoes", inputFile);
				saveProcessedReport(participantes, "Participantes", inputFile);
				saveProcessedReport(produtos, "Produtos", inputFile);
				saveProcessedReport(inventario, "Inventario", inputFile);

				JOptionPane.showMessageDialog(null, "Reports created");
			}

			// save in data base
			if (saveBD)
			{
				OrganizacaoDAOImpl dbOrg = new OrganizacaoDAOImpl();

				try
				{
					dbOrg.createTable();
					dbOrg.saveAll(organizacoes);
				}
				catch (GlobalcodeException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				ParticipanteDAOImpl dbPart = new ParticipanteDAOImpl();

				try
				{
					dbPart.createTable();
					dbPart.saveAll(participantes);
				}
				catch (GlobalcodeException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				ProdutosDAOImpl dbProd = new ProdutosDAOImpl();

				try
				{
					dbProd.createTable();
					dbProd.saveAll(produtos);
				}
				catch (GlobalcodeException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				InventarioDAOImpl dbInv = new InventarioDAOImpl();

				try
				{
					dbInv.createTable();
					dbInv.saveAll(inventario);
				}
				catch (GlobalcodeException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				JOptionPane.showMessageDialog(null, "Saved in Data Base");
			}
		}
	}

	/**
	 * save processed report
	 *
	 * @param lstObjetosBI
	 */
	private void saveProcessedReport(List<? extends ObjectBI> lstObjetosBI, String objectType, String inputFile)
	{
		try
		{
			// format the list<object> as .csv
			ListHandler lst = new ListHandler();
			List<String> relatorio = lst.formatReport((List<ObjectBI>) lstObjetosBI, objectType);

			// save the file
			FileHandler fh = new FileHandler();

			Path path = Paths.get(inputFile);
			fh.writeStream(path.getParent().toString() + "\\" + objectType + ".csv", relatorio, false);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
