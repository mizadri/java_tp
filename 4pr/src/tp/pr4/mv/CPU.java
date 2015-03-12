package tp.pr4.mv;

import java.util.ArrayList;
import java.util.Stack;

import tp.pr4.mv.exceptions.EmptyStackAcces;
import tp.pr4.mv.exceptions.InstructionExecutionException;
import tp.pr4.mv.exceptions.MVException;
import tp.pr4.mv.inout.InStrategy;
import tp.pr4.mv.inout.OutStrategy;
import tp.pr4.mv.instructions.Instruction;

/**
 *  Clase representando la CPU de la mÃ¡quina virtual. Gestiona los siguientes elementos:
 *	Memoria de datos
 *	Pila de Operandos
 *	Unidad de control
 *	Programa con las instrucciones a ejecutar
 *  @author Adrian Garcia y Omar Gaytan
 *
 */
public class CPU {

	private Memory<Integer> memory;
	private OperandStack<Integer> stack;
	private boolean exit;
	private boolean correctPC;
	private int pc;
	private ProgramMV program;
	
	private static InStrategy inStrategy;
	private static OutStrategy outStrategy;

	/**
	 * Constuctora por defecto que inicializa los atributos de CPU.
	 */

	public CPU() {
		this.memory = new Memory<Integer>( new ArrayList<Memory.MemCell<Integer>>() );
		this.stack = new OperandStack<Integer>(new Integer[OperandStack.getMaxSize()]);
		this.exit = false;
		this.correctPC = true; 
		this.pc = 0;
		this.program = new ProgramMV();
	}

	public static void setInStrat(InStrategy s) throws MVException {
		if (s == null)
			throw new MVException("Cannot set inStrategy to null");
		else
			inStrategy = s;
	}

	public static void setOutStrat(OutStrategy s) throws MVException {
		if (s == null)
			throw new MVException("Cannot set inStrategy to null");
		else
			outStrategy = s;
	}

	public static InStrategy getInStrat() {
		return inStrategy;
	}

	public static OutStrategy getOutStrat() {
		return outStrategy;
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
		this.memory = new Memory<Integer>( new ArrayList<Memory.MemCell<Integer>>() );
		this.stack = new OperandStack<Integer>(new Integer[OperandStack.getMaxSize()]);
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
		return program.getInstructionAt(this.pc);
	
	}
	
	/**
	 * Devuelve true si la ejecucion debe detenerse bien porque el contador de programa es incorrecto
	   o bien porque se ejecuto la instruccion Halt.
	 */
	public boolean abortComputation(){
		boolean aux = false;
		if(!this.correctPC || this.exit || this.getCurrentInstruction()== null ){
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
	 * Modifica el contador de programa sumandole o restandole una cantidad. Si el salto se sale del nº de instrucciones pone correctPC a false.
	 * @param n
	 */
	public void addProgramCounter(int n){
		int jump = n + pc;
		if(jump < program.getSizeProgram() && jump >= 0){
		this.pc =  jump;
		correctPC= true;
		}
		else {
			correctPC = false;
		}
	}
	
	/**
	 * Modifica el contador de programa. Si el salto se sale del nº de instrucciones pone correctPC a false.
	 * @param n
	 */
	public void modifyProgramCounter(int n){

		
		if(n >= 0 && n <= program.getSizeProgram()){
			this.pc =  n;
			correctPC = true;
		}
		else {
			correctPC = false;
		}
		
		
	}
	/**
	 * Metodo que ejecuta el programa completo( mientras el contador de programa sea correcto )
	 * @throws InstructionExecutionException 
	 * @throws EmptyStackAcces 
	 */
	public void run() throws InstructionExecutionException, EmptyStackAcces{
		while(!this.abortComputation()){
			this.step();
		}
	}
	/**
	 *  Metodo que ejecuta la siguiente instruccion, es decir la situada en el contador de programa
	 * @throws EmptyStackAcces 
	 */
	public void step() throws InstructionExecutionException, EmptyStackAcces{ 
		
		getCurrentInstruction().execute(this); 
		
	}
	
	public int getSizeProgram(){
		return program.getSizeProgram();
	}
	
	public String showInstructions() {
		String prog = "";
		
		for(int i = 0; i < this.program.getSizeProgram(); i++){
			if(i == this.pc)
				prog = prog + " * " + Integer.toString(i) + ": " + this.program.getInstructionAt(i).toString() + '\n';
			else prog = prog +"   " +  Integer.toString(i) + ": " + this.program.getInstructionAt(i).toString() + '\n';
		}
		
		return prog;
	}
	/**
	 * Inserta un valor en la cima de la pila
	 * @param result
	 */
	public boolean push(int result) {
		boolean aux = stack.push(result);
		if (!aux) {
			int maxSizeS = 2*OperandStack.getMaxSize();
			OperandStack.setMaxSize(maxSizeS);
			Integer[] nstack = new Integer[maxSizeS];
			this.stack.reSize(nstack);
			aux = stack.push(result);
		}
		
		return aux;
	}
	
	/**
	 * Devuelve el valor de la cima de la pila
	 * @return int
	 * @throws EmptyStackAcces 
	 */
	public Integer pop() throws EmptyStackAcces {
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
	 * @throws EmptyStackAcces 
	 */
	public boolean store(int position) throws EmptyStackAcces{
		return this.memory.store(position, this.pop());
	}

	public int totalPos() {
		return this.memory.getNumElems();
	}

	public int getPC() {
		// TODO Auto-generated method stub
		return this.pc;
	}
	

	 public ProgramMV getProgram(){
		 return this.program;
	 }
	 
	 public Stack<Integer> getOperandStack(){
		 return stack.getOperandStack();
	 }

	public Memory<Integer> getMemory() {
		return memory;
	}
}
