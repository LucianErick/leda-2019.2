package problems;

/**
 * Calcula o floor e ceil de um numero em um array usando a estrategia de busca
 * binaria.
 * 
 * Restricoes: 
 * - Algoritmo in-place (nao pode usar memoria extra a nao ser variaveis locais) 
 * - O tempo de seu algoritmo deve ser O(log n).
 * 
 * @author Adalberto
 *
 */
public class FloorCeilBinarySearch implements FloorCeil {

	@Override
	public Integer floor(Integer[] array, Integer x) {
		return buscaBinariaFloor(array, x, 0, array.length - 1);
	}

	@Override
	public Integer ceil(Integer[] array, Integer x) {
		return buscaBinariaCeil(array, x, 0, array.length - 1);
	}

	// metodo que realiza a busca binaria, tomaando como referencia o floor, ou seja, teto inferior de um numero.
	private Integer buscaBinariaFloor(Integer[] array, int numero, int inicio, int fim) {

		// Se o numero passado como inicio for maior que o fim, retornar o menor valor entre os dois
		// ou seja, o fim.
		if (inicio > fim) {
			return array[fim];
		}

		int meio = (inicio + fim) / 2;
		int atual = array[meio]; // Variavel que acessa o valor do indice do meio, tornando o acesso menos custoso.

		if (atual > numero) {
			return buscaBinariaFloor(array, numero, inicio, meio - 1);

		} else if (atual < meio) {
			return buscaBinariaFloor(array, numero, meio + 1, fim);
		}
		else if (atual == numero){
			return numero; // Se, por acaso, estiver no meio o elemento buscado, retorna-se o proprio elemento.
		}
		return -1; // Se não achar nenhum, retorna -1.
	}

	// metodo que realiza a busca binaria, tomando como referencia o ceil, ou seja, teto superior de um determinado numero.
	private Integer buscaBinariaCeil(Integer[] array, int numero, int inicio, int fim) {

		// Se o inicio for maior que o fim, retorna-se o maior valor entre os dois.
		if (inicio > fim) {
			return array[inicio];
		}
		int meio = (inicio + fim) / 2;
		int atual = array[meio];

		if (atual > numero) {
			return buscaBinariaCeil(array, numero, inicio, meio - 1);
		} else if (atual < meio) {
			return buscaBinariaCeil(array, numero, meio + 1, fim);
		}
		else if (atual == numero){
			return numero;
		}
		return -1;
	}
}
