package tp.pr2.mv;

import java.util.Scanner;



import tp.pr2.mv.commands.*;
/**
 * Clase principal que ejecuta el programa.
 * @author Adrian Garcia y Omar Gaytan
 *
 */
public class Main {

	public static void main(String[] args) {
	
	System.out.println("Introduce el programa fuente "); //Muestra el prompt.
	Scanner sc = new Scanner(System.in);
	ProgramMV prog = new ProgramMV();
	CommandParser cmdParser = new CommandParser();
	
	prog.readProgram(sc); //Lee todas las instrucciones del programa.
	System.out.println(prog.toString());//Muestra el programa leido.
		
	CPU cpu = new CPU();
	cpu.loadProgram(prog);
	
	CommandInterpreter.configureCommandInterpreter(cpu);
	CommandInterpreter cmd;
		
	do{
			
		System.out.print('>');
		String line = sc.nextLine();
		cmd = cmdParser.parseProgramCommand(line);
		
		if(cmd!=null){
			cmd.executeCommand();
		}else System.out.println(Constants.CMD_ERROR);
		
	}while(!CommandInterpreter.isFinished()&&!cpu.abortComputation());

	//abortcomputation comprueba si meten halt o pc incorrecto
	// isFInished si metes quit, pero al ser abstract da problemas cuando trabajas con instrucciones que no han sido parseadas con éxito
	//Así que lo puse como static para poder usarlo aunque estes procesando una instruccion incorrecta
	}
	

}
