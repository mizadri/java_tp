package tp.pr3.mv.instructions.restSeq;

import tp.pr3.mv.CPU;
import tp.pr3.mv.exceptions.WrongInstructionFormatException;
import tp.pr3.mv.instructions.Instruction;

/**
 * Clase encargada de ejecutar, crear y representar la instruccion HALT
 * @author Omar Gaytan y Adrian Garcia
 *
 */
public class Halt extends RestSeq{

	/**
	 * Metodo que ejecuta la instruccion HALT sobre la CPU
	 * @param cpu
	 * @return True
	 */
	protected boolean executeAux(CPU cpu) {
		cpu.exit();
		return true;
	}

	/**
	 * Crea un objeto nuevo de la instruccion correspondiente si el texto analizado coincide con la cadena "HALT"
	 * @param s - cadena de texto analizar
	 * @return Nuevo objeto de tipo Instruction
	 * @throws WrongInstructionFormatException 
	 */
	public Instruction parse(String[] s){
		Instruction ins = null;
		if (s.length == 1 && s[0].equalsIgnoreCase("HALT"))
			ins = new Halt();
		return ins;
	}
	/**
	 * Devuelve una representacion textual de la instruccion
	 * @return "HALT"
	 */
	public String toString(){
		return "HALT";
		
	}

}
