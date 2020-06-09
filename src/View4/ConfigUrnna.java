package View4;

import java.awt.EventQueue;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class ConfigUrnna extends JFrame {

	private JPanel contentPane;
	private JTextField MunicipioCandidatos;
	private JTextField MunicipiosEleitores;
	private String[] Municipios = new String[6000];
	private String[] TodosCandidatos = new String[6000];
	private String[] TodosEleitores = new String[6000];
	private int[] Zona = new int[6000];
	private int[] Secao = new int[6000];
	private Leitura let = new Leitura();
	private String MunicipioUrnaC = " ";
	private String MunicipioUrnaE;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConfigUrnna frame = new ConfigUrnna();
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
	public ConfigUrnna() {
		ImageIcon icone = new ImageIcon("./src/icon.png");
		setIconImage(icone.getImage());
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Digite o municipio dos candidato");
		lblNewLabel.setBounds(10, 11, 190, 14);
		contentPane.add(lblNewLabel);
		
		MunicipioCandidatos = new JTextField();
		MunicipioCandidatos.setBounds(210, 8, 171, 20);
		contentPane.add(MunicipioCandidatos);
		MunicipioCandidatos.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Digite o municipio dos eleitores");
		lblNewLabel_1.setBounds(10, 101, 197, 14);
		contentPane.add(lblNewLabel_1);
		
		MunicipiosEleitores = new JTextField();
		MunicipiosEleitores.setBounds(210, 98, 172, 20);
		contentPane.add(MunicipiosEleitores);
		MunicipiosEleitores.setColumns(10);
		
		
		
		JComboBox<String> comboBoxCandidatos = new JComboBox<String>();
		comboBoxCandidatos.setBounds(210, 52, 60, 22);
		contentPane.add(comboBoxCandidatos);
		comboBoxCandidatos.addItem("(AC)");
		comboBoxCandidatos.addItem("(AL)");
		comboBoxCandidatos.addItem("(AP)");
		comboBoxCandidatos.addItem("(AM)");
		comboBoxCandidatos.addItem("(BA)");
		comboBoxCandidatos.addItem("(CE)");
		comboBoxCandidatos.addItem("(DF)");
		comboBoxCandidatos.addItem("(ES)");
		comboBoxCandidatos.addItem("(GO)");
		comboBoxCandidatos.addItem("(MA)");
		comboBoxCandidatos.addItem("(MT)");
		comboBoxCandidatos.addItem("(MS)");
		comboBoxCandidatos.addItem("(MG)");
		comboBoxCandidatos.addItem("(PA)");
		comboBoxCandidatos.addItem("(PB)");
		comboBoxCandidatos.addItem("(PR)");
		comboBoxCandidatos.addItem("(PE)");
		comboBoxCandidatos.addItem("(PI)");
		comboBoxCandidatos.addItem("(RJ)");
		comboBoxCandidatos.addItem("(RN)");
		comboBoxCandidatos.addItem("(RS)");
		comboBoxCandidatos.addItem("(RO)");
		comboBoxCandidatos.addItem("(RR)");
		comboBoxCandidatos.addItem("(SC)");
		comboBoxCandidatos.addItem("(SP)");
		comboBoxCandidatos.addItem("(SE)");
		comboBoxCandidatos.addItem("(TO)");
		
		
		
		JLabel lblNewLabel_2 = new JLabel("Digite o estado dos candidatos");
		lblNewLabel_2.setBounds(10, 56, 190, 14);
		contentPane.add(lblNewLabel_2);
		
		JComboBox<String> comboBoxEleitor = new JComboBox<String>();
		comboBoxEleitor.setBounds(210, 142, 60, 22);
		contentPane.add(comboBoxEleitor);
		comboBoxEleitor.addItem("(AC)");
		comboBoxEleitor.addItem("(AL)");
		comboBoxEleitor.addItem("(AP)");
		comboBoxEleitor.addItem("(AM)");
		comboBoxEleitor.addItem("(BA)");
		comboBoxEleitor.addItem("(CE)");
		comboBoxEleitor.addItem("(DF)");
		comboBoxEleitor.addItem("(ES)");
		comboBoxEleitor.addItem("(GO)");
		comboBoxEleitor.addItem("(MA)");
		comboBoxEleitor.addItem("(MT)");
		comboBoxEleitor.addItem("(MS)");
		comboBoxEleitor.addItem("(MG)");
		comboBoxEleitor.addItem("(PA)");
		comboBoxEleitor.addItem("(PB)");
		comboBoxEleitor.addItem("(PR)");
		comboBoxEleitor.addItem("(PE)");
		comboBoxEleitor.addItem("(PI)");
		comboBoxEleitor.addItem("(RJ)");
		comboBoxEleitor.addItem("(RN)");
		comboBoxEleitor.addItem("(RS)");
		comboBoxEleitor.addItem("(RO)");
		comboBoxEleitor.addItem("(RR)");
		comboBoxEleitor.addItem("(SC)");
		comboBoxEleitor.addItem("(SP)");
		comboBoxEleitor.addItem("(SE)");
		comboBoxEleitor.addItem("(TO)");
		
		
		JLabel lblNewLabel_3 = new JLabel("Digite o municipio dos eleitores");
		lblNewLabel_3.setBounds(10, 146, 171, 14);
		contentPane.add(lblNewLabel_3);
		
		
		let.abrirArquivo("C.txt");
		for (int i = 0; i < TodosCandidatos.length -1; i++) 
		{
			TodosCandidatos[i] = let.ler();
		}
		let.fecharArquivo();
		
		let.abrirArquivo("D.txt");
		for (int i = 0; i < TodosEleitores.length -1; i++) 
		{
			TodosEleitores[i] = let.ler();
		}
		let.fecharArquivo();
		
		
		
		
		let.abrirArquivo("NomesDosMunicipios.csv");
		for (int i = 0; i < Municipios.length -1; i++)
		{
			Municipios[i] = let.ler();
		}
		let.fecharArquivo();
		
		for (int i = 0; i < TodosEleitores.length -1; i++)
		{
			if(TodosEleitores[i] != null) 
			{
				String infoCompleta = TodosEleitores[i];
				String[] Splitando = infoCompleta.split(";");
				
				Zona[i] = Integer.parseInt(Splitando[3]);
				Secao[i] = Integer.parseInt(Splitando[4]);
				
			}
		}
		
		
		JButton btnNewButton = new JButton("Configurar Urnas");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				boolean TudoCeroto = true;
				boolean valid = false, valid2 = false;
				MunicipioUrnaC = MunicipioCandidatos.getText().trim() +  " " + comboBoxCandidatos.getSelectedItem().toString();
				System.out.println(MunicipioUrnaC);
				MunicipioUrnaE = MunicipiosEleitores.getText().trim() + " " + comboBoxCandidatos.getSelectedItem().toString(); 

				if(MunicipioCandidatos.getText().length() == 0) 
				{
					JOptionPane.showMessageDialog(null, "Municipio: Digite o municipio no campo dos candidatos");
					TudoCeroto = false;
				}
				if(MunicipiosEleitores.getText().length() == 0) 
				{
					JOptionPane.showMessageDialog(null, "Municipio: Digite o municipio no campo dos eleitores");
					TudoCeroto = false;
				}
				for (int i = 0; i < Municipios.length; i++) 
				{
					if(MunicipioUrnaC.equalsIgnoreCase(Municipios[i])) 
					{
						valid = true;
					}
				}
				if(valid == false) 
				{
					JOptionPane.showMessageDialog(null, "Municipio: " + MunicipioCandidatos.getText() + " dos candidatos não existe");
					TudoCeroto = false;
				}
				
				
				for (int i = 0; i < Municipios.length; i++) 
				{
					if(MunicipioUrnaE.equalsIgnoreCase(Municipios[i])) 
					{
						valid2 = true;
					}
				}
				if(valid2 == false) 
				{
					JOptionPane.showMessageDialog(null, "Municipio: " + MunicipiosEleitores.getText() + " dos eleitores não existe");
					TudoCeroto = false;
				}
				
				if(TudoCeroto) 
				{
					JOptionPane.showMessageDialog(null, "Municipio: " + MunicipioCandidatos.getText() + " dos candidatos cadastrado com sucesso!!");
					JOptionPane.showMessageDialog(null, "Municipio: " + MunicipiosEleitores.getText() + " dos eleitores cadastrado com sucesso!!");

						try {
							NomeCandidatos(MunicipioUrnaC.toUpperCase(), TodosCandidatos);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						try {
							NomeEleitores(MunicipioUrnaE.toUpperCase(), TodosEleitores);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

				}				
			}
		});
		
		btnNewButton.setBounds(132, 198, 138, 23);
		contentPane.add(btnNewButton);
		
		MunicipioCandidatos.setDocument(new LimitarNumeross());
		MunicipiosEleitores.setDocument(new LimitarNumeross());
		
		JButton btnNewButton_1 = new JButton("Menu");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				Menu.Index menu = new Menu.Index();
				menu.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(326, 226, 89, 23);
		contentPane.add(btnNewButton_1);
	}
	
	public static void NomeCandidatos(String MunicipioUrna, String[] TodosCandidatos) throws IOException 
	{
		Arquivo arquivo = new Arquivo();
		String a = MunicipioUrna.replaceAll(" ", "");
		System.out.println(a);
		arquivo.CriacaoArquivo("Candidatos" +a.toUpperCase(), "NomesCandidatos" + a.toUpperCase());
		for (int i = 0; i < TodosCandidatos.length -1; i++)
		{
			if(TodosCandidatos[i] == null) break;
			String infoCompleta = TodosCandidatos[i];
			//System.out.println(infoCompleta);
			String[] Splitando = infoCompleta.split(";");
			
			if(MunicipioUrna.equalsIgnoreCase(Splitando[2]))
			{
				arquivo.SalvaVetor(TodosCandidatos[i]);
			}
		}
		arquivo.fecharArquivoSaida();
	}
	public static void NomeEleitores(String MunicipioUrna, String[] TodosEleitores) throws IOException  
	{
		
		Arquivo arquivo = new Arquivo();
		for (int i = 0; i < TodosEleitores.length -1; i++)
		{
			if(TodosEleitores[i] != null) 
			{
				String infoCompleta = TodosEleitores[i];
				System.out.println(infoCompleta);
				String[] Splitando = infoCompleta.split(";");
				
				if(MunicipioUrna.equalsIgnoreCase(Splitando[2]))
				{
					arquivo.CriacaoArquivo("Eleitores" +MunicipioUrna.replaceAll(" ", "").toUpperCase(), Splitando[3]+ Splitando[4]);	
					arquivo.SalvaVetor(TodosEleitores[i]);
					arquivo.fecharArquivoSaida();
				}
			}
		}
		arquivo.fecharArquivoSaida();
	}
}
