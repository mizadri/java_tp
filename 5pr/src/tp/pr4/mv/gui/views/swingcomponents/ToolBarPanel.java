package tp.pr4.mv.gui.views.swingcomponents;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import tp.pr4.mv.Memory;
import tp.pr4.mv.OperandStack;
import tp.pr4.mv.controllers.Controller;
import tp.pr4.mv.instructions.Instruction;
import tp.pr4.mv.observers.CPUObserver;
import tp.pr4.mv.observers.Observable;

	public class ToolBarPanel extends JPanel implements CPUObserver{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private Controller ctrl;
		private JButton runButton;
		private JButton exitButton;
		private JButton stepButton;
		
		private Observable<CPUObserver> cpu;
	

		public ToolBarPanel(Controller ctrl, Observable<CPUObserver> cpu) {
			this.ctrl = ctrl;
			this.cpu = cpu;
			initGUI();
		}

		private void initGUI(){
			cpu.addObserver(this);
			this.setBorder(new TitledBorder ("Actions"));
			
			stepButton = new JButton();
			stepButton.setIcon(createImageIcon("step.png"));
			stepButton.setToolTipText("Step");
			this.add(stepButton);
			stepButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					ctrl.step();
				}
			});
			runButton = new JButton();
			runButton.setIcon(createImageIcon("run.png"));
			runButton.setToolTipText("Run");
			this.add(runButton);
			runButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					ctrl.run();
				}
			});
			exitButton = new JButton();
			exitButton.setIcon(createImageIcon("exit.png"));
			exitButton.setToolTipText("Exit");
			this.add(exitButton);
			exitButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					int n = JOptionPane.showOptionDialog(new JFrame(),
							"¿Desea finalizar la máquina virtual?", "Quit",
							JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
							null, null);

					if (n == 0){
						ctrl.quit();	
					}
					
				}
			});
		}


		private static ImageIcon createImageIcon(String path){
			java.net.URL imgURL = ToolBarPanel.class.getResource(path);
			if(imgURL != null) return new ImageIcon(imgURL);
			else return null;
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
		   this.stepButton.setEnabled(false);
		   this.runButton.setEnabled(false);
		}

		@Override
		public void onEndRun() {
		
		
		}

		@Override
		public void onError(String msg, String title) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onHalt() {
			this.stepButton.setEnabled(false);
			this.runButton.setEnabled(false);
		}

}