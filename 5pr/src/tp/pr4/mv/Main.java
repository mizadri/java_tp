package tp.pr4.mv;


import java.io.IOException;
import java.util.Scanner;

import org.apache.commons.cli.*;

import tp.pr4.mv.commands.*;
import tp.pr4.mv.controllers.BatchController;
import tp.pr4.mv.controllers.Controller;
import tp.pr4.mv.controllers.GUIController;
import tp.pr4.mv.controllers.InteractiveController;
import tp.pr4.mv.exceptions.*;
import tp.pr4.mv.gui.views.BatchView;
import tp.pr4.mv.gui.views.InteractiveView;
import tp.pr4.mv.gui.views.MainWindow;
import tp.pr4.mv.inout.*;
import tp.pr4.mv.observers.Observable;
import tp.pr4.mv.observers.StackObserver;

/**
 * Clase principal que ejecuta el programa.
 * @author Adrian Garcia y Omar Gaytan
 *
 */
public class Main {
	private static final int _BATCH_MODE = 0;
	private static final int _INTER_MODE = 1;
	private static final int _WINDOW_MODE = 2;
	private static int exeMode = _INTER_MODE;
	
	private static String asmFileName = null;
	private static String inFileName = null;
	private static String modeName = null;
	private static String outFileName = null;
	
	private static CommandLine cmdLine = null;
	
	private static CPU cpu;
	private static ProgramMV prog;
	private static Scanner sc;
	
