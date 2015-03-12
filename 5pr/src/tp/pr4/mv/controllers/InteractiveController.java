package tp.pr4.mv.controllers;

import java.util.Scanner;

import tp.pr4.mv.CPU;
import tp.pr4.mv.commands.CommandInterpreter;
import tp.pr4.mv.commands.CommandParser;
import tp.pr4.mv.exceptions.EmptyStackAcces;
import tp.pr4.mv.exceptions.InstructionExecutionException;
import tp.pr4.mv.exceptions.WrongCommandFormatException;

public class InteractiveController extends Controller {

	public InteractiveController(CPU cpu) {
		super(cpu);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void start() {
		Scanner sc ;
		CommandInterpreter cmd;
		CommandParser cmdParser = new CommandParser();	
		do{
			sc = new Scanner(System.in);
			String line = sc.nextLine();
			try{
				cmd = cmdParser.parseProgramCommand(line); 
				cmd.executeCommand();					   
			}
			catch (WrongCommandFormatException e){
				System.err.println(e.getMessage());
			}
			catch (InstructionExecutionException e) {
		
			} 
			catch (EmptyStackAcces e) {
				
			}
	
		}while(!CommandInterpreter.isFinished());
	sc.close();
	}

}
