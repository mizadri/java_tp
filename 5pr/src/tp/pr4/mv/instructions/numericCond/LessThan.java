package tp.pr4.mv.instructions.numericCond;

import tp.pr4.mv.instructions.Instruction;

/**
 * Clase encargada de representar la instruccion LESS THAN 
 * @author Omar Gaytan y Adrian Garcia
 *
 */
public class LessThan extends NumericCond {

	/**
	  * Metodo que compara si la cima sea mayor que la subcima
	  * @param top
	  * @param subtop
	  */
	protected void compare(int top, int subtop) {
		if (subtop < top)
			result = true;
		else result = false;

	}

	/**
	 * Crea un objeto nuevo de la instruccion correspondiente si el texto analizado coincide con la cadena "LT"
	 * @param s - cadena de texto analizar
	 * @return Nuevo objeto de tipo Instruction 
	 */
	public Instruction parse(String[] s){
		Instruction ins = null;
		if (s.length == 1 && s[0].equalsIgnoreCase("LT"))
			ins = new LessThan();
		return ins;
	}
	
	/**
	 * Devuelve una representacion textual de la instruccion
	 * @return "LT"
	 */
	public String toString() {
		return "LT";
	}
}
