package tp.pr4.mv.instructions.jumps;

import tp.pr4.mv.CPU;
import tp.pr4.mv.instructions.Instruction;

/**
 * Clase que representa la instruccion de salto (JUMP): salto directo.
 * @author Omar Gaytan y Adrian Garcia
 *
 */
public class Jump implements Instruction {

	private int n;

	/**
	 * Constructora por defecto
	 */
	public Jump() {

	}

	/**
	 * Constructora con un parametro
	 * @param n - entero que representa la instruccion a la que se saltar.
	 */
	public Jump(int n) {
		this.n = n;
	}

	
	/**
	 * Metodo que ejecuta la instruccion JUMP sobre la CPU
	 * @param cpu
	 */
	public void execute(CPU cpu){
		cpu.modifyProgramCounter(n);
	}

	
	/**
	 * Devuelve una representacion textual de la instruccion
	 * @return "JUMP + (instruccion a la que saltar)"
	 */
	public String toString() {
		return "JUMP " + n;
	}
	
	
	/**
	 * Crea un objeto nuevo de la instruccion correspondiente si el texto analizado coincide con la cadena "JUMP + (entero)"
	 * @param s - cadena de texto analizar
	 * @return Nuevo objeto de tipo Instruction
	 */
	public Instruction parse(String[] s){
		Instruction ins = null;
		if (s.length == 2 && s[0].equalsIgnoreCase("JUMP"))
			ins = new Jump(Integer.parseInt(s[1]));
		return ins;
	}

}
