package tp.pr2.mv.instructions.numericCond;

import tp.pr2.mv.instructions.Instruction;

/**
 * Clase encargada de ejecutar, crear y representar la instruccion GREATER THAN
 * @author Omar Gaytan y Adrian Garcia
 *
 */
public class GreaterThan extends NumericCond {

	/**
	  * Metodo que verifica que la subcima sea mayor que la cima
	  * @param top
	  * @param subtop
	  * @return true si la subcima es mayor y false en caso contrario
	  */
	protected boolean compare(int top, int subtop) {
		boolean cmp = false;
		if (subtop > top)
			cmp = true;
		return cmp;

	}

	/**
	 * Crea un objeto nuevo de la instruccion correspondiente si el texto analizado coincide con la cadena "GT"
	 * @param s - cadena de texto analizar
	 * @return Nuevo objeto de tipo Instruction
	 */
	public Instruction parse(String[] s) {
		Instruction ins = null;
		if (s.length == 1 && s[0].equalsIgnoreCase("GT"))
			ins = new GreaterThan();
		return ins;
	}
	
	/**
	 * Devuelve una representacion textual de la instruccion
	 * @return "GT"
	 */
	public String toString() {
		return "GT";
	}
}
