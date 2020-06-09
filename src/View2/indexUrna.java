package View2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;

@SuppressWarnings("serial")
public class indexUrna extends JFrame {

	private JPanel textMunici;
	private JTextField textNumeroC;
	private JTextField NumCandidato;
	private JTextField NomeCandidato;
	private JTextField PartidoCandidato;
	private JTextField ViceCandidato;
	private String Municipio = " ";
	private JTextField textMuni;
	private Leitura2 let = new Leitura2();
	private UrnaEletronica candidato;
	private ListaUrnaEletronica urna = new ListaUrnaEletronica();
	private boolean Pesquisa = false;
	private Arquivo dados = new Arquivo();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					indexUrna frame = new indexUrna();
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
	public indexUrna() 
	{
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		textMunici = new JPanel();
		textMunici.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(textMunici);
		textMunici.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Digite o n\u00FAmero do candidato");
		lblNewLabel.setBounds(10, 11, 204, 14);
		textMunici.add(lblNewLabel);
		
		textNumeroC = new JTextField();
		textNumeroC.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) 
			{
				int num = 5;
				if(textNumeroC.getText().length() >= num) 
				{
					e.consume();
					JOptionPane.showMessageDialog(null, "Digite apenas 5 caracteres nesse campo");
				}
			}
			@SuppressWarnings("static-access")
			@Override
			public void keyPressed(KeyEvent e) 
			{
				if (e.getKeyCode() == e.VK_BACK_SPACE || e.getKeyCode() == e.VK_DELETE) { e.consume(); }
			}
		});
		textNumeroC.setBounds(209, 8, 86, 20);
		textMunici.add(textNumeroC);
		textNumeroC.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nome do candidato");
		lblNewLabel_1.setBounds(10, 99, 162, 14);
		textMunici.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Partido do candidato");
		lblNewLabel_2.setBounds(10, 137, 162, 14);
		textMunici.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Vice do candidato");
		lblNewLabel_3.setBounds(10, 173, 162, 14);
		textMunici.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("N\u00FAmero do candidato");
		lblNewLabel_4.setBounds(10, 66, 162, 14);
		textMunici.add(lblNewLabel_4);
		
		NumCandidato = new JTextField();
		NumCandidato.setBackground(SystemColor.textHighlightText);
		NumCandidato.setEnabled(false);
		NumCandidato.setForeground(Color.BLACK);
		NumCandidato.setFont(new Font("Wide Latin", Font.BOLD, 14));
		NumCandidato.setBounds(172, 63, 86, 20);
		textMunici.add(NumCandidato);
		NumCandidato.setColumns(10);
		
		NomeCandidato = new JTextField();
		NomeCandidato.setForeground(SystemColor.desktop);
		NomeCandidato.setFont(new Font("Gill Sans MT", Font.BOLD, 16));
		NomeCandidato.setBackground(SystemColor.textHighlightText);
		NomeCandidato.setEnabled(false);
		NomeCandidato.setBounds(172, 96, 244, 20);
		textMunici.add(NomeCandidato);
		NomeCandidato.setColumns(10);
		
		PartidoCandidato = new JTextField();
		PartidoCandidato.setForeground(SystemColor.desktop);
		PartidoCandidato.setFont(new Font("Wide Latin", Font.BOLD, 14));
		PartidoCandidato.setBackground(SystemColor.textHighlightText);
		PartidoCandidato.setEnabled(false);
		PartidoCandidato.setBounds(172, 134, 86, 20);
		textMunici.add(PartidoCandidato);
		PartidoCandidato.setColumns(10);
		
		ViceCandidato = new JTextField();
		ViceCandidato.setForeground(SystemColor.desktop);
		ViceCandidato.setFont(new Font("Wide Latin", Font.BOLD, 14));
		ViceCandidato.setBackground(SystemColor.textHighlightText);
		ViceCandidato.setEnabled(false);
		ViceCandidato.setBounds(172, 170, 244, 20);
		textMunici.add(ViceCandidato);
		ViceCandidato.setColumns(10);
		
		JButton btnBranco = new JButton("Branco");
		btnBranco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				try {
					dados.escrever2("Branco", "" + textMuni.getText());
					Menu.Index menu = new Menu.Index();
					menu.setVisible(true);
					dispose();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnBranco.setBounds(10, 217, 89, 23);
		textMunici.add(btnBranco);
		
		JButton btnCorrigir = new JButton("Corrigir");
		btnCorrigir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				textNumeroC.setText("");
			}
		});
		btnCorrigir.setBounds(172, 217, 89, 23);
		textMunici.add(btnCorrigir);
		
		JButton btnConfirma = new JButton("Confirma");
		btnConfirma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				Municipio = textMuni.getText();
				//System.out.println(Municipio);
				boolean TudoCerto = true;
				if(textNumeroC.getText().length() == 0) 
				{
					JOptionPane.showMessageDialog(null, "O campo Número deve ser preenchido");
					TudoCerto = false;
				}
				if(textNumeroC.getText().length() != 2 && textNumeroC.getText().length() != 5) 
				{
					int n = textNumeroC.getText().length();
					JOptionPane.showMessageDialog(null, "Error, Vereador possuir 5 algarismo você digitou apenas: " + n + " algarismos");
					JOptionPane.showMessageDialog(null, "Error, Prefeito possuir apenas 2 algarismo você digitou: " + n + " algarismos");
					TudoCerto = false;
				}
				if(!Pesquisa) 
				{
					JOptionPane.showMessageDialog(null, "Error, é preciso pesquisa o número antes");
					TudoCerto = false;
				}
				if(TudoCerto) 
				{
					String diretorio = "Candidatos" + Municipio.replaceAll(" ", "");
					if(let.AcharDiretorio(diretorio)) 
					{
						String arquivo = "NomesCandidatos" + Municipio.replaceAll(" ", "");
						System.out.println(arquivo);
						if(let.AcharArquivo(diretorio,arquivo))
						{
							let.AbrirComDiretorio(diretorio, arquivo);
							boolean sair = true;
								while(sair)
								{
									String linha = let.ler();
									if(linha == null || linha.isEmpty()) sair = false;
									else 
									{
										String Splitando[] = linha.split(";");
										//System.out.println(Splitando[1]);
										if(!Splitando[1].equalsIgnoreCase(textNumeroC.getText()))
										{
											JOptionPane.showMessageDialog(null, "Não existe candidato com esse número "+ NumCandidato  +" no municipo " + Municipio);
											//System.out.println("Não existe candidato com esse número no municipo " + municipio);
										}
										else 
										{
											JOptionPane.showMessageDialog(null, " Entrou no salva ");

											candidato = new UrnaEletronica(Splitando[0], Splitando[1],Splitando[2], Splitando[3],Splitando[4]);
											urna.inserirFinal(candidato);
											try {
												urna.imprimir(Municipio);
												Menu.Index menu = new Menu.Index();
												menu.setVisible(true);
												dispose();
											} catch (IOException e1) {
												// TODO Auto-generated catch block
												e1.printStackTrace();
											}
										}
									}
								}
							let.fecharArquivo();
						}
						else 
						{
							
							//System.out.println("Não existe zona: " + zona.toString() + " e secao: " + secao.toString() + " do municipio " + municipio );
						}
					} 
				}
			}
		});
		btnConfirma.setBounds(327, 217, 89, 23);
		textMunici.add(btnConfirma);
		
		
		
		textMuni = new JTextField();
		textMuni.setEditable(false);
		textMuni.setEnabled(false);
		textMuni.setBounds(10, 36, 204, 20);
		textMunici.add(textMuni);
		textMuni.setColumns(10);
		
		JButton btnNewButton = new JButton("Procurar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				Municipio = textMuni.getText();
				//System.out.println(Municipio);
				boolean TudoCerto = true;
				if(textNumeroC.getText().length() == 0) 
				{
					JOptionPane.showMessageDialog(null, "O campo Número deve ser preenchido");
					TudoCerto = false;
				}
				if(textNumeroC.getText().length() != 2 && textNumeroC.getText().length() != 5) 
				{
					int n = textNumeroC.getText().length();
					JOptionPane.showMessageDialog(null, "Error, Vereador possuir 5 algarismo você digitou apenas: " + n + " algarismos");
					JOptionPane.showMessageDialog(null, "Error, Prefeito possuir apenas 2 algarismo você digitou: " + n + " algarismos");
					TudoCerto = false;
				}
				if(TudoCerto) 
				{
					String diretorio = "Candidatos" + Municipio.replaceAll(" ", "");
					if(let.AcharDiretorio(diretorio)) 
					{
						String arquivo = "NomesCandidatos" + Municipio.replaceAll(" ", "");
						System.out.println(arquivo);
						if(let.AcharArquivo(diretorio,arquivo))
						{
							let.AbrirComDiretorio(diretorio, arquivo);
							boolean sair = true;
								while(sair)
								{
									String linha = let.ler();
									if(linha == null || linha.isEmpty()) sair = false;
									else 
									{
										String Splitando[] = linha.split(";");
										//System.out.println(Splitando[1]);
										if(!Splitando[1].equalsIgnoreCase(textNumeroC.getText()))
										{
											JOptionPane.showMessageDialog(null, "Não existe candidato com esse número "+ NumCandidato.getText()  +" no municipo " + Municipio);
											//System.out.println("Não existe candidato com esse número no municipo " + municipio);
										}
										else 
										{
											Pesquisa = true;
											JOptionPane.showMessageDialog(null, " Entrou no salva ");
											NomeCandidato.setText(Splitando[0]);
											NumCandidato.setText(Splitando[1]);
											PartidoCandidato.setText(Splitando[3]);
											if(Splitando[4].equalsIgnoreCase("P")) 
											{
												ViceCandidato.setText("Mc Daleste");
											}
										}
									}
								}
							let.fecharArquivo();
						}
						else 
						{
							//System.out.println("Não existe zona: " + zona.toString() + " e secao: " + secao.toString() + " do municipio " + municipio );
						}
					} 
				}
			}
		});
		btnNewButton.setBounds(327, 7, 89, 23);
		textMunici.add(btnNewButton);
		textNumeroC.setDocument(new ApenasNumeros2());
	}
	public void recebendoMunicipio (String receber) 
	{
		 textMuni.setText(receber);
		
	}
}
