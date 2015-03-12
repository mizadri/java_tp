package tp.pr4.mv.gui.swing;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

import tp.pr4.mv.inout.OutStrategy;

@SuppressWarnings("serial")
	public class OutputPanel extends JPanel{
		private GUIControler guiCtrl;
		private JTextArea outputTextArea;

		public OutputPanel(GUIControler guiCtrl){
			this.guiCtrl = guiCtrl;
			initGUI();
		}

		private void initGUI() {
			this.setBorder(new TitledBorder("Output"));
			this.setLayout(new BorderLayout());
			this.outputTextArea = new JTextArea();
			this.add(new JScrollPane(outputTextArea), BorderLayout.CENTER);
			OutStrategy outCurr = guiCtrl.getOutStream(); 
			OutStrategy outNew = new OutStreamGUI( outCurr, outputTextArea); 
			guiCtrl.setOutStream( outNew );
		}
}