	public static void main(String[] args) {
	
	//----------------------------------------Codigo para configurar el uso de la Commons CLI----------------------------------------
	CommandLineParser parser = new BasicParser();
	
	Options options = new Options();

	options.addOption("a", "asm", true, "Fichero con el codigo en ASM del programa a ejecutar. Obligatorio en modo batch.");
	options.addOption("h", "help", false, "Muestra esta ayuda");
	options.addOption("i", "in", true, "Entrada del programa de la maquina-p.");
	options.addOption("o", "out", true , "Fichero donde se guarda la salida del programa de la maquina-p.");
	options.addOption("m", "mode", true, "Modo de funcionamiento (batch | interactive). Por defecto, batch.");
	// ------------------CODIGO main--------------
	sc = new Scanner(System.in);//(Colocado aqui para cerrarlo en el finally)Usado en caso de leer programa de entrada y para leer comandos.
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
			
			cpu = new CPU();
			prog = new ProgramMV();
		
			defineInMethod();
			defineOutMethod();
			defineMode();
			defineProgramReading();	
			
			cpu.loadProgram(prog);
			
			CPU.getInStrat().open();
			try {
				CPU.getOutStrat().open();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
				
			switch(exeMode){
			case _BATCH_MODE:
				exeBatch();break;
			case _INTER_MODE:
				exeInteractive();break;
			case _WINDOW_MODE:
				exeWindow();break;
			}
		}//end else(parametro distinto a help)
		

	} 
	catch (org.apache.commons.cli.ParseException ex) {
		System.err.println("Error: Invalid usage: "+ ex.getMessage() +". Use --help for more information");
		System.exit(1);
	} 
	catch (java.lang.NumberFormatException ex) {
		new HelpFormatter().printHelp(Main.class.getCanonicalName(),options);
	}
	finally{
		if(exeMode != _WINDOW_MODE){
		sc.close();
		CPU.getInStrat().close();
		CPU.getOutStrat().close();	
		}
	
	}

	}//end main
	
	/**
	 * Ejecuta la MV en el modo Batch.
	 */
	@SuppressWarnings("unused")
	public static void exeBatch(){
		
		BatchController ctrl = new BatchController(cpu);
		BatchView view = new BatchView(cpu);
		ctrl.start();
		
	}
	
	/**
	 * Ejecuta la MV en el modo interactivo.
	 */
	@SuppressWarnings("unused")
	public static void exeInteractive(){
		System.out.println(prog.toString());
		System.out.print('>');
		CommandInterpreter.configureCommandInterpreter(cpu);
		
		InteractiveController ctrl = new InteractiveController(cpu);
		InteractiveView view = new InteractiveView(cpu);
		ctrl.start();
	
	}
	

	/**
	 * Ejecuta la MV en el modo ventana.
	 */
	@SuppressWarnings("unused")
	public static void exeWindow(){
		Observable<StackObserver<Integer>> stack = null ;
		Controller ctrl = new GUIController(cpu);
		MainWindow mwindow = new MainWindow(ctrl, cpu, cpu.getOperandStack(),cpu.getMemory());
		ctrl.start();
	}
	
	/**
	 * Define el modo de entrada de la MV.
	 */
	private static void defineInMethod(){
		try {
			CPU.setInStrat(new InStrategyNada());
			CPU.setOutStrat(new OutStrategyNada());
		} catch (MVException e) {
			System.err.println(e.getMessage());
		}
		
		if(cmdLine.hasOption("i")||cmdLine.hasOption("in")){
			
			if (cmdLine.hasOption("i"))	inFileName = cmdLine.getOptionValue("i");
			else if (cmdLine.hasOption("in")) inFileName = cmdLine.getOptionValue("in");
			
			if(inFileName==null){
				System.err.println("Uso incorrecto: Fichero IN no especificado.");
				System.err.println("Use -h|--help para mas detalles.");
				System.exit(1);
			}else if(inFileName.equalsIgnoreCase("std")){
				try {
					CPU.setInStrat(new InStrategyStd());
				} catch (MVException e) {
					System.err.println(e.getMessage());
				}
			}else {
				try {
					CPU.setInStrat(new InStrategyFile(inFileName));
				} catch (MVException e) {
					System.err.println(e.getMessage());
				}
			}	
		} 
		
	
	}
	
	/**
	 * Define el metodo de salida de la MV.
	 */
	private static void defineOutMethod(){
		if(cmdLine.hasOption("o")||cmdLine.hasOption("out")){
			
				if (cmdLine.hasOption("o"))	outFileName = cmdLine.getOptionValue("o");
				else if (cmdLine.hasOption("out")) outFileName = cmdLine.getOptionValue("out");
				
				if(outFileName==null){
					System.err.println("Uso incorrecto: Fichero OUT no especificado.");
					System.err.println("Use -h|--help para mas detalles.");
					System.exit(1);
				}else if(outFileName.equalsIgnoreCase("std")){
				
					try {
						CPU.setOutStrat(new OutStrategyStd());
					} catch (MVException e) {
						System.err.println(e.getMessage());
					}
				
				}else {
					try {
						CPU.setOutStrat(new OutStrategyFile(outFileName));
					} catch (MVException e) {
						System.err.println(e.getMessage());
					} 
				}
			
			}
	
	}
	
	/**
	 * Define el modo de ejecucion de la MV.
	 */
	private static void defineMode(){
		
		if(cmdLine.hasOption("m")||cmdLine.hasOption("mode")){
			
			if (cmdLine.hasOption("m"))	modeName = cmdLine.getOptionValue("m");
			else if (cmdLine.hasOption("mode")) modeName = cmdLine.getOptionValue("mode");

			if(modeName == null){
				System.err.println("Uso incorrecto: Modo de ejecucion no especificado.");
				System.err.println("Use -h|--help para mas detalles.");
				System.exit(1);
			}else if(modeName.equalsIgnoreCase("interactive")||modeName.equalsIgnoreCase("batch")||modeName.equalsIgnoreCase("window")){
				
				if(modeName.equalsIgnoreCase("batch")){
					exeMode = _BATCH_MODE;
					
					if(inFileName == null){
						try {
							CPU.setInStrat(new InStrategyStd());
							} catch (MVException e) {
							System.err.println(e.getMessage());
						}
					}
					if(outFileName == null){
						try {
							CPU.setOutStrat(new OutStrategyStd());
							} catch (MVException e) {
							System.err.println(e.getMessage());
						}
					}
				}
				else if(modeName.equalsIgnoreCase("window")) exeMode = _WINDOW_MODE;
				
				
			}else {
				System.err.println("Uso incorrecto: Modo incorrecto (parametro -m|--mode)");
				System.err.println("Use -h|--help para mas detalles.");
				System.exit(1);
			} 
		}
	}
	
	/**
	 * Define el tipo de lectura de programa.
	 */
	public static void defineProgramReading(){
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
			} catch(WrongInstructionFormatException e){
				System.err.println(e.getMessage());
				System.exit(1);
			}	
			
		}else{
			if(exeMode == _BATCH_MODE){
				System.err.println("Uso incorrecto: En modo Batch es necesario especificar fichero de programa ASM");
				System.exit(1);
			}
			prog.readProgram(sc);	
		}	
	}
	
}
