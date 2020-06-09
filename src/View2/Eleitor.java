package View2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import javax.swing.JComboBox;

@SuppressWarnings("serial")
public class Eleitor extends JFrame {

	private JPanel contentPane;
	private JTextField textNome;
	private JTextField textTitulo;
	private JTextField textMunicipio;
	private JTextField textZonaEleitoral;
	private JTextField textSecaoEleitoral;
	
	private String[] Municipios = new String[5574];
	String[] TituloEleitor = new String[6000];
	String[] TesteTitular = new String[6000];

	ArquivoDeEscritaA arquivo = new ArquivoDeEscritaA();
	Leitura let = new Leitura();
	private JButton btnNewButton;
	private JLabel lblNewLabel_5;
	private JComboBox<String> comboBox;
	private String Estado;
	private int i = 0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Eleitor frame = new Eleitor();
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
	public Eleitor() {
		ImageIcon icone = new ImageIcon("./src/icon.png");
		setIconImage(icone.getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Digite seu nome");
		lblNewLabel.setBounds(10, 11, 156, 14);
		contentPane.add(lblNewLabel);
		
		textNome = new JTextField();
		textNome.setBounds(176, 8, 219, 20);
		contentPane.add(textNome);
		textNome.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Digite seu titulo de eleitor");
		lblNewLabel_1.setBounds(10, 47, 165, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Digite o seu municipio");
		lblNewLabel_2.setBounds(10, 78, 156, 14);
		contentPane.add(lblNewLabel_2);
		
		textTitulo = new JTextField();
		textTitulo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) 
			{
				int num = 8;
				if(textTitulo.getText().length() >= num) 
				{
					e.consume();
					JOptionPane.showMessageDialog(null, "Error titulo de eleitor invalido");
				}
			}
		});
		textTitulo.setBounds(176, 44, 219, 20);
		contentPane.add(textTitulo);
		textTitulo.setColumns(10);
		
		textMunicipio = new JTextField();
		textMunicipio.setBounds(176, 75, 219, 20);
		contentPane.add(textMunicipio);
		textMunicipio.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Digite a zona eleitoral");
		lblNewLabel_3.setBounds(10, 137, 156, 14);
		contentPane.add(lblNewLabel_3);
		
