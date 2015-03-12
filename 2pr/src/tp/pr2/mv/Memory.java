package tp.pr2.mv;
/**
 * Clase encargada de representar la memor√≠a de datos. Esta compuesta de un array que representa la memor√≠a en s√≠ y otro,
 * las posiciones de memoria que contienen valores validos introducidos por nosotros(presenta la ventaja de no tener).
 * @author Adrian Garcia y Omar Gaytan
 *
 */
public class Memory {
	
private Integer[] memory;
private boolean[] memUsed;
private int maxSize = 100;
private int numberOfElements = 0;

/**
 * Constructor sin parametros.
 */
public Memory(){
	this.memory = new Integer[this.maxSize];
	this.memUsed = new boolean[this.maxSize];
}

/**
 * Devuelve la memoria de datos en forma de string.
 */
public String toString(){
	String cad = "";

	if(this.numberOfElements == 0) 
		cad = cad + " <vacia>";
	
	else for(int i = 0; i < this.memory.length; i++ ){	
		if(this.memUsed[i])	//comprueba que la posicion haya sido escrita
			cad = cad + " [" + i + "]:" + this.memory[i];
	}
	return cad;	
}

/**
 * Almacena un valor en una posiciÛn dados. Devuelve true si la operacion se completa con exito.
 * @param pos
 * @param val
 * @return aux
 */
public boolean store(int pos, int val){
	boolean aux;

    if(pos > memory.length){
		aux = false;
	}else {
		this.memory[pos] = val;
		this.memUsed[pos] = true;
		this.numberOfElements++;
		aux = true;
	}
	return aux;
}

/**
 * Devuelve el valor almacenado en memoria en una posicion dada, la correccion de la posicion a la que accedemos es controlada por los usuarios de esta funcion.
 * @param pos
 * @return val
 */
public int load(int pos){
	int val = memory[pos];
	return val;
}

/**
 * Nos indica si la posicion a la que queremos acceder es valida(ha sido cargada por nosotros)
 * @param pos
 * @return aux
 */
public boolean canLoad(int pos){
	boolean aux = false;

if(pos>=0 && pos < memory.length && memUsed[pos]){
	aux = true;
}
	
	return aux;
}


/**
 * Funcion que duplica el tamaÒo de la memoria(es llamada por cpu cuando se intenta almacenar un valor en una posiciÛn mayor al tamaÒo de la memoria.
 */
public void reSize() {
	Integer[] aux = new Integer[maxSize];
	boolean[] auxB = new boolean[maxSize];
	
	for(int i=0;i<maxSize;i++){
		aux[i] = memory[i];
		auxB[i] = memUsed[i];
	}
	
	maxSize = maxSize * 2;
	memory = new Integer[maxSize];
	memUsed = new boolean[maxSize];
	
	for(int i=0; i < maxSize/2; i++){
		memory[i] = aux[i];
		memUsed[i] = auxB[i];
		}
	}
}
