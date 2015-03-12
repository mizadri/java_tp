package tp.pr4.mv.commands;

import tp.pr4.mv.Constants;
import tp.pr4.mv.exceptions.EmptyStackAcces;
import tp.pr4.mv.exceptions.InstructionExecutionException;
import tp.pr4.mv.instructions.Instruction;

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
		
		Instruction ins = CommandInterpreter.cpu.getCurrentInstruction();// si es null significa que el contador de programa ha superado el nº de instr
		System.out.println("Comienza la ejecución de " + ins.toString());
		
		CommandInterpreter.cpu.step();
		
		System.out.println(Constants.MACHINE_STATE);
		System.out.println(cpu.toString());
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
