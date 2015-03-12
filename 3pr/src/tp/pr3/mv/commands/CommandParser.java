package tp.pr3.mv.commands;

import tp.pr3.mv.exceptions.WrongCommandFormatException;

/**
 * Esta clase se encarga de traducir la entrada a comandos.
 * @author Adrian Garcia y Omar Gaytan
 *
 */
public class CommandParser {

	private static CommandInterpreter arrayCommand[] = { new Quit(), new Run(),	new Steps(), new Step()
	, new Pop(), new Push(), new Write()
	
	};

	/**
	 * Devuelve el array de posibles comandos.
	 * @return arrayCommand
	 */
	public CommandInterpreter[] getInstruction() {
		return arrayCommand;
	}

	/**
	 * Recibe una string y devuelve un comando
	 * @param line
	 * @return cmd
	 * @throws WrongCommandFormatException 
	 */
	public CommandInterpreter parseProgramCommand(String line) throws WrongCommandFormatException {
		CommandInterpreter cmd = null;
		String[] st = line.split(" ");

		int i = 0;
		boolean stop = false;
		while (i < CommandParser.arrayCommand.length && !stop) {
			cmd = CommandParser.arrayCommand[i].parse(st);
			if (cmd != null)
				stop = true;
			else
				i++;
		}
		if(cmd == null) throw new WrongCommandFormatException("Error en el formato del comando");
		
		return cmd;
	}

}
