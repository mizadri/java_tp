package tp.pr1.mv; 
  
public class OperandStack { 
  
    private int maxSize = 100; 
    private Integer[] stack; 
    private int top = -1; 
    private int numElements = 0; 
      
    public OperandStack(){ 
        this.stack = new Integer[maxSize]; 
          
    } 
      
    public int getNumElem(){ 
          
        return this.numElements; 
    } 
      
      
    public boolean isEmpty(){ 
    boolean aux = true; 
      
    if(top >= 0) aux = false; 
      
    return aux; 
    } 
      
    public boolean push(int value){ 
    boolean aux = false; 
    if(top < maxSize -1){ 
        stack[++top] = value;  
        aux = true; 
        this.numElements++; 
    } 
      
    return aux;      
    } 
      
  
    public void pop(){ 
          
        if(!this.isEmpty()){ 
        top--;   
        this.numElements--; 
        } 
          
          
    } 
      
    public int top(){ 
    int i = 0; 
      
    if(!this.isEmpty()){ 
        i = stack[top] ;             
    } 
    return i; 
    } 
      
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