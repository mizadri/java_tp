package tp.pr4.mv.gui.swing;

import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import tp.pr4.mv.CPU;
import tp.pr4.mv.Memory;
import tp.pr4.mv.ProgramMV;
import tp.pr4.mv.exceptions.EmptyStackAcces;
import tp.pr4.mv.exceptions.InstructionExecutionException;
import tp.pr4.mv.exceptions.MVException;
import tp.pr4.mv.inout.InStrategy;
import tp.pr4.mv.inout.OutStrategy;

public class GUIControler {
	private CPU cpu;
	private MainWindow gui;
	public GUIControler(CPU cpu, MainWindow gui){
		this.cpu = cpu;
		this.gui = gui;
	}

	public int getMemoryRows(){
		return cpu.totalPos();
	}

	private void reportError(String msg, String title){
			JOptionPane.showMessageDialog(null, msg, title, JOptionPane.ERROR_MESSAGE);
	}

	public void step(){
		if(!cpu.abortComputation()){
			try {
				cpu.step();
			} catch (InstructionExecutionException e) {
				reportError(e.getMessage(), "Error");
			} catch (EmptyStackAcces e) {
				reportError("Pila vacia", "Error");
			}
			gui.updateView();
		}
			if(cpu.abortComputation()){
			CPU.getInStrat().close(); 
			CPU.getOutStrat().close();
			
			this.gui.disableGUI();
			}
		
		
	}

	public void run(){
		if(!cpu.abortComputation()){
		try {
			cpu.run();
		} catch (InstructionExecutionException e) {
			reportError(e.getMessage(), "Error");
		} catch (EmptyStackAcces e) {
			reportError("Pila vacia", "Error");
		}
		gui.updateView();
		}
			CPU.getInStrat().close(); 
			CPU.getOutStrat().close();
			
			this.gui.disableGUI();
		
		
	}

	public void pop(){
		if(!cpu.abortComputation()){
		try {
			cpu.pop();
		} catch (EmptyStackAcces e) {
			reportError("Pila vacia", "Error");
		}
		gui.updateView();
		}
	}

	public void push(String s){
		if(!cpu.abortComputation()){
			try{
			cpu.push(Integer.parseInt(s));
			}catch(NumberFormatException e){
				this.reportError(e.getMessage()+": Se esperaba un numero", "Error" );
			}
			gui.updateView();
		}
	}

	public void write(String text, String text2) {
		if(!cpu.abortComputation())	{
			try {
			int pos = Integer.parseInt(text);
			int val = Integer.parseInt(text2);
			cpu.write(pos, val);
					}catch(NumberFormatException e){
						this.reportError(e.getMessage() + ": Se esperaba un numero", "Error");
					}
			gui.updateView();
		}
		
	}
	public void quit(){
		int n = JOptionPane.showOptionDialog(new JFrame(),
				"¿Desea finalizar la máquina virtual?", "Quit",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
				null, null);

		if (n == 0){
		CPU.getInStrat().close(); 
		CPU.getOutStrat().close();
		System.exit(0);	
		}
			
	}

	public void memorySet(String n1, String n2){
         
	}

	public int getPC(){
		return cpu.getPC();
	}


	
		public void setInStream(InStrategy in){
			try {
				CPU.setInStrat(in);
			} catch (MVException e) {
				e.printStackTrace();
			}
	}

	
	
		public void setOutStream(OutStrategy out){
			try {
				CPU.setOutStrat(out);
			} catch (MVException e) {
				e.printStackTrace();
			}
	}


	
		public InStrategy getInStream(){
			return CPU.getInStrat();
	}


	
		public OutStrategy getOutStream(){
			return CPU.getOutStrat();
	}

	public ProgramMV getProgram(){
          return cpu.getProgram();
	}

	public Stack<Integer> getOperandStack(){
         return cpu.getOperandStack();

	}
	
	 public String updatePPanel(){
		  return cpu.showInstructions();
		 }

	public Memory<Integer> getMemory(){
		return cpu.getMemory();
	}

	public boolean abortComputation() {
		return cpu.abortComputation();
	}

	
}
