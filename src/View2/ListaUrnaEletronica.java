package View2;
import java.io.IOException;

public class ListaUrnaEletronica 
{

	private CelularUrnaEletronica primeiro; // referência à primeira célula da lista encadeada de contas-correntes.
    									  // a primeira célula da lista encadeada de contas-correntes corresponderá ao nodo-cabeça, utilizado apenas para controle.
	private CelularUrnaEletronica ultimo;   // referência à última célula da lista encadeada de contas-correntes.

	private Arquivo arquivo = new Arquivo();
	// construtor que inicializa o nodo-cabeça da lista encadeada.
	public ListaUrnaEletronica()
	{
		// criação do nodo-cabeça da lista de contas-correntes. O nodo-cabeça é utilizado apenas para controle.
		// o nodo-cabeça é o primeiro nodo da lista encadeada.
		primeiro = new CelularUrnaEletronica();

		// quando a lista encadeada é criada, o nodo-cabeça é também o último nodo da lista encadeada.
		ultimo = primeiro;
	}

	// insere o item passado como parâmetro para esse método no final da lista encadeada.
	public void inserirFinal(UrnaEletronica cc)
	{
		CelularUrnaEletronica aux = new CelularUrnaEletronica();
		
		// inserção de uma nova célula ao final da lista encadeada.
		ultimo.proximo = aux;
		
		// inserção da conta-corrente, passada como parâmetro para esse método, no final da lista encadeada.
		aux.item = cc;
				
		// atualização do ponteiro de controle "ultimo" para a última célula da lista encadeada.
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
        // o ponteiro aux será utilizado para percorrermos a lista encadeada.
        aux = primeiro.proximo;
        int cont = 0;
		if(!listaVazia()) 
		{
			 while (aux != null)
	            {	                
	                // avançamos na lista encadeada.
	                aux = aux.proximo;
	                cont++;
	            }
			 return cont;
		}
		return 0;
	}
	
	
	// retira da lista encadeada a conta-corrente cujo número corresponde ao que foi passado como parâmetro para esse método. Se a conta-corrente tiver sido localizada na lista encadeada e retirada com sucesso, esse método deve retornar a conta-corrente retirada. Caso contrário, esse método deve retornar null.
    public UrnaEletronica retirar(String numContaCorrente)
    {
        CelularUrnaEletronica aux, anterior;

        // o ponteiro anterior apontará sempre para a célula, da lista encadeada, anterior à célula que estiver sendo inspecionada. 
        anterior = primeiro;

        // o ponteiro aux será utilizado para percorrermos a lista encadeada a procura da célula que deverá ser retirada. 
        aux = primeiro.proximo;

        // enquanto o ponteiro aux não tiver percorrido toda a lista encadeada...
        while (aux != null)
        {
            // se o ponteiro aux estiver apontando para o item que deverá ser retirado...
            if (aux.item.getNumeroCandidato().equalsIgnoreCase(numContaCorrente))
            {
                // utiliza-se o ponteiro anterior para "pular" a célula que deve ser retirada da lista encadeada.
                anterior.proximo = aux.proximo;

                if (aux == ultimo)
                {
                    // se a célula retirada da lista encadeada era a última, atualizamos o ponteiro de controle "ultimo" para apontar para a célula anterior à que foi retirada.
                    // a célula anterior à que foi retirada passa a ser a última célula da lista encadeada.
                    ultimo = anterior;
                }
                return aux.item;
            }
            else
            {
                // se ainda não encontramos o item que deverá ser retirado, avançamos na lista encadeada.
                // os ponteiros anterior e aux devem avançar na lista encadeada.
                anterior = aux;
                aux = aux.proximo;
            }
        }
        return null;
    }
    
    // localiza, na lista encadeada, a conta-corrente cujo número corresponde ao que foi passado como parâmetro para esse método. Se a conta-corrente tiver sido localizada na lista encadeada, esse método deve retornar a conta-corrente localizada. Caso contrário, esse método deve retornar null.
    public UrnaEletronica localizar(String numContaCorrente)
    {
        CelularUrnaEletronica aux;

        // o ponteiro aux será utilizado para percorrermos a lista encadeada a procura do item desejado. 
        aux = primeiro.proximo;

        // enquanto o ponteiro aux não tiver percorrido toda a lista encadeada...
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
                // se ainda não encontramos o item desejado, avançamos na lista encadeada.
                aux = aux.proximo;
            }
        }
        return null;
    }

    // verifica se a lista encadeada está vazia. Em caso afirmativo, retorna true e em caso negativo retorna false.
    public Boolean listaVazia()
    {
        // a lista está vazia se ela só apresenta o nodo-cabeça.
        if (primeiro == ultimo)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    // imprimi, para todas as contas-correntes armazenadas na lista encadeada, o nome de seu titular, o número de sua agência, seu número e saldo. A ordem de impressão deve ser do primeiro nodo da lista para o último.
    public void imprimir(String Muni) throws IOException
    {
        CelularUrnaEletronica aux;

        // o ponteiro aux será utilizado para percorrermos a lista encadeada.
        aux = primeiro.proximo;

        if (aux == null)
        {
            System.out.println("A lista de contas-correntes está vazia.");
        }
        else
        {
            // enquanto o ponteiro aux não tiver percorrido toda a lista encadeada...
            while (aux != null)
            {
                // imprimi os dados da conta-corrente apontada pelo ponteiro aux.
                String palavra = aux.item.getNomeCandidato() + ";" + aux.item.getNumeroCandidato() + ";" +  aux.item.getMunicipio() +";"+aux.item.getPartido() + ";" + aux.item.getCargo();
                arquivo.escrever2(palavra, Muni);
                // avançamos na lista encadeada.
                aux = aux.proximo;
            }
        }
    }    
}
