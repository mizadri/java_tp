package tp.pr4.mv.instructions.restSeq;

import tp.pr4.mv.CPU;
import tp.pr4.mv.exceptions.EmptyStackAcces;
import tp.pr4.mv.instructions.Instruction;

/**
 * Clase encargada de representar la instruccion OUT
 * @author Omar Gaytan y Adrian Garcia
 *
 */
public class Out extends RestSeq{

	/**
	 * Metodo que ejecuta la instruccion OUT sobre la CPU
	 * @param cpu
	 * @throws EmptyStackAcces 
	 */
	protected void executeAux(CPU cpu) throws EmptyStackAcces {
		exec = false;

		int val = cpu.pop();
		CPU.getOutStrat().write(val);
		
		exec = true;
	}

	/**
	 * Crea un objeto nuevo de la instruccion correspondiente si el texto analizado coincide con la cadena "OUT"
	 * @param s - cadena de texto analizar
	 * @return Nuevo objeto de tipo Instruction 
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
