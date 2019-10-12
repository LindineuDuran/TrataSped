package br.com.lduran.sped.gui;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.swing.*;

import org.apache.commons.lang3.ArrayUtils;

import br.com.lduran.sped.bean.Organizacao;
import br.com.lduran.sped.features.FileHandler;
import br.com.lduran.sped.features.ListHandler;
import br.com.lduran.sped.listas.AvailableProcesses;

public class FrmSped extends JFrame
{
	private JTextField txtInputFile;
	private JList list;

	public FrmSped()
	{
		super("Processa Dados SPED");
		this.setSize(800, 300);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		JPanel panel = this.montaJPanelPrincipal();
		this.add(panel);

		this.setVisible(true);
	}

	private JPanel montaJPanelPrincipal()
	{
		JPanel p = new JPanel();
		p.setLayout(null);

		JLabel lblInputFile = this.makeLabel("Input File:", 10, 5, 100, 25);
		p.add(lblInputFile);

		this.txtInputFile = this.makeTextField("C:\\Temp\\New\\GruposSPED.txt", 10, 30, 370, 25);
		p.add(this.txtInputFile);

		JLabel lblProcess = this.makeLabel("Available Processes:", 600, 5, 150, 25);
		p.add(lblProcess);

		// String array of Available Processes
		AvailableProcesses[] availableProc = AvailableProcesses.values();

		JScrollPane scroll = this.makeList(availableProc, 600, 30, 175, 190);
		p.add(scroll);

		JButton processButton = this.makeButton("Process", 10, 230, 100, 25);
		processButton.addActionListener((ActionEvent event) ->
		{
			this.execAction();
		});
		p.add(processButton);

		JButton quitButton = this.makeButton("Quit", 715, 230, 60, 25);
		quitButton.addActionListener((ActionEvent event) ->
		{
			System.exit(0);
		});
		p.add(quitButton);

		return p;
	}

	private JLabel makeLabel(String texto, int posX, int posY, int largura, int altura)
	{
		JLabel lbl = new JLabel(texto);
		lbl.setLocation(posX, posY);
		lbl.setSize(largura, altura);

		return lbl;
	}

	private JScrollPane makeList(AvailableProcesses[] availableProc, int posX, int posY, int largura, int altura)
	{
		this.list = new JList(availableProc);

		JScrollPane scrollPane = new JScrollPane(this.list);
		scrollPane.setLocation(posX, posY);
		scrollPane.setSize(largura, altura);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		return scrollPane;
	}

	private JTextField makeTextField(String texto, int posX, int posY, int largura, int altura)
	{
		JTextField txtField = new JTextField(texto);
		txtField.setLocation(posX, posY);
		txtField.setSize(largura, altura);

		return txtField;
	}

	private JButton makeButton(String texto, int posX, int posY, int largura, int altura)
	{
		JButton btn = new JButton(texto);
		btn.setLocation(posX, posY);
		btn.setSize(largura, altura);

		return btn;
	}

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

			// remember to change the file path
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
			String[] grupo =
			{ "|0000|", "|0005|" };

			List<Organizacao> organizacoes = (List<Organizacao>) lst.processFileInfo(fileContent, "Organizacoes", grupo);

			Organizacao org = organizacoes.get(0);
		}
	}
}
