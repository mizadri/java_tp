package tp.pr2.mv.instructions.booleanCond;

import tp.pr2.mv.CPU;
import tp.pr2.mv.instructions.Instruction;

	/**
	 * Clase abstracta proporcionando el codigo comun a las instrucciones booleanas
	 * @author Omar Gaytan y Adrian Garcia
	 *
	 */
	abstract public class BooleanCond extends Instruction {
	protected int result;


	abstract protected boolean execute(int n1, int n2);
	
	/**
	 * Metodo que llama a los execute de de las instrucciones booleanas para ejecutarlas sobre la CPU
	 * @param cpu
	 * @return true si la instruccion se realizo correctamente y false en caso contrario
	 */
	public boolean execute(CPU cpu) {
		boolean exec = false;
		if (cpu.getSizeStack() >= 1) {
			int n1 = cpu.pop();
			int n2 = cpu.pop();
			boolean aux = this.execute(n1,n2);
			if(aux){
			
					cpu.push(this.result);
					cpu.increaseProgramCounter();
					exec = true;
			}
			
		}
		return exec;
	}

}
