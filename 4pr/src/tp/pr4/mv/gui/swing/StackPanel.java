package tp.pr4.mv.gui.swing;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;



	public class StackPanel extends JPanel {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private GUIControler guiCtrl;
		private JList<Integer> stackArea;
		private JTextField tStackElem;
		private JLabel lDato;
		private JButton bPush;
		private JButton bPop;
		private DefaultListModel<Integer> model;

		public StackPanel(GUIControler guiCtrl){
			this.guiCtrl = guiCtrl;
			initGUI();
		}

		private void initGUI(){
			
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
					guiCtrl.push(tStackElem.getText());
				}
			});
			bPop = new JButton("Pop");
			bPop.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					guiCtrl.pop();
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

		void updateView(){
			Stack<Integer> operandsStack = guiCtrl.getOperandStack();
			model.clear();
			//a�adir los elementos de la pila al modelo
			for (Integer i : operandsStack)
				model.addElement(i);
		}
}