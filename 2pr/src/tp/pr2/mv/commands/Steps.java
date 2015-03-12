package tp.pr2.mv.commands;

import tp.pr2.mv.Constants;
import tp.pr2.mv.instructions.Instruction;
 
/**
 * Representa el comando Step n, encargado de ejecutar un numero n de instrucciones.
 * @author Adrian Garcia y Omar Gaytan
 *
 */
public class Steps extends Step {
	int steps;

	/**
	 * Constructor sin parametros.
	 */
	public Steps() {

	}

	/**
	 * Constructor para indicar el numero de instrucciones a ejecutar.
	 * @param i
	 */
	public Steps(int i) {
		steps = i;
	}

	/**
	 * Ejecuta un numero determinado de instrucciones por parametro.
	 */
	public boolean executeCommand() {
		boolean exec = false;
		boolean aux = true;
		int i = 0;
		Instruction ins = CommandInterpreter.cpu.getCurrentInstruction();
		if (ins != null) {

			while (i < this.steps && aux) {
			System.out.println("Comienza la ejecución de " + ins.toString());
				exec = CommandInterpreter.cpu.step();
				if (exec) {
					System.out.println(Constants.MACHINE_STATE);
					System.out.println(cpu.toString());
				} else{
					aux = false;
					System.out.println(Constants.EXE_ERROR);
				}
				ins = CommandInterpreter.cpu.getCurrentInstruction();//Cuando ejecuta la ultima instruccion posible, al hacer step te pasa a pc+1 y cuando compruebas aqui getcurrrent instruccion si es null
				if (ins == null) {
					aux = false;
					System.out.println(Constants.PC_OVERFLOW);
				}
				i++;
			}

		} else
			System.out.println(Constants.PC_OVERFLOW);

		return exec;
	}

	public CommandInterpreter parse(String[] s) {
		CommandInterpreter cmd = null;
		if (s.length == 2 && s[0].equalsIgnoreCase("STEP")) {

			cmd = new Steps(Integer.parseInt(s[1]));
		}
		return cmd;
	}
}
