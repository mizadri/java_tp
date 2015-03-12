package tp.pr3.mv.commands;

import tp.pr3.mv.exceptions.CommandExecutionException;
import tp.pr3.mv.exceptions.InstructionExecutionException;
import tp.pr3.mv.exceptions.WrongCommandFormatException;

/**
 * Representa el comando Step n, encargado de ejecutar un numero n de instrucciones.
 * @author Adrian Garcia y Omar Gaytan
 *
 */
public class Steps extends Step {
	int steps;

	/**
	 * Constructor sin parametros.
	 */
	public Steps() {

	}

	/**
	 * Constructor para indicar el numero de instrucciones a ejecutar.
	 * @param i
	 */
	public Steps(int i) {
		steps = i;
	}

	/**
	 * Ejecuta un numero determinado de instrucciones por parametro.
	 * @throws InstructionExecutionException , CommandExecutionException
	 */
	public void executeCommand() throws CommandExecutionException, InstructionExecutionException {
		int i = 0;
		
		while (i < this.steps) {
			super.executeCommand();
			i++;
		}

	}
	
	/**
	 * Crea un objeto nuevo de comando correspondiente si el texto analizado coincide con la cadena "step n"
	 * @param s 
	 * @return cmd
	 * @throws WrongCommandFormatException 
	 */
	public CommandInterpreter parse(String[] s){
		CommandInterpreter cmd = null;
		if (s.length == 2 && s[0].equalsIgnoreCase("STEP"))
			cmd = new Steps(Integer.parseInt(s[1]));
		
		return cmd;
	}
}
