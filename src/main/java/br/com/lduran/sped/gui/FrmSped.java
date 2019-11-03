package br.com.lduran.sped.gui;

import java.awt.event.*;

import javax.swing.*;

import br.com.lduran.sped.listas.AvailableProcesses;
import br.com.lduran.sped.process.Processamento;

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

		processButton.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				Processamento proc = new Processamento(txtInputFile.getText(), list.getSelectedValuesList(), chkSaveTXT.isSelected(), chkSaveBD.isSelected());
				Thread t = new Thread(proc);
				t.start();
			}
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
}
