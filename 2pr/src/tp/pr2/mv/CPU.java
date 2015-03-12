package tp.pr2.mv;

import tp.pr2.mv.instructions.Instruction;

/**
 *  Clase representando la CPU de la máquina virtual. Gestiona los siguientes elementos:
 *	Memoria de datos
 *	Pila de Operandos
 *	Unidad de control
 *	Programa con las instrucciones a ejecutar
 *  @author Adrian Garcia y Omar Gaytan
 *
 */
public class CPU {

	private Memory memory;
	private OperandStack stack;
	private boolean exit;
	private boolean correctPC;
	private int pc;
	private ProgramMV program;

	/**
	 * Constuctora por defecto que inicializa los atributos de CPU.
	 */
	public CPU() {
		this.memory = new Memory();
		this.stack = new OperandStack();
		this.exit = false;
		this.correctPC = true; 
		this.pc = 0;
		this.program = new ProgramMV();
	}

	/**
	 * Metodo que muestra el estado de la memoria y la pila.
	 */
	public String toString() {
		return "Memoria:" + this.memory.toString() + Constants.LINE_SEPARATOR
				+ "Pila de operandos:" + this.stack.toString();
	}

	/**
	 * Metodo que carga el programa en el cpu
	 * @param prog - conjunto de instrucciones a ejecutar
	 */
	public void loadProgram(ProgramMV prog){
		this.program = prog;
	}
	
	/**
	 * Ejecucion de la instruccion halt
	 */
	public void exit(){
		this.exit = true;
	}
	
	/**
	 * Inicializa todos los atributos de la CPU para preparar una ejecucion con Run
	 */
	public void	resetCPU(){
		this.memory = new Memory();
		this.stack = new OperandStack();
		this.exit = false;
		this.correctPC = true; 
		this.pc = 0;
		this.program = new ProgramMV();
	} 
	
	/**
	 * Devuelve la siguiente instruccion a ejecutar, es decir la situada en el contador de programa
     * en caso de que este sea correcto(null si correctPc = false). En caso de que pc se salga del numero de instrucciones.
	 * @return instruction
	 */
	public Instruction getCurrentInstruction(){
		Instruction ins = null;
		if(this.correctPC) ins = program.getInstructionAt(this.pc); 
		return ins;
	
	}
	
	/**
	 * Devuelve true si la ejecucion debe detenerse bien porque el contador de programa es incorrecto
	   o bien porque se ejecuto la instruccion Halt.
	 */
	public boolean abortComputation(){
		boolean aux = false;
		if(!this.correctPC || this.exit){
			aux = true;
		}
		return aux;
		
	}
	
	/**
	 * Devuelve el tamaño de la pila.
	 *
	 */
	public int getSizeStack() {
		
		return this.stack.getNumElem();
	}
	
	/**
	 * Aumenta en una unidad el contador de programa.
	 */
	public void increaseProgramCounter() {
		pc++;
			
	}
	
	/**
	 * Modifica el contador de programa sumandole o restandole una cantidad. Si el salto se sale del nº de instrucciones devuelve false.
	 * @param n
	 */
	public boolean addProgramCounter(int n){
		boolean canJump = true;
		int jump = n + pc;
		if(jump < program.getSizeProgram() && jump >= 0)
		this.pc =  jump;
		else canJump = false;
		return canJump;
	}
	
	/**
	 * Modifica el contador de programa. Si el salto se sale del nº de instrucciones devuelve false.
	 * @param n
	 */
	public boolean modifyProgramCounter(int n){
		boolean canJump = true;
		
		if(n >= 0 && n < program.getSizeProgram())
		this.pc =  n;
		else canJump = false;
		return canJump;
		
	}
	/**
	 *  Metodo que ejecuta la siguiente instruccion, es decir la situada en el contador de programa
	 * @return aux
	 */
	public boolean step(){ 
		
		return this.getCurrentInstruction().execute(this);
		
	}
	
	
	/**
	 * Inserta un valor en la cima de la pila
	 * @param result
	 */
	public void push(int result) {
		boolean aux = stack.push(result);
		if (!aux) {
			this.stack.reSize();
			this.stack.push(result);
		}
		
	}
	
	/**
	 * Devuelve el valor de la cima de la pila
	 * @return int
	 */
	public int pop() {
		return this.stack.pop();
	}
	
	/**
	 * Lee de memoria el valor de position y lo apila en la pila de operandos
	 * @param position
	 * @return int
	 */
	public int load(int position){
		
		return this.memory.load(position);
		
	}
	
	/**
	 * Metodo que comprueba si la posicion de memoria es valida para realizar la instruccion LOAD
	 * @param position
	 * @return boolean - True si se puede hacer load y false en caso contrario
	 */
	public boolean canLoad(int position){
		return this.memory.canLoad(position);
		
	}
	
	/**
	 * Metodo que escribe en la posicion indicada el valor dado.
	 * @param pos , val
	 * @return boolean
	 */
	public boolean write (int pos, int val){
		return this.memory.store(pos, val);
	}
	
	/**
	 * Metodo que escribe en la posicion "position" el valor de la cima de la pila, que se elimina
	 * @param position
	 * @return boolean
	 */
	public boolean store(int position){
		return this.memory.store(position, this.pop());
	}
	
	/**
	 * Aumenta el tamaño de la memoria
	 */
	public void reSizeMemory(){
		this.memory.reSize();
	}

}
