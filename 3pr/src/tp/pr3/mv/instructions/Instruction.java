package tp.pr3.mv.instructions;

import tp.pr3.mv.CPU;
import tp.pr3.mv.exceptions.InstructionExecutionException;
import tp.pr3.mv.exceptions.WrongInstructionFormatException;
import tp.pr3.mv.instructions.Instruction;

/**
 * Esta clase representa la instruccion a ejecutar.
 * 
 * @author Adrian Garcia y Omar Gaytan
 * 
 */
public interface Instruction {
	/**
	 * Ejecuta la instruccion y devuelve una booleana que vale true si se ha ejecutado correctamente.
	 * @param cpu
	 * @return boolean
	 * @throws InstructionExecutionException 
	 */
	abstract public void execute(CPU cpu) throws InstructionExecutionException;
	
	/**
	 * Devuelve una string con el nombre de instruccion y el parametro, si lo tiene.
	 */
	abstract public String toString();
	/**
	 * Traduce la entrada del usuario a una instruccion.
	 * @param s
	 * @return Instruction
	 * @throws WrongInstructionFormatException 
	 */
	abstract public Instruction parse(String[] s);
}
