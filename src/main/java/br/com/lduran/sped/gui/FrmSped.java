package br.com.lduran.sped.gui;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

import javax.swing.*;

import org.apache.commons.lang3.ArrayUtils;

import br.com.lduran.sped.bean.*;
import br.com.lduran.sped.features.FileHandler;
import br.com.lduran.sped.features.ListHandler;
import br.com.lduran.sped.listas.AvailableProcesses;

public class FrmSped extends JFrame
{
	private JTextField txtInputFile;
	private JCheckBox chkSaveBD;
	private JCheckBox chkSaveTXT;
	private JList list;

	public FrmSped()
	{
		super("Processa Dados SPED");
		this.setSize(560, 195);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		JPanel panel = this.montaJPanelPrincipal();
		this.add(panel);

		this.setVisible(true);
	}

	/**
	 * JPanel Builder
	 *
	 * @return
	 */
	private JPanel montaJPanelPrincipal()
	{
		JPanel p = new JPanel();
		p.setLayout(null);

		JLabel lblInputFile = this.makeLabel("Input File:", 10, 5, 100, 25);
		p.add(lblInputFile);

		this.txtInputFile = this.makeTextField("C:\\GitHub\\TrataSped\\GruposSPED.txt", 10, 30, 370, 25);
		p.add(this.txtInputFile);

		JLabel lblOutputFile = this.makeLabel("Output Type:", 10, 65, 100, 25);
		p.add(lblOutputFile);

		chkSaveBD = this.makeCheckBox("Save in Data Base", 10, 85, 150, 25);
		p.add(chkSaveBD);

		chkSaveTXT = this.makeCheckBox("Save in TXT File", 170, 85, 120, 25);
		p.add(chkSaveTXT);

		JLabel lblProcess = this.makeLabel("Available Processes:", 390, 5, 150, 25);
		p.add(lblProcess);

		// String array of Available Processes
		AvailableProcesses[] availableProc = AvailableProcesses.values();

		JScrollPane scroll = this.makeList(availableProc, 390, 30, 145, 80);
		p.add(scroll);

		JButton processButton = this.makeButton("Process", 10, 120, 100, 25);
		processButton.addActionListener((ActionEvent event) ->
		{
			this.execAction();
		});
		p.add(processButton);

		JButton quitButton = this.makeButton("Quit", 475, 120, 60, 25);
		quitButton.addActionListener((ActionEvent event) ->
		{
			System.exit(0);
		});
		p.add(quitButton);

		return p;
	}

	/**
	 * Label Builder
	 *
	 * @param texto
	 * @param posX
	 * @param posY
	 * @param largura
	 * @param altura
	 * @return
	 */
	private JLabel makeLabel(String texto, int posX, int posY, int largura, int altura)
	{
		JLabel lbl = new JLabel(texto);
		lbl.setLocation(posX, posY);
		lbl.setSize(largura, altura);

		return lbl;
	}

	/**
	 * JScrollPane Builder
	 *
	 * @param availableProc
	 * @param posX
	 * @param posY
	 * @param largura
	 * @param altura
	 * @return
	 */
	private JScrollPane makeList(AvailableProcesses[] availableProc, int posX, int posY, int largura, int altura)
	{
		this.list = new JList(availableProc);

		JScrollPane scrollPane = new JScrollPane(this.list);
		scrollPane.setLocation(posX, posY);
		scrollPane.setSize(largura, altura);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		return scrollPane;
	}

	/**
	 * TextField Builder
	 *
	 * @param texto
	 * @param posX
	 * @param posY
	 * @param largura
	 * @param altura
	 * @return
	 */
	private JTextField makeTextField(String texto, int posX, int posY, int largura, int altura)
	{
		JTextField txtField = new JTextField(texto);
		txtField.setLocation(posX, posY);
		txtField.setSize(largura, altura);

		return txtField;
	}

	/**
	 * Button Builder
	 *
	 * @param texto
	 * @param posX
	 * @param posY
	 * @param largura
	 * @param altura
	 * @return
	 */
	private JButton makeButton(String texto, int posX, int posY, int largura, int altura)
	{
		JButton btn = new JButton(texto);
		btn.setLocation(posX, posY);
		btn.setSize(largura, altura);

		return btn;
	}

	private JCheckBox makeCheckBox(String texto, int posX, int posY, int largura, int altura)
	{
		JCheckBox chk = new JCheckBox(texto);
		chk.setLocation(posX, posY);
		chk.setSize(largura, altura);

		return chk;
	}

	/**
	 * processButton Action
	 */
	private void execAction()
	{
		// ==================
		// read the text file
		// ==================
		FileHandler fh = new FileHandler();
		List<String> fileContent = new LinkedList<>();
		try
		{
			List<String> selectedValuesList = this.list.getSelectedValuesList();
			String[] grupo =
			{};

			for (Object item : selectedValuesList)
			{
				for (AvailableProcesses ap : AvailableProcesses.values())
				{
					if (item.toString().equalsIgnoreCase(ap.name()))
					{
						grupo = ArrayUtils.addAll(ap.getGrupo(), grupo);

						break;
					}
				}
			}

			// get input file path
			if ((this.txtInputFile != null) && (!this.txtInputFile.getText().equals("")))
			{
				String path = this.txtInputFile.getText();
				fileContent = fh.readStream(path, grupo);
			}
			else if (this.txtInputFile != null)
			{
				JOptionPane.showMessageDialog(null, "Fill the Input File field!!!");
			}

			JOptionPane.showMessageDialog(null, "File loaded: " + fileContent.size() + " lines");
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
			String[] grupoOrganizacao =
			{ "|0000|", "|0005|" };

			List<Organizacao> organizacoes = (List<Organizacao>) lst.processFileInfo(fileContent, "Organizacoes", grupoOrganizacao);
			Organizacao org = new Organizacao();

			// generate list of participants
			List<Participante> participantes = (List<Participante>) lst.processFileInfo(org, fileContent, "Participantes", "Outros", "|0150|");

			//
			List<Produto> produtos = (List<Produto>) lst.processFileInfo(org, fileContent, "Produtos", "Outros", "|0200|");

			// generate list of inventory
			String[] grupoApuracaoInventario =
			{ "|H001|", "|H005|", "|H010|" };

			if (organizacoes.size() > 0)
			{
				org = organizacoes.get(0);
			}

			List<Inventario> inventario = (List<Inventario>) lst.processFileInfo(org, fileContent, "Inventario", "Inventario", grupoApuracaoInventario);

			// make lists reports
			if (chkSaveTXT.isSelected())
			{
				System.out.println("Make reports");

				this.saveProcessedReport(organizacoes, "Organizacoes");
				this.saveProcessedReport(participantes, "Participantes");
				this.saveProcessedReport(produtos, "Produtos");
				this.saveProcessedReport(inventario, "Inventario");
			}

			// save in data base
			if (chkSaveBD.isSelected())
			{
				System.out.println("Save in Data Base");
			}
		}
	}

	/**
	 * save processed report
	 *
	 * @param lstObjetosBI
	 */
	private void saveProcessedReport(List<? extends ObjectBI> lstObjetosBI, String objectType)
	{
		try
		{
			// format the list<object> as .csv
			ListHandler lst = new ListHandler();
			List<String> relatorio = lst.formatReport((List<ObjectBI>) lstObjetosBI, objectType);

			// save the file
			FileHandler fh = new FileHandler();

			Path path = Paths.get(this.txtInputFile.getText());
			fh.writeStream(path.getParent().toString() + "\\" + objectType + ".csv", relatorio, false);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
