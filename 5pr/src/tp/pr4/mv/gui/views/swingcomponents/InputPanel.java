package tp.pr4.mv.gui.views.swingcomponents;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

import tp.pr4.mv.controllers.Controller;
import tp.pr4.mv.inout.InStrategy;


	public class InputPanel extends JPanel{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private Controller ctrl;
		private JTextArea inputTextArea;
		public InputPanel (Controller ctrl){
			this.ctrl = ctrl;
			initGUI();
		}

		private void initGUI() {
			
			
			this.setBorder(new TitledBorder("Input"));
			this.setLayout(new BorderLayout());
			this.inputTextArea = new JTextArea();
			inputTextArea.setEditable(false);
			this.add(new JScrollPane(inputTextArea), BorderLayout.CENTER);
			InStrategy inCurr = ctrl.getInStrat();
			InStrategy inNew = new InStreamGUI(inCurr, inputTextArea);
			ctrl.setInStrat(inNew);
		}
}

