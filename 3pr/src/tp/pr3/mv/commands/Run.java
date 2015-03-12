package tp.pr3.mv.commands;

import tp.pr3.mv.exceptions.CommandExecutionException;
import tp.pr3.mv.exceptions.InstructionExecutionException;
import tp.pr3.mv.exceptions.WrongCommandFormatException;
import tp.pr3.mv.instructions.Instruction;
import tp.pr3.mv.instructions.restSeq.Halt;



/**
 * Clase encargada de representar la instruccion Run, que ejecuta el programa completo desde el PC.
 * @author Adrian Garcia y Omar Gaytan
 *
 */
public class Run extends Step{

	/**
	 * Ejecuta el programa completo.
	 * @throws InstructionExecutionException, CommandExecutionException 
	 */
	public void executeCommand() throws CommandExecutionException, InstructionExecutionException {
		Instruction ins = new Halt(); // para que sea distinto de null al entrar en el bucle
		
		while( !cpu.abortComputation() && ins != null){
			
		super.executeCommand();
		ins = cpu.getCurrentInstruction();
		
		}
			
		
	}
	/**
	 * Crea un objeto nuevo de comando correspondiente si el texto analizado coincide con la cadena "run"
	 * @param s 
	 * @return cmd
	 * @throws WrongCommandFormatException 
	 */
	public CommandInterpreter parse(String[] s){
		CommandInterpreter cmd = null;
		if (s.length==1 && s[0].equalsIgnoreCase("RUN")) 
			cmd = new Run();
		return cmd;	
	}
}
