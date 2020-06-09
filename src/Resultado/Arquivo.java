package Resultado;
import java.io.*;



public class Arquivo {

	BufferedReader entrada;
	BufferedWriter saida;

	public static final String USER_DIR = System.getProperty("user.dir");
	public static final String SEPARATOR = System.getProperty("file.separator");

	public void abrirArquivo(String nomeArquivo){	
		
		try {
			entrada = new BufferedReader(new FileReader(nomeArquivo));
		}
		catch (FileNotFoundException excecao) {
			System.out.println("Arquivo não encontrado");
		}
	}

	
	
	public void fecharArquivo() 
	{
		
		try {
			entrada.close();
		}
		catch (IOException excecao) {
			System.out.println("Erro no fechamento do arquivo de leitura: " + excecao);	
		}
	}
	public void CriacaoArquivo(String NomeDiretorio, String NomeArquivo) throws IOException 
	{
		File file = new File(USER_DIR + SEPARATOR + NomeDiretorio);
		if (!file.exists())//Criei a pasta
			file.mkdirs();
		saida = new BufferedWriter(new FileWriter(USER_DIR + SEPARATOR + NomeDiretorio + SEPARATOR + NomeArquivo + ".txt"));
	}
	public void SalvaVetor(String valoresBuubleSort) throws IOException 
	{
		
			try {
				saida.write(valoresBuubleSort);
				saida.newLine();
			}
			catch (IOException excecao){
				System.out.println("Erro de entrada/saída " + excecao);
			}
		
	}
	public void fecharArquivoSaida() {
		
		try {
			saida.close();
		}
		catch (IOException excecao) {
			System.out.println("Erro no fechamento do arquivo de leitura: " + excecao);	
		}
	}
	
	public String ler() {
		
		String textoEntrada;
		
		try {
			textoEntrada = entrada.readLine();
		}
		catch (EOFException excecao) { //Exceção de final de arquivo.
			return null;
		}
		catch (IOException excecao) {
			System.out.println("Erro de leitura: " + excecao);
			return null;
		}
		return textoEntrada;
	}
	public void escrever2(String textoEntrada, String Municipio) throws IOException {
		
		 try {
			 saida = new BufferedWriter(new FileWriter("Ganhou" + Municipio + ".txt", true));
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
