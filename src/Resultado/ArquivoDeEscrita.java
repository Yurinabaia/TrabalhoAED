package Resultado;

import java.io.*;


public class ArquivoDeEscrita {

	BufferedWriter bw, saida;
	public static final String USER_DIR = System.getProperty("user.dir");
	public static final String SEPARATOR = System.getProperty("file.separator");
		
	public void abrirArquivo(String nomeArquivo){	
		
		try {
			saida = new BufferedWriter(new FileWriter(nomeArquivo));
		}
		catch (FileNotFoundException excecao) {
			System.out.println("Arquivo não encontrado");
		}
		catch (IOException excecao) {
			System.out.println("Erro na abertura do arquivo de escrita: " + excecao);
		}
	}
	
	public void fecharArquivo() {
		
		try {
			saida.close();
		}
		catch (IOException excecao) {
			System.out.println("Erro no fechamento do arquivo de escrita: " + excecao);	
		}
	}
	public void CriacaoArquivo(String NomeDiretorio, String NomeArquivo) throws IOException 
	{
		File file = new File(USER_DIR + SEPARATOR + NomeDiretorio);
		if (!file.exists())//Criei a pasta
			file.mkdirs();
		saida = new BufferedWriter(new FileWriter(USER_DIR + SEPARATOR + NomeDiretorio + SEPARATOR + NomeArquivo + ".txt"));
	}
	
	
	public void escrever(String textoEntrada) throws IOException {
	
		 try {
	            bw = new BufferedWriter(new FileWriter("Ganhou.txt", true));
	            bw.write(textoEntrada);
	            bw.newLine();
	            bw.flush();
	        } catch (IOException ioe) {
	            ioe.printStackTrace();
	        } finally { // always close the file
	            if (bw != null) {
	                try {
	                    bw.close();
	                } catch (IOException ioe2) {
	                    // just ignore it
	                }
	            }
	        }
	}
}

