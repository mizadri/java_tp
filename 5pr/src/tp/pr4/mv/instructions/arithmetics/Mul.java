package tp.pr4.mv.instructions.arithmetics;

import tp.pr4.mv.instructions.Instruction;

/**
 * Clase que representa la instruccion Mul. Multiplicacion de la cima y subcima, apilando el resultado.
 * @author Adrian Garcia y Omar Gaytan
 *
 */
public class Mul extends Arithmetics {

	public void execute(int n1, int n2) {
		this.result = n1 * n2;
	}

	public String toString() {
		return "MUL";
	}

	public Instruction parse(String[] s){
		Instruction ins = null;
		if (s.length == 1 && s[0].equalsIgnoreCase("MUL"))
			ins = new Mul();
		return ins;
	}
}
