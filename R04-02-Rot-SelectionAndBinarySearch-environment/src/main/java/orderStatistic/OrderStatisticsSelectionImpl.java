package orderStatistic;

public class OrderStatisticsSelectionImpl<T extends Comparable<T>> implements OrderStatistics<T> {

	/**
	 * Esta eh uma implementacao do calculo da estatistica de ordem seguindo a estrategia
	 * de usar o selection sem modificar o array original. Note que seu algoritmo vai
	 * apenas aplicar sucessivas vezes o selection ate encontrar a estatistica de ordem
	 * desejada sem modificar o array original.
	 * <p>
	 * Restricoes:
	 * - Preservar o array original, ou seja, nenhuma modificacao pode ser feita no
	 * array original
	 * - Nenhum array auxiliar deve ser criado e utilizado.
	 * - Voce nao pode encontrar a k-esima estatistica de ordem por contagem de
	 * elementos maiores/menores, mas sim aplicando sucessivas selecoes (selecionar um elemento
	 * como o selectionsort mas sem modificar nenhuma posicao do array).
	 * - Caso a estatistica de ordem nao exista no array, o algoritmo deve retornar null.
	 * - Considerar que k varia de 1 a N
	 * - Sugestao: o uso de recursao ajudara sua codificacao.
	 */

	@Override
	public T getOrderStatistics(T[] array, int k) {
		int valorMaximo = 0;
		int valorMinimo = array.length - 1;
		for (int i = 0; i < array.length; i++) {
			if (array[i].compareTo(array[valorMaximo]) > 0)
				valorMaximo = i;
			if (array[i].compareTo(array[valorMinimo]) < 0)
				valorMinimo = i;
		}

		return getOrderStatisticsRecursivo(array, k, 1, valorMinimo, valorMaximo);
	}

	private T getOrderStatisticsRecursivo(T[] array, int k, int quantidadeMinimo, int ultimoMinimo, int indiceMaximo) {

		if (quantidadeMinimo == k)
			return array[ultimoMinimo];

		if (quantidadeMinimo == array.length)
			return null;

		int minimo = indiceMaximo;
		for (int i = 0; i < array.length; i++) {
			if (array[i].compareTo(array[minimo]) < 0) {
				if (array[i].compareTo(array[ultimoMinimo]) > 0)
					minimo = i;
			}
		}
		return getOrderStatisticsRecursivo(array, k, quantidadeMinimo + 1, minimo, indiceMaximo);
	}
}