		textZonaEleitoral = new JTextField();
		textZonaEleitoral.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) 
			{
				int num = 3;
				if(textZonaEleitoral.getText().length() >= num) 
				{
					e.consume();
					JOptionPane.showMessageDialog(null, "Digite apenas 3 caracteres nesse campo");
				}
			}
		});
		textZonaEleitoral.setBounds(176, 134, 89, 20);
		contentPane.add(textZonaEleitoral);
		textZonaEleitoral.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Digite sua se\u00E7\u00E3o eleitoral");
		lblNewLabel_4.setBounds(10, 171, 156, 14);
		contentPane.add(lblNewLabel_4);
		
		textSecaoEleitoral = new JTextField();
		textSecaoEleitoral.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e)
			{
				int num = 4;
				if(textSecaoEleitoral.getText().length() >= num) 
				{
					e.consume();
					JOptionPane.showMessageDialog(null, "Digite apenas 4 caracteres nesse campo");
				}
			}
		});
		textSecaoEleitoral.setBounds(176, 168, 89, 20);
		contentPane.add(textSecaoEleitoral);
		textSecaoEleitoral.setColumns(10);
		
		
		comboBox = new JComboBox<String>();
		comboBox.setBounds(176, 106, 54, 22);
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
		
		JButton ButtonCadastra = new JButton("Cadastra Eleitor");
		ButtonCadastra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				boolean TudoCerto = true;
				textNome.getText().trim();
				Estado = textMunicipio.getText().trim() + " " + comboBox.getSelectedItem().toString();
				System.out.println(Estado);
				//Verificação se Municipio é valido
				boolean valid = false;
				for (int i = 0; i < Municipios.length -1; i++) 
				{
					if(Estado.trim().equalsIgnoreCase(Municipios[i])) 
					{
						valid = true;
					}
				}
				//Verificação do titulo de eleitor já cadastrado 
				boolean validTitulo = true;
				for (int i = 0; i < TituloEleitor.length -1; i++) 
				{
					if(textTitulo.getText().equalsIgnoreCase(TituloEleitor[i])) 
					{
						validTitulo = false;
					}
				}
				if(valid == false) 
				{
					JOptionPane.showMessageDialog(null, "Municipio: " + textMunicipio.getText() + " não existe no estado " + comboBox.getSelectedItem().toString());
					TudoCerto = false;
				}
				if(validTitulo == false) 
				{
					JOptionPane.showMessageDialog(null, "O titulo de eleitor: " + textTitulo.getText() + " já cadastrado");
					TudoCerto = false;
				}
				if(textZonaEleitoral.getText().length() == 0 || textZonaEleitoral.getText().contains("0")) 
				{
					JOptionPane.showMessageDialog(null, "Erro, A zona eleitoral possuir 1, 2 ou 3 digitos" );
					TudoCerto = false;
				}
				if(textSecaoEleitoral.getText().length() == 0 || textSecaoEleitoral.getText().contains( "0") ) 
				{
					JOptionPane.showMessageDialog(null, "Erro, A seção eleitoral possuir 1,2,3 ou 4 digitos" );
					TudoCerto = false;
				}
				if(textTitulo.getText().length() != 8 ) 
				{
					JOptionPane.showMessageDialog(null, "Erro, todo titulo de eleitor possuir 8 algarismos, você digitou: " + textTitulo.getText().length() );
					TudoCerto = false;
				}
				else 
				{
					try {
						arquivo.escrever(textTitulo.getText(), "TitulosDeEleitor");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				boolean TituloAS = true;
				if(i>0) 
				{
					for (int i = 0; i < TesteTitular.length; i++)
					{
						if(TesteTitular[i].equalsIgnoreCase(textTitulo.getText())) 
						{
							TituloAS = false;
						}
					}
				}
				if(!TituloAS) 
				{
					JOptionPane.showMessageDialog(null, "O titulo de eleitor: " + textTitulo.getText() + " já cadastrado");
					TudoCerto = false;
				}
				if(TudoCerto == true) 
				{			
					TesteTitular[i] = textTitulo.getText();
					i++;
					JOptionPane.showMessageDialog(null, "Tudo Certo, \n Eleitor: " + textNome.getText() + " cadastrado com sucesso!!" );

					try {
						arquivo.escrever(textNome.getText() + ";" + textTitulo.getText() + ";" + textMunicipio.getText() + " "+ comboBox.getSelectedItem().toString() + ";" + textZonaEleitoral.getText() + ";" + textSecaoEleitoral.getText(), "D");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
				}
			
			}
		});
		
		ButtonCadastra.setBounds(126, 213, 165, 23);
		contentPane.add(ButtonCadastra);
		
		textNome.setDocument(new LimitarNumeros());
		textMunicipio.setDocument(new LimitarNumeros());
		textTitulo.setDocument(new ApenasNumeros());
		textZonaEleitoral.setDocument(new ApenasNumeros());
		textSecaoEleitoral.setDocument(new ApenasNumeros());
		
		btnNewButton = new JButton("Menu");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				Menu.Index menu = new Menu.Index();
				menu.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(335, 227, 89, 23);
		contentPane.add(btnNewButton);
		
		lblNewLabel_5 = new JLabel("Digite o estado do eleitor");
		lblNewLabel_5.setBounds(10, 112, 156, 14);
		contentPane.add(lblNewLabel_5);
		

		
		

		let.abrirArquivo("NomesDosMunicipios.csv");
		for (int i = 0; i < Municipios.length -1; i++)
		{
			Municipios[i] = let.ler();
		}
		let.fecharArquivo();
		
		let.abrirArquivo("TitulosDeEleitor.txt");
		for (int i = 0; i < Municipios.length -1; i++)
		{
			TituloEleitor[i] = let.ler();
		}
		let.fecharArquivo();
		
		for (int i = 0; i < TesteTitular.length; i++) 
		{
			TesteTitular[i] = "0";
		}
		
	}
	

}
