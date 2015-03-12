package tp.pr2.mv.instructions.jumps;

import tp.pr2.mv.CPU;
import tp.pr2.mv.instructions.Instruction;

/**
 * Clase que crea, ejecuta y representa la instruccion de salto (RBT) modifica pc si la cima de la pila es distinta de cero
 * @author Omar Gaytan y Adrian Garcia
 *
 */
public class Rbt extends Instruction {
	private int n;

	/**
	 * Constructora por defecto
	 */
	public Rbt() {

	}

	/**
	 * Constructora con un parametro
	 * @param n 
	 */
	public Rbt(int n) {
		this.n = n;
	}

	
	/**
	 * Metodo que ejecuta la instruccion RBT sobre la CPU
	 * @param cpu
	 * @return True si se realiza la instruccion correctamente y false en caso contrario
	 */
	public boolean execute(CPU cpu) {
		boolean exec = false;

		if(cpu.pop() != 0)
		exec = cpu.addProgramCounter(n);

		return exec;
	}

	
	/**
	 * Devuelve una representacion textual de la instruccion
	 * @return "RBT + n"
	 */
	public String toString() {
		return "RBT " + n;
	}
	
	
	/**
	 * Crea un objeto nuevo de la instruccion correspondiente si el texto analizado coincide con la cadena "RBT + n"
	 * @param s - cadena de texto analizar
	 * @return Nuevo objeto de tipo Instruction
	 */
	public Instruction parse(String[] s) {
		Instruction ins = null;
		if (s.length == 2 && s[0].equalsIgnoreCase("RBT")) {

			ins = new Rbt(Integer.parseInt(s[1]));
		}
		return ins;
	}
}
