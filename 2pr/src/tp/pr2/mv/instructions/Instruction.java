package tp.pr2.mv.instructions;

import tp.pr2.mv.instructions.Instruction;
import tp.pr2.mv.CPU;

/**
 * Esta clase representa la instruccion a ejecutar.
 * 
 * @author Adrian Garcia y Omar Gaytan
 * 
 */
abstract public class Instruction {
	/**
	 * Ejecuta la instruccion y devuelve una booleana que vale true si se ha ejecutado correctamente.
	 * @param cpu
	 * @return boolean
	 */
	abstract public boolean execute(CPU cpu);
	
	/**
	 * Devuelve una string con el nombre de instruccion y el parametro , si lo tiene.
	 */
	abstract public String toString();
	/**
	 * Traduce la entrada del usuario a una instruccion.
	 * @param s
	 * @return Instruction
	 */
	abstract public Instruction parse(String[] s);
}
