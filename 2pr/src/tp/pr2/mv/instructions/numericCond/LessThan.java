package tp.pr2.mv.instructions.numericCond;

import tp.pr2.mv.instructions.Instruction;

/**
 * Clase encargada de ejecutar, crear y representar la instruccion LESS THAN EQUALS
 * @author Omar Gaytan y Adrian Garcia
 *
 */
public class LessThan extends NumericCond {

	/**
	  * Metodo que compara si la cima sea mayor que la subcima
	  * @param top
	  * @param subtop
	  * @return true si la cima es mayor que la subcima y false en caso contrario
	  */
	protected boolean compare(int top, int subtop) {
		boolean cmp = false;
		if (subtop < top)
			cmp = true;
		return cmp;

	}

	/**
	 * Crea un objeto nuevo de la instruccion correspondiente si el texto analizado coincide con la cadena "LT"
	 * @param s - cadena de texto analizar
	 * @return Nuevo objeto de tipo Instruction
	 */
	public Instruction parse(String[] s) {
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
