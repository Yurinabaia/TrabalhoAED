package Resultado;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.*;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.Window.Type;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Color;

public class IndexRes extends JFrame {

	private JPanel contentPane;
	private String Estado;
	private JTextField textMunici;
	private JTextField textGanhador;
	private Leitura3 let = new Leitura3();
	private ArquivoTextoEscritaSDS grava2 = new ArquivoTextoEscritaSDS();

	String[] Candidatos = new String[6000];
	String[] CandidatosV = new String[6000];
	String[] ListaGanhadoreVereador = new String[6000];

	String[] Votos = new String[6000];
	String[] VotosV = new String[6000];

	String[] MunicipioA = new String[5580];
	String[] Municipios = new String[5570];
	String[] SecaoZona = new String[100];
	private int QuantideVotos;
	private int QuantideVotosV;

	private String Ganhador;
	private String Ganhador2;
	private double PorcetagemMaior;
	private List<Ganhador>  listaG = new ArrayList<Ganhador>();
	private List<Ganhador>  listaV = new ArrayList<Ganhador>();	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IndexRes frame = new IndexRes();
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
	public IndexRes() {
		setType(Type.UTILITY);
		
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 475, 423);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Digite o municipio");
		lblNewLabel.setBounds(10, 11, 133, 14);
		contentPane.add(lblNewLabel);
		
		textMunici = new JTextField();
		textMunici.setBounds(176, 8, 183, 20);
		contentPane.add(textMunici);
		textMunici.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Prefeito:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		lblNewLabel_1.setBounds(10, 76, 101, 43);
		contentPane.add(lblNewLabel_1);
		
		textGanhador = new JTextField();
		textGanhador.setForeground(Color.BLACK);
		textGanhador.setBackground(Color.WHITE);
		textGanhador.setFont(new Font("MS Reference Sans Serif", Font.BOLD | Font.ITALIC, 12));
		textGanhador.setEditable(false);
		textGanhador.setEnabled(false);
		textGanhador.setBounds(80, 89, 354, 20);
		contentPane.add(textGanhador);
		textGanhador.setColumns(10);
		
		textMunici.setDocument(new LimitarNumeros());
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(176, 39, 53, 22);
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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(137, 138, 296, 52);
		contentPane.add(scrollPane);
		
		
		JList<String> listJlistSegundoTurno = new JList<String>();
		scrollPane.setViewportView(listJlistSegundoTurno);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(80, 224, 354, 107);
		contentPane.add(scrollPane_1);
		
		JList<String> listJlistVereador = new JList<String>();
		scrollPane_1.setViewportView(listJlistVereador);
		
		JButton btnNewButton = new JButton("Ver Resultados");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				int contador = 0, contadorV = 0, contadorTeste = 0, contadorTesteV = 0;
				String[] VetorAuxliar = new String[100];
				let.abrirArquivo("D.txt");
				boolean SAINDO = true;
				while (SAINDO) 
				{
					String APTA = let.ler();
					if(APTA == null || APTA.isEmpty()) 
					{
						SAINDO = false;
					}
					else 
					{
						String[] Splitandos = APTA.split(";");
						VetorAuxliar[contador] = Splitandos[3] + Splitandos[4];
						System.out.println(VetorAuxliar[contador]);
						contador++;
						contadorV++;
						
					}

				}
				let.fecharArquivo();
				contador = 0;
				contadorV =0;
				VetorAuxliar = new HashSet<String>(Arrays.asList(VetorAuxliar))
			                .toArray(new String[0]);
			        
			        for (String str : VetorAuxliar) 
			        {
			            SecaoZona[contador] = str;
						System.out.println(SecaoZona[contador]);
			            contador++;
			            contadorV++;
			            contadorTeste++;
			            contadorTesteV++;
			        }
			        
			        
				
				
				textMunici.getText().trim();
				boolean TudoCerto = true;
				Estado = textMunici.getText().trim() + " " + comboBox.getSelectedItem().toString();
				//Verificação se Municipio é valido
				boolean valid = false;
				for (int i = 0; i < Municipios.length -1; i++) 
				{
					if(Estado.trim().equalsIgnoreCase(Municipios[i])) 
					{
						valid = true;
					}
				}
				if(valid == false) 
				{
					JOptionPane.showMessageDialog(null, "Municipio: " + textMunici.getText() + " não existe");
					TudoCerto = false;
				}
				boolean ArquivoExiste = false;
				
