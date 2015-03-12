package tp.pr4.mv.gui.views.swingcomponents;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

import tp.pr4.mv.Memory;
import tp.pr4.mv.OperandStack;
import tp.pr4.mv.ProgramMV;
import tp.pr4.mv.controllers.Controller;
import tp.pr4.mv.instructions.Instruction;
import tp.pr4.mv.observers.CPUObserver;
import tp.pr4.mv.observers.Observable;


public class ProgramPanel extends JPanel implements CPUObserver{
/**
	 * 
	 */
private static final long serialVersionUID = 1L;
private Controller ctrl;
private Observable<CPUObserver> cpu;

private JTextArea programTextArea;
private ProgramMV prog;
private int pc;

public ProgramPanel(Controller ctrl, Observable<CPUObserver> cpu) {
	this.ctrl = ctrl;
	this.cpu = cpu;
	initGUI();
	
}

private void initGUI(){
	cpu.addObserver(this);
	prog = ctrl.getProgram();
	pc = 0;
	
	this.setLayout(new BorderLayout());
	this.setBorder(new TitledBorder("Program"));
	programTextArea = new JTextArea(20,18);
	
	programTextArea.setFont(new Font("Courier", Font.PLAIN, 16));
	programTextArea.setEditable(false);
	this.add(new JScrollPane(programTextArea));
	showProgram();
}

	private void showProgram() {
		String instructions = "";
		for(int i = 0; i < prog.getSizeProgram(); i++){
			if(i == this.pc)
				instructions = instructions + " * " + Integer.toString(i) + ": " + this.prog.getInstructionAt(i).toString() + '\n';
			else instructions = instructions +"   " +  Integer.toString(i) + ": " + this.prog.getInstructionAt(i).toString() + '\n';
		}
		
		this.programTextArea.setText(instructions);
		this.repaint();
	}


	@Override
	public void onStartInstrExecution(Instruction ins) {
		showProgram();
	
	}

	@Override
	public void onEndInstrExecution(int pc, Memory<Integer> mem, OperandStack<Integer> stack) {
	this.pc = pc;
	}

	@Override
	public void onStartRun() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onEndRun() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onError(String msg, String title) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onHalt() {
		// TODO Auto-generated method stub
		
	}
}
