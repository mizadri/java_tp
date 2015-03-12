package tp.pr2.mv.commands;

import tp.pr2.mv.Constants;
import tp.pr2.mv.instructions.Instruction;

/**
 * Clase encargada de representar la instruccion Run, que ejecuta el programa completo desde el PC.
 * @author Adrian Garcia y Omar Gaytan
 *
 */
public class Run extends Step{

	/**
	 * Ejecuta el programa completo.
	 */
	public boolean executeCommand() {
		boolean exec = false;
		boolean aux = true;
		
		Instruction ins = CommandInterpreter.cpu.getCurrentInstruction(); // si es null significa que el contador de programa ha superado el nº de instr
		if(ins!=null){
		
			 while(aux){
			 System.out.println("Comienza la ejecucion de " + ins.toString());	 
			 exec = CommandInterpreter.cpu.step();
			 if (exec) {
					System.out.println(Constants.MACHINE_STATE);
					System.out.println(cpu.toString());
				} else{
					System.out.println(Constants.EXE_ERROR);
					aux = false;
				}

			 ins = CommandInterpreter.cpu.getCurrentInstruction(); // si es null significa que el contador de programa ha superado el nº de instr
			 	if(ins==null){
					 aux = false;
				 }
			 }
			 
		}else System.out.println(Constants.PC_OVERFLOW);
		
		return exec;
	}
	public CommandInterpreter parse(String[] s) {
		CommandInterpreter cmd = null;
		if (s.length==1 && s[0].equalsIgnoreCase("RUN")) 
			cmd = new Run();
		return cmd;
	}
}
