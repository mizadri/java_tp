package tp.pr3.mv.instructions.booleanCond;

import tp.pr3.mv.CPU;
import tp.pr3.mv.exceptions.InstructionExecutionException;
import tp.pr3.mv.instructions.Instruction;

	/**
	 * Clase abstracta proporcionando el codigo comun a las instrucciones booleanas
	 * @author Omar Gaytan y Adrian Garcia
	 *
	 */
	abstract public class BooleanCond implements Instruction {
	protected int result;


	abstract protected boolean execute(int n1, int n2);
	
	/**
	 * Metodo que llama a los execute de de las instrucciones booleanas para ejecutarlas sobre la CPU
	 * @param cpu
	 * @return true si la instruccion se realizo correctamente y false en caso contrario
	 * @throws InstructionExecutionException 
	 */
	public void execute(CPU cpu) throws InstructionExecutionException {
		if (cpu.getSizeStack() >= 1) {
			int n1 = cpu.pop();
			int n2 = cpu.pop();
			boolean aux = this.execute(n1,n2);
			if(aux){
			
					cpu.push(this.result);
					cpu.increaseProgramCounter();
			}
			
		}
		else throw new InstructionExecutionException("Error ejecutando instruccion booleana(Necesario un elemento en la pila)");

	}

}
