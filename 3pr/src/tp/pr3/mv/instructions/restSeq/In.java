package tp.pr3.mv.instructions.restSeq;

import tp.pr3.mv.CPU;
import tp.pr3.mv.MVSystem;
import tp.pr3.mv.exceptions.WrongInstructionFormatException;
import tp.pr3.mv.instructions.Instruction;

/**
 * Clase encargada de ejecutar, crear y representar la instruccion IN
 * @author Omar Gaytan y Adrian Garcia
 *
 */
public class In extends RestSeq{

	/**
	 * Metodo que ejecuta la instruccion IN sobre la CPU
	 * @param cpu
	 * @return True si se realiza la instruccion correctamente y false en caso de no tener un minimo de dos valores en la pila
	 * o en caso de que el valor del operando no se encuentre en el rango establecido 
	 */
	protected boolean executeAux(CPU cpu) {
			int val = MVSystem.in.read();
				cpu.push((int) val);
		return true;
	}

	/**
	 * Crea un objeto nuevo de la instruccion correspondiente si el texto analizado coincide con la cadena "IN"
	 * @param s - cadena de texto analizar
	 * @return Nuevo objeto de tipo Instruction
	 * @throws WrongInstructionFormatException 
	 */
	public Instruction parse(String[] s){
		Instruction ins = null;
		if (s.length == 1 && s[0].equalsIgnoreCase("In"))
			ins = new In();
		return ins;
	}
	
	/**
	 * Devuelve una representacion textual de la instruccion
	 * @return "OUT"
	 */
	public String toString(){
		return "IN";
		
	}

}
