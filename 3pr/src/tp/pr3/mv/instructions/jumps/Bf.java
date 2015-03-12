package tp.pr3.mv.instructions.jumps;

import tp.pr3.mv.CPU;
import tp.pr3.mv.exceptions.InstructionExecutionException;
import tp.pr3.mv.exceptions.LethalJumpsException;
import tp.pr3.mv.exceptions.WrongInstructionFormatException;
import tp.pr3.mv.instructions.Instruction;

/**
 * Clase que crea, ejecuta y representa la instruccion de salto (BF) si la cima de la pila es cero
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
	 * @return True si se realiza la instruccion correctamente y false en caso contrario
	 * @throws InstructionExecutionException 
	 */
	public void execute(CPU cpu) throws InstructionExecutionException {
		boolean exec = false;

		if (cpu.pop() == 0)
			exec = cpu.modifyProgramCounter(n);
		else {
			exec = true;
			cpu.increaseProgramCounter();
		}		// necesitas esto porque aunq la condicion no se cumpla la instruccion si es correcta
		
		if(!exec) throw new LethalJumpsException("Error ejecutando instruccion BF(nº de salto incorrecto)");
		//return exec;
	}

	
	/**
	 * Crea un objeto nuevo de la instruccion correspondiente si el texto analizado coincide con la cadena "BF + (entero)"
	 * @param s - cadena de texto analizar
	 * @return Nuevo objeto de tipo Instruction
	 * @throws WrongInstructionFormatException 
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
