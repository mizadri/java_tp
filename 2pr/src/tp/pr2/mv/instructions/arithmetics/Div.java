package tp.pr2.mv.instructions.arithmetics;

import tp.pr2.mv.instructions.Instruction;

/**
 * Clase que representa la instruccion Div. Division la cima entre subcima, apilando el resultado. Subcima == 0 entonces devuelve false.
 * @author Adrian Garcia y Omar Gaytan
 *
 */
public class Div extends Arithmetics {

	public boolean execute(int n1, int n2) {
		boolean exec = false;
		if (n2 != 0){
			this.result = n1 / n2;
			exec = true;
		}
		return exec;
	}

	public String toString() {
		return "DIV";
	}

	public Instruction parse(String[] s) {
		Instruction ins = null;
		if (s.length == 1 && s[0].equalsIgnoreCase("DIV"))
			ins = new Div();
		
		return ins;
	}
}
