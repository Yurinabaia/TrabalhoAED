package View3;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

@SuppressWarnings("serial")
public class UrnaEletronica extends JFrame {

	private JPanel contentPane;
	private JTextField textMunicipio;
	private JTextField textZonaEleitoral;
	private JTextField textSecaoEleitoral;
	private String[] Municipios = new String[5570];

	ArquivoDeEscritaC arquivo = new ArquivoDeEscritaC();
	Leitura let = new Leitura();
	private JButton btnNewButton;
	private JLabel lblNewLabel_3;
	private JComboBox<String> comboBox;
	private String Estado;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UrnaEletronica frame = new UrnaEletronica();
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
	public UrnaEletronica() {
		ImageIcon icone = new ImageIcon("./src/icon.png");
		setIconImage(icone.getImage());
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Digite o municipio da urna");
		lblNewLabel.setBounds(10, 11, 206, 14);
		contentPane.add(lblNewLabel);
		
		textMunicipio = new JTextField();
		textMunicipio.setBounds(197, 8, 193, 20);
		contentPane.add(textMunicipio);
		textMunicipio.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Digite a zona eleitoral ");
		lblNewLabel_1.setBounds(10, 73, 165, 14);
		contentPane.add(lblNewLabel_1);
		
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
		textZonaEleitoral.setBounds(197, 67, 86, 20);
		contentPane.add(textZonaEleitoral);
		textZonaEleitoral.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Digite a se\u00E7\u00E3o eleitoral");
		lblNewLabel_2.setBounds(10, 106, 165, 14);
		contentPane.add(lblNewLabel_2);
		
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
		textSecaoEleitoral.setBounds(197, 103, 86, 20);
		contentPane.add(textSecaoEleitoral);
		textSecaoEleitoral.setColumns(10);
		
		comboBox = new JComboBox<String>();
		comboBox.setBounds(197, 36, 60, 22);
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
		
		JButton CadastraUrna = new JButton("Cadastra Urna");
		CadastraUrna.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				boolean TudoCerto = true;
				Estado = textMunicipio.getText().trim() + " " + comboBox.getSelectedItem().toString();
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
					JOptionPane.showMessageDialog(null, "Municipio: " + textMunicipio.getText() + " não existe");
					TudoCerto = false;
				}
				if(textZonaEleitoral.getText().length() == 0 || textZonaEleitoral.getText().contains("0")) 
				{
					JOptionPane.showMessageDialog(null, "Erro, A zona eleitoral possuir 1, 2 ou 3 digitos" );
					TudoCerto = false;
				}
				if(textSecaoEleitoral.getText().length() == 0 || textSecaoEleitoral.getText().contains("0")) 
				{
					JOptionPane.showMessageDialog(null, "Erro, A seção eleitoral possuir 1,2,3 ou 4 digitos" );
					TudoCerto = false;
				}
				if(TudoCerto == true) 
				{			
					JOptionPane.showMessageDialog(null, "Tudo Certo, \n Urna do municipio: " + textMunicipio.getText() + " cadastrado com sucesso!!" );

					try {
						arquivo.escrever(textMunicipio.getText() + comboBox.getSelectedItem().toString() + ";" + textZonaEleitoral.getText() + ";" + textSecaoEleitoral.getText(), "E");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}				
				}
			}
		});
		CadastraUrna.setBounds(126, 196, 165, 23);
		contentPane.add(CadastraUrna);
		
		textMunicipio.setDocument(new LimitarNumeros());
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
		btnNewButton.setBounds(334, 222, 89, 23);
		contentPane.add(btnNewButton);
		
		lblNewLabel_3 = new JLabel("Digite o estado da urna");
		lblNewLabel_3.setBounds(10, 45, 165, 14);
		contentPane.add(lblNewLabel_3);
		

		
		
		let.abrirArquivo("NomesDosMunicipios.csv");
		for (int i = 0; i < Municipios.length -1; i++)
		{
			Municipios[i] = let.ler();
		}
		let.fecharArquivo();
	}

}
