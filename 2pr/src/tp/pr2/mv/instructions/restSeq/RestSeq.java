package tp.pr2.mv.instructions.restSeq;

import tp.pr2.mv.instructions.Instruction;
import tp.pr2.mv.CPU;
/**
 * Clase abstracta proporcionando el codigo comun a las instrucciones sin parametro, con un parametro y con dos parametros.
 * Tanto para las instrucciones que no toman operando de la pila o las instrucciones que toman uno o dos operandos.
 * @author Omar Gaytan y Adrian Garcia
 *
 */
abstract public class RestSeq extends Instruction {
	abstract protected boolean executeAux(CPU cpu);
	
	/**
	 * Metodo que llama a los executes auxiliares de cada instruccion para ejecutarlas sobre la CPU
	 * @param cpu
	 * @return true si la instruccion se realizo correctamente y falso en caso contrario.
	 */
	public boolean execute(CPU cpu) {
	boolean exec = false ; 
	if (this.executeAux(cpu)){
	cpu.increaseProgramCounter();
	exec = true;
	}
	return exec;
	}
}
