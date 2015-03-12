package tp.pr3.mv.instructions.restSeq;

import tp.pr3.mv.CPU;
import tp.pr3.mv.MVSystem;
import tp.pr3.mv.exceptions.WrongInstructionFormatException;
import tp.pr3.mv.instructions.Instruction;

/**
 * Clase encargada de ejecutar, crear y representar la instruccion OUT
 * @author Omar Gaytan y Adrian Garcia
 *
 */
public class Out extends RestSeq{

	/**
	 * Metodo que ejecuta la instruccion OUT sobre la CPU
	 * @param cpu
	 * @return True si se realiza la instruccion correctamente y false en caso de no tener un minimo de dos valores en la pila
	 * o en caso de que el valor del operando no se encuentre en el rango establecido 
	 */
	protected boolean executeAux(CPU cpu) {
		boolean exec = false;
		if (cpu.getSizeStack() > 0) {
			
				int val = cpu.pop();
				MVSystem.out.write(val);
				exec = true;
				
				
		}
		return exec;
	}

	/**
	 * Crea un objeto nuevo de la instruccion correspondiente si el texto analizado coincide con la cadena "OUT"
	 * @param s - cadena de texto analizar
	 * @return Nuevo objeto de tipo Instruction
	 * @throws WrongInstructionFormatException 
	 */
	public Instruction parse(String[] s){
		Instruction ins = null;
		if (s.length == 1 && s[0].equalsIgnoreCase("OUT"))
			ins = new Out();
		return ins;
	}
	
	/**
	 * Devuelve una representacion textual de la instruccion
	 * @return "OUT"
	 */
	public String toString(){
		return "OUT";
		
	}

}
