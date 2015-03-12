package tp.pr2.mv.instructions.restSeq;

import tp.pr2.mv.instructions.Instruction;
import tp.pr2.mv.CPU;
/**
 * Clase encargada de ejecutar, crear y representar la instruccion FLIP
 * @author Omar Gaytan y Adrian Garcia
 *
 */
public class Flip extends RestSeq{

	/**
	 * Metodo que ejecuta la instruccion FLIP sobre la CPU
	 * @param cpu
	 * @return True si se realiza la instruccion correctamente y false en caso de no tener un minimo de dos valores en la pila
	 */
	protected boolean executeAux(CPU cpu) {
		boolean exec = false;
		if (cpu.getSizeStack() >= 2) {
			int subCima = cpu.pop();
			int nuevaCima = cpu.pop();

			cpu.push(subCima);
			cpu.push(nuevaCima);

			exec = true;
		}
		return exec;
	}

	/**
	 * Crea un objeto nuevo de la instruccion correspondiente si el texto analizado coincide con la cadena "FLIP"
	 * @param s - cadena de texto analizar
	 * @return Nuevo objeto de tipo Instruction
	 */
	public Instruction parse(String[] s) {
		Instruction ins = null;
		if (s.length == 1 && s[0].equalsIgnoreCase("FLIP"))
			ins = new Flip();
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
