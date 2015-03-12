package tp.pr4.mv.instructions.booleanCond;

import tp.pr4.mv.CPU;
import tp.pr4.mv.exceptions.EmptyStackAcces;
import tp.pr4.mv.exceptions.InstructionExecutionException;
import tp.pr4.mv.instructions.Instruction;

/**
 * Clase encargada de ejecutar, crear y representar la instruccion NOT
 * @author Omar Gaytan y Adrian Garcia
 *
 */
public class Not implements Instruction {
	private int result;
	
	public void execute(CPU cpu) throws InstructionExecutionException, EmptyStackAcces {
		
			int n1 = cpu.pop();
			
			if(n1 == 0)
			this.result = 1;
			else
			this.result = 0;
	
			cpu.push(this.result);
			cpu.increaseProgramCounter();
	
	}

	
	public Instruction parse(String[] s){
		Instruction ins = null;
		if (s.length == 1 && s[0].equalsIgnoreCase("NOT"))
			ins = new Not();
		return ins;
	}
	
	
    public String toString() {
		return "NOT";
	}

}
