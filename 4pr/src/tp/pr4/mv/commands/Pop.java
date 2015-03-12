package tp.pr4.mv.commands;

import tp.pr4.mv.exceptions.EmptyStackAcces;


/**
 * Clase encargada de ejecutar, crear y representar el comando POP
 * @author Omar Gaytan y Adrian Garcia
 *
 */
public class Pop extends CommandInterpreter{

	/**
	 * Metodo que ejecuta el comando POP sobre la CPU. True si se realiza la instruccion correctamente y false en caso de no tener operandos en la pila.
	 * 
	 * @throws EmptyStackAcces 
	 * @throws InstructionExecutionException 
	 */
	public void executeCommand() throws  EmptyStackAcces {
		cpu.pop();
	}

	/**
	 * Crea un objeto nuevo de comando correspondiente si el texto analizado coincide con la cadena "POP"
	 * @param s - cadena de texto analizar
	 * @return Nuevo objeto de tipo Instruction
	 */
	public CommandInterpreter parse(String[] s) {
		CommandInterpreter cmd = null;
		if (s.length == 1 && s[0].equalsIgnoreCase("POP"))
			cmd = new Pop();
		return cmd;
	}


}