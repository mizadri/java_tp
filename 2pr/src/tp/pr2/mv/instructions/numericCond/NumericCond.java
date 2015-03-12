package tp.pr2.mv.instructions.numericCond;

import tp.pr2.mv.instructions.Instruction;
import tp.pr2.mv.CPU;

/**
 * Clase abstracta proporcionando el codigo comun a las instrucciones condicionales
 * @author Omar Gaytan y Adrian Garcia
 *
 */
abstract public class NumericCond extends Instruction {
	
	protected abstract boolean compare(int top, int subtop);

	/**
	 * Metodo que llama a los compare de de las instrucciones condicionales para ejecutarlas sobre la CPU
	 * @param cpu
	 * @return true si la instruccion se realizo correctamente y false en caso contrario
	 */
	public boolean execute(CPU cpu) {
	boolean exec = false;
		if (cpu.getSizeStack() >= 2) {

			int top = cpu.pop();
			int subtop = cpu.pop();
			if (compare(top, subtop))
				cpu.push(1);
			else
				cpu.push(0);
			cpu.increaseProgramCounter();
			exec = true;
		}
			return exec;
	}
}