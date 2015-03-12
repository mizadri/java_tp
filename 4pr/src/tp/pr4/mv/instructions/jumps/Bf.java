package tp.pr4.mv.instructions.jumps;

import tp.pr4.mv.CPU;
import tp.pr4.mv.exceptions.EmptyStackAcces;
import tp.pr4.mv.instructions.Instruction;

/**
 * Clase que representa la instruccion de salto (BF): salta si la cima false(=0).
 * @author Omar Gaytan y Adrian Garcia
 *
 */
public class Bf implements Instruction {

	private int n;

    /**
     * Constructora por defecto
     */
	public Bf() {

	}

	/**
	 * Constructora con un par�metro
	 * @param n
	 */
	public Bf(int n) {
		this.n = n;
	}

	/**
	 * Metodo que ejecuta la instruccion BF sobre la CPU
	 * @param cpu
	 * @throws EmptyStackAcces 
	 */
	public void execute(CPU cpu) throws EmptyStackAcces{
		if (cpu.pop() == 0){
		cpu.modifyProgramCounter(n);	
		}		
		else {
		cpu.increaseProgramCounter();
		}		
	}

	
	/**
	 * Crea un objeto nuevo de la instruccion correspondiente si el texto analizado coincide con la cadena "BF + (entero)"
	 * @param s - cadena de texto analizar
	 * @return Nuevo objeto de tipo Instruction
	 */
	public Instruction parse(String[] s){
		Instruction ins = null;
		if (s.length == 2 && s[0].equalsIgnoreCase("BF"))
			ins = new Bf(Integer.parseInt(s[1]));
		return ins;
	}
	
	/**
	 * Devuelve una representacion textual de la instruccion
	 * @return "BF + (instruccion a la que saltar)"
	 */
	public String toString() {
		return "BF " + this.n;
	}

}
