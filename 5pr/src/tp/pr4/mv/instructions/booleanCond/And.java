package tp.pr4.mv.instructions.booleanCond;

import tp.pr4.mv.exceptions.WrongInstructionFormatException;
import tp.pr4.mv.instructions.Instruction;

/**
 * Clase encargada de ejecutar, crear y representar la instruccion AND
 * @author Omar Gaytan y Adrian Garcia
 *
 */
public class And extends BooleanCond {

	/**
	 * Metodo que realiza la operacion && Los operandos se interpretan como valores binarios siendo donde 0 indica false y cualquier otra
	 * cosa es true.
	 * @param n1
	 * @param n2
	 */
	public void execute(int n1, int n2) {
		
		if (n1 != 0 && n2 != 0)
			this.result = 1;
		else
			this.result = 0;

	}

	
	/**
	 * Crea un objeto nuevo de la instruccion correspondiente si el texto analizado coincide con la cadena "AND"
	 * @param s - cadena de texto analizar
	 * @return Nuevo objeto de tipo Instruction
	 * @throws WrongInstructionFormatException 
	 */
	public Instruction parse(String[] s){
		Instruction ins = null;
		if (s.length == 1 && s[0].equalsIgnoreCase("AND"))
			ins = new And();
		return ins;
	}
	
	/**
	 * Devuelve una representacion textual de la instruccion
	 * @return "AND"
	 */
	public String toString() {
		return "AND";
	}

}
