package tp.pr4.mv.instructions.booleanCond;

import tp.pr4.mv.CPU;
import tp.pr4.mv.exceptions.EmptyStackAcces;
import tp.pr4.mv.exceptions.InstructionExecutionException;
import tp.pr4.mv.instructions.Instruction;

	/**
	 * Clase abstracta proporcionando el codigo comun a las instrucciones booleanas
	 * @author Omar Gaytan y Adrian Garcia
	 *
	 */
	abstract public class BooleanCond implements Instruction {
	protected int result;


	abstract protected void execute(int n1, int n2);
	
	/**
	 * Metodo que llama a los execute de de las instrucciones booleanas para ejecutarlas sobre la CPU
	 * @param cpu
	 * @return true si la instruccion se realizo correctamente y false en caso contrario
	 * @throws InstructionExecutionException 
	 * @throws EmptyStackAcces 
	 */
	public void execute(CPU cpu) throws InstructionExecutionException, EmptyStackAcces {
		
		int n1 = cpu.pop();
		int n2 = cpu.pop();

		this.execute(n1,n2);
	
		cpu.push(this.result);
		cpu.increaseProgramCounter();
		
	}

}
