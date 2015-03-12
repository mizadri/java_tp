package tp.pr4.mv.instructions.restSeq;

import tp.pr4.mv.CPU;
import tp.pr4.mv.exceptions.EmptyStackAcces;
import tp.pr4.mv.exceptions.InstructionExecutionException;
import tp.pr4.mv.instructions.Instruction;
/**
 * Clase abstracta proporcionando el codigo comun a las instrucciones sin parametro, con un parametro y con dos parametros.
 * Tanto para las instrucciones que no toman operando de la pila o las instrucciones que toman uno o dos operandos.
 * @author Omar Gaytan y Adrian Garcia
 *
 */
abstract public class RestSeq implements Instruction {
	protected boolean exec;
	protected abstract void executeAux(CPU cpu) throws EmptyStackAcces, InstructionExecutionException;
	
	/**
	 * Metodo que llama a los executes auxiliares de cada instruccion para ejecutarlas sobre la CPU
	 * @param cpu
	 * @return true si la instruccion se realizo correctamente y falso en caso contrario.
	 * @throws InstructionExecutionException 
	 * @throws EmptyStackAcces 
	 */
	public void execute(CPU cpu) throws InstructionExecutionException, EmptyStackAcces {
		
	this.executeAux(cpu);
	if (exec){
	cpu.increaseProgramCounter();
	}else throw new InstructionExecutionException("Error en la ejecucion de la instruccion");
	
	}
}
