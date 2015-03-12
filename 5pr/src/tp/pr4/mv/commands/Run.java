package tp.pr4.mv.commands;

import tp.pr4.mv.exceptions.EmptyStackAcces;
import tp.pr4.mv.exceptions.InstructionExecutionException;


/**
 * Clase encargada de representar la instruccion Run, que ejecuta el programa completo desde el PC.
 * @author Adrian Garcia y Omar Gaytan
 *
 */
public class Run extends Step{

	/**
	 * Ejecuta el programa completo.
	 * @throws InstructionExecutionException
	 * @throws EmptyStackAcces 
	 */
	public void executeCommand() throws InstructionExecutionException, EmptyStackAcces {
		while( !cpu.abortComputation()) {
			super.executeCommand();
		}		
	}
	/**
	 * Crea un objeto nuevo de comando correspondiente si el texto analizado coincide con la cadena "run"
	 * @param s 
	 * @return cmd
	 */
	public CommandInterpreter parse(String[] s){
		CommandInterpreter cmd = null;
		if (s.length==1 && s[0].equalsIgnoreCase("RUN")) 
			cmd = new Run();
		return cmd;	
	}
}
