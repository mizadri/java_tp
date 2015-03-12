package tp.pr4.mv.instructions.restSeq;

import tp.pr4.mv.CPU;
import tp.pr4.mv.exceptions.EmptyStackAcces;
import tp.pr4.mv.exceptions.InstructionExecutionException;
import tp.pr4.mv.instructions.Instruction;

/**
 * Clase encargada de representar la instruccion LoadInd: Carga en la pila, el contenido de la posicion de memoria indicado por la cima(antigua).
 * @author usuario_local
 *
 */
public class LoadInd extends RestSeq{

	/**
	 * Devuelve el nombre de la instruccion
	 */
	public String toString() {
		return "LOADIND ";
	}

	/**
	 * Devuelve una instancia de esta instruccion si la cadena de entrada corresponde con "LOADIND"
	 */
	public Instruction parse(String[] s){
		Instruction ins = null;
		if (s.length == 1 && s[0].equalsIgnoreCase("LOADIND"))
			ins = new LoadInd();
		return ins;
	}

	/**
	 * Carga en la pila, el contenido de la posicion de memoria indicado por la cima(antigua).
	 * @throws EmptyStackAcces 
	 * @throws InstructionExecutionException 
	 */
	protected void executeAux(CPU cpu) throws EmptyStackAcces, InstructionExecutionException {
		
		exec = false;
		Integer top = cpu.pop();
	
		if(cpu.canLoad(top))
		exec = cpu.push(cpu.load(top));  
		else throw new InstructionExecutionException("Acceso a memoria invalido");
	}

}
