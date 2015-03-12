package tp.pr4.mv.instructions.restSeq;

import tp.pr4.mv.CPU;
import tp.pr4.mv.exceptions.EmptyStackAcces;
import tp.pr4.mv.exceptions.InstructionExecutionException;
import tp.pr4.mv.instructions.Instruction;

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
	 * @throws EmptyStackAcces 
	 * @throws InstructionExecutionException 
	 */
	protected void executeAux(CPU cpu) throws EmptyStackAcces, InstructionExecutionException {
		exec = false;
		if(this.operand >= 0){ 
			int valor = cpu.pop(); 
			cpu.write(this.operand, valor);
			/*boolean aux = cpu.write(this.operand, valor);
			while(!aux){
				cpu.reSizeMemory();
				aux = cpu.write(this.operand, valor);
			}
			*/
		exec = true;
		}
	}

	/**
	 * Crea un objeto nuevo de la instruccion correspondiente si el texto analizado coincide con la cadena "STORE + (int)"
	 * @param s - cadena de texto analizar
	 * @return Nuevo objeto de tipo Instruction
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
