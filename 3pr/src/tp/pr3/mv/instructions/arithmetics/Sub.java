package tp.pr3.mv.instructions.arithmetics;

import tp.pr3.mv.instructions.Instruction;

/**
 * Clase que representa la instruccion Sub. Resta de la cima y subcima, apilando el resultado.
 * @author Adrian Garcia y Omar Gaytan
 *
 */
public class Sub extends Arithmetics {

	public boolean execute(int n1, int n2) {
		this.result = n2 - n1;
		return true;
	}

	public String toString() {
		return "SUB";
	}

	public Instruction parse(String[] s){
		Instruction ins = null;
		if (s.length == 1 && s[0].equalsIgnoreCase("SUB"))
			ins = new Sub();
		return ins;
	}

}
