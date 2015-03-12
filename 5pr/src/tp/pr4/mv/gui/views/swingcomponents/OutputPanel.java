package tp.pr4.mv.gui.views.swingcomponents;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

import tp.pr4.mv.controllers.Controller;
import tp.pr4.mv.inout.OutStrategy;


	public class OutputPanel extends JPanel{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private Controller ctrl;
		private JTextArea outputTextArea;

		public OutputPanel(Controller ctrl){
			this.ctrl = ctrl;
			initGUI();
		}

		private void initGUI() {
			this.setBorder(new TitledBorder("Output"));
			this.setLayout(new BorderLayout());
			this.outputTextArea = new JTextArea();
			outputTextArea.setEditable(false);
			this.add(new JScrollPane(outputTextArea), BorderLayout.CENTER);
			OutStrategy outCurr = ctrl.getOutStrat(); 
			OutStrategy outNew = new OutStreamGUI( outCurr, outputTextArea); 
			ctrl.setOutStrat( outNew );
		}
}

