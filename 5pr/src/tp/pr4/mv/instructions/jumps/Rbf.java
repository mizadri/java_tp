package tp.pr4.mv.instructions.jumps;

import tp.pr4.mv.CPU;
import tp.pr4.mv.exceptions.EmptyStackAcces;
import tp.pr4.mv.instructions.Instruction;

/**
 * Clase que representa la instruccion de salto relativa(RBF): modifica pc en n si la cima de la pila es false(0).
 * @author Omar Gaytan y Adrian Garcia
 *
 */
public class Rbf implements Instruction {
	private int n;

	/**
	 * Constructora por defecto
	 */
	public Rbf() {

	}

	/**
	 * Constructora con un parametro
	 * @param n 
	 */
	public Rbf(int n) {
		this.n = n;
	}

	
	/**
	 * Metodo que ejecuta la instruccion RBF sobre la CPU
	 * @param cpu
	 * @throws EmptyStackAcces 
	 */
	public void execute(CPU cpu) throws EmptyStackAcces{

		if(cpu.pop() == 0){
			cpu.addProgramCounter(n);
		}
		else {
			cpu.increaseProgramCounter();
		}		

	}

	
	/**
	 * Devuelve una representacion textual de la instruccion
	 * @return "RBF + n"
	 */
	public String toString() {
		return "RBF " + n;
	}
	
	
	/**
	 * Crea un objeto nuevo de la instruccion correspondiente si el texto analizado coincide con la cadena "RBF + n"
	 * @param s - cadena de texto analizar
	 * @return Nuevo objeto de tipo Instruction
	 */
	public Instruction parse(String[] s){
		Instruction ins = null;
		if (s.length == 2 && s[0].equalsIgnoreCase("RBF"))
			ins = new Rbf(Integer.parseInt(s[1]));
		return ins;
	}
}
