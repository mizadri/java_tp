package tp.pr4.mv.instructions.restSeq;

import tp.pr4.mv.CPU;
import tp.pr4.mv.instructions.Instruction;

/**
 * Clase encargada de representar la instruccion IN
 * @author Omar Gaytan y Adrian Garcia
 *
 */
public class In extends RestSeq{

	/**
	 * Metodo que ejecuta la instruccion IN sobre la CPU
	 * @param cpu
	 */
	protected void executeAux(CPU cpu) {
		exec = false;
		
		int val = CPU.getInStrat().read();
		cpu.push((int) val);
		
		exec = true;
	
	}

	/**
	 * Crea un objeto nuevo de la instruccion correspondiente si el texto analizado coincide con la cadena "IN"
	 * @param s - cadena de texto analizar
	 * @return Nuevo objeto de tipo Instruction 
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
