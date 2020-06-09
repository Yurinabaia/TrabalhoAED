package View2;
import java.io.IOException;

public class ListaUrnaEletronica 
{

	private CelularUrnaEletronica primeiro; // refer�ncia � primeira c�lula da lista encadeada de contas-correntes.
    									  // a primeira c�lula da lista encadeada de contas-correntes corresponder� ao nodo-cabe�a, utilizado apenas para controle.
	private CelularUrnaEletronica ultimo;   // refer�ncia � �ltima c�lula da lista encadeada de contas-correntes.

	private Arquivo arquivo = new Arquivo();
	// construtor que inicializa o nodo-cabe�a da lista encadeada.
	public ListaUrnaEletronica()
	{
		// cria��o do nodo-cabe�a da lista de contas-correntes. O nodo-cabe�a � utilizado apenas para controle.
		// o nodo-cabe�a � o primeiro nodo da lista encadeada.
		primeiro = new CelularUrnaEletronica();

		// quando a lista encadeada � criada, o nodo-cabe�a � tamb�m o �ltimo nodo da lista encadeada.
		ultimo = primeiro;
	}

	// insere o item passado como par�metro para esse m�todo no final da lista encadeada.
	public void inserirFinal(UrnaEletronica cc)
	{
		CelularUrnaEletronica aux = new CelularUrnaEletronica();
		
		// inser��o de uma nova c�lula ao final da lista encadeada.
		ultimo.proximo = aux;
		
		// inser��o da conta-corrente, passada como par�metro para esse m�todo, no final da lista encadeada.
		aux.item = cc;
				
		// atualiza��o do ponteiro de controle "ultimo" para a �ltima c�lula da lista encadeada.
		ultimo = ultimo.proximo;
	}
	
	public void concatenar(ListaUrnaEletronica lista) 
	{
		//Ultimo pegar da lista anterior
		//Lista da new lista
	    ultimo.proximo = lista.primeiro.proximo;

	}
	
	public int obterNumContasCorrentes() 
	{
        CelularUrnaEletronica aux;
        // o ponteiro aux ser� utilizado para percorrermos a lista encadeada.
        aux = primeiro.proximo;
        int cont = 0;
		if(!listaVazia()) 
		{
			 while (aux != null)
	            {	                
	                // avan�amos na lista encadeada.
	                aux = aux.proximo;
	                cont++;
	            }
			 return cont;
		}
		return 0;
	}
	
	
	// retira da lista encadeada a conta-corrente cujo n�mero corresponde ao que foi passado como par�metro para esse m�todo. Se a conta-corrente tiver sido localizada na lista encadeada e retirada com sucesso, esse m�todo deve retornar a conta-corrente retirada. Caso contr�rio, esse m�todo deve retornar null.
    public UrnaEletronica retirar(String numContaCorrente)
    {
        CelularUrnaEletronica aux, anterior;

        // o ponteiro anterior apontar� sempre para a c�lula, da lista encadeada, anterior � c�lula que estiver sendo inspecionada. 
        anterior = primeiro;

        // o ponteiro aux ser� utilizado para percorrermos a lista encadeada a procura da c�lula que dever� ser retirada. 
        aux = primeiro.proximo;

        // enquanto o ponteiro aux n�o tiver percorrido toda a lista encadeada...
        while (aux != null)
        {
            // se o ponteiro aux estiver apontando para o item que dever� ser retirado...
            if (aux.item.getNumeroCandidato().equalsIgnoreCase(numContaCorrente))
            {
                // utiliza-se o ponteiro anterior para "pular" a c�lula que deve ser retirada da lista encadeada.
                anterior.proximo = aux.proximo;

                if (aux == ultimo)
                {
                    // se a c�lula retirada da lista encadeada era a �ltima, atualizamos o ponteiro de controle "ultimo" para apontar para a c�lula anterior � que foi retirada.
                    // a c�lula anterior � que foi retirada passa a ser a �ltima c�lula da lista encadeada.
                    ultimo = anterior;
                }
                return aux.item;
            }
            else
            {
                // se ainda n�o encontramos o item que dever� ser retirado, avan�amos na lista encadeada.
                // os ponteiros anterior e aux devem avan�ar na lista encadeada.
                anterior = aux;
                aux = aux.proximo;
            }
        }
        return null;
    }
    
    // localiza, na lista encadeada, a conta-corrente cujo n�mero corresponde ao que foi passado como par�metro para esse m�todo. Se a conta-corrente tiver sido localizada na lista encadeada, esse m�todo deve retornar a conta-corrente localizada. Caso contr�rio, esse m�todo deve retornar null.
    public UrnaEletronica localizar(String numContaCorrente)
    {
        CelularUrnaEletronica aux;

        // o ponteiro aux ser� utilizado para percorrermos a lista encadeada a procura do item desejado. 
        aux = primeiro.proximo;

        // enquanto o ponteiro aux n�o tiver percorrido toda a lista encadeada...
        while (aux != null)
        {
            // se o ponteiro aux estiver apontando para o item desejado...
            if (aux.item.getNumeroCandidato().equalsIgnoreCase(numContaCorrente))
            {
                // retorna o item desejado.
                return aux.item;
            }
            else
            {
                // se ainda n�o encontramos o item desejado, avan�amos na lista encadeada.
                aux = aux.proximo;
            }
        }
        return null;
    }

    // verifica se a lista encadeada est� vazia. Em caso afirmativo, retorna true e em caso negativo retorna false.
    public Boolean listaVazia()
    {
        // a lista est� vazia se ela s� apresenta o nodo-cabe�a.
        if (primeiro == ultimo)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    // imprimi, para todas as contas-correntes armazenadas na lista encadeada, o nome de seu titular, o n�mero de sua ag�ncia, seu n�mero e saldo. A ordem de impress�o deve ser do primeiro nodo da lista para o �ltimo.
    public void imprimir(String Muni) throws IOException
    {
        CelularUrnaEletronica aux;

        // o ponteiro aux ser� utilizado para percorrermos a lista encadeada.
        aux = primeiro.proximo;

        if (aux == null)
        {
            System.out.println("A lista de contas-correntes est� vazia.");
        }
        else
        {
            // enquanto o ponteiro aux n�o tiver percorrido toda a lista encadeada...
            while (aux != null)
            {
                // imprimi os dados da conta-corrente apontada pelo ponteiro aux.
                String palavra = aux.item.getNomeCandidato() + ";" + aux.item.getNumeroCandidato() + ";" +  aux.item.getMunicipio() +";"+aux.item.getPartido() + ";" + aux.item.getCargo();
                arquivo.escrever2(palavra, Muni);
                // avan�amos na lista encadeada.
                aux = aux.proximo;
            }
        }
    }    
}
