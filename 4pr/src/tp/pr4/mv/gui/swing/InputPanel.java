package tp.pr4.mv.gui.swing;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

import tp.pr4.mv.inout.InStrategy;


	public class InputPanel extends JPanel{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private GUIControler guiCtrl;
		private JTextArea inputTextArea;
		public InputPanel (GUIControler guiCtrl){
			this.guiCtrl = guiCtrl;
			initGUI();
		}

		private void initGUI() {

			this.setBorder(new TitledBorder("Input"));
			this.setLayout(new BorderLayout());
			this.inputTextArea = new JTextArea();
			this.add(new JScrollPane(inputTextArea), BorderLayout.CENTER);
			InStrategy inCurr = guiCtrl.getInStream();
			InStrategy inNew = new InStreamGUI(inCurr, inputTextArea);
			guiCtrl.setInStream(inNew);
		}
}

