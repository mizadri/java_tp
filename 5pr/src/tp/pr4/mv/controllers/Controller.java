package tp.pr4.mv.controllers;

import tp.pr4.mv.CPU;
import tp.pr4.mv.ProgramMV;
import tp.pr4.mv.exceptions.EmptyStackAcces;
import tp.pr4.mv.exceptions.InstructionExecutionException;
import tp.pr4.mv.exceptions.MVException;
import tp.pr4.mv.inout.InStrategy;
import tp.pr4.mv.inout.OutStrategy;

abstract public class Controller {
	private CPU cpu;
	
	public Controller (CPU cpu){
		this.cpu = cpu;
	}
	
	public void step(){
		try {
			cpu.step();
		} catch (InstructionExecutionException e) {
		
		} catch (EmptyStackAcces e) {
	
		}
	}
	public void stepn(int n) {
		for(int i = 0; i<n; i++){
			try {
				cpu.step();
			} catch (InstructionExecutionException e) {
				
			} catch (EmptyStackAcces e) {
			
			}
		}
	} 

	public void run() {
		try {
			cpu.run();
		} catch (InstructionExecutionException e) {
			
		} catch (EmptyStackAcces e) {
			
		}
	} 
	
	public void pop() {
		try {
			cpu.pop();
		} catch (EmptyStackAcces e) {
	
		}
		
	}
	
	public void push(int v) {
		cpu.push(v);
	} 

	public void write(int i, int v) {
		try {
			cpu.write(i, v);
		} catch (InstructionExecutionException e) {
		
		}
	} 

	public ProgramMV getProgram() {
		return cpu.getProgram();
	} // devuelve el programa actual

	public void setInStrat(InStrategy s) {
		try {
			CPU.setInStrat(s);
		} catch (MVException e) {
			
		}
	} 

	public void setOutStrat(OutStrategy out) {
		
		try {
			CPU.setOutStrat(out);
		} catch (MVException e) {
			
		}
	} 
	
	public OutStrategy getOutStrat() {
		return CPU.getOutStrat();
	} 
	
	public InStrategy getInStrat(){
		return CPU.getInStrat();
	}
//	public void pause() {
//	} // ejecuta el pause del cpu(opcional)

	public abstract void start(); // un método abstracto, depende del modo 
									

	public void quit() {
		CPU.getOutStrat().close();
		CPU.getInStrat().close();
		System.exit(0);
	}
}
