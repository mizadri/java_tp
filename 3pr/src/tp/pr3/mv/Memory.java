package tp.pr3.mv;
/**
 * Clase encargada de representar la memoria de datos. Esta compuesta de un array que representa la memoria en si y otro,
 * las posiciones de memoria que contienen valores validos introducidos por nosotros(presenta la ventaja de no tener).
 * @author Adrian Garcia y Omar Gaytan
 *
 */
public class Memory<T> {
	
private T[] memory;
private boolean[] memUsed;
private static int maxSize = 100;
private int numberOfElements = 0;

/**
 * Constructor sin parametros.
 */
public Memory(T[] m){
	this.memory = m;
	this.memUsed = new boolean[maxSize];
}

public static int getMaxSize(){
	return maxSize;
}

public static void setMaxSize(int maxSizeB) {
	maxSize = maxSizeB;
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
 * Almacena un valor en una posicion dados. Devuelve true si la operacion se completa con exito.
 * @param pos
 * @param val
 * @return aux
 */
public boolean store(int pos, T val){
	boolean aux;

    if(pos > maxSize-1){
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
public T load(int pos){
	T val = memory[pos];
	return val;
}

/**
 * Nos indica si la posicion a la que queremos acceder es valida(ha sido cargada por nosotros)
 * @param pos
 * @return aux
 */
public boolean canLoad(int pos){
	boolean aux = false;

if(pos>=0 && pos < maxSize - 1 && memUsed[pos]){
	aux = true;
}
	
	return aux;
}


/**
 * Funcion que duplica el tam. de la memoria(es llamada por cpu cuando se intenta almacenar un valor en una posicion mayor al tam. de la memoria.
 */

public void reSize(T[] m, boolean[] b) { 
    
    for(int i=0;i<maxSize/2;i++){ 
        m[i] = memory[i]; 
        b[i] = memUsed[i];
    } 
     
    memory =  m;
    memUsed = b;
}

}
