package tp.pr4.mv.gui.views.swingcomponents;



import java.awt.Color;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import tp.pr4.mv.Memory;
import tp.pr4.mv.OperandStack;
import tp.pr4.mv.instructions.Instruction;
import tp.pr4.mv.observers.CPUObserver;
import tp.pr4.mv.observers.MemoryObserver;
import tp.pr4.mv.observers.Observable;
import tp.pr4.mv.observers.StackObserver;

public class StatusBarPanel extends JPanel implements StackObserver<Integer>,
		MemoryObserver<Integer>, CPUObserver {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Observable<StackObserver<Integer>> stack;
	private Observable<MemoryObserver<Integer>> memory;
	private Observable<CPUObserver> cpu;
	
	private int countInstructions;
	private JLabel estado;
	private JLabel numInstructions;
	private JCheckBox pila;
	private JLabel pilaLab;
	private JCheckBox memoria;
	private JLabel memoriaLab;

	public StatusBarPanel(Observable<StackObserver<Integer>> stack,
			Observable<MemoryObserver<Integer>> memory,
			Observable<CPUObserver> cpu) {
		this.stack = stack;
		this.memory = memory;
		this.cpu = cpu;
			initGUI();
	}

	public void initGUI(){
		countInstructions = 0;
		stack.addObserver(this);
		memory.addObserver(this);
		cpu.addObserver(this);
		
		
		numInstructions = new JLabel("Nº instrucciones ejecutadas: 0");
		pila = new JCheckBox();
		pilaLab = new JLabel("Pila modificada");
		memoria = new JCheckBox();
		memoriaLab = new JLabel("Memoria modificada");
		estado = new JLabel("Maquina en ejecucion");
		estado.setForeground(Color.GREEN);
		estado.setOpaque(true);
		
		this.add(estado);
		this.add(numInstructions);
		this.add(pila);
		this.add(pilaLab);
		this.add(memoria);
		this.add(memoriaLab);
	}
	@Override
	public void onStartInstrExecution(Instruction ins) {
		countInstructions++;
		numInstructions.setText("Nº instrucciones ejecutadas: "+this.countInstructions);

	}

	@Override
	public void onEndInstrExecution(int pc, Memory<Integer> mem,
			OperandStack<Integer> stack) {
		// TODO Auto-generated method stub

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
		estado = new JLabel("Maquina finalizada");
		estado.setForeground(Color.RED);
		estado.setOpaque(true);
	}

	@Override
	public void onWrite(int index, Integer value) {
		// TODO Auto-generated method stub

		if(!memoria.isSelected())memoria.doClick();
	
	}

	@Override
	public void onPush(Integer value) {
		// TODO Auto-generated method stub
		if(!pila.isSelected())pila.doClick();
	}

	@Override
	public void onPop(Integer value) {
		// TODO Auto-generated method stub
		
	}
}