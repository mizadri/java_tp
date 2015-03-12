package tp.pr3.mv.instructions.arithmetics;

import tp.pr3.mv.exceptions.InstructionExecutionException;
import tp.pr3.mv.instructions.Instruction;

/**
 * Clase que representa la instruccion Div. Division la cima entre subcima, apilando el resultado. Subcima == 0 entonces devuelve false.
 * @author Adrian Garcia y Omar Gaytan
 *
 */
public class Div extends Arithmetics {

	public boolean execute(int n1, int n2) throws InstructionExecutionException {
		boolean exec = false;
		if (n1 != 0){
			this.result = n2 / n1;
			exec = true;
		}else throw new InstructionExecutionException("Division por cero, error ejecutando");
		return exec;
	}

	public String toString() {
		return "DIV";
	}

	public Instruction parse(String[] s){
		Instruction ins = null;
		if (s.length == 1 && s[0].equalsIgnoreCase("DIV"))
			ins = new Div();
		return ins;
	}
}
