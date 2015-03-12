package tp.pr4.mv.instructions.jumps;

import tp.pr4.mv.CPU;
import tp.pr4.mv.exceptions.EmptyStackAcces;
import tp.pr4.mv.instructions.Instruction;

/**
 * Clase que representa la instruccion de salto(JumpInd): Salta al valor de PC indicado por la cima de la pila
 * @author Omar Gaytan y Adrian Garcia
 *
 */
public class JumpInd implements Instruction {

	/**
	 * Ejecuta la instruccion. Salta al valor de PC indicado por la cima de la pila.
	 * @throws EmptyStackAcces 
	 */
	public void execute(CPU cpu) throws EmptyStackAcces{
		
		Integer top = cpu.pop();
		cpu.modifyProgramCounter(top);
	}

	/**
	 * Devuelve el nombre de la instruccion
	 */
	public String toString() {
		return "JUMPIND";
	}

	/**
	 * Devuelve la instruccion si la cadena de entrada coincide con "JUMPIND".
	 */
	public Instruction parse(String[] s){
		Instruction ins = null;
		if (s.length == 1 && s[0].equalsIgnoreCase("JUMPIND"))
			ins = new JumpInd();
		return ins;
	}

}
