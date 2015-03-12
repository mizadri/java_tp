package tp.pr4.mv.commands;


import tp.pr4.mv.exceptions.EmptyStackAcces;
import tp.pr4.mv.exceptions.InstructionExecutionException;


/**
 * Representa el comando Step, encargado de ejecutar una instruccion.
 * @author Adrian Garcia y Omar Gaytan
 *
 */
public class Step extends CommandInterpreter {

	/**
	 * Ejecuta una instruccion.
	 * @throws InstructionExecutionException
	 * @throws EmptyStackAcces 
	 */
	public void executeCommand()throws InstructionExecutionException, EmptyStackAcces{
		
		CommandInterpreter.cpu.step();
		
	}

	/**
	 * Crea un objeto nuevo de comando correspondiente si el texto analizado coincide con la cadena "step"
	 * @param s 
	 * @return cmd
	 */
	public CommandInterpreter parse(String[] s) {
		CommandInterpreter cmd = null;
		if (s.length == 1 && s[0].equalsIgnoreCase("STEP")) 
			cmd = new Step();
		return cmd;
	}
}
