package tp.pr4.mv.commands;

/**
 * Clase encargada de ayudar a debug . 
 * @author Adrian Garcia y Omar Gaytan
 *
 */
public class Write extends CommandInterpreter {
	private int pos;
	private int value;
	/**
	 * Constructora por defecto
	 */
	public Write(){
	
	}
	
	/**
	 * Constructora con un parametro
	 * @param pos , value
	 */
	public Write(int pos, int value) {
		this.pos = pos;
		this.value = value;
	}

	/**
	 * Metodo que escribe un valor en una posicion dada de memoria
	 * 
	 * @return pos, value
	 */
	public void executeCommand() {
		cpu.write(pos, value);
	}

	/**
	 * Crea un objeto nuevo de comando correspondiente si el texto analizado coincide con la cadena "WRITE pos value"
	 * @param s 
	 * @return cmd
	 */
	public CommandInterpreter parse(String[] s){
		CommandInterpreter cmd = null;
		if (s.length==3 && s[0].equalsIgnoreCase("WRITE")) 
			cmd = new Write(Integer.parseInt(s[1]), Integer.parseInt(s[2]));
		return cmd;
		
	}
}
