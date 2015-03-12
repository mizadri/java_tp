package tp.pr3.mv.instructions.arithmetics;

import tp.pr3.mv.CPU;
import tp.pr3.mv.exceptions.InstructionExecutionException;
import tp.pr3.mv.instructions.Instruction;

/**
 * Clase que representa la instrucciones aritmeticas. Suma, Resta, Multiplicacion y Division.
 * @author Adrian Garcia y Omar Gaytan
 *
 */
abstract public class Arithmetics implements Instruction {
	protected int result;

	abstract protected boolean execute(int n1, int n2)throws InstructionExecutionException;

	/**
	 * Este metodo facilita la ejecucion de cada una de las instrucciones, desapilando los operandos  y luego apilando el resultado si se ha ejecutado correctamente.
	 * @throws InstructionExecutionException 
	 */
	public void execute(CPU cpu) throws InstructionExecutionException {
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
		else throw new InstructionExecutionException("Error ejecutando " + this.toString() + ": faltan operandos en la pila (hay 1)");
		
	}

}
