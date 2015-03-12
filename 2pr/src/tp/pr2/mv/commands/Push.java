package tp.pr2.mv.commands;


/**
 * Clase encargada de ejecutar, crear y representar el comando PUSH
 * @author Omar Gaytan y Adrian Garcia
 *
 */
public class Push extends CommandInterpreter{
	private int operand;
	/**
	 * Constructora por defecto
	 */
	public Push(){
	
	}
	
	/**
	 * Constructora con un parametro
	 * @param i - operando entero que se colocara a la cima de la pila
	 */
	public Push(int i) {
		this.operand = i;
	}

	/**
	 * Metodo que ejecuta el comando PUSH sobre la CPU. 
	 * 
	 * @return boolean
	 */
	public boolean executeCommand() {
		cpu.push(this.operand);
		return true;
	}

	/**
	 * Crea un objeto nuevo de comando correspondiente si el texto analizado coincide con la cadena "PUSH n"
	 * @param s - cadena de texto analizar
	 * @return Nuevo objeto de tipo Instruction
	 */
	public CommandInterpreter parse(String[] s) {
		CommandInterpreter cmd = null;
		if (s.length==2 && s[0].equalsIgnoreCase("PUSH")) 
			cmd = new Push(Integer.parseInt(s[1]));
		return cmd;
	}


}