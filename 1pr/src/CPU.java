package tp.pr1.mv;

public class CPU {
	
public static final String LINE_SEPARATOR = System.getProperty("line.separator"); 
public static final String INST_ERROR = "Error en la ejecución de la instrucción.";	
private Memory memory;
private OperandStack stack;
private boolean finished;


/**
 * Constuctora por defecto que inicializa la memoria y la pila con sus respectivas capacidades. 
 */
public CPU(){
	this.memory = new Memory();
	this.stack = new OperandStack();
	this.finished = false;
	
}

/**
 * M�todo que muestra el estado de la memoria y la pila.
 */
public String toString(){
	return "Memoria:" + this.memory.toString() + LINE_SEPARATOR + "Pila de operandos:" + this.stack.toString();
}


/**
 * M�todo que indica si la maquina virtual se ha detenido o no, se detiene si se ejecuta la instruccion HALT. 
 * @return Si la CPU est� detenida.
 */
	public boolean isFinished() {
		return this.finished;
	}
	
/**
 * M�todo que se encarga de ejecutar la instruccion pasada por parametro.
 * @param instruction es la instrucci�n a ejecutar.
 * @return true si la instrucci�n se ejecuto con exito y false si hubo un error o la maquina este parada.
 */
	public boolean execute(Instruction instruction){

if(instruction.getType() == InstructionType.HALT){ 
	this.finished = true;
	}
else if (instruction.getType() == InstructionType.ADD){
	 if(this.stack.getNumElem() >= 2){ 
	        int operando2 = this.stack.top(); 
	        this.stack.pop(); 
	          
	        int operando1 = this.stack.top(); 
	        this.stack.pop(); 
	          
	        int resultado = operando1 + operando2; 
	        this.stack.push(resultado);
 }
}
else if (instruction.getType() == InstructionType.SUB){ 
		   if(this.stack.getNumElem() >= 2){ 
		      int operando2 = this.stack.top(); 
		      this.stack.pop(); 
		          
		      int operando1 = this.stack.top(); 
		      this.stack.pop(); 
		          
		      int resultado = operando1 - operando2; 
		      this.stack.push(resultado); 
		      
	} 
} 
else if (instruction.getType() == InstructionType.DIV){
    if(this.stack.getNumElem() >= 2 && this.stack.top() != 0){ // para que la división por cero no se ejecute 
        int operando2 = this.stack.top(); 
        this.stack.pop(); 
          
        int operando1 = this.stack.top(); 
        this.stack.pop(); 
          
        int resultado = operando1 / operando2; 
          
        this.stack.push(resultado); 
          
    }
}
else if (instruction.getType() == InstructionType.DUP){
	if(!this.stack.isEmpty()){
		int val = this.stack.top();
		boolean aux = stack.push(val);
		if(!aux){
			this.stack.reSize();
			this.stack.push(val);
		}
	}else{
		System.out.println(INST_ERROR);
	}
}
else if (instruction.getType() == InstructionType.FLIP){
	   if(this.stack.getNumElem() >= 2){ 
	        int subCima = this.stack.top(); 
	        this.stack.pop(); 
	          
	        int nuevaCima = this.stack.top(); 
	        this.stack.pop(); 
	          
	        this.stack.push(subCima); 
	        this.stack.push(nuevaCima);  
	    } 
}
else if (instruction.getType() == InstructionType.LOAD){
	if(memory.canLoad(instruction.getParam())){
		if(!stack.push(memory.load(instruction.getParam()))){
			stack.reSize();
			stack.push(memory.load(instruction.getParam()));
		}
	}
}
else if(instruction.getType() == InstructionType.MUL){
	   if(this.stack.getNumElem() >= 2){ 
		      int operando2 = this.stack.top(); 
		      this.stack.pop(); 
		          
		      int operando1 = this.stack.top(); 
		      this.stack.pop(); 
		          
		      int resultado = operando1 * operando2; 
		      this.stack.push(resultado); 
		      
	}
}
else if(instruction.getType() == InstructionType.OUT){
	
	int top = stack.top();
	if(top>=0 && top<=255){
	System.out.println((char)top);
	}
}
else if(instruction.getType() == InstructionType.POP){
	
	if(!this.stack.isEmpty()){
		stack.pop();
	}else{
		System.out.println(INST_ERROR);
	}
}
else if(instruction.getType() == InstructionType.PUSH){
	int value = instruction.getParam();
	boolean aux = stack.push(value);
	if(!aux){
		this.stack.reSize();
		this.stack.push(value);
	}
}
else if(instruction.getType() == InstructionType.STORE){
	
	int pos = instruction.getParam();
	if(!this.stack.isEmpty()||pos<0){
		
		int val = this.stack.top();
		this.stack.pop();
		boolean aux = this.memory.store(pos,val);
		
		while(!aux){
			this.memory.reSize();
			aux = this.memory.store(pos,val);
		}
		
	}else{
		System.out.println(INST_ERROR);
	}
	
}


return this.finished;
}
		
	}
	
	

