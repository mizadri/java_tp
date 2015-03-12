package tp.pr4.mv.instructions.jumps;

import tp.pr4.mv.CPU;
import tp.pr4.mv.exceptions.EmptyStackAcces;
import tp.pr4.mv.instructions.Instruction;

/**
 * Clase que representa la instruccion de salto relativa (RBT): modifica pc si la cima es true (!=0)
 * @author Omar Gaytan y Adrian Garcia
 *
 */
public class Rbt implements Instruction {
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
	 * @throws EmptyStackAcces 
	 */
	public void execute(CPU cpu) throws EmptyStackAcces{

		if(cpu.pop() != 0)
		cpu.addProgramCounter(n);
		else {
			cpu.increaseProgramCounter();
		}
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
	public Instruction parse(String[] s){
		Instruction ins = null;
		if (s.length == 2 && s[0].equalsIgnoreCase("RBT")) 
			ins = new Rbt(Integer.parseInt(s[1]));
		return ins;
	}
}
