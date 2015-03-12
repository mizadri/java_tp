package tp.pr4.mv;

import java.util.ArrayList;



import tp.pr4.mv.exceptions.InstructionExecutionException;
import tp.pr4.mv.observers.MemoryObserver;
import tp.pr4.mv.observers.Observable;


/**
 * Clase encargada de representar la memoria de datos. Esta compuesta de un array que representa la memoria en si y otro,
 * las posiciones de memoria que contienen valores validos introducidos por nosotros(presenta la ventaja de no tener).
 * @author Adrian Garcia y Omar Gaytan
 * @param <T>
 *
 */
public class Memory<T> implements Observable<MemoryObserver<T>>{

	public static class MemCell<T> {
		int pos;
		T value;
		public MemCell(int pos, T value){
			this.pos = pos;
			this.value = value;
		}
		
		public int getPos(){
			return pos;
		}
		public T getValue(){
			return value;
		}
		
		private void setValue(T x){
			this.value = x;
		}
	}

private ArrayList< MemCell<T> > memory;
private ArrayList<MemoryObserver<T>> observers;

/**
 * Constructor sin parametros.
 */
public Memory(ArrayList<MemCell<T>> m){
	this.memory = m;
	observers = new ArrayList<MemoryObserver<T>>();
}

public void addObserver(MemoryObserver<T> o) {
	observers.add(o); 

}
public void removeObserver(MemoryObserver<T> o) {
	observers.remove(o); 

}

/**
 * Devuelve la memoria de datos en forma de string.
 */
public String toString(){
	String cad = "";

	if(memory.size() == 0) 
		cad = cad + " <vacia>";
	
	else{
		for(int i = 0; i < this.memory.size(); i++ ){	
			cad = cad + " [" + memory.get(i).pos + "]:" + memory.get(i).value;
		}
	}
	return cad;	
}

/**
 * Almacena un valor en una posicion dados. Devuelve true si la operacion se completa con exito.
 * @param pos
 * @param val
 * @return aux
 * @throws InstructionExecutionException 
 */
public boolean store(int pos, T val) throws InstructionExecutionException{
	if(pos<0) throw new InstructionExecutionException("Invalid memory acces: "+pos);
	int i = 0;
	int found = 0;
	boolean enc = false;
	while(i<memory.size()){
		if(pos == memory.get(i).pos){
			enc = true;
			found = i;
			memory.get(i).value = val;
		}
		i++;
	}

	if(!enc) memory.add(new MemCell<T>(pos, val));
	else memory.get(found).setValue(val);
	
	
	   int n = memory.size();
	
	   for (int k = 1; k < n; k++){
	       int v = memory.get(k).pos;
	       MemCell<T> vm = memory.get(k);
	       int j = k - 1;
	       
	       while (j >= 0 && memory.get(j).pos > v){
	              memory.set(j + 1, memory.get(j));
	              j--;
	          }
	       memory.set(j + 1, vm);
	   }
	   
	   for(MemoryObserver<T> o:observers){
			o.onWrite(pos, val);
		}
	return true;
}

/**
 * Devuelve el valor almacenado en memoria en una posicion dada, la correccion de la posicion a la que accedemos es controlada por los usuarios de esta funcion.
 * @param pos
 * @return val
 */
public T load(int pos){
	int i = 0;
	T val = null;
	
	while(i<memory.size()){
		if(pos == memory.get(i).pos){
			val = memory.get(i).value;
		}
		i++;
	}
	return val;
}

/**
 * Nos indica si la posicion a la que queremos acceder es valida(ha sido cargada por nosotros)
 * @param pos
 * @return aux
 */
public boolean canLoad(int pos){
	boolean aux = false;
	int i = 0;
	
	while(i<memory.size()){
		if(pos == memory.get(i).pos){
			aux = true;
		}
		i++;
	}
	return aux;
}


public int getNumElems(){
	return this.memory.size();
}

public ArrayList<Object> getArray() {
	ArrayList<Object> a = new ArrayList<Object>();
	for(int i = 0;i<memory.size(); i++){
		a.add(memory.get(i));
	}
	
	return  a;
}

}
