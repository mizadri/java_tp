package tp.pr4.mv.instructions.numericCond;

import tp.pr4.mv.instructions.Instruction;

/**
 * Clase encargada de representar la instruccion LESS OR EQUAL
 * @author Omar Gaytan y Adrian Garcia
 *
 */
public class LessOrEqual extends NumericCond {

	/**
	  * Metodo que verifica que la subcima sea menor o igual que la cima
	  * @param top
	  * @param subtop
	  */
	protected void compare(int top, int subtop) {
		if (subtop <= top)
			result = true;
		else result = false;
	}

	/**
	 * Crea un objeto nuevo de la instruccion correspondiente si el texto analizado coincide con la cadena "LE"
	 * @param s - cadena de texto analizar
	 * @return Nuevo objeto de tipo Instruction
	 */
	public Instruction parse(String[] s){
		Instruction ins = null;
		if (s.length == 1 && s[0].equalsIgnoreCase("LE"))
			ins = new LessOrEqual();
		return ins;
	}
	
	/**
	 * Devuelve una representacion textual de la instruccion
	 * @return "LE"
	 */
	public String toString() {
		return "LE";
	}
}
