package tp.pr2.mv.instructions.jumps;

import tp.pr2.mv.instructions.Instruction;
import tp.pr2.mv.CPU;


/**
 * Clase que crea, ejecuta y representa la instruccion de salto (BT) salta si la cima de la pila es distinta de cero
 * @author Omar Gaytan y Adrian Garcia
 *
 */
public class Bt extends Instruction {

	private int n;

	/**
	 * Constructora por defecto
	 */
	public Bt() {

	}

	/**
	 * Constructora con un parametro
	 * @param n - entero que representa la instruccion a la que saltar
	 */
	public Bt(int n) {
		this.n = n;
	}

	
	/**
	 * Metodo que ejecuta la instruccion BT sobre la CPU
	 * @param cpu
	 * @return True si se realiza la instruccion correctamente y false en caso contrario
	 */
	public boolean execute(CPU cpu) {
		boolean exec = false;

		if (cpu.pop() != 0)
			exec = cpu.modifyProgramCounter(n);

		return exec;
	}

	/**
	 * Devuelve una representacion textual de la instruccion
	 * @return "BT + (instruccion a la que saltar)"
	 */
	public String toString() {
		return "BT " + this.n;
	}

	/**
	 * Crea un objeto nuevo de la instruccion correspondiente si el texto analizado coincide con la cadena "BT + (entero)"
	 * @param s - cadena de texto analizar
	 * @return Nuevo objeto de tipo Instruction
	 */
	public Instruction parse(String[] s) {
		Instruction ins = null;
		if (s.length == 2 && s[0].equalsIgnoreCase("BT")) {

			ins = new Bt(Integer.parseInt(s[1]));
		}
		return ins;
	}

}
