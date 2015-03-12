package tp.pr2.mv;

import java.util.Scanner;

import tp.pr2.mv.instructions.*;

public class ProgramMV {
	
	static private final int MAX_PROGRAM = 100;
	private Instruction[] program;
	private int numberInstructions;
	//private int sizeProgram;
	
	public ProgramMV(){
		program = new Instruction[MAX_PROGRAM];
		this.numberInstructions = 0;
		//this.sizeProgram = 0;
	}
	
	/**
	 * Devuelve la instruccion en la posicion indicada. Null en caso de que se pase de pc.
	 * @param i
	 * @return ins
	 */
	public Instruction getInstructionAt(int i){
		Instruction ins = null;
		
		if( i>=0 && i<numberInstructions) ins = program[i];
		
		return ins;
		
	}
	
	public int getSizeProgram(){
		return this.numberInstructions;
	}
	
	/**
	 * Metodo encargado de leer el programa, mostrando al usuario el prompt (>) y los mensajes de informacion o error.
	 * @param input
	 */
	public void readProgram(Scanner input){
		
		Instruction ins = null;
		InstructionParser insParser = new InstructionParser() ;
		
			
		System.out.print('>');
		String line = input.nextLine();
		//this.sizeProgram++;
				
		while(!line.equalsIgnoreCase("end")){
			
			ins = insParser.parseProgramInstruction(line);
			if(ins != null){
				this.program[numberInstructions] = ins; 
				this.numberInstructions++;
			}else System.out.println(Constants.INST_ERROR);
			
			System.out.print('>');
			line = input.nextLine();
			//this.sizeProgram++;
		}
	}
	
	public String toString(){
		
		String prog = "El programa introducido es: " + '\n';

		for(int i = 0; i < this.numberInstructions; i++){
			prog = prog + Integer.toString(i) + ": " + program[i].toString() + '\n';
		}
		
		return prog;
	}
	//En el pdf se habla de hacer push() supongo que para manejar el program como una pila, y getSizeProgram(), y utiliza sizeProgram.
	

}
