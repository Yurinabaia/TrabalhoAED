package View;

import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComboBox;

@SuppressWarnings("serial")
public class Index extends JFrame {

	private JPanel contentPane;
	private JTextField textNome;
	private JTextField textNumero;
	private JTextField textMunicipio;
	private String Partido;
	private char Cargo = ' ';
	private String[] Municipios = new String[5570];
	private String[] NumeroCandidato = new String[6000];
	private String[] NumeroGeral = new String[6000];
	ArquivoDeEscrita arquivo = new ArquivoDeEscrita();
	Leitura let = new Leitura();
	private int i = 0;
	private String Estado;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Index frame = new Index();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	ButtonGroup group = new ButtonGroup();
	ButtonGroup group2 = new ButtonGroup();
	public Index() {
		
		ImageIcon icone = new ImageIcon("./src/icon.png");
		setIconImage(icone.getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textNome = new JTextField();
		textNome.setBounds(165, 11, 210, 20);
		contentPane.add(textNome);
		textNome.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Digite seu nome");
		lblNewLabel.setBounds(10, 14, 153, 14);
		contentPane.add(lblNewLabel);
		
		textNumero = new JTextField();
		textNumero.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e)
			{
				int num = 5;
				if(textNumero.getText().length() >= num) 
				{
					e.consume();
					JOptionPane.showMessageDialog(null, "Digite apenas 5 caracteres nesse campo");
				}
			}
		});
		textNumero.setBounds(165, 42, 128, 20);
		contentPane.add(textNumero);
		textNumero.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Digite seu n\u00FAmero");
		lblNewLabel_1.setBounds(10, 39, 106, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Digite seu municipio");
		lblNewLabel_2.setBounds(10, 75, 153, 14);
		contentPane.add(lblNewLabel_2);
		
		textMunicipio = new JTextField();
		textMunicipio.setBounds(165, 73, 210, 20);
		contentPane.add(textMunicipio);
		textMunicipio.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Escolha seu partido");
		lblNewLabel_3.setBounds(10, 138, 235, 14);
		contentPane.add(lblNewLabel_3);
		
		JRadioButton RdButtonP1 = new JRadioButton("Partidos Dos Trabalhadores (PT)");
		RdButtonP1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				Partido = "PT";
			}
		});
		RdButtonP1.setBounds(10, 159, 153, 23);
		contentPane.add(RdButtonP1);
		
		JRadioButton RdButtonP2 = new JRadioButton("Partido verde (PV)");
		RdButtonP2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				Partido = "PV";
			}
		});
		RdButtonP2.setBounds(10, 196, 156, 23);
		contentPane.add(RdButtonP2);
		
		group.add(RdButtonP1);
		group.add(RdButtonP2);
		
		JLabel lblNewLabel_4 = new JLabel("Escolha o seu cargo que esteja candidatando");
		lblNewLabel_4.setBounds(165, 138, 261, 14);
		contentPane.add(lblNewLabel_4);
		
		JRadioButton RdButtonCandidato1 = new JRadioButton("Prefeito (P)");
		RdButtonCandidato1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				Cargo = 'P';
			}
		});
		RdButtonCandidato1.setBounds(165, 159, 109, 23);
		contentPane.add(RdButtonCandidato1);
		
		JRadioButton RdButtonCandidato2 = new JRadioButton("Vereador (V)");
		RdButtonCandidato2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				Cargo = 'V';
			}
		});
		RdButtonCandidato2.setBounds(165, 196, 109, 23);
		contentPane.add(RdButtonCandidato2);
		group2.add(RdButtonCandidato1);
		group2.add(RdButtonCandidato2);
		
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(220, 104, 54, 22);
		contentPane.add(comboBox);
		comboBox.addItem("(AC)");
		comboBox.addItem("(AL)");
		comboBox.addItem("(AP)");
		comboBox.addItem("(AM)");
		comboBox.addItem("(BA)");
		comboBox.addItem("(CE)");
		comboBox.addItem("(DF)");
		comboBox.addItem("(ES)");
		comboBox.addItem("(GO)");
		comboBox.addItem("(MA)");
		comboBox.addItem("(MT)");
		comboBox.addItem("(MS)");
		comboBox.addItem("(MG)");
		comboBox.addItem("(PA)");
		comboBox.addItem("(PB)");
		comboBox.addItem("(PR)");
		comboBox.addItem("(PE)");
		comboBox.addItem("(PI)");
		comboBox.addItem("(RJ)");
		comboBox.addItem("(RN)");
		comboBox.addItem("(RS)");
		comboBox.addItem("(RO)");
		comboBox.addItem("(RR)");
		comboBox.addItem("(SC)");
		comboBox.addItem("(SP)");
		comboBox.addItem("(SE)");
		comboBox.addItem("(TO)");
		
		
		
		JButton ButtonCadastra = new JButton("Cadastra Candidato");
		ButtonCadastra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				boolean TudoCerto = true;
				textNome.getText().trim();
				Estado = textMunicipio.getText().trim() + " " + comboBox.getSelectedItem().toString();
				System.out.println(Estado);
				if(textNome.getText().length() == 0) 
				{
					JOptionPane.showMessageDialog(null, "O campo Nome deve ser preenchido");
					TudoCerto = false;
				}
				if(textNumero.getText().length() == 0) 
				{
					JOptionPane.showMessageDialog(null, "O campo Número deve ser preenchido");
					TudoCerto = false;
				}
				if(textMunicipio.getText().length() ==0) 
				{
					JOptionPane.showMessageDialog(null, "O campo Municipio deve ser preenchido");
					TudoCerto = false;
				}
				if(Partido == null) 
				{
					JOptionPane.showMessageDialog(null, "O campo Partido deve ser preenchido");
					TudoCerto = false;
				}
				if(Cargo == ' ') 
				{
					JOptionPane.showMessageDialog(null, "O campo Cargo deve ser preenchido");
					TudoCerto = false;
				}
								
				//Verificação se Municipio é valido
				boolean valid = false;
				for (int i = 0; i < Municipios.length -1; i++) 
				{
					if(Estado.trim().contains(Municipios[i])) 
					{
						valid = true;
					}
				}
				if(valid == false) 
				{
					JOptionPane.showMessageDialog(null, "Municipio: " + textMunicipio.getText() + " não existe em " + comboBox.getSelectedItem().toString());
					TudoCerto = false;
				}
				//Validando Número do candidato
				boolean validNum = true;
				for (int i = 0; i < NumeroCandidato.length -1; i++) 
				{
					String palavra = NumeroCandidato[i];
					if(palavra == null) break;
					else 
					{
						String[] Splitando = palavra.split(";");

						if(Splitando[0].equalsIgnoreCase(textNumero.getText()) && Splitando[1].equalsIgnoreCase(Estado)) 
						{
							validNum = false;
						}
					}
				}
				if(validNum == false) 
				{
					JOptionPane.showMessageDialog(null, "Número ja cadastrado no municipio de  " + textMunicipio.getText() + " no estado " + comboBox.getSelectedItem().toString());
					TudoCerto = false;
				}
				
				
				
				if(Cargo == 'V') 
				{
					int n = textNumero.getText().length();
					if(textNumero.getText().length() != 5) 
					{
						JOptionPane.showMessageDialog(null, "Error, Vereador possuir 5 algarismo você digitou apenas: " + n + " algarismos");
						TudoCerto = false;
					}
				}
				
				if(Cargo == 'P' ) 
				{
					int n = textNumero.getText().length();
					if(textNumero.getText().length() != 2) 
					{
						JOptionPane.showMessageDialog(null, "Error, Prefeito possuir apenas 2 algarismo você digitou: " + n + " algarismos");
						TudoCerto = false;
					}
				}
				
				boolean validnUMEC = true;
				if(i >0) 
				{
					for (int i = 0; i < NumeroGeral.length; i++)
					{
						if(NumeroGeral[i].contains(textNumero.getText())) 
						{
							validnUMEC = false;
						}
					}
				}
				if(!validnUMEC) 
				{
					JOptionPane.showMessageDialog(null, "Número ja cadastrado no municipio de  " + textMunicipio.getText() + " no estado " + comboBox.getSelectedItem().toString());
					TudoCerto = false;
				}
				
				if(TudoCerto == true) 
				{
					NumeroGeral[i] = textNumero.getText();
					i++;
					if(Cargo == 'V')
					JOptionPane.showMessageDialog(null, "Tudo Certo, \n candidato: " + textNome.getText() + " para vereador cadastrado com sucesso!!" );
					else 
					JOptionPane.showMessageDialog(null, "Tudo Certo, \n candidato: " + textNome.getText() + " para prefeito cadastrado com sucesso!!" );
					try {
						arquivo.escrever(textNome.getText() + ";" + textNumero.getText() + ";" + textMunicipio.getText() + " " + comboBox.getSelectedItem().toString() + ";" +  Partido + ";" + Cargo);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}				
				}
				
			}
		});
		ButtonCadastra.setBounds(121, 226, 171, 23);
		contentPane.add(ButtonCadastra);
		
		
		textNumero.setDocument(new ApenasNumeros());
		textMunicipio.setDocument(new LimitarNumeros());
		textNome.setDocument(new LimitarNumeros());
		
		JButton btnNewButton = new JButton("Menu");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				Menu.Index menu = new Menu.Index();
				menu.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(324, 226, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_5 = new JLabel("Escolha o estado do candidato");
		lblNewLabel_5.setBounds(10, 113, 199, 14);
		contentPane.add(lblNewLabel_5);
		
		
		
		let.abrirArquivo("NomesDosMunicipios.csv");
		for (int i = 0; i < Municipios.length -1; i++)
		{
			Municipios[i] = let.ler();
		}
		let.fecharArquivo();
		
		let.abrirArquivo("C.txt");
		for (int i = 0; i < NumeroCandidato.length -1; i++)
		{
			String palavra = let.ler();
			if(palavra == null ) 
			{
				break;
			}
			else 
			{
				String[] Splitando = palavra.split(";");
				NumeroCandidato[i] = Splitando[1] + ";" + Splitando[2];
				//System.out.println(NumeroCandidato[i]);
			}
		}
		let.fecharArquivo();
		
		for (int i = 0; i < NumeroGeral.length; i++) 
		{
			NumeroGeral[i] = "0";
		}
		setResizable(false);
	}
}
