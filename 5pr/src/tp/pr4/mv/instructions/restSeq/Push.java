package tp.pr4.mv.instructions.restSeq;

import tp.pr4.mv.CPU;
import tp.pr4.mv.instructions.Instruction;

/**
 * Clase encargada de representar la instruccion PUSH
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
	 */
	protected void executeAux(CPU cpu) {
		exec = false;
		cpu.push(this.operand);
		exec = true;
	}

	/**
	 * Crea un objeto nuevo de la instruccion correspondiente si el texto analizado coincide con la cadena "PUSH + (entero)"
	 * @param s - cadena de texto analizar
	 * @return Nuevo objeto de tipo Instruction
	 */
	public Instruction parse(String[] s){
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
