package tp.pr2.mv; 
 
/**
 * Clase que representa la pila de operandos.
 * @author Adrian Garcia y Omar Gaytan
 *
 */
public class OperandStack { 
  
    private int maxSize = 100; 
    private Integer[] stack; 
    private int top = -1; 
    private int numElements = 0; 
     
    /**
     * Constructor sin parametros
     */
    public OperandStack(){ 
        this.stack = new Integer[maxSize]; 
          
    } 
     
    /**
     * Devuelve el número de elementos en la pila
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
    public boolean push(int value){ 
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
	public int pop() {
		Integer n = this.stack[top];
		top--;
		this.numElements--;

		return n;
	}
     
    /**
     * Devuelve la cima de la pila.
     * @return i
     */
    public int top(){ 
    int i = 0; 
      
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
     * Duplica el tamaño de la pila(llamada por cpu cuando se supera el tamaño).
     */
    public void reSize() { 
        int[] aux = new int[maxSize]; 
        for(int i=0;i<maxSize;i++){ 
            aux[i] = stack[i]; 
        } 
          
        maxSize = maxSize*2; 
        stack = new Integer[maxSize]; 
          
        for(int i=0;i<maxSize/2;i++){ 
            stack[i] = aux[i]; 
        } 
    } 
    
      
} 