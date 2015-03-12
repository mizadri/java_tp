package tp.pr4.mv.instructions.jumps;

import tp.pr4.mv.CPU;
import tp.pr4.mv.instructions.Instruction;
/**
 * Esta clase representa una instruccion de salto relativa(RJump): Salta sumandole o restandole una cantidad a PC.
 * @author Omar Gaytan y Adrian Garcia
 *
 */
public class Rjump implements Instruction{
	private int n;

	/**
	 * Constructora por defecto
	 */
	public Rjump() {

	}

	/**
	 * Constructora con un parametro
	 * @param n - numero de instrucciones que se suman o restan a pc.
	 */
	public Rjump(int n) {
		this.n = n;
	}

	
	/**
	 * Metodo que ejecuta la instruccion RJUMP sobre la CPU
	 * @param cpu
	 * @return True si se realiza la instruccion correctamente y false en caso contrario
	 */
	public void execute(CPU cpu){
		cpu.addProgramCounter(n);
	}

	
	/**
	 * Devuelve una representacion textual de la instruccion
	 * @return "RJUMP + n
	 */
	public String toString() {
		return "RJUMP " + n;
	}
	
	
	/**
	 * Crea un objeto nuevo de la instruccion correspondiente si el texto analizado coincide con la cadena RJUMP + n
	 * 
	 * @param s - cadena de texto analizar
	 * @return Nuevo objeto de tipo Instruction
	 * @throws WrongInstructionFormatException 
	 */
	public Instruction parse(String[] s){
		Instruction ins = null;
		if (s.length == 2 && s[0].equalsIgnoreCase("RJUMP")) 
			ins = new Rjump(Integer.parseInt(s[1]));
		return ins;
	}
}
