package tp.pr4.mv.gui.swing;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;


public class ProgramPanel extends JPanel{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private GUIControler guiCtrl;
private JTextArea programTextArea;

ProgramPanel(GUIControler guiCtrl){
	this.guiCtrl = guiCtrl;
	initGUI();
}

private void initGUI(){
	this.setLayout(new BorderLayout());
	this.setBorder(new TitledBorder("Program"));
	programTextArea = new JTextArea(20,18);
	
	programTextArea.setFont(new Font("Courier", Font.PLAIN, 16));
	programTextArea.setEditable(false);
	this.add(new JScrollPane(programTextArea));
}

	void updateView() {
		this.programTextArea.setText(guiCtrl.updatePPanel());
		this.repaint();
	}
}
