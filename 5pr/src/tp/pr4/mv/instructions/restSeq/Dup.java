package tp.pr4.mv.instructions.restSeq;

import tp.pr4.mv.CPU;
import tp.pr4.mv.exceptions.EmptyStackAcces;
import tp.pr4.mv.instructions.Instruction;
/**
 * Clase encargada de representar la instruccion DUP
 * @author Omar Gaytan y Adrian Garcia
 *
 */
public class Dup extends RestSeq{

	/**
	 * Metodo que ejecuta la instruccion DUP sobre la CPU
	 * @param cpu
	 * @throws EmptyStackAcces 
	 */
	protected void executeAux(CPU cpu) throws EmptyStackAcces {

		exec = false;

		int val = cpu.pop();
		cpu.push(val);
		cpu.push(val);
		
		exec = true;
	}

	/**
	 * Crea un objeto nuevo de la instruccion correspondiente si el texto analizado coincide con la cadena "DUP"
	 * @param s - cadena de texto analizar
	 * @return Nuevo objeto de tipo Instruction
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
