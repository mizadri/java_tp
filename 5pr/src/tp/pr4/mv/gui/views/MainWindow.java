package tp.pr4.mv.gui.views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;


import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


import tp.pr4.mv.Memory;
import tp.pr4.mv.OperandStack;
import tp.pr4.mv.controllers.Controller;
import tp.pr4.mv.gui.views.swingcomponents.InputPanel;
import tp.pr4.mv.gui.views.swingcomponents.MemoryPanel;
import tp.pr4.mv.gui.views.swingcomponents.OutputPanel;
import tp.pr4.mv.gui.views.swingcomponents.ProgramPanel;
import tp.pr4.mv.gui.views.swingcomponents.StackPanel;
import tp.pr4.mv.gui.views.swingcomponents.StatusBarPanel;
import tp.pr4.mv.gui.views.swingcomponents.ToolBarPanel;
import tp.pr4.mv.instructions.Instruction;
import tp.pr4.mv.observers.CPUObserver;
import tp.pr4.mv.observers.MemoryObserver;
import tp.pr4.mv.observers.Observable;
import tp.pr4.mv.observers.StackObserver;

public class MainWindow extends JFrame implements CPUObserver{//Swing view

	private Observable<CPUObserver> cpu;
	private Observable<StackObserver<Integer>> stack;
	private Observable<MemoryObserver<Integer>> memory;
	private Controller ctrl;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

private ToolBarPanel  toolBar;
private ProgramPanel program;
private StackPanel stackPanel;
private InputPanel iPanel;
private OutputPanel oPanel;
private MemoryPanel memPanel;
private StatusBarPanel statPanel;

public MainWindow(Controller ctrl,
		 Observable<CPUObserver> cpu, 
		 Observable<StackObserver<Integer>> stack, 
		 Observable<MemoryObserver<Integer>> memory){
	super("Virtual Machine");
	this.cpu = cpu;
	this.stack = stack;
	this.memory = memory;
	this.ctrl = ctrl;
	initGUI();
	
	
	this.setPreferredSize(new Dimension(850, 600));
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	pack();
	setLocationRelativeTo(null);
	setVisible(true); 
	cpu.addObserver(this);
}



private void initGUI(){

	program = new ProgramPanel(ctrl, cpu);
	toolBar = new ToolBarPanel(ctrl, cpu);
	statPanel = new StatusBarPanel(stack, memory, cpu);
	stackPanel = new StackPanel(ctrl, stack, cpu);
	iPanel = new InputPanel(ctrl);
	oPanel = new OutputPanel(ctrl);
	memPanel = new MemoryPanel(ctrl, memory, cpu);
	
	
	JPanel mainPanel = new JPanel (new BorderLayout());
	this.setContentPane(mainPanel);
	mainPanel.add(toolBar, BorderLayout.NORTH);
	mainPanel.add(program, BorderLayout.WEST);
	
	JPanel eastPanel = new JPanel();
	JPanel machinePanel = new JPanel();
	JPanel inoutPanel = new JPanel();

	
	machinePanel.setLayout(new GridLayout(1,2));
	machinePanel.add(stackPanel);
	machinePanel.add(memPanel);
	
	inoutPanel.setLayout(new GridLayout(2,1));
	inoutPanel.add(iPanel);
	inoutPanel.add(oPanel);
	
	eastPanel.setLayout(new GridLayout(2,1));
	eastPanel.add(machinePanel);
	eastPanel.add(inoutPanel);
	
	
	add(eastPanel, BorderLayout.CENTER);
	add(statPanel,BorderLayout.SOUTH);
	
	
}


@Override
public void onStartInstrExecution(Instruction ins) {
	// TODO Auto-generated method stub
	
}

@Override
public void onEndInstrExecution(int pc, Memory<Integer> mem, OperandStack<Integer> stack) {
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
	JOptionPane.showMessageDialog(null,title , msg, JOptionPane.ERROR_MESSAGE);	
}

@Override
public void onHalt() {
	int n = JOptionPane.showOptionDialog(new JFrame(),
			"La ejecucion del programa ha finalizado. Desea salir de la ventana?", "Quit",
			JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
			null, null);

	if (n == 0){
		ctrl.quit();	
	}
}

}
