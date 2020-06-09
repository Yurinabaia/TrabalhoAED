package View4;
import java.io.*;

public class ArquivoDeEscrita {

	BufferedWriter saida;
		
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
	
	public void escrever(String textoEntrada)
	{
	
		try {
			saida.write(textoEntrada);
			saida.newLine();
		}
		catch (IOException excecao){
			System.out.println("Erro de entrada/saída " + excecao);
		}
	}
	public void escrever2(String textoEntrada) throws IOException
	{
		
		 try {
			 saida = new BufferedWriter(new FileWriter("C.txt", true));
			 saida.write(textoEntrada);
			 saida.newLine();
			 saida.flush();
	        } catch (IOException ioe) {
	            ioe.printStackTrace();
	        } finally { // always close the file
	            if (saida != null) {
	                try {
	                	saida.close();
	                } catch (IOException ioe2) {
	                    // just ignore it
	                }
	            }
	        }
	}
}
