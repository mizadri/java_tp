package tp.pr2.mv.commands;

import tp.pr2.mv.Constants;
import tp.pr2.mv.instructions.Instruction;

/**
 * Representa el comando Step, encargado de ejecutar una instruccion.
 * @author Adrian Garcia y Omar Gaytan
 *
 */
public class Step extends CommandInterpreter {

	/**
	 * Ejecuta una instruccion.
	 */
	public boolean executeCommand() {
		boolean exec = false;
		Instruction ins = CommandInterpreter.cpu.getCurrentInstruction();// si es null significa que el contador de programa ha superado el nº de instr
		if (ins != null) {
			System.out.println("Comienza la ejecución de " + ins.toString());
			exec = CommandInterpreter.cpu.step();
			if (exec) {
				System.out.println(Constants.MACHINE_STATE);
				System.out.println(cpu.toString());
			}else System.out.println(Constants.EXE_ERROR);
		} else
			System.out.println(Constants.PC_OVERFLOW);
		return exec;
	}

	public CommandInterpreter parse(String[] s) {
		CommandInterpreter cmd = null;
		if (s.length == 1 && s[0].equalsIgnoreCase("STEP")) {

			cmd = new Step();
		}
		return cmd;
	}
}
