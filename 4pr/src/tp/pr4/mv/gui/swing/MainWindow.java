package tp.pr4.mv.gui.swing;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import tp.pr4.mv.CPU;

public class MainWindow extends JFrame {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private CPU cpu;
private ToolBarPanel  toolBar;
private ProgramPanel program;
private StackPanel stack;
private InputPanel iPanel;
private OutputPanel oPanel;
private MemoryPanel memPanel;
private GUIControler guiCtrl;

public MainWindow(CPU cpu){
	super("Virtual Machine");
	this.cpu = cpu;
	initGUI();
	updateView();
	
	this.setPreferredSize(new Dimension(850, 600));
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	pack();
	setLocationRelativeTo(null);
	setVisible(true); 
}

private void initGUI(){
	guiCtrl = new GUIControler(cpu, this);
	toolBar = new ToolBarPanel(guiCtrl);
	program = new ProgramPanel(guiCtrl);
	stack = new StackPanel(guiCtrl);
	iPanel = new InputPanel(guiCtrl);
	oPanel = new OutputPanel(guiCtrl);
	memPanel = new MemoryPanel(guiCtrl);
	
	
	JPanel mainPanel = new JPanel (new BorderLayout());
	this.setContentPane(mainPanel);
	mainPanel.add(toolBar, BorderLayout.NORTH);
	mainPanel.add(program, BorderLayout.WEST);
	
	JPanel eastPanel = new JPanel();
	JPanel machinePanel = new JPanel();
	JPanel inoutPanel = new JPanel();
	
	machinePanel.setLayout(new GridLayout(1,2));
	machinePanel.add(stack);
	machinePanel.add(memPanel);
	
	inoutPanel.setLayout(new GridLayout(2,1));
	inoutPanel.add(iPanel);
	inoutPanel.add(oPanel);
	
	eastPanel.setLayout(new GridLayout(2,1));
	eastPanel.add(machinePanel);
	eastPanel.add(inoutPanel);
	
	this.add(eastPanel, BorderLayout.CENTER);
	
}
public void disableGUI(){
	this.toolBar.disableGUI();
}

void updateView(){
	program.updateView();
	stack.updateView();
	memPanel.updateView();
}

}
