package tp.pr3.mv.instructions.restSeq;

import tp.pr3.mv.CPU;
import tp.pr3.mv.exceptions.WrongInstructionFormatException;
import tp.pr3.mv.instructions.Instruction;

/**
 * Clase encargada de ejecutar, crear y representar la instruccion STORE
 * @author Omar Gaytan y Adrian Garcia
 *
 */
public class Store extends RestSeq{

	private int operand;
	
	/**
	 * Constructora por defecto
	 */
	public Store(){
		
	}
	
	/**
	 * Constructora con un parametro
	 * @param op - posicion a la que se le asignara el valor de la cima de la pila
	 */
	public Store(int op){
		this.operand = op;
	}
	
	/**
	 * Metodo que ejecuta la instruccion STORE sobre la CPU
	 * @param cpu
	 * @return True cuando termina de ejecutar la instruccion y false cuando no hay elementos en la pila o la posicion de memoria introducida
	 * es negativa
	 */
	protected boolean executeAux(CPU cpu) {
		boolean exec = false;
		if(cpu.getSizeStack() > 0 && this.operand >= 0){ // En la practica uno tenia esta condicion if (!this.stack.isEmpty() || pos < 0) 
			int valor = cpu.pop();                                             // pero pos tiene que ser mayor o igual a 0 porq no puedes hacer un store de -1
			boolean aux = cpu.write(this.operand, valor);
			while(!aux){
				cpu.reSizeMemory();
				aux = cpu.write(this.operand, valor);
			}
			exec = true;
		}
		return exec;
	}

	/**
	 * Crea un objeto nuevo de la instruccion correspondiente si el texto analizado coincide con la cadena "STORE + (int)"
	 * @param s - cadena de texto analizar
	 * @return Nuevo objeto de tipo Instruction
	 * @throws WrongInstructionFormatException 
	 */
	public Instruction parse(String[] s){
		Instruction ins = null;
		if (s.length==2 && s[0].equalsIgnoreCase("STORE")) 
			ins = new Store(Integer.parseInt(s[1]));
		return ins;
	}
	
	/**
	 * Devuelve una representacion textual de la instrucci�n
	 * @return "STORE + (posicion en memoria)"
	 */
    public String toString(){
		
		return "STORE " + this.operand;
		
	}

}
