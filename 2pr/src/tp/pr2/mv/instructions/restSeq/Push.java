package tp.pr2.mv.instructions.restSeq;

import tp.pr2.mv.instructions.Instruction;
import tp.pr2.mv.CPU;

/**
 * Clase encargada de ejecutar, crear y representar la instruccion PUSH
 * @author Omar Gaytan y Adrian Garcia
 *
 */
public class Push extends RestSeq{

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
	 * Metodo que ejecuta la instruccion PUSH sobre la CPU
	 * @param cpu
	 * @return True cuando termina de ejecutar la instruccion
	 */
	protected boolean executeAux(CPU cpu) {
		cpu.push(this.operand);
		return true;
	}

	/**
	 * Crea un objeto nuevo de la instruccion correspondiente si el texto analizado coincide con la cadena "PUSH + (entero)"
	 * @param s - cadena de texto analizar
	 * @return Nuevo objeto de tipo Instruction
	 */
	public Instruction parse(String[] s) {
		Instruction ins = null;
		if (s.length==2 && s[0].equalsIgnoreCase("PUSH")) 
			ins = new Push(Integer.parseInt(s[1]));
		return ins;
	}

	/**
	 * Devuelve una representacion textual de la instruccion
	 * @return "PUSH + (entero)"
	 */
    public String toString(){
		
		return "PUSH " + this.operand;
		
	}
}
