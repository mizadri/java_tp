package tp.pr4.mv.instructions.restSeq;

import tp.pr4.mv.CPU;
import tp.pr4.mv.exceptions.EmptyStackAcces;
import tp.pr4.mv.instructions.Instruction;
/**
 * Clase encargada de representar la instruccion FLIP
 * @author Omar Gaytan y Adrian Garcia
 *
 */
public class Flip extends RestSeq{

	/**
	 * Metodo que ejecuta la instruccion FLIP sobre la CPU
	 * @param cpu
	 * @throws EmptyStackAcces 
	 */
	protected void executeAux(CPU cpu) throws EmptyStackAcces {
		exec = false;
		
		int subCima = cpu.pop();
		int nuevaCima = cpu.pop();

		cpu.push(subCima);
		cpu.push(nuevaCima);

		exec = true;
	}

	/**
	 * Crea un objeto nuevo de la instruccion correspondiente si el texto analizado coincide con la cadena "FLIP"
	 * @param s - cadena de texto analizar
	 * @return Nuevo objeto de tipo Instruction 
	 */
	public Instruction parse(String[] s){
		Instruction ins = null;
		if (s.length == 1 && s[0].equalsIgnoreCase("FLIP"))
			ins =  new Flip();
		return ins;
	}
	
	/**
	 * Devuelve una representacion textual de la instruccion
	 * @return "FLIP"
	 */
	public String toString(){
		return "FLIP";
		
	}

}
