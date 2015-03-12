package tp.pr2.mv.commands;

/**
 * Representa la instruccion Quit, encargada de terminar el programa.
 * @author Adrian Garcia y Omar Gaytan
 *
 */
public class Quit extends CommandInterpreter{

	/**
	 * Ejecuta la instruccion Quit
	 */
	public boolean executeCommand() {
		isFinished = true;
		return true;
	}
	
	 public CommandInterpreter parse(String[] s) {
		 CommandInterpreter cmd = null;
			if (s.length == 1 && s[0].equalsIgnoreCase("QUIT")) 
				cmd = new Quit();
		return cmd;
		}

}
