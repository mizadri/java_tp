package tp.pr3.mv.instructions.numericCond;


import tp.pr3.mv.exceptions.WrongInstructionFormatException;
import tp.pr3.mv.instructions.Instruction;

/**
 * Clase encargada de ejecutar, crear y representar la instruccion LESS OR EQUAL
 * @author Omar Gaytan y Adrian Garcia
 *
 */
public class LessOrEqual extends NumericCond {

	/**
	  * Metodo que verifica que la subcima sea menor o igual que la cima
	  * @param top
	  * @param subtop
	  * @return true si la subcima es menor o igual y false en caso de que la cima sea mayor
	  */
	protected boolean compare(int top, int subtop) {
		boolean cmp = false;
		if (subtop <= top)
			cmp = true;
		return cmp;

	}

	/**
	 * Crea un objeto nuevo de la instruccion correspondiente si el texto analizado coincide con la cadena "LE"
	 * @param s - cadena de texto analizar
	 * @return Nuevo objeto de tipo Instruction
	 * @throws WrongInstructionFormatException 
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
