package tp.pr4.mv.instructions.jumps;

import tp.pr4.mv.CPU;
import tp.pr4.mv.exceptions.EmptyStackAcces;
import tp.pr4.mv.instructions.Instruction;


/**
 * Clase que representa la instruccion de salto (BT) salta si la cima de la pila es true(!=0)
 * @author Omar Gaytan y Adrian Garcia
 *
 */
public class Bt implements Instruction {

	private int n;

	/**
	 * Constructora por defecto
	 */
	public Bt() {

	}

	/**
	 * Constructora con un parametro
	 * @param n - entero que representa la instruccion a la que saltar
	 */
	public Bt(int n) {
		this.n = n;
	}

	
	/**
	 * Metodo que ejecuta la instruccion BT sobre la CPU
	 * @param cpu
	 * @throws EmptyStackAcces 
	 */
	public void execute(CPU cpu) throws EmptyStackAcces{
		if (cpu.pop() != 0){
			cpu.modifyProgramCounter(n);
		}
		else {
			cpu.increaseProgramCounter();
		} 
	}

	/**
	 * Devuelve una representacion textual de la instruccion
	 * @return "BT + (instruccion a la que saltar)"
	 */
	public String toString() {
		return "BT " + this.n;
	}

	/**
	 * Crea un objeto nuevo de la instruccion correspondiente si el texto analizado coincide con la cadena "BT + (entero)"
	 * @param s - cadena de texto analizar
	 * @return Nuevo objeto de tipo Instruction 
	 */
	public Instruction parse(String[] s)   {
		Instruction ins = null;
		if (s.length == 2 && s[0].equalsIgnoreCase("BT")) 
			ins = new Bt(Integer.parseInt(s[1]));
		return ins;
	}

}
