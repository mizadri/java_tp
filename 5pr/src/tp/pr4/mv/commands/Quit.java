package tp.pr4.mv.commands;

/**
 * Representa la instruccion Quit, encargada de terminar el programa.
 * @author Adrian Garcia y Omar Gaytan
 *
 */
public class Quit extends CommandInterpreter{

	/**
	 * Ejecuta la instruccion Quit
	 */
	public void executeCommand() {
		isFinished = true;
	}
	
	/**
	 * Crea un objeto nuevo de comando correspondiente si el texto analizado coincide con la cadena "quit"
	 * @param s 
	 * @return cmd
	 */
	 public CommandInterpreter parse(String[] s){
		 	CommandInterpreter cmd = null;
			if (s.length == 1 && s[0].equalsIgnoreCase("QUIT")) 
				cmd = new Quit();
			return cmd;
		}

}
