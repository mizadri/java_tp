package tp.pr3.mv;


import java.io.IOException;
import java.util.Scanner;

import org.apache.commons.cli.*;

import tp.pr3.mv.commands.*;
import tp.pr3.mv.exceptions.CommandExecutionException;
import tp.pr3.mv.exceptions.InstructionExecutionException;
import tp.pr3.mv.exceptions.LethalJumpsException;
import tp.pr3.mv.exceptions.WrongCommandFormatException;
import tp.pr3.mv.inout.InStrategyFile;
import tp.pr3.mv.inout.InStrategyNada;
import tp.pr3.mv.inout.InStrategyStd;
import tp.pr3.mv.inout.OutStrategyFile;
import tp.pr3.mv.inout.OutStrategyNada;
import tp.pr3.mv.inout.OutStrategyStd;
import tp.pr3.mv.instructions.Instruction;
import tp.pr3.mv.instructions.restSeq.Halt;
/**
 * Clase principal que ejecuta el programa.
 * @author Adrian Garcia y Omar Gaytan
 *
 */
public class Main {

	public static void main(String[] args) {
	
	//----------------------------------------Codigo para configurar el uso de la Commons CLI----------------------------------------
	CommandLineParser parser = new BasicParser();
	CommandLine cmdLine = null;
	
	Options options = new Options();

	options.addOption("a", "asm", true, "Fichero con el codigo en ASM del programa a ejecutar. Obligatorio en modo batch.");
	options.addOption("h", "help", false, "Muestra esta ayuda");
	options.addOption("i", "in", true, "Entrada del programa de la maquina-p.");
	options.addOption("o", "out", true , "Fichero donde se guarda la salida del programa de la maquina-p.");
	options.addOption("m", "mode", true, "Modo de funcionamiento (batch | interactive). Por defecto, batch.");
	//----------------------------------------Codigo para configurar el uso de la Commons CLI----------------------------------------
	
	//---Strings usados para almacenar valores del modo de ejecucion---
	String asmFileName = null;
	String inFileName = null;
	String modeName = null;
	String outFileName = null;
	//---Strings usados para almacenar valores del modo de ejecucion---
	
	Scanner sc = new Scanner(System.in);//(Colocado aqui para cerrarlo en el finally)Usado en caso de leer programa de entrada y para leer comandos.
	
	MVSystem.in = new InStrategyNada();
	 MVSystem.out = new OutStrategyNada();
	
	// ------------------CODIGO main--------------
	try {

		// ----------------------------------------------------------------------------------------------
		// --You can modify the start options in cmd or in Eclipse->Run->Run Counfigurations->Arguments--
		// ----------------------------------------------------------------------------------------------
		parser = new BasicParser();
		cmdLine = parser.parse(options, args);
		if (cmdLine.hasOption("h")) {
			System.out.println("Execute this assignment with these parameters:");
			new HelpFormatter().printHelp(Main.class.getCanonicalName()+ "  [-a <asmfile>] [-h] [-i <infile>] [-m <mode>] [-o <outfile>]", options);
		} else {
		
			
			//---------------------------TRATAMIENTO DE IN(String inFileName)---------------------------
				if(cmdLine.hasOption("i")||cmdLine.hasOption("in")){
					
					if (cmdLine.hasOption("i"))	inFileName = cmdLine.getOptionValue("i");
					else if (cmdLine.hasOption("in")) inFileName = cmdLine.getOptionValue("in");
					
					if(inFileName==null){
						System.err.println("Uso incorrecto: Fichero IN no especificado.");
						System.err.println("Use -h|--help para mas detalles.");
						System.exit(1);
					}else if(inFileName.equalsIgnoreCase("std")){
						MVSystem.in = new InStrategyStd();
					}else MVSystem.in = new InStrategyFile(inFileName);
					
				} 
				
				MVSystem.in.open();
			//---------------------------TRATAMIENTO DE IN(String inFileName)---------------------------
			//---------------------------TRATAMIENTO DE OUT(String outFileName)---------------------------
				
				if(cmdLine.hasOption("o")||cmdLine.hasOption("out")){
					
					if (cmdLine.hasOption("o"))	outFileName = cmdLine.getOptionValue("o");
					else if (cmdLine.hasOption("out")) outFileName = cmdLine.getOptionValue("out");
					
					if(outFileName==null){
						System.err.println("Uso incorrecto: Fichero OUT no especificado.");
						System.err.println("Use -h|--help para mas detalles.");
						System.exit(1);
					}else if(outFileName.equalsIgnoreCase("std")){
					
					MVSystem.out = new OutStrategyStd();
					
					}else MVSystem.out = new OutStrategyFile(outFileName);
					
					}
				
				try {
					MVSystem.out.open();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			//---------------------------TRATAMIENTO DE OUT(String outFileName)---------------------------
			
				
				ProgramMV prog = new ProgramMV();
				CPU cpu = new CPU();
				
			//--------------------------TIPO DE LECTURA DE PROGRAMA---------------------------------------	
				boolean isBatch = true;
				if(cmdLine.hasOption("m")||cmdLine.hasOption("mode")){
					if (cmdLine.hasOption("m"))	modeName = cmdLine.getOptionValue("m");
					else if (cmdLine.hasOption("mode")) modeName = cmdLine.getOptionValue("mode");
					
					
					
					if(modeName == null){
						System.err.println("Uso incorrecto: Modo de ejecucion no especificado.");
						System.err.println("Use -h|--help para mas detalles.");
						System.exit(1);
					}else if(modeName.equalsIgnoreCase("interactive")||modeName.equalsIgnoreCase("batch")){
						if(modeName.equalsIgnoreCase("interactive"))isBatch=false;	
						
					}else {
						System.err.println("Uso incorrecto: Modo incorrecto (parametro -m|--mode)");
						System.err.println("Use -h|--help para mas detalles.");
						System.exit(1);
					} 
				}
				//--------------------------TIPO DE LECTURA DE PROGRAMA---------------------------------------	
				
				
				//---------------------------TIPO DE LECTURA DE PROGRAMA(String asmFileName)---------------------------
				
				if(cmdLine.hasOption("a")||cmdLine.hasOption("asm")){
					if (cmdLine.hasOption("a"))	asmFileName = cmdLine.getOptionValue("a");
					else if (cmdLine.hasOption("asm")) asmFileName = cmdLine.getOptionValue("asm");
					
					if(asmFileName==null){
						System.err.println("Uso incorrecto: Fichero OUT no especificado.");
						System.err.println("Use -h|--help para mas detalles.");
						System.exit(1);
					}
					
					try {
						prog.readProgram(asmFileName);
					} catch (IOException e) {
						e.printStackTrace();
					} 
					
				}else{
					prog.readProgram(sc);	
				}	
				//---------------------------TIPO DE LECTURA DE PROGRAMA---------------------------	
				//El programa ya ha sido cargado en prog siguiendo una de las dos formas posibles
				
				cpu.loadProgram(prog);
				
				
				
				if(isBatch){
					//------------------------------CODIGO BATCH------------------------------------
					
					Instruction ins = new Halt();
					while( ins != null && !cpu.abortComputation()){
						
						try{
							cpu.step();
							ins = cpu.getCurrentInstruction();
						}catch (InstructionExecutionException e){
							System.err.println( e.getMessage() + ": " + ins.toString());
							sc.close(); 
							MVSystem.in.close(); 
							MVSystem.out.close();
							System.exit(2);
						}
						
						ins = cpu.getCurrentInstruction();
					}
					//------------------------------CODIGO BATCH------------------------------------
				}else{
					//------------------------------CODIGO INTERACTIVA------------------------------
					System.out.println(prog.toString());//Muestra el programa leido.
					CommandInterpreter.configureCommandInterpreter(cpu);
					CommandInterpreter cmd;
					CommandParser cmdParser = new CommandParser();	//solo en instruccion interactiva
					do{
							
						System.out.print('>');
						String line = sc.nextLine();
						try{
							cmd = cmdParser.parseProgramCommand(line); //throws cmdWF
							cmd.executeCommand();					   //throws cmdWExe,insWExe
						}
						catch (WrongCommandFormatException e){
							System.err.println(e.getMessage());
						}
						catch (CommandExecutionException e){
							System.err.println(e.getMessage());
						}
						catch (LethalJumpsException e){
							System.err.println(e.getMessage());
							sc.close();
							MVSystem.in.close(); 	
							MVSystem.out.close(); 
							System.exit(2);
						}
						catch (InstructionExecutionException e) {
							System.err.println(e.getMessage());
						}
						
						
					}while(!CommandInterpreter.isFinished()&&!cpu.abortComputation());
					
					//------------------------------CODIGO INTERACTIVA------------------------------
				}
		
		
		}//fin de else(parametro distinto a help)
		

	} 
	catch (org.apache.commons.cli.ParseException ex) {
		System.err.println("Error: Invalid usage: "+ ex.getMessage() +". Use --help for more information");
		System.exit(1);
	} 
	catch (java.lang.NumberFormatException ex) {
		new HelpFormatter().printHelp(Main.class.getCanonicalName(),options);
	}
	finally{
		sc.close();
		MVSystem.in.close();
		MVSystem.out.close();
		
	}
	//------------------------------CODIGO main------------------------------
	
	}
	

}
