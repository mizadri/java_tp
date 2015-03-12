package tp.pr3.mv.instructions.restSeq;

import tp.pr3.mv.CPU;
import tp.pr3.mv.exceptions.WrongInstructionFormatException;
import tp.pr3.mv.instructions.Instruction;

/**
 * Clase encargada de ejecutar, crear y representar la instruccion NEG
 * @author Omar Gaytan y Adrian Garcia
 *
 */
public class Neg extends RestSeq{

	/**
	 * Metodo que ejecuta la instruccion NEG sobre la CPU
	 * @param cpu
	 * @return True si se realiza la instruccion correctamente y false en caso de no tener operandos en la pila
	 */
	protected boolean executeAux(CPU cpu) {
		boolean exec = false;
		if(cpu.getSizeStack() > 0){
			int aux = cpu.pop() * -1;
			cpu.push(aux);	
			exec = true;
		}
		return exec;
	}

	/**
	 * Crea un objeto nuevo de la instruccion correspondiente si el texto analizado coincide con la cadena "NEG"
	 * @param s - cadena de texto analizar
	 * @return Nuevo objeto de tipo Instruction
	 * @throws WrongInstructionFormatException 
	 */
	public Instruction parse(String[] s){
		Instruction ins = null;
		if (s.length == 1 && s[0].equalsIgnoreCase("NEG"))
			ins = new Neg();
		return ins;
	}
	
	/**
	 * Devuelve una representacion textual de la instruccion
	 * @return "NEG"
	 */
	public String toString() {
		return "NEG";
	}
	

}
