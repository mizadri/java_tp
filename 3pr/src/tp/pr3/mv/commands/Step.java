package tp.pr3.mv.commands;

import tp.pr3.mv.Constants;
import tp.pr3.mv.exceptions.CommandExecutionException;
import tp.pr3.mv.exceptions.InstructionExecutionException;
import tp.pr3.mv.exceptions.LethalJumpsException;
import tp.pr3.mv.instructions.Instruction;

/**
 * Representa el comando Step, encargado de ejecutar una instruccion.
 * @author Adrian Garcia y Omar Gaytan
 *
 */
public class Step extends CommandInterpreter {

	/**
	 * Ejecuta una instruccion.
	 * @throws InstructionExecutionException , CommandExecutionException
	 */
	public void executeCommand()throws CommandExecutionException, InstructionExecutionException{
		
		Instruction ins = CommandInterpreter.cpu.getCurrentInstruction();// si es null significa que el contador de programa ha superado el nº de instr
		if (ins != null) {
			System.out.println("Comienza la ejecución de " + ins.toString());
			CommandInterpreter.cpu.step();
			System.out.println(Constants.MACHINE_STATE);
			System.out.println(cpu.toString());
		} else throw new LethalJumpsException(Constants.PC_OVERFLOW);
		
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
