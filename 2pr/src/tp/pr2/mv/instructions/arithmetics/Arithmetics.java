package tp.pr2.mv.instructions.arithmetics;

import tp.pr2.mv.instructions.Instruction;
import tp.pr2.mv.CPU;

/**
 * Clase que representa la instrucciones aritmeticas. Suma, Resta, Multiplicacion y Division.
 * @author Adrian Garcia y Omar Gaytan
 *
 */
abstract public class Arithmetics extends Instruction {
	protected int result;

	abstract protected boolean execute(int n1, int n2);

	/**
	 * Este metodo facilita la ejecucion de cada una de las instrucciones, desapilando los operandos  y luego apilando el resultado si se ha ejecutado correctamente.
	 */
	public boolean execute(CPU cpu) {
		boolean exec = false;
		if (cpu.getSizeStack() >= 2) {
			int n1 = cpu.pop();
			int n2 = cpu.pop();
			
			exec = this.execute(n1, n2);
			if (exec) {
				cpu.push(this.result);
				cpu.increaseProgramCounter();
			}
			
		}
		
		return exec;
	}

}
