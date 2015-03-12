package tp.pr3.mv.instructions.restSeq;

import tp.pr3.mv.CPU;
import tp.pr3.mv.exceptions.WrongInstructionFormatException;
import tp.pr3.mv.instructions.Instruction;
/**
 * Clase encargada de ejecutar, crear y representar la instruccion DUP
 * @author Omar Gaytan y Adrian Garcia
 *
 */
public class Dup extends RestSeq{

	/**
	 * Metodo que ejecuta la instruccion DUP sobre la CPU
	 * @param cpu
	 * @return True si se realiza la instruccion correctamente y false en caso de no tener operandos en la pila
	 */
	protected boolean executeAux(CPU cpu) {
		boolean exec = false;
		if (cpu.getSizeStack() > 0) {
			int val = cpu.pop();
			cpu.push(val);
			cpu.push(val);
			exec = true;
		}
		
		return exec;
	}

	/**
	 * Crea un objeto nuevo de la instruccion correspondiente si el texto analizado coincide con la cadena "DUP"
	 * @param s - cadena de texto analizar
	 * @return Nuevo objeto de tipo Instruction
	 * @throws WrongInstructionFormatException 
	 */
	public Instruction parse(String[] s){
		Instruction ins = null;
		if (s.length == 1 && s[0].equalsIgnoreCase("DUP"))
			ins = new Dup();
		return ins;
	}

	/**
	 * Devuelve una representacion textual de la instruccion
	 * @return "DUP"
	 */
	public String toString(){
		return "DUP";
		
	}
}
