package tp.pr4.mv.instructions.booleanCond;

import tp.pr4.mv.instructions.Instruction;


/**
 * Clase encargada de ejecutar, crear y representar la instruccion OR
 * @author Omar Gaytan y Adrian Garcia
 *
 */
public class Or extends BooleanCond {

	public void execute(int n1, int n2) {

		if (n1 != 0 || n2 != 0)
			this.result = 1;
		else
			this.result = 0;
		
	}

	public String toString() {
		return "OR";
	}

	public Instruction parse(String[] s){
		Instruction ins = null;
		if (s.length == 1 && s[0].equalsIgnoreCase("OR"))
			ins = new Or();
		return ins;
	}

}
