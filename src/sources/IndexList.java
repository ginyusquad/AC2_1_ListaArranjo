package sources;

public interface IndexList<T> {
	// Retorna o n�mero de elementos na lista
	public int size();
	// Retorna se a lista est� vazia
	public boolean isEmpty();
	// Insere um elemento, e, no �ndice, i, deslocando todos os elmentos depois dele
	public void add(int i, T e) throws IndexOutOfBoundsException;
	// Retorna um elemento no �ndice i, sem remov�-lo
	public T get(int i) throws IndexOutOfBoundsException;
	// Remove e retorna o elemento do �ndice i, deslocando os elementos depois dele
	public T remove(int i) throws IndexOutOfBoundsException;
	// Troca o elemento de i com e, retornando o elemento que estava em i
	public T set(int i, T e) throws IndexOutOfBoundsException;
	}
