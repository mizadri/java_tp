package tp.pr3.mv.instructions.jumps;

import tp.pr3.mv.CPU;
import tp.pr3.mv.exceptions.InstructionExecutionException;
import tp.pr3.mv.exceptions.LethalJumpsException;
import tp.pr3.mv.exceptions.WrongInstructionFormatException;
import tp.pr3.mv.instructions.Instruction;

/**
 * Clase que crea, ejecuta y representa la instruccion de salto (JUMP)
 * @author Omar
 *
 */
public class Jump implements Instruction {

	private int n;

	/**
	 * Constructora por defecto
	 */
	public Jump() {

	}

	/**
	 * Constructora con un parametro
	 * @param n - entero que representa la instruccion a la que se saltar.
	 */
	public Jump(int n) {
		this.n = n;
	}

	
	/**
	 * Metodo que ejecuta la instruccion JUMP sobre la CPU
	 * @param cpu
	 * @return True si se realiza la instruccion correctamente y false en caso contrario
	 * @throws InstructionExecutionException 
	 */
	public void execute(CPU cpu) throws InstructionExecutionException {
		boolean exec = false;

		exec = cpu.modifyProgramCounter(n);

		if(!exec) throw new LethalJumpsException("Error ejecutando instruccion Jump(nº de salto incorrecto)");
		//return exec;
	}

	
	/**
	 * Devuelve una representacion textual de la instruccion
	 * @return "JUMP + (instruccion a la que saltar)"
	 */
	public String toString() {
		return "JUMP " + n;
	}
	
	
	/**
	 * Crea un objeto nuevo de la instruccion correspondiente si el texto analizado coincide con la cadena "JUMP + (entero)"
	 * @param s - cadena de texto analizar
	 * @return Nuevo objeto de tipo Instruction
	 * @throws WrongInstructionFormatException 
	 */
	public Instruction parse(String[] s){
		Instruction ins = null;
		if (s.length == 2 && s[0].equalsIgnoreCase("JUMP"))
			ins = new Jump(Integer.parseInt(s[1]));
		return ins;
	}

}
