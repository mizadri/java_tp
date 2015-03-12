package tp.pr4.mv.gui.views.swingcomponents;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import tp.pr4.mv.Memory;
import tp.pr4.mv.OperandStack;
import tp.pr4.mv.controllers.Controller;
import tp.pr4.mv.instructions.Instruction;
import tp.pr4.mv.observers.CPUObserver;
import tp.pr4.mv.observers.Observable;
import tp.pr4.mv.observers.StackObserver;



	public class StackPanel extends JPanel  implements StackObserver<Integer>, CPUObserver{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		private Controller ctrl;
		private Observable<StackObserver<Integer>> stack;
		private Observable<CPUObserver> cpu;
		
		private JList<Integer> stackArea;
		private JTextField tStackElem;
		private JLabel lDato;
		private JButton bPush;
		private JButton bPop;
		private DefaultListModel<Integer> model;

		


		public StackPanel(Controller ctrl,
				Observable<StackObserver<Integer>> stack,
				Observable<CPUObserver> cpu) {
			this.stack = stack;
			this.ctrl = ctrl;
			this.cpu = cpu;
			initGUI();
		
		
		}

		private void initGUI(){
			stack.addObserver(this);
			cpu.addObserver(this);
		
			
			this.setBorder(new TitledBorder("Stack"));
			this.setLayout(new BorderLayout());
			
			model = new DefaultListModel<Integer>();
			stackArea = new JList<Integer>(model);
			lDato = new JLabel("Value: ");
			
			tStackElem = new JTextField(5);
			tStackElem.setName("TextoVal");
			
			bPush = new JButton("Push");
			bPush.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String s = null;
					try{
					s = tStackElem.getText();
					ctrl.push(Integer.parseInt(s));
					}catch(NumberFormatException e){
						JOptionPane.showMessageDialog(null, e.getMessage(), "Tipo de datos incorrecto", JOptionPane.ERROR_MESSAGE);
					}
				
				}
			});
			bPop = new JButton("Pop");
			bPop.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					ctrl.pop();
				}
			});
			
			JPanel bot = new JPanel();
			JPanel buttons = new JPanel();
			JPanel topbuttons = new JPanel();
			JPanel botbuttons = new JPanel();
			
			buttons.setLayout(new GridLayout(2,1));
			bot.setLayout(new BorderLayout());
			
			buttons.add(lDato);
			buttons.add(tStackElem);
			buttons.add(bPush);
			buttons.add(bPop);
			
			bot.add(new JScrollPane(stackArea), BorderLayout.CENTER);
			topbuttons.add(lDato);
			topbuttons.add(tStackElem);
			topbuttons.add(bPush);
			topbuttons.add(bPop);

			buttons.add(topbuttons);
			buttons.add(botbuttons);
			
			
			this.add(bot, BorderLayout.CENTER);
			this.add(buttons, BorderLayout.SOUTH);
			this.setPreferredSize(new Dimension(300, 125));
			
		}

//		public void updateView(){
//			Stack<Integer> operandsStack = ctrl.getOperandStack();
//			model.clear();
//			//a�adir los elementos de la pila al modelo
//			for (Integer i : operandsStack)
//				model.addElement(i);
//		}

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
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onHalt() {
			// TODO Auto-generated method stub
			this.bPop.setEnabled(false);
			this.bPush.setEnabled(false);
		}

		@Override
		public void onPush(Integer value) {
			model.addElement(value);
			stackArea.repaint();
			
		}

		@Override
		public void onPop(Integer value) {
			model.removeElementAt(model.indexOf(value));
			  repaint();
		}
}