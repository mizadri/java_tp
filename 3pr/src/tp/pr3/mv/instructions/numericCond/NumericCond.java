package tp.pr3.mv.instructions.numericCond;

import tp.pr3.mv.CPU;
import tp.pr3.mv.exceptions.InstructionExecutionException;
import tp.pr3.mv.instructions.Instruction;

/**
 * Clase abstracta proporcionando el codigo comun a las instrucciones condicionales
 * @author Omar Gaytan y Adrian Garcia
 *
 */
abstract public class NumericCond implements Instruction {
	
	protected abstract boolean compare(int top, int subtop);

	/**
	 * Metodo que llama a los compare de de las instrucciones condicionales para ejecutarlas sobre la CPU
	 * @param cpu
	 * @return true si la instruccion se realizo correctamente y false en caso contrario
	 * @throws InstructionExecutionException 
	 */
	public void execute(CPU cpu) throws InstructionExecutionException {
		
		if (cpu.getSizeStack() >= 2) {

			int top = cpu.pop();
			int subtop = cpu.pop();
			if (compare(top, subtop))
				cpu.push(1);
			else
				cpu.push(0);
			cpu.increaseProgramCounter();
		}
		else throw new InstructionExecutionException("Error ejecutando instrucciones de cmp(pila con insuficientes operandos)");
	}
}