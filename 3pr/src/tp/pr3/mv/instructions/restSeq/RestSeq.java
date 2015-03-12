package tp.pr3.mv.instructions.restSeq;

import tp.pr3.mv.CPU;
import tp.pr3.mv.exceptions.InstructionExecutionException;
import tp.pr3.mv.instructions.Instruction;
/**
 * Clase abstracta proporcionando el codigo comun a las instrucciones sin parametro, con un parametro y con dos parametros.
 * Tanto para las instrucciones que no toman operando de la pila o las instrucciones que toman uno o dos operandos.
 * @author Omar Gaytan y Adrian Garcia
 *
 */
abstract public class RestSeq implements Instruction {
	abstract protected boolean executeAux(CPU cpu);
	
	/**
	 * Metodo que llama a los executes auxiliares de cada instruccion para ejecutarlas sobre la CPU
	 * @param cpu
	 * @return true si la instruccion se realizo correctamente y falso en caso contrario.
	 * @throws InstructionExecutionException 
	 */
	public void execute(CPU cpu) throws InstructionExecutionException {
	
	if (this.executeAux(cpu)){
	cpu.increaseProgramCounter();
	
	}else throw new InstructionExecutionException("Error en la ejecucion de la instruccion");
	
	}
}
