package tp.pr2.mv.commands;

import tp.pr2.mv.CPU;
/**
 * Esta clase se encarga de representar los comandos a ejecutar y de controlar su bucle de lectura. De esta clase heredan
 * el resto de comandos.
 * @author Adrian Garcia y Omar Gaytan
 *
 */
abstract public class CommandInterpreter {
	
	protected static boolean isFinished;
	protected static CPU cpu;

	public abstract boolean executeCommand();
	
	/**
	 * Traduce una cadena de array de strings a un comando.
	 * @param s
	 * @return CommandInterpreter
	 */
	abstract public CommandInterpreter parse(String[] s);
	
	/**
	 * Constructora sin parametros. Inicializa isFinished a false.
	 */
	public CommandInterpreter() {
		isFinished = false;
	}

	/**
	 * Configura la instancia de ejecucion de cpu.
	 * @param cpu
	 */
	public static void configureCommandInterpreter(CPU cpu) {
		CommandInterpreter.cpu = cpu;
	}

	/**
	 * Devuelve si la lectura de comandos debe terminar
	 * @return boolean
	 */
	public static boolean isFinished() {
		return isFinished;
	}

	/**
	 * Devuelve un string con el estado de la maquina.
	 */
	public static void printStateMachine() {
		CommandInterpreter.cpu.toString();
	}
}