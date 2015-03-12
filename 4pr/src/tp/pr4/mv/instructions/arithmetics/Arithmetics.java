package tp.pr4.mv.instructions.arithmetics;

import tp.pr4.mv.CPU;
import tp.pr4.mv.exceptions.EmptyStackAcces;
import tp.pr4.mv.exceptions.InstructionExecutionException;
import tp.pr4.mv.instructions.Instruction;

/**
 * Clase que representa la instrucciones aritmeticas. Suma, Resta, Multiplicacion y Division.
 * @author Adrian Garcia y Omar Gaytan
 *
 */
abstract public class Arithmetics implements Instruction {
	protected int result;

	abstract protected void execute(int n1, int n2)throws InstructionExecutionException;

	/**
	 * Este metodo facilita la ejecucion de cada una de las instrucciones, desapilando los operandos  y luego apilando el resultado si se ha ejecutado correctamente.
	 * @throws InstructionExecutionException 
	 * @throws EmptyStackAcces 
	 */
	public void execute(CPU cpu) throws InstructionExecutionException, EmptyStackAcces {

			int n1 = cpu.pop();
			int n2 = cpu.pop();
			
			this.execute(n1, n2);
			
			cpu.push(this.result);
			cpu.increaseProgramCounter();
		
	}

}
