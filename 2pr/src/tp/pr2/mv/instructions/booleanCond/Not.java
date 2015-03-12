package tp.pr2.mv.instructions.booleanCond;

import tp.pr2.mv.CPU;
import tp.pr2.mv.instructions.Instruction;

/**
 * Clase encargada de ejecutar, crear y representar la instruccion NOT
 * @author Omar Gaytan y Adrian Garcia
 *
 */
public class Not extends Instruction {
	private int result;
	public boolean execute(CPU cpu) {
		
		boolean exec = false;
		if (cpu.getSizeStack() > 0) {
			
			int n1 = cpu.pop();
			if(n1 == 0)
				this.result = 1;
				else
				this.result = 0;
	
			cpu.push(this.result);
			cpu.increaseProgramCounter();
			exec = true;
		
			
		}
		return exec;
	}

	
	public Instruction parse(String[] s) {
		Instruction ins = null;
		if (s.length == 1 && s[0].equalsIgnoreCase("NOT"))
			ins = new Not();
		return ins;
	}
	
	
    public String toString() {
		return "NOT";
	}

}
