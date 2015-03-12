package tp.pr2.mv.instructions.restSeq;

import tp.pr2.mv.instructions.Instruction;
import tp.pr2.mv.CPU;

/**
 * Clase encargada de ejecutar, crear y representar la instruccion POP
 * @author Omar Gaytan y Adrian Garcia
 *
 */
public class Pop extends RestSeq{

	/**
	 * Metodo que ejecuta la instruccion POP sobre la CPU
	 * @param cpu
	 * @return True si se realiza la instruccion correctamente y false en caso de no tener operandos en la pila
	 */
	protected boolean executeAux(CPU cpu) {
		boolean exec = false;
	
		if(cpu.getSizeStack() > 0){
		cpu.pop();
		exec = true;
		}
		
		return exec;
	}

	/**
	 * Crea un objeto nuevo de la instruccion correspondiente si el texto analizado coincide con la cadena "POP"
	 * @param s - cadena de texto analizar
	 * @return Nuevo objeto de tipo Instruction
	 */
	public Instruction parse(String[] s) {
		Instruction ins = null;
		if (s.length == 1 && s[0].equalsIgnoreCase("POP"))
			ins = new Pop();
		return ins;
	}
	
	/**
	 * Devuelve una representacion textual de la instruccion
	 * @return "POP"
	 */
	public String toString(){
		return "POP";
		
	}

}
