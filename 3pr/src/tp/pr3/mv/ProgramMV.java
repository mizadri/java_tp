package tp.pr3.mv;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import tp.pr3.mv.exceptions.WrongInstructionFormatException;
import tp.pr3.mv.instructions.*;

public class ProgramMV {
	
	static private final int MAX_PROGRAM = 100;
	private Instruction[] program;
	private int numberInstructions;

	
	public ProgramMV(){
		program = new Instruction[MAX_PROGRAM];
		this.numberInstructions = 0;
		
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
		
		System.out.println("Introduce el programa fuente ");
		System.out.print('>');
		String line = input.nextLine();
		
				
		while(!line.equalsIgnoreCase("end")){
			
			try{
				ins = insParser.parseProgramInstruction(line);
				this.program[numberInstructions] = ins; 
				this.numberInstructions++;
				
			}
			catch(WrongInstructionFormatException e){
				System.err.println("Error en el formato de la instruccion: "+ line);
			}
			catch (NumberFormatException e){
				System.err.println("Error en el parametro de la instruccion(int mal introducido): "+ line);
			}
			System.out.print('>');
			line = input.nextLine();
			
		}
	}
	
	/**
	 * Metodo encargado de leer el programa de un archivo con nombre dado
	 * @param fname
	 */
	public void readProgram(String fname) throws IOException{
		Instruction ins = null;
		InstructionParser insParser = new InstructionParser();
		Scanner s = null;
		
		try{
			
			s = new Scanner(new FileReader(fname));
			
			while (s.hasNext()) {
				String line = s.nextLine();
				
				String[] aux = line.split(";");
				
				if(aux.length != 0){
					if(aux[0].length()!=0){ 
						
						//comprueba que pueda ser: "push 6" || "push 6 ;esto es un push"
						//ninguna linea que no tenga aux[0] distinto de 0 puede ser una instruccion
						
						try{
							ins = insParser.parseProgramInstruction(aux[0]);
							this.program[numberInstructions] = ins;
							this.numberInstructions++;	
						}
						catch(WrongInstructionFormatException e){
							System.err.println("Error en el programa: "+ aux[0]);
							System.exit(1);
						}					
					}//no hay ; o hay 1, ademas hay contenido a la izda del ;
				}//linea vacia				
			}		
		
		}
		catch(FileNotFoundException e) {
			System.err.println("Uso incorrecto: Error al acceder al fichero ASM ("+ fname +")");
			System.exit(2);
		}
		finally{
			s.close();
		}
		
		}
	
	public String toString(){
		
		String prog = "El programa introducido es: " + '\n';

		for(int i = 0; i < this.numberInstructions; i++){
			prog = prog + Integer.toString(i) + ": " + program[i].toString() + '\n';
		}
		
		return prog;
	}
	
	

}
