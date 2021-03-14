package sources;

/*	size()
 * 	isEmpty()
 *  add(int index, <Tipo de dado> elemento) 
 *  get(int index, <Tipo de dado> elemento)
 *  remove(int index)
 *  set(int index, <Tipo de dado> elemento)
 */

public class ArranjoList<T> implements IndexList<T>{
	private static final int TAM_VETOR_INICIAL = 10;
	// Vetor contendo os objetos
	private T[] vetor = (T[]) new Comparable[ TAM_VETOR_INICIAL ];

	// tamanho do vetor
	private int size;
	
	public int size(){
		return this.size;
	}
	public boolean isEmpty(){
		return this.size() < 1;
	}
	/*  Metodo que adiciona no vetor 
	 * observe que ele seje a regra do vetor expansivel
	 */
	public void add(int index, T elemento){
		
		if(index > vetor.length - 1 ){
			// Codigo que cria um 2° vetor
			// contendo os dados do primeiro
			this.vetor = expandirVetor( vetor.length * 2, vetor);			
		}

		if( size > 0 && this.vetor[index] != null   ){
			/* Pega todos os itens anteriores
			 * a esse index e move para tras
			 *    n + 1 cada elemento
		    */
			if( size + 1 > vetor.length - 1 ){
				this.vetor = expandirVetor( vetor.length * 2, vetor);			
			}
			
			T auxElementoTrocaAnterior  = this.vetor[index];
			
			for(int i = (index + 1); i < this.vetor.length ; i++){
				
				T auxElementoTroca = this.vetor[i];
				this.vetor[ i ] = auxElementoTrocaAnterior;
				auxElementoTrocaAnterior = auxElementoTroca; 
				
				
			}
			
			this.vetor[index] = elemento;
			this.size++;
		} else {
			this.vetor[index] = elemento;
			this.size++;
		}
		
		
	}
	/*  Metodo que retorna o elemento do vetor correspondente
	 *  a posição passada como parametro
	 */
	public T get(int index)throws IndexOutOfBoundsException{
		T elemento = null; 
		
		/* 	Se o index do elemento pesquisado estiver fora
		   do tamanho do vetor atual
		*/ 
		if( index + 1 > size ){
			throw new IndexOutOfBoundsException("error");
		}
		
		for(int i = 0; i < this.vetor.length ; i++){
			if( index == i  ){
				elemento = this.vetor[i];
			}
		}
		
		return elemento;
	}
	/*  Metodo que remove elementos do vetor
	 */
	public T remove(int index)throws IndexOutOfBoundsException{
		
		T elementoRemovido = null;
		
		if( index + 1 > size ){
			new IndexOutOfBoundsException("error");
		}
		
		elementoRemovido = this.vetor[index];
		
		// verificar se tem algo depois do elemento deletado
		// e move(s) para trás
		if(index + 1  < size){
			
			T auxElementoTrocaAnterior = this.vetor[index +1];
			for(int i = index + 1; i < size; i++){
				
				T auxElementoTroca = this.vetor[ i + 1 ];
				
				this.vetor[ i - 1 ] = auxElementoTrocaAnterior;
				
				auxElementoTrocaAnterior = auxElementoTroca;
			}
			//Removendo ultimo elemento que foi movido para n - 1
			// mas foi deixado no vetor pelo loop
			this.vetor[ size -1  ] = null;
			// removendo tamanho no veotor do elemento deletado 
			size--;
		} else {// Caso seja para remover ao final do vetor
			// Removendo do vetor
			this.vetor[index] = null;
			size--;
		}
		
		
		return elementoRemovido;
	}
	/* Troca um elemento pelo elemento passado e retorna
	 * o elemento que foi trocado dentro da lista 
	 */
	public T set(int index, T elemento)throws IndexOutOfBoundsException{
		T elementoRetorno = null; 
		
		/* 	Se o index do elemento pesquisado estiver fora
		   do tamanho do vetor atual
		*/ 
		if( index + 1 > size ){
			new IndexOutOfBoundsException("error");
		}
		
		
		elementoRetorno = this.vetor[index];
		this.vetor[index] = elemento;
		
		return elementoRetorno;
	}
	
	public T[] getVetor() {
		return vetor;
	}
	public void setVetor(T[] vetor) {
		this.vetor = vetor;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	/*  Metodo que expande o vetor para
	 * n * 2, caso o limite do vetor seja atingido
	 * na operação de adicionar elemento add()
	 */
	public T[] expandirVetor(int tamanho, T[] vetor){
		T[] vetorExpandido =  (T[]) new Comparable[ tamanho ];
		
		for(int i = 0; i < vetor.length; i++){
			vetorExpandido[i] = vetor[i];
		}
		
		
		return vetorExpandido;
	}
	
	@Override
	public String toString() {
		String toReturn = "(";
		if (size() == 0) return "()";
		for (int i = 0;( i < vetor.length); i++){
			
			if(this.vetor[i] != null)toReturn += this.vetor[i].toString() + ", ";
			
		}
		return toReturn.substring(0, toReturn.length() - 2) + ")";
	}

	
}
