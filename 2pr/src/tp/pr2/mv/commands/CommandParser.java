package tp.pr2.mv.commands;

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
	 */
	public CommandInterpreter parseProgramCommand(String line) {
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
		return cmd;
	}

}
