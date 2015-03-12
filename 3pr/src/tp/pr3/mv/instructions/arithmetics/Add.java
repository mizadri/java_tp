package tp.pr3.mv.instructions.arithmetics;

import tp.pr3.mv.instructions.Instruction;

/**
 * Clase que representa la instruccion Add. Suma de la cima y subcima, apilando el resultado.
 * @author Adrian Garcia y Omar Gaytan
 *
 */
public class Add extends Arithmetics {

	public boolean execute(int n1, int n2) {
		this.result = n1 + n2;
		return true;
	}

	public String toString() {
		return "ADD";
	}

	public Instruction parse(String[] s) {
		Instruction ins = null;
		if (s.length == 1 && s[0].equalsIgnoreCase("ADD"))
			ins = new Add();
		return ins;
	}

}
