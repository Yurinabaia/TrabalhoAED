package Resultado;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Leitura3 
{
	BufferedReader entrada;
	
	public void abrirArquivo(String nomeArquivo){	
		
		try {
			entrada = new BufferedReader(new FileReader(nomeArquivo));
		}
		catch (FileNotFoundException excecao) {
			System.out.println("Arquivo não encontrado");
		}
	}

	public void AbrirComDiretorio(String diretorio, String arquivo) {
		
		try {
			entrada = new BufferedReader(new FileReader(diretorio + "/" + arquivo + ".txt"));
		}
		catch (FileNotFoundException excecao) {
			System.out.println("Arquivo não encontrado");
		}
	}
	
	public void fecharArquivo() {
		
		try {
			entrada.close();
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

	public boolean AcharDiretorio(String arquivo) 
	{
		String path = arquivo;
		File caminho = new File(path);
		boolean caminhoValido = caminho.exists();
		boolean eDiretorio = caminho.isDirectory();
		if(caminhoValido && eDiretorio){
			return true;
		}
		else return false;
	}
	public boolean AcharArquivo(String diretorio, String Arquivo) 
	{
		String path = diretorio;
		File caminho = new File(path);
		boolean caminhoValido = caminho.exists();
		boolean eDiretorio = caminho.isDirectory();
		if(caminhoValido && eDiretorio){
			String[] conteudo = caminho.list();
			for (String arquivo1 : conteudo) 
			{
				if(arquivo1.contains(Arquivo + ".txt"))
				{
					return true;
				}
			}
		}
		return false;
	}
	public boolean ArquivoExiste (String arquivo) throws IOException 
	{
		File file = new File(arquivo);

		return file.exists();

	}
}
