package tp.pr2.mv.instructions.numericCond;

import tp.pr2.mv.instructions.Instruction;

/**
 * Clase encargada de ejecutar, crear y representar la instruccion EQUALS
 * @author Omar Gaytan y Adrian Garcia
 *
 */
public class Equals extends NumericCond {

	/**
	  * Metodo que compara si la cima y la subcima son iguales
	  * @param top		
	  * @param subtop
	  * @return true si son iguales y false en caso contrario
	  */
	protected boolean compare(int top, int subtop) {
		boolean cmp = false;
		if (subtop == top)
			cmp = true;
		return cmp;
	}

	/**
	 * Crea un objeto nuevo de la instruccion correspondiente si el texto analizado coincide con la cadena "EQ"
	 * @param s - cadena de texto analizar
	 * @return Nuevo objeto de tipo Instruction
	 */
	public Instruction parse(String[] s) {
		Instruction ins = null;
		if (s.length == 1 && s[0].equalsIgnoreCase("EQ"))
			ins = new Equals();
		return ins;
	}
	
	/**
	 * Devuelve una representacion textual de la instruccion
	 * @return "EQ"
	 */
	public String toString() {
		return "EQ";
	}

}
