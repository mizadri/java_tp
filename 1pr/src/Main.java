package tp.pr1.mv;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
	CPU cpu = new CPU();
	InstructionParser parser = new InstructionParser();
	Instruction instruction;
	
	while(!cpu.isFinished()){
		System.out.print("Instruccion a ejecutar: ");	
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String cadena = sc.nextLine();
		
		instruction = parser.parse(cadena); 
		if(instruction==null){
			System.out.println("Error: Instrucción incorrecta");
		}else{
			
			System.out.println("Comienza la ejecucion de "+ instruction.getType().toString().toUpperCase());
			cpu.execute(instruction);
			System.out.println("El estado de la maquina tras ejecutar la instrucción es:");
			System.out.println(cpu.toString());
			
			}
		
		}

 	
	}
	
	
}
