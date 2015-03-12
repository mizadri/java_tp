package tp.pr4.mv.instructions.restSeq;

import tp.pr4.mv.CPU;
import tp.pr4.mv.exceptions.EmptyStackAcces;
import tp.pr4.mv.instructions.Instruction;

/**
 * Clase encargada de representar la instruccion NEG
 * @author Omar Gaytan y Adrian Garcia
 *
 */
public class Neg extends RestSeq{

	/**
	 * Metodo que ejecuta la instruccion NEG sobre la CPU
	 * @param cpu
	 * @throws EmptyStackAcces 
	 */
	protected void executeAux(CPU cpu) throws EmptyStackAcces {
		exec = false;
	
		int aux = cpu.pop() * -1;
		cpu.push(aux);	
		
		exec = true;	
	}

	/**
	 * Crea un objeto nuevo de la instruccion correspondiente si el texto analizado coincide con la cadena "NEG"
	 * @param s - cadena de texto analizar
	 * @return Nuevo objeto de tipo Instruction
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