				while(contadorTeste != -1) 
				{
					
					try {
						ArquivoExiste = let.ArquivoExiste("Resultado" + textMunici.getText().trim().toUpperCase() + " " +comboBox.getSelectedItem().toString()  +  SecaoZona[contadorTeste] +".txt");
					} catch (IOException e1) 
					{
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					if(ArquivoExiste)
					{
						TudoCerto = true;
						contadorTeste = -1;
						break;
					}
					contadorTeste--;
				}			
				if(!ArquivoExiste) 
				{
					JOptionPane.showMessageDialog(null, "Arquivo de apuração dos prefeiros: Resultado" + textMunici.getText() + " " + comboBox.getSelectedItem().toString() +".txt" + " \nNÃO EXISTE");
					TudoCerto = false;
				}
				
				
				boolean ArquivoVereador = false;
				
				while(contadorTesteV != -1) 
				{
					String asdsd = "Resultado" + textMunici.getText().trim() + " " + comboBox.getSelectedItem().toString() + "V"+  SecaoZona[contadorTesteV]  + ".txt";
					System.out.println(asdsd);

					try {
						ArquivoVereador = let.ArquivoExiste("Resultado" + textMunici.getText().trim() + " " + comboBox.getSelectedItem().toString() + "V"+  SecaoZona[contadorTesteV]  + ".txt");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					if(ArquivoVereador)
					{
						TudoCerto = true;
						contadorTesteV = -1;
						break;
					}
					contadorTesteV--;
				}
				if(!ArquivoVereador) 
				{				
					JOptionPane.showMessageDialog(null, "Arquivo de apuração dos vereadores: Resultado" + textMunici.getText() + " " + comboBox.getSelectedItem().toString()  + "V" +".txt" + " \nNÃO EXISTE");
					TudoCerto = false;
				}
				
				
				
				
				if(TudoCerto) 
				{
				
					listaG.clear();
					listaV.clear();
					VotosV = new String[6000];
					Votos = new String[6000];
					ListaGanhadoreVereador = new String[6000];
					CandidatosV = new String[6000];
					Candidatos = new String[6000];
					
					
					
					
					DefaultListModel<String> DFL = new DefaultListModel<String>();
					DefaultListModel<String> DFLSEGUNDOTURNO = new DefaultListModel<String>();
					textMunici.getText().toUpperCase();
					String a = textMunici.getText().toUpperCase() + comboBox.getSelectedItem().toString();
					String diretorio = "Candidatos" + a.replaceAll(" ", "");
					
					if(let.AcharDiretorio(diretorio)) 
					{
						String arquivo = "NomesCandidatos" + a.replaceAll(" ", "");
						if(let.AcharArquivo(diretorio,arquivo))
						{
							let.AbrirComDiretorio(diretorio, arquivo);
							boolean sair = true;
							int cont = 0;
								while(sair)
								{
									String linha = let.ler();
									if(linha == null || linha.isEmpty()) sair = false;
									else 
									{
										Candidatos[cont] = linha;
										cont++;
									}
								}
							let.fecharArquivo();
							sair = true;
							cont = 0;
							contador = contador -1;
							while (contador != -1) 
							{
								String teste = "Resultado" + textMunici.getText().trim().toUpperCase() + " " +  comboBox.getSelectedItem().toString() +  SecaoZona[contador] + ".txt";
								System.out.println(teste);
								boolean ArquivoExiste2 = false;
								try {
									ArquivoExiste2 = let.ArquivoExiste("Resultado" + textMunici.getText().trim().toUpperCase() + " " +comboBox.getSelectedItem().toString()  +  SecaoZona[contador] +".txt");
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								
								if(ArquivoExiste2) 
								{
									let.abrirArquivo("Resultado" +  textMunici.getText().trim().toUpperCase() +  " " +comboBox.getSelectedItem().toString()  + SecaoZona[contador] +".txt");
									
									while(sair) 
									{
										String linha = let.ler();
										if(linha == null || linha.isEmpty()) 
										{
											sair = false;
										}
										else 
										{
											Votos[cont] = linha;
											//System.out.println(Votos[cont]);
											cont++;
										}
									}
									let.fecharArquivo();
								}
								sair = true;
								contador--;
								
							}
							
							int as = 0, i = 0;
							sair = true;
							int resultado = 1;
							grava2.abrirArquivo("Ganhou" + textMunici.getText().trim() + comboBox.getSelectedItem().toString() + ".txt");
							while(sair) 
							{	
								//Para parada 
								//para pecorre todo meu vetor votor
								//ana 
								if(Candidatos[as] == null || Candidatos[as].isEmpty()) 
								{
									sair = false;
								}
								if(Votos[i] == null || Votos[i].isEmpty()) 
								{
									as++;
									i = 0;
									resultado = 1;
								}
								if(Votos[i].equalsIgnoreCase(Candidatos[as]))//Ana 
								{
									System.out.println(Candidatos[as]);
									grava2.escrever(Candidatos[as] + ";" + resultado);
									resultado++;
								}
	
								i++;
							}
							grava2.fecharArquivo();
							//Pecorrer aquivo ganhou
							
							String valor = "Ganhou" + textMunici.getText().trim() + comboBox.getSelectedItem().toString() + ".txt";
							System.out.println(valor);
	
							let.abrirArquivo(valor);
							sair = true;
							while(sair) 
							{
								String palavra = let.ler();
								if(palavra == null || palavra.isEmpty()) 
								{
									sair = false;
									break;
								}
								QuantideVotos++;
							}
							let.fecharArquivo();
							System.out.println(QuantideVotos);
							
							//A parte de quem ganhou
							let.abrirArquivo(valor);
							sair = true;
							int maior = 0;
							while(sair) 
							{
								String palavra = let.ler();
	
								if(palavra == null || palavra.isEmpty()) 
								{
									sair = false;
									break;
								}
								String[] Splitando = palavra.split(";");
								
								int Splits = Integer.parseInt(Splitando[5]);
								listaG.add(new Ganhador(Splitando[0], Splitando[1], Splitando[2], Splitando[3], Splitando[4], Splits));
	
								if(Splits > maior ) 
								{
									Ganhador = Splitando[0] + " teve " + Splitando[5] + " votos";
									maior = Splits;
								}
	
							}
							let.fecharArquivo();
							//Para o objeto iincio
							Collections.sort((List<Ganhador>) listaG);
	
							grava2.abrirArquivo("ValoresFinaisDo"+ textMunici.getText() + comboBox.getSelectedItem().toString() + ".txt");
							int ad = 0;
							String[] palavraRepetida = new String[QuantideVotos];
							sair = true;
							boolean repetida = false;
							for (Object object : listaG)
							{
								String Palavra = object.toString();
								String[] Splitando = Palavra.split(";");
								String linha = Splitando[0] + ";" + Splitando[1]+ ";" + Splitando[2] + ";" + Splitando[3] + ";" + Splitando[4];
								
								for (int j = 0; j < palavraRepetida.length; j++) 
								{
									//System.out.println(palavraRepetida[j]);
									//System.out.println("Linha " +linha);
									if(linha.equalsIgnoreCase(palavraRepetida[j])) 
									{
										repetida = true;
										break;
									}
								}
								if(!repetida) 
								{
									grava2.escrever(object.toString());
									//System.out.println("Linha " +linha);
									palavraRepetida[ad] = linha;
									ad++;						
								}
								if(repetida)
								{
									repetida = false;
								}
	
							}
							grava2.fecharArquivo();
							
							String asd = textMunici.getText().trim().replaceAll(" ", "");
							int quantidadeH = 0;
							for (int j = 0; j < MunicipioA.length; j++)
							{
								String palavra = MunicipioA[j];
								if(palavra != null)
								{
									String[] Splitando = palavra.split(";");
									if(asd.equalsIgnoreCase(Splitando[0])) 
									{
										quantidadeH = Integer.parseInt(Splitando[2]);
									}
								}
							}
							//11
							
							PorcetagemMaior = ((maior *100)/QuantideVotos);
							System.out.println(PorcetagemMaior);
							System.out.println(maior);
	
							if(quantidadeH < 200000 || PorcetagemMaior >50 )
							{
								textGanhador.setText(Ganhador);
							}						
							else if(quantidadeH > 200000 && PorcetagemMaior < 50)
							{
								//textGanhador.setText(Ganhador);
	
								System.out.println("Entrou aqui");
								//A parte de quem ganhou
								let.abrirArquivo("ValoresFinaisDo"+ textMunici.getText().trim() + comboBox.getSelectedItem().toString() + ".txt");
								sair = true;
								int Posicoes = 0;
								while(sair) 
								{
									if(Posicoes == 0) 
									{
										Ganhador = let.ler();
									}
									else 
									{ 
										Ganhador2 = let.ler();
										break;
									}
									Posicoes++;
								}
								let.fecharArquivo();
								DFLSEGUNDOTURNO.add(0, Ganhador);
								DFLSEGUNDOTURNO.add(1, Ganhador2);
								listJlistSegundoTurno.setModel(DFLSEGUNDOTURNO);
							}
							
							
							//Vereador
							
							sair = true;
							cont = 0;
							contadorV = contadorV -1;
							
							while (contadorV != -1) 
							{
								String teste = "Resultado" + textMunici.getText().trim().toUpperCase() + " " +  comboBox.getSelectedItem().toString() +   "V"+  SecaoZona[contadorV]  +".txt";
								System.out.println(teste);
								boolean ArquivoExiste3 = false;
								try {
									ArquivoExiste3 = let.ArquivoExiste(teste);
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								
								if(ArquivoExiste3) 
								{
									let.abrirArquivo("Resultado" + textMunici.getText().trim() + " " + comboBox.getSelectedItem().toString() + "V"+  SecaoZona[contadorV]  + ".txt");
									while(sair) 
									{
										String linha = let.ler();
										if(linha == null || linha.isEmpty()) 
										{
											sair = false;
										}
										else 
										{
											VotosV[cont] = linha;
											//System.out.println(Votos[cont]);
											cont++;
										}
									}
									let.fecharArquivo();
								}
								contadorV--;
								sair = true;
								
							}
							

							
							 as = 0;
							 i = 0;
							 sair = true;
							 resultado = 1;
							grava2.abrirArquivo("Ganhou" + textMunici.getText().trim() + comboBox.getSelectedItem().toString() +  "V" + ".txt");
							while(sair) 
							{	
								//Para parada 
								//para pecorre todo meu vetor votor
								//ana 
								if(Candidatos[as] == null || Candidatos[as].isEmpty()) 
								{
									sair = false;
								}
								if(VotosV[i] == null || VotosV[i].isEmpty()) 
								{
									as++;
									i = 0;
									resultado = 1;
								}
								if(VotosV[i].equalsIgnoreCase(Candidatos[as]))//hULK
								{
									System.out.println(Candidatos[as]);
									grava2.escrever(Candidatos[as] + ";" + resultado);
									resultado++;
								}
	
								i++;
							}
							grava2.fecharArquivo();
							//Pecorrer aquivo ganhou
							
							valor = "Ganhou" + textMunici.getText().trim() + comboBox.getSelectedItem().toString() +  "V" + ".txt";
							System.out.println(valor);
	
							let.abrirArquivo(valor);
							sair = true;
							while(sair) 
							{
								String palavra = let.ler();
								if(palavra == null || palavra.isEmpty()) 
								{
									sair = false;
									break;
								}
								QuantideVotosV++;
							}
							let.fecharArquivo();
							System.out.println(QuantideVotosV);
							let.abrirArquivo(valor);
							sair = true;
							while(sair) 
							{
								String palavra = let.ler();
	
								if(palavra == null || palavra.isEmpty()) 
								{
									sair = false;
									break;
								}
								String[] Splitando = palavra.split(";");
								
								int Splits = Integer.parseInt(Splitando[5]);
								listaV.add(new Ganhador(Splitando[0], Splitando[1], Splitando[2], Splitando[3], Splitando[4], Splits));
	
							}
							let.fecharArquivo();
							
							
							String MuniciU = textMunici.getText().trim().replaceAll(" ", "");
							int quantidadeCandidatos = 0;
							for (int j = 0; j < MunicipioA.length; j++)
							{
								String palavra = MunicipioA[j];
								if(palavra != null)
								{
									String[] Splitando = palavra.split(";");
									System.out.println(Splitando[0]);

									if(Splitando[0].equalsIgnoreCase(MuniciU)) 
									{
										quantidadeCandidatos = Integer.parseInt(Splitando[3]);
									}
								}
							}
														
							
							//Para o objeto iincio
							Collections.sort((List<Ganhador>) listaV);
	
							grava2.abrirArquivo("ValoresFinaisDo"+ textMunici.getText().trim() + comboBox.getSelectedItem().toString() + "V" + ".txt");
							ad = 0;
							String[] palavraRepetidas = new String[QuantideVotosV];
							sair = true;
							boolean repetidas = false;
							int Contador = 0;
							System.out.print(quantidadeCandidatos);
							for (Object object : listaV)
							{
								if(Contador < quantidadeCandidatos) 
								{
								
									String Palavra = object.toString();
									String[] Splitando = Palavra.split(";");
									String linha = Splitando[0] + ";" + Splitando[1]+ ";" + Splitando[2] + ";" + Splitando[3] + ";" + Splitando[4];
									
									for (int j = 0; j < palavraRepetidas.length; j++) 
									{
										//System.out.println(palavraRepetida[j]);
										//System.out.println("Linha " +linha);
										if(linha.equalsIgnoreCase(palavraRepetidas[j])) 
										{
											repetidas = true;
											break;
										}
									}
									if(!repetidas) 
									{
										grava2.escrever(object.toString());
										//System.out.println("Linha " +linha);
										palavraRepetidas[ad] = linha;
										ad++;		
										DFL.add(Contador, object.toString());
										listJlistVereador.setModel(DFL);
										Contador++;
										
									}
									if(repetidas)
									{
										repetidas = false;
									}
								}
								else break;
							}
							grava2.fecharArquivo();
							
						}
						else 
						{
							JOptionPane.showMessageDialog(null, "Error, O municipio "+ textMunici.getText() + " no estado " + comboBox.getSelectedItem().toString() + " não teve apuração de votos");
						}
					}
				}
			}
		});
		btnNewButton.setBounds(161, 344, 133, 23);
		contentPane.add(btnNewButton);
		let.abrirArquivo("B.txt"); 
			for (int j = 0; j < MunicipioA.length; j++) 
			{
				MunicipioA[j] = let.ler();
				if(MunicipioA[j] != null)
				System.out.println(MunicipioA[j]);
			}
		let.fecharArquivo();
		
		let.abrirArquivo("NomesDosMunicipios.csv");
		for (int i = 0; i < Municipios.length -1; i++)
		{
			Municipios[i] = let.ler();
		}
		let.fecharArquivo();
		
		JLabel lblNewLabel_2 = new JLabel("Digite o estado");
		lblNewLabel_2.setBounds(10, 51, 116, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Vereadores:");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		lblNewLabel_3.setBounds(10, 193, 107, 20);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Segundo Turno:");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		lblNewLabel_4.setBounds(10, 130, 199, 28);
		contentPane.add(lblNewLabel_4);
		


		
		
	}
}
