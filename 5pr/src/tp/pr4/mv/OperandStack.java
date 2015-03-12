package tp.pr4.mv; 

import java.util.ArrayList;
import java.util.Stack;

import tp.pr4.mv.exceptions.EmptyStackAcces;
import tp.pr4.mv.observers.Observable;
import tp.pr4.mv.observers.StackObserver;
 
/**
 * Clase que representa la pila de operandos.
 * @author Adrian Garcia y Omar Gaytan
 *
 */
public class OperandStack<T> implements Observable<StackObserver<T>> { 
  
    private static int maxSize = 100; 
    private T[] stack; 
    private int top = -1; 
    private int numElements = 0; 
    
    private ArrayList<StackObserver<T>> observers;
    /**
     * Constructor sin parametros
     */
    public OperandStack(T[] stack){ 
        this.stack = stack; 
        observers = new ArrayList<StackObserver<T>>();
          
    } 
    
    public void addObserver(StackObserver<T> o) {
		observers.add(o); 

    }
    
    public void removeObserver(StackObserver<T> o) {
		observers.remove(o); 

    }
    
    public static int getMaxSize(){
    	return maxSize;
    }
    
    public static void setMaxSize(int maxSizeB) {
		maxSize = maxSizeB;
	} 
     
    /**
     * Devuelve el numero de elementos en la pila
     * @return numElements
     */
    public int getNumElem(){ 
          
        return this.numElements; 
    } 
      
      
    /**
     * Comprueba si la pila esta vacía
     * @return aux
     */
    public boolean isEmpty(){ 
    boolean aux = true; 
      
    if(top >= 0) aux = false; 
      
    return aux; 
    } 
      
    /**
     * Inserta un valor en la cima de la pila.
     * @param value
     * @return aux
     */
    public boolean push(T value){ 
    boolean aux = false; 
    if(top < maxSize -1){ 
        stack[++top] = value;  
        aux = true; 
        this.numElements++; 
    } 
    for(StackObserver<T> o:observers){
		o.onPush(value);
	}
    return aux;      
    } 
      
  
    /**
     * Disminuye la cima de la pila.
     * @throws EmptyStackAcces 
     */
	public T pop() throws EmptyStackAcces {
		T n = null;
		if(!this.isEmpty()){ // cambiado pero no definitivo(no funciona ejec 6)
		n = this.stack[top];
		top--;
		this.numElements--;
		}else throw new EmptyStackAcces("Error: Pop de pila vacia.");

		for(StackObserver<T> o:observers){
		o.onPop(n);
		}
		return n;
	}
     
    /**
     * Devuelve la cima de la pila.
     * @return i
     */
    public T top(){ 
    T i = null ; 
      
    if(!this.isEmpty()){ 
        i = stack[top] ;             
    } 
    return i; 
    } 
      
    /**
     * Devuelve el contenido de la pila en forma de string.
     */
    public String toString(){ 
        String s = ""; 
        if(!this.isEmpty()){ 
            for(int i =0;i<=top;i++){ 
                s = s + " " + stack[i]; 
            } 
        }else{ 
            s = s + " <vacia>"; 
        } 
        return s; 
    } 
  
    /**
     * Duplica el tamano de la pila(llamada por cpu cuando se supera el tamano).
     */
    public void reSize(T[] nstack) { 
       
        for(int i=0;i<maxSize/2;i++){ 
            nstack[i] = stack[i]; 
        } 
          
        stack =  nstack; 
          
    }

	public Stack<Integer> getOperandStack() {
		Stack<Integer> s = new Stack<Integer>();
		
		for(int i = 0; i < numElements; i++){
			s.push((Integer) stack[i]);
		}
			
		return  s;
	}

	
    
      
} 