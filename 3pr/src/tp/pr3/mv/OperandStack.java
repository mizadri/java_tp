package tp.pr3.mv; 
 
/**
 * Clase que representa la pila de operandos.
 * @author Adrian Garcia y Omar Gaytan
 *
 */
public class OperandStack<T> { 
  
    private static int maxSize = 100; 
    private T[] stack; 
    private int top = -1; 
    private int numElements = 0; 
     
    /**
     * Constructor sin parametros
     */
    public OperandStack(T[] stack){ 
        this.stack = stack; 
          
    } 
    
    public static int getMaxSize(){
    	return maxSize;
    }
    
    public static void setMaxSize(int maxSizeB) {
		maxSize = maxSizeB;
	} 
     
    /**
     * Devuelve el nÃƒÂºmero de elementos en la pila
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
      
    return aux;      
    } 
      
  
    /**
     * Disminuye la cima de la pila.
     */
	public T pop() {
		T n = null;
		if(!this.isEmpty()){ // cambiado pero no definitivo(no funciona ejec 6)
		n = this.stack[top];
		top--;
		this.numElements--;
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
     * Duplica el tamaÃƒÂ±o de la pila(llamada por cpu cuando se supera el tamaño).
     */
    public void reSize(T[] nstack) { 
       
        for(int i=0;i<maxSize/2;i++){ 
            nstack[i] = stack[i]; 
        } 
          
        stack =  nstack; 
          
    }

	
    
      
} 