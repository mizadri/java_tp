package tp.pr4.mv.instructions.numericCond;

import tp.pr4.mv.CPU;
import tp.pr4.mv.exceptions.EmptyStackAcces;
import tp.pr4.mv.exceptions.InstructionExecutionException;
import tp.pr4.mv.instructions.Instruction;

/**
 * Clase abstracta proporcionando el codigo comun a las instrucciones condicionales
 * @author Omar Gaytan y Adrian Garcia
 *
 */
abstract public class NumericCond implements Instruction {
	protected boolean result;
	protected abstract void compare(int top, int subtop);

	/**
	 * Metodo que llama a los compare de de las instrucciones condicionales para ejecutarlas sobre la CPU
	 * @param cpu
	 * @return true si la instruccion se realizo correctamente y false en caso contrario
	 * @throws InstructionExecutionException 
	 * @throws EmptyStackAcces 
	 */
	public void execute(CPU cpu) throws InstructionExecutionException, EmptyStackAcces {	

		int top = cpu.pop();
		int subtop = cpu.pop();
		
		compare(top, subtop);
		if (result)
			cpu.push(1);
		else
			cpu.push(0);
		
		cpu.increaseProgramCounter();
		
	}
}