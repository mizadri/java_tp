package tp.pr3.mv.instructions.jumps;

import tp.pr3.mv.CPU;
import tp.pr3.mv.exceptions.InstructionExecutionException;
import tp.pr3.mv.exceptions.LethalJumpsException;
import tp.pr3.mv.exceptions.WrongInstructionFormatException;
import tp.pr3.mv.instructions.Instruction;

/**
 * Clase que crea, ejecuta y representa la instruccion de salto (RBF) modifica pc en n si la cima de la pila es distinta de cero
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
	 * @return True si se realiza la instruccion correctamente y false en caso contrario
	 * @throws InstructionExecutionException 
	 */
	public void execute(CPU cpu) throws InstructionExecutionException {
		boolean exec = false;

		if(cpu.pop() == 0)
		exec = cpu.addProgramCounter(n);
		else {
			exec = true;
			cpu.increaseProgramCounter();
		}		// necesitas esto porque aunq la condicion no se cumpla la instruccion si es correcta

		if(!exec) throw new LethalJumpsException("Error ejecutando instruccion Jump(nº de salto incorrecto)");
		//return exec;
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
	 * @throws WrongInstructionFormatException 
	 */
	public Instruction parse(String[] s){
		Instruction ins = null;
		if (s.length == 2 && s[0].equalsIgnoreCase("RBF"))
			ins = new Rbf(Integer.parseInt(s[1]));
		return ins;
	}
}
