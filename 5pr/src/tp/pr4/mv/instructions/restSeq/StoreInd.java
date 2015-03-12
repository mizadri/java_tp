package tp.pr4.mv.instructions.restSeq;

import tp.pr4.mv.CPU;
import tp.pr4.mv.exceptions.EmptyStackAcces;
import tp.pr4.mv.exceptions.InstructionExecutionException;
import tp.pr4.mv.instructions.Instruction;
 
/**
 * Clase encargada de representar la instruccion StoreInd:Escribe en memoria, en la posicion indicada 
 * por la subcima el valor de la cima.
 * @author Omar Gaytan y Adrian Garcia
 *
 */
public class StoreInd extends RestSeq
{


	/**
	 * Devuelve el nombre de la instruccion
	 */
	public String toString() {
		return "STOREIND ";
	}

	/**
	 * Devuelve una instancia de la instruccion si la entrada coincide con la cadena "STOREIND"
	 */
	public Instruction parse(String[] s){
		Instruction ins = null;
		if (s.length == 1 && s[0].equalsIgnoreCase("STOREIND"))
			ins = new StoreInd();
		return ins;
	}

	/**
	 * Escribe en memoria, en la posicion indicada 
	 * por la subcima el valor de la cima.
	 * @throws EmptyStackAcces 
	 * @throws InstructionExecutionException 
	 */
	protected void executeAux(CPU cpu) throws EmptyStackAcces, InstructionExecutionException {
		exec = false;

		int top = cpu.pop();
		int top2 = cpu.pop();
		
		exec = cpu.write(top2, top); // write(pos , value) 	
	}

}